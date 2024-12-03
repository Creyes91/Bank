package com.example.mybank.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mybank.data.Movements
import com.example.mybank.databinding.ItemMovementsBinding

class MovementsAdapter(var movements: List<Movements>,val onItemClick: (Int)-> Unit) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= ItemMovementsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movement= movements[position]
        holder.render(movement)

    }

    override fun getItemCount(): Int {
        return movements.size
    }


}


class ViewHolder(val binding:ItemMovementsBinding): RecyclerView.ViewHolder(binding.root)
{
    fun render (movement: Movements)
    {
        binding.dateTextView.text=movement.date.toString()
        binding.conceptMovementTextView.text= movement.concept.toString()
        binding.moneyMovement.text=movement.quantity.toString()

        //cambiar de color o poner icono

    }


}