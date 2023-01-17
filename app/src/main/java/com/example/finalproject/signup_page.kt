package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
//import kotlinx.android.synthetic.main.signup_page.*

class signup_page : AppCompatActivity() {
    private lateinit var ETemailsignup: EditText
    private lateinit var ETpasswordsignup: EditText
    private lateinit var ETrepeatpasswordsignup: EditText
    private lateinit var signupbutton: Button
    private lateinit var gotologintextview: TextView

    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page)

        cvladebi()
        signuplisteners()


        gotologintextview.setOnClickListener(){
            startActivity(Intent(this,Login_page::class.java))
        }

    }

    private fun signuplisteners(){
        signupbutton.setOnClickListener(){
            val email = ETemailsignup.text.toString()
            val password = ETpasswordsignup.text.toString()
            val repeatpassword = ETrepeatpasswordsignup.text.toString()

            if (password!=repeatpassword){
                Toast.makeText(this, "passwords do not match!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (email.isEmpty() || password.isEmpty() || repeatpassword.isEmpty()){
                Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "Sign up completed! Now you can log in", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,Login_page::class.java))
                } else {
                    Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


    private fun cvladebi(){
        ETemailsignup = findViewById(R.id.ETemail_signup)
        ETpasswordsignup = findViewById(R.id.ETpassword_signup)
        ETrepeatpasswordsignup = findViewById(R.id.ETrepeatpassword_signup)
        signupbutton = findViewById(R.id.signup_button)
        gotologintextview = findViewById(R.id.gotologin_textview)
    }
}