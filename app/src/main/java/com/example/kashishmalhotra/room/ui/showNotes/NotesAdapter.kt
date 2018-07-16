package com.example.kashishmalhotra.room.ui.showNotes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kashishmalhotra.room.R
import com.example.kashishmalhotra.room.db.dao.entities.Note
import kotlinx.android.synthetic.main.item_notes.view.*

class NotesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: List<Note>? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false))
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tvNotes.text = list?.get(position)?.name
    }

    fun setNotes(list: List<Note>) {
        this.list = list
        notifyDataSetChanged()
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
