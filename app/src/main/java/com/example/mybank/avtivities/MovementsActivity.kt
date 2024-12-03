package com.example.mybank.avtivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mybank.R
import com.example.mybank.adapter.MovementsAdapter
import com.example.mybank.data.Movements
import com.example.mybank.databinding.ActivityMovementsBinding
import com.example.mybank.utils.MovementsDao



class MovementsActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovementsBinding
    lateinit var adapter: MovementsAdapter
    lateinit var movement: Movements
    lateinit var movesDAO: MovementsDao
    var saldo: Float = 0.00f
    var movementsList: MutableList<Movements> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMovementsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movesDAO= MovementsDao(this)


        adapter= MovementsAdapter(movementsList){
            val movement = movementsList[it]
          //  navigateTo(movement)

        }

        binding.movementsRecyclerView.adapter= adapter
        binding.movementsRecyclerView.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)


        binding.addMovementButton.setOnClickListener{
            var intent= Intent(this, DetailActivity::class.java)
            startActivity(intent)

        }


    }

    override fun onResume() {
        super.onResume()

        movementsList=movesDAO.findAll().toMutableList()
        adapter.updateItems(movementsList)

        updateSaldo()



    }

    private fun updateSaldo() {

        val tam= movementsList.size-1
                saldo=0.00f
        for(i in 0..tam)
            saldo += movementsList[i].quantity


        binding.saldoTextView.text=saldo.toString() + "€"
    }


}

