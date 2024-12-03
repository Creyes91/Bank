package com.example.mybank.data

class Movements (var quantity: Long,var concept: String,var date: String){

    companion object{

        const val TABLE_NAME = "MOVEMENTS"
        const val COLUMN_ID = "ID"
        const val COLUMN_QUANTITY = "QUANTITY"
        const val COLUMN_CONCEPT = "CONCEPT"
        const val COLUMN_DATE = "DATE"

    }
}