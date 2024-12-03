package com.example.mybank.data

class Movements(var id: Long, var quantity: Float, var concept: String, var date: String){

    companion object{

        const val TABLE_NAME = "MOVEMENTS"
        const val COLUMN_ID = "ID"
        const val COLUMN_QUANTITY = "QUANTITY"
        const val COLUMN_CONCEPT = "CONCEPT"
        const val COLUMN_DATE = "DATE"

    }
}