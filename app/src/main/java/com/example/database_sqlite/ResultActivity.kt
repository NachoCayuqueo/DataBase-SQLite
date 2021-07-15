package com.example.database_sqlite

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ResultActivity: AppCompatActivity() {
    val usuarioAdmin = AdministrarUsuario()
    lateinit var listaUsuarios: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_result)
        comenzar()

    }
    fun comenzar(){
        crearLista()
        eliminarUsuario()

        val buttonGoBack = findViewById<Button>(R.id.button_go_back)

        buttonGoBack.setOnClickListener {
            onBackPressed()
        }
    }
    fun crearLista(){
        listaUsuarios = usuarioAdmin.getAllName()!!
        val adaptador = ArrayAdapter(
            AppUsuarios.CONTEXT,
            android.R.layout.simple_list_item_1,
            listaUsuarios
        )

        val userList = findViewById<ListView>(R.id.user_list)
        userList.adapter = adaptador
    }
    fun eliminarUsuario(){
        val userList = findViewById<ListView>(R.id.user_list)
        userList.onItemLongClickListener = AdapterView.OnItemLongClickListener { adapterView, view, i, l ->
            val usuario = listaUsuarios.get(i)

            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Confirmación")
            dialog.setMessage("Confirme que desea eliminar este usuario")
            dialog.setPositiveButton("Si"){dialogInterface,i ->
                //TODO - si oprimimos Si, eliminamos el usuario de la base de datos
                usuarioAdmin.deleteUsuario(usuario)
                crearLista()
            }
            dialog.setNegativeButton("No"){dialogInterface, i ->
                dialogInterface.dismiss()
            }
            dialog.show()
            true
        }
    }
}