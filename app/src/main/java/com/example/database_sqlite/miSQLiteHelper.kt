package com.example.database_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper:SQLiteOpenHelper(
    AppUsuarios.CONTEXT,AppUsuarios.DB_NAME,null,AppUsuarios.VERSION) {

    val qryCreateTable = "CREATE TABLE ${AppUsuarios.DB_NAME}("+
            "${Contract.Usuario.userID} STRING PRIMARY KEY,"+
            "${Contract.Usuario.nombre} STRING,"+
            "${Contract.Usuario.password} STRING"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(qryCreateTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db!!.execSQL("DROP TABLE IF EXISTS $qryCreateTable")
        onCreate(db)
    }

    /**añadir datos**/
    fun addDate(nombre:String,email:String){
        val datos = ContentValues()
        datos.put("nombre",nombre)
        datos.put("email",email)

        val db = this.writableDatabase
        db.insert("dataBase",null,datos)
        db.close()
    }
}