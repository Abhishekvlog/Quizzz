package com.example.quiz.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.Model.QuestionModel
import com.example.quiz.R
import com.example.quiz.buttonClick.onTaskItemClick

class QuestionAdapter(
    val context: Context,
    val questionList :MutableList<QuestionModel>,
    val listener : onTaskItemClick
) : RecyclerView.Adapter<QuestionViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val inflater = LayoutInflater.from(context)
        val view1: View = inflater.inflate(R.layout.item_layout, parent, false)
        return QuestionViewHolder(view1)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questionList.get(position)

    }

    override fun getItemCount(): Int {
        return questionList.size
    }
}

class QuestionViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
    lateinit var Question : TextView
    lateinit var option1 : TextView
    lateinit var option2 : TextView
    lateinit var option3 : TextView
    lateinit var option4 : TextView

    init {
        Question = itemView.findViewById(R.id.Question)
        option1 = itemView.findViewById(R.id.option1)
        option2 = itemView.findViewById(R.id.option2)
        option3 = itemView.findViewById(R.id.option3)
        option4 = itemView.findViewById(R.id.option4)
    }

}