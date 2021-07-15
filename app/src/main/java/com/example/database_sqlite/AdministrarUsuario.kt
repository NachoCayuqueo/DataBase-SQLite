package com.example.database_sqlite

import android.database.DatabaseUtils
import android.widget.Toast

data class Usuario(var userId: String, var name: String, var password: String)

class AdministrarUsuario {

    //obtener y retorno los nombres de los usuarios
    fun getAllName(): ArrayList<String>? {
        try{
            val usersArray = arrayListOf<String>() //array de retorno

            val db = AppUsuarios.DB.readableDatabase
            //primero se verifica si exiten datos guardados
            val numDatos = DatabaseUtils.queryNumEntries(db,AppUsuarios.TB_USUARIO).toInt()

            if(numDatos > 0){
                val qry = "SELECT ${Contract.Usuario.userID} FROM ${AppUsuarios.TB_USUARIO}"
                val userName = db.rawQuery(qry,null)

                userName.moveToFirst() //inicio de la tabla
                do {
                    usersArray.add(userName.getString(userName.getColumnIndex(Contract.Usuario.userID)))
                }while (userName.moveToNext())
            }else{
                Toast.makeText(AppUsuarios.CONTEXT,"No se encontraron usuarios guardados",Toast.LENGTH_SHORT).show()
            }
            db.close()
            return usersArray

        }catch (ex:Exception){
            Toast.makeText(AppUsuarios.CONTEXT,"No se pudo recuperar usuarios",Toast.LENGTH_SHORT).show()
            return null
        }
    }

    //insertar un usuario
    fun addUser(usuario: Usuario){
        try {
            val db = AppUsuarios.DB.writableDatabase

            var qry = "INSERT INTO ${AppUsuarios.TB_USUARIO} ("+
                    "${Contract.Usuario.userID}, ${Contract.Usuario.nombre}, ${Contract.Usuario.password})" +
                    "VALUES('${usuario.userId}','${usuario.name}','${usuario.password}');"

            db.execSQL(qry)
            db.close()
        }catch (ex:Exception){
            Toast.makeText(AppUsuarios.CONTEXT,"No se pudo guardar el usuario",Toast.LENGTH_SHORT).show()
        }
    }

    //verificar si un usuario existe

}