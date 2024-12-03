package com.example.mybank.utils

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.mybank.data.Movements

class MovementsDao(var context: Context) {

    lateinit var db: SQLiteDatabase

    private fun open() {
        db = DBManager(context).writableDatabase

    }

    private fun close() {

        db.close()
    }

    fun delete (movements: Movements)
    {
        open()

        val values= ContentValues().apply {
            put(Movements.COLUMN_CONCEPT, movements.concept)
            put(Movements.COLUMN_DATE, movements.date)
            put(Movements.COLUMN_CONCEPT,movements.concept)

        }

        try{
            val deletedRows= db.delete(Movements.TABLE_NAME,"${Movements.COLUMN_ID}=${movements.id}", null)
        }catch (e:Exception)
        {
            Log.e("DB", e.stackTraceToString())
        }finally {
            close()
        }


    }

    fun insert(movements: Movements) {
        open()

        val values = ContentValues().apply {
            put(Movements.COLUMN_CONCEPT, movements.concept)
            put(Movements.COLUMN_DATE, movements.date)
            put(Movements.COLUMN_QUANTITY,movements.quantity)


        }
        try {
            val id = db.insert(Movements.TABLE_NAME, null, values)
        } catch (e: Exception) {
            Log.e("DB", e.stackTraceToString())
        } finally {
            close()
        }

    }

    fun findAll(): List<Movements>
    {
        open()
        var list: MutableList<Movements> = mutableListOf()
        val projection= arrayOf(Movements.COLUMN_ID, Movements.COLUMN_CONCEPT, Movements.COLUMN_QUANTITY,Movements.COLUMN_DATE)

        try {
            val cursor = db.query(
                Movements.TABLE_NAME,                    // The table to query
                projection,                         // The array of columns to return (pass null to get all)
                null,                       // The columns for the WHERE clause
                null,                   // The values for the WHERE clause
                null,                       // don't group the rows
                null,                         // don't filter by row groups
                null   )                      // The sort order

            while (cursor.moveToNext()) {
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(Movements.COLUMN_ID))
                val concept = cursor.getString(cursor.getColumnIndexOrThrow(Movements.COLUMN_CONCEPT))
                val date = cursor.getString(cursor.getColumnIndexOrThrow(Movements.COLUMN_DATE))
                val money = cursor.getFloat(cursor.getColumnIndexOrThrow(Movements.COLUMN_QUANTITY))

                val move= Movements(id, money,concept,date)
                list.add(move)
            }
        }catch (e:Exception)
        {
            Log.e("DB", e.stackTraceToString())
        }
        return list
    }
}