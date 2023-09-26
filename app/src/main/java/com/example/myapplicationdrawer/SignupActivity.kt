package com.example.myapplicationdrawer

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignupActivity : AppCompatActivity() {
    private lateinit var uname:EditText
    private lateinit var pword:EditText
    private lateinit var Sbtn:Button
    private lateinit var db:DatabaseHelper
    
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        uname=findViewById(R.id.email_address_signup)
        pword=findViewById(R.id.password_signup)
        Sbtn=findViewById(R.id.signupButton)
        db= DatabaseHelper(this)
        Sbtn.setOnClickListener {
            val unametext=uname.text.toString()
            val pwordtext=pword.text.toString()
            val savedata=db.insertUser(unametext,pwordtext)

            if (TextUtils.isEmpty(unametext)||TextUtils.isEmpty(pwordtext)){
                Toast.makeText(this,"add user",Toast.LENGTH_SHORT).show()
            }else{
                if(pwordtext.equals(pwordtext)){
                    if (savedata!=null){
                        Toast.makeText(this,"add user",Toast.LENGTH_SHORT).show()
                        val intent= Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"add user",Toast.LENGTH_SHORT).show()
                    }
                }
                Toast.makeText(this,"add user",Toast.LENGTH_SHORT).show()
            }
        }
    }
}