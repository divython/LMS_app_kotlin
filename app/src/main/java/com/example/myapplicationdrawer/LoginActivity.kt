package com.example.myapplicationdrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplicationdrawer.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var db:DatabaseHelper
    private lateinit var redirectbtn:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db=DatabaseHelper(this)
        binding.loginButton.setOnClickListener{
            val loginUsername =binding.emailaddress.text.toString()
            val loginPassword = binding.password.text.toString()
            loginDatabase(loginUsername,loginPassword)
        }
        binding.signupRoute.setOnClickListener{
            val intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun loginDatabase(username:String,password:String){
        val userExists= db.readUser(username,password)
        if(userExists){
            Toast.makeText(this,"login successful",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this,"login failed",Toast.LENGTH_SHORT).show()
        }
    }

}
