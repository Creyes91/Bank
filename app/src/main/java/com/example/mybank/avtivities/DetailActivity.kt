package com.example.mybank.avtivities

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybank.data.Movements
import com.example.mybank.databinding.ActivityDetailBinding
import com.example.mybank.utils.MovementsDao
import java.util.Locale

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    lateinit var movement: Movements
    lateinit var movesDao: MovementsDao

    companion object{


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movesDao= MovementsDao(this)
        movement= Movements(-1,0.0f,"","")




        binding.saveBTN.setOnClickListener{
            val simpleDateFormat = SimpleDateFormat("dd/MM", Locale.getDefault())
            if (movement.date.isEmpty()){
                val date= Calendar.getInstance()
                movement.date=simpleDateFormat.format(date.time)

            }

            else{
                movement.date=binding.datePicker.editText?.text.toString()

            }


            movement.concept=binding.conceptMovementEditText.editText?.text.toString()


            val texto=binding.EurosEditText.editText?.text.toString()
            val num: Float = texto.toFloat()
            movement.quantity=num
            movesDao.insert(movement)


            finish()
        }

        binding.datePicker.editText?.setOnClickListener{
            datePicker()

        }

    }




    private fun datePicker()
    {
        val initialDate = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val date = Calendar.getInstance()
                date.set(Calendar.YEAR, year)
                date.set(Calendar.MONTH, month)
                date.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val simpleDateFormat = SimpleDateFormat("dd/MM", Locale.getDefault())
                val formattedDate = simpleDateFormat.format(date.time)
                binding.datePicker.editText?.setText(formattedDate)
            }, initialDate.get(Calendar.YEAR), initialDate.get(Calendar.MONTH), initialDate.get(
                Calendar.DAY_OF_MONTH)
        )
// Show the dialog
        datePickerDialog.show()
    }
}