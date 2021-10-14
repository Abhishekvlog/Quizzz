package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quiz.Adapter.QuestionAdapter
import com.example.quiz.Model.QuestionModel
import com.example.quiz.buttonClick.onTaskItemClick
import com.example.quiz.database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , onTaskItemClick {

    private var questionList : MutableList<QuestionModel> = mutableListOf()
    lateinit var QAdapter : QuestionAdapter
    lateinit var dbHandler : DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = DatabaseHandler(this)
        questionList =dbHandler.getQuestions()

        QAdapter = QuestionAdapter(this, questionList , this)
        recyclerView.layoutManager =LinearLayoutManager(this)
        recyclerView.adapter =QAdapter
        dbHandler = DatabaseHandler(this)

        Build()

    }
    fun Build(){
        dbHandler.insertQuestion("1 - Question " , " Option 1", "option 2" , "option 3" , "option 4")
        dbHandler.insertQuestion("2 - Question " , " Option 1", "option 2" , "option 3" , "option 4")
        dbHandler.insertQuestion("3 - Question " , " Option 1", "option 2" , "option 3" , "option 4")
        dbHandler.insertQuestion("4 - Question " , " Option 1", "option 2" , "option 3" , "option 4")
        dbHandler.insertQuestion("5 - Question " , " Option 1", "option 2" , "option 3" , "option 4")
    }


    override fun onSubmitClicked(questionModel: QuestionModel) {

    }
}