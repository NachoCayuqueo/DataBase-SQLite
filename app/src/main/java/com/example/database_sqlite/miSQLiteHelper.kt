package com.example.database_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper(context: Context):SQLiteOpenHelper(
    context,"dataBase.db",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE amigos "+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT, email TEXT)"

        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS dabaBase"

        db!!.execSQL(ordenBorrado)

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