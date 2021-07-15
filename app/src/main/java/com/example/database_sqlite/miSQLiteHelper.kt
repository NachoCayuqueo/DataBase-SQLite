package com.example.database_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper:SQLiteOpenHelper(
    AppUsuarios.CONTEXT,AppUsuarios.DB_NAME,null,AppUsuarios.VERSION) {

    val qryCreateTable = "CREATE TABLE ${AppUsuarios.TB_USUARIO}("+
            "${Contract.Usuario.userID} STRING PRIMARY KEY,"+
            "${Contract.Usuario.nombre} STRING,"+
            "${Contract.Usuario.password} STRING)"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(qryCreateTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        //db!!.execSQL("DROP TABLE IF EXISTS $qryCreateTable")
        //onCreate(db)
    }

}