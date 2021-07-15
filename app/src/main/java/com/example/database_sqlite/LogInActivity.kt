package com.example.database_sqlite

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LogInActivity: AppCompatActivity() {

    private val usuarioAdmin = AdministrarUsuario()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        comenzar()
    }
    private fun comenzar(){

        /**BOTON**/
        val backButton = findViewById<Button>(R.id.back_button)
        /**USER & PASSWORD**/
        val nameText = findViewById<EditText>(R.id.user_information_edit_text)
        val userText = findViewById<EditText>(R.id.user_edit_text)
        val passwordText = findViewById<EditText>(R.id.password_edit_text)
        val repeatPasswordText = findViewById<EditText>(R.id.repeat_password_edit_text)

        backButton.setOnClickListener {
            val name = nameText.text.toString()
            val user = userText.text.toString()
            val password = passwordText.text.toString()
            val repeatPassword = repeatPasswordText.text.toString()

            if(!camposVacios(name,user,password,repeatPassword)){
                if (!existeUsuario(user)){
                    if(sonIguales(password,repeatPassword)){
                        val usuario = Usuario(user,name,password)
                        usuarioAdmin.addUser(usuario)
                        onBackPressed()
                    }
                    else{
                        Toast.makeText(this,"Deben ser contraseñas iguales", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this,"El usuario ya existe", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Se deben completar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sonIguales(password: String, repeatPassword: String): Boolean {

        if(password == repeatPassword)
            return true

        return false
    }

    private fun camposVacios(name: String, user: String, password: String, repeatPassword: String): Boolean {

        if(name == "" || user == "" || password == "" || repeatPassword == "")
            return true

        return false
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