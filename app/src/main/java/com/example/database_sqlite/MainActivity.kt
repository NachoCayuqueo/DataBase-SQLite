package com.example.database_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        comenzar()
    }
    private fun comenzar(){
        /**BOTON**/
        val enterButton = findViewById<Button>(R.id.enter_button)

        /**USUARIO Y CONTRASEÑA**/
        val userText = findViewById<EditText>(R.id.user_edit_text)
        val passText = findViewById<EditText>(R.id.password_edit_text)

        enterButton.setOnClickListener {
            val name = userText.text.toString()
            //se verifica si se ingreso un nombre
            if(name != ""){//si existe un nombre ingreso

            }
        }
    }
}