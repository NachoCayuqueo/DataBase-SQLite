package com.example.database_sqlite

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LogInActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        comenzar()
    }
    private fun comenzar(){

        /**BOTON**/
        val backButton = findViewById<Button>(R.id.back_button)
        /**USER & PASSWORD**/
        val userText = findViewById<EditText>(R.id.user_edit_text)
        val passwordText = findViewById<EditText>(R.id.password_edit_text)
        val repeatPasswordText = findViewById<EditText>(R.id.repeat_password_edit_text)

    }
}