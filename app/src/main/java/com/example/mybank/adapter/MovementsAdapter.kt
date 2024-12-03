package com.example.mybank.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mybank.R


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

    fun updateItems (items: List<Movements>)
    {

        this.movements= items
        notifyDataSetChanged()
    }


}


class ViewHolder(val binding:ItemMovementsBinding): RecyclerView.ViewHolder(binding.root)
{


    fun render (movement: Movements)
    {
        val money=movement.quantity
        binding.dateTextView.text=movement.date.toString()
        binding.conceptMovementTextView.text= movement.concept.toString()
        binding.moneyMovement.text=money.toString()

        if (money<0.00f) {
            binding.moneyMovement.setTextColor(Color.RED)

        } else
            binding.moneyMovement.setTextColor(Color.GREEN)

        //cambiar de color o poner icono

    }


}