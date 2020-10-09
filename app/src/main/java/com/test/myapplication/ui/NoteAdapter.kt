package com.test.myapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.myapplication.R
import com.test.myapplication.db.Note
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter(val note: List<Note>): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder (view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        )
    }

    override fun getItemCount() = note.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.txtNoteTitle.text = note[position].title
        holder.view.txtMsg.text = note[position].note

    }
}