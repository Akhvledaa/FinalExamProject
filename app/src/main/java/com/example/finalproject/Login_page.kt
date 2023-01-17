package com.example.finalproject

import androidx.lifecycle.LiveData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login_page : AppCompatActivity() {
    private lateinit var ETemaillogin: EditText
    private lateinit var ETpasswordlogin: EditText
    private lateinit var loginbutton: Button
    private lateinit var gotosignuptextview: TextView

    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)


        cvladebi()
        loginlisteners()

        gotosignuptextview.setOnClickListener {
            startActivity(Intent(this,signup_page::class.java))
        }

    }

    private fun loginlisteners(){
        loginbutton.setOnClickListener(){
            val email = ETemaillogin.text.toString()
            val password = ETpasswordlogin.text.toString()
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Email or password is incorrect", Toast.LENGTH_SHORT).show()
                }

            }

        }

    }

    private fun cvladebi(){
        ETemaillogin = findViewById(R.id.ETemail_login)
        ETpasswordlogin = findViewById(R.id.ETpassword_login)
        loginbutton = findViewById(R.id.login_button)
        gotosignuptextview = findViewById(R.id.gotosignup_textview)

    }

}