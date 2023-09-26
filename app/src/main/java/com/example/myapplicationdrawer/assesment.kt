package com.example.myapplicationdrawer

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplicationdrawer.databinding.FragmentAssesmentBinding


class assesment : Fragment() {
    private var _binding: FragmentAssesmentBinding? =null
    private val binding get()=_binding!!

    private val Questions= arrayOf("how many district in uttar pradesh?",
        "what is the capital of uttar pradesh?",
        "what is the capital of india?",
        "How many days are there in a week?",
        "How many minutes are there in an hour?")
    private val Options = arrayOf(arrayOf("72" ,"75" ,"80","55"),
        arrayOf("lucknow","delhi","raebareli","gonda"),
        arrayOf("lucknow","delhi","raebareli","gonda"),
        arrayOf("7" ,"5" ,"8","1"),
        arrayOf("72" ,"75" ,"80","60")
        )
    private val  correctAnswers= arrayOf(0,0,1,0,3)
    private var currentQuestionIndex=0
    private var score=0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAssesmentBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment



        displayQuestion()

        binding.option1answer.setOnClickListener {
            checkAnswer(0)
        }
        binding.option2answer.setOnClickListener {
            checkAnswer(1)
        }
        binding.option3answer.setOnClickListener {
            checkAnswer(2)
        }
        binding.option4answer.setOnClickListener {
            checkAnswer(3)
        }
        binding.RestrartButton.setOnClickListener {
            restartQuiz()
        }
        setupButtonListeners()
        return binding.root
    }

    private fun correctButtonColor(buttonIndex:Int){
        when(buttonIndex){
            0->binding.option1answer.setBackgroundColor(Color.GREEN)
            1->binding.option2answer.setBackgroundColor(Color.GREEN)
            2->binding.option3answer.setBackgroundColor(Color.GREEN)
            3->binding.option4answer.setBackgroundColor(Color.GREEN)
        }
    }
    private fun wrongButtonColor(buttonIndex: Int){
        when(buttonIndex){
            0->binding.option1answer.setBackgroundColor(Color.RED)
            1->binding.option2answer.setBackgroundColor(Color.RED)
            2->binding.option3answer.setBackgroundColor(Color.RED)
            3->binding.option4answer.setBackgroundColor(Color.RED)

        }
    }
    private fun resetButtonColor(){
        binding.option1answer.setBackgroundColor(Color.rgb(50,59,96))
        binding.option2answer.setBackgroundColor(Color.rgb(50,59,96))
        binding.option3answer.setBackgroundColor(Color.rgb(50,59,96))
        binding.option4answer.setBackgroundColor(Color.rgb(50,59,96))
    }
    private fun  showResult(){
        Toast.makeText(activity,"your score:$score out of ${Questions.size}",Toast.LENGTH_SHORT).show()
        binding.RestrartButton.isEnabled=true

    }
    private fun displayQuestion(){
        binding.questions.text=Questions[currentQuestionIndex]
        binding.option1answer.text=Options[currentQuestionIndex][0]
        binding.option2answer.text=Options[currentQuestionIndex][1]
        binding.option3answer.text=Options[currentQuestionIndex][2]
        binding.option4answer.text=Options[currentQuestionIndex][3]
        resetButtonColor()

    }
    private fun checkAnswer(selectedAnswerIndex:Int){
        val correctAnswerIndex=correctAnswers[currentQuestionIndex]
        if (selectedAnswerIndex==correctAnswerIndex){
            score++
            correctButtonColor(selectedAnswerIndex)
        }else{
            wrongButtonColor(selectedAnswerIndex)
            correctButtonColor(correctAnswerIndex)
        }
        if(currentQuestionIndex<Questions.size-1){
            currentQuestionIndex++
            binding.questions.postDelayed({displayQuestion()},1000)
        }else{
            showResult()
        }
    }
    private fun restartQuiz(){
        currentQuestionIndex=0
        score=0
        displayQuestion()
        binding.RestrartButton.isEnabled=false
    }
    private fun setupButtonListeners() {
        binding.quizroute.setOnClickListener {
            // Replace 'SecondActivity::class.java' with the actual name of your second activity
            val intent = Intent(activity, StartActivity::class.java)
            startActivity(intent)
        }
    }


}