package com.example.database_sqlite

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val usuarioAdmin = AdministrarUsuario()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        comenzar()
    }
    private fun comenzar(){
        /**BOTONES**/
        val enterButton = findViewById<Button>(R.id.enter_button)
        val logInButton = findViewById<Button>(R.id.log_in_button)

        /**USERNAME**/
        val userNameText = findViewById<EditText>(R.id.userName_edit_text)

        enterButton.setOnClickListener {
            val username = userNameText.text.toString() //obtengo el texto escrito

            //verifico si escribieron un nombre
            if(username != ""){ //si se escribio
                if(existeUsuario(username)){ //busco usuario en BD
                    val intent = Intent(this,ResultActivity::class.java)
                    startActivity(intent)

                    finish()
                }else{
                    Toast.makeText(this,"No existe usuario, debe loguearse para jugar",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Se debe ingresar un nombre",Toast.LENGTH_SHORT).show()
                userNameText.requestFocus()

                val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(userNameText,InputMethodManager.SHOW_IMPLICIT)
            }
        }

        logInButton.setOnClickListener {
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun existeUsuario(username: String): Boolean {
        val usuarios = usuarioAdmin.getAllName() //obtengo todos los usuarios existentes en la BD

        usuarios?.forEach {
            if(it == username)
                return true
        }
        return false
    }


}