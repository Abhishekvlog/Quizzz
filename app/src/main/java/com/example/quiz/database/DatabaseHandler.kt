package com.example.quiz.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.quiz.Model.QuestionModel

class DatabaseHandler(val context: Context) :
    SQLiteOpenHelper(context , "quizzdb" , null , 1){
companion object{
    val TABLE_NAME = "Quiz_Table"
    val ID = "id"
    val Question = "question"
    val Option_1 = "option1"
    val Option_2 = "option2"
    val Option_3= "option3"
    val Option_4 = "option4"
}
    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery ="CREATE TABLE $TABLE_NAME($ID : INTEGER PRIMARY KEY ," +
                " $Question : TEXT ," +
                " $Option_1 :  TEXT ," +
                " $Option_2 :  TEXT , " +
                "$Option_3 :  TEXT ," +
                " $Option_4 :  TEXT ,)"
        db?.execSQL(createQuery)
    }

    fun insertQuestion(question : String , option1 : String , option2 : String , option3 : String , option4 : String ){
        val db = writableDatabase
        val values = ContentValues()
        values.put(Question , question)
        values.put(Option_1 , option1)
        values.put(Option_2 , option2)
        values.put(Option_3 , option3)
        values.put(Option_4 , option4)

        val id = db.insert(TABLE_NAME, null , values)

        if (id.toInt() == -1){
            Toast.makeText(context,"Error in insertion", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Successfully Insertion", Toast.LENGTH_LONG).show()
        }
    }

    fun getQuestions() : MutableList<QuestionModel>{
        val listQuestions = mutableListOf<QuestionModel>()
        val db = readableDatabase
        val query = "Select * From $TABLE_NAME"

        val cursor = db.rawQuery(query , null)

        if (cursor != null && cursor.count > 0){
            cursor.moveToFirst()
            do {
                val idIndex = cursor.getColumnIndex(ID)
                val questionIndex = cursor.getColumnIndex(Question)
                val option1Index = cursor.getColumnIndex(Option_1)
                val option2Index = cursor.getColumnIndex(Option_2)
                val option3Index = cursor.getColumnIndex(Option_3)
                val option4Index = cursor.getColumnIndex(Option_4)

                val id =cursor.getInt(idIndex)
                val question = cursor.getString(questionIndex)
                val option1 = cursor.getString(option1Index)
                val option2 = cursor.getString(option2Index)
                val option3 = cursor.getString(option3Index)
                val option4 = cursor.getString(option4Index)

                val questionModel = QuestionModel(id , question , option1 ,option2 ,option3 ,option4)
                listQuestions.add(questionModel)

            }while (cursor.moveToNext())
        }
        return listQuestions

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}