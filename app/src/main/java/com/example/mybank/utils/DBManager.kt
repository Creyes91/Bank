package com.example.mybank.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mybank.data.Movements

class DBManager (context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    companion object
    {
        const val DATABASE_VERSION =1
        const val DATABASE_NAME= "MovementsBank.db"

        private const val  SQL_CREATE_TABLE =
            "CREATE TABLE ${Movements.TABLE_NAME} (" +
                    "${Movements.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${Movements.COLUMN_QUANTITY} INTEGER," +
                    "${Movements.COLUMN_CONCEPT} INTEGER," +
                    "${Movements.COLUMN_DATE} TEXT)"

        private const val SQL_DELETE_TABLE= "DROP TABLE IF EXISTS ${Movements.TABLE_NAME}"

    }
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL(SQL_CREATE_TABLE)





    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_TABLE)
        db?.execSQL(SQL_CREATE_TABLE)
        //Alter table para modificar la tabla

        /* when old version */
    }


}