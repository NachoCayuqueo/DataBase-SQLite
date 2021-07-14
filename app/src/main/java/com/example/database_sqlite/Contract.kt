package com.example.database_sqlite

import android.provider.BaseColumns

class Contract {

    class Usuario:BaseColumns{
        companion object{
            val userID = "usuarioID"
            val nombre = "nombre"
            val password = "password"
        }
    }
}