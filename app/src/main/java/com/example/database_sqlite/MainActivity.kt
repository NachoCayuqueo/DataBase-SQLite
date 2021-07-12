package com.example.database_sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var dataBase: miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataBase = miSQLiteHelper(this)
        comenzar()
    }
    private fun comenzar(){
        /**BOTONES**/
        val enterButton = findViewById<Button>(R.id.enter_button)
        val logInButton = findViewById<Button>(R.id.log_in_button)

        enterButton.setOnClickListener {

        }

        logInButton.setOnClickListener {
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}