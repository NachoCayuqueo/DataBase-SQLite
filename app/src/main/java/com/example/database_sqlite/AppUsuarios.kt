package com.example.database_sqlite

import android.app.Application
import android.content.Context

/**
 * Este archivo contiene las variables globales
 * para que podamos acceder de todos lados
 * **/
class AppUsuarios: Application() {

    companion object{
        //variable perezosa, se define aca pero se inicializa mas adelante
        lateinit var CONTEXT: Context
        lateinit var DB: miSQLiteHelper //accedo a la base de datos

        val DB_NAME = "database.db" //nombre de la base de datos
        val VERSION = 1
        //la version no se cambia mientras no haya modificaciones
        //a la base de datos (ej: agregar tablas, cambias campos)
        val TB_USUARIO = "tbLogIn" //nombre de la tabla
    }
    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        DB = miSQLiteHelper()
    }
}