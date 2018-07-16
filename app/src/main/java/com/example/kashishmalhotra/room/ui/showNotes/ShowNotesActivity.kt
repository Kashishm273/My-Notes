package com.example.kashishmalhotra.room.ui.showNotes

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.kashishmalhotra.room.R
import com.example.kashishmalhotra.room.ui.addNote.AddNoteActivity
import com.example.kashishmalhotra.room.db.dao.entities.Note
import kotlinx.android.synthetic.main.activity_show_notes.*

class ShowNotesActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: MyViewModel
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_notes)
        setAdapter()
        init()
        setListeners()
    }

    private fun setListeners() {
        fab.setOnClickListener(this)
    }

    private fun setAdapter() {
        rvNotes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = NotesAdapter()
        rvNotes.adapter = adapter
    }

    private fun init() {
        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        viewModel.getAllWords()?.observe(this, Observer<List<Note>> {
            it?.let { it1 -> adapter.setNotes(it1) }
        })
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.fab -> {
                startActivityForResult(Intent(this, AddNoteActivity::class.java), 124)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 124 && resultCode == Activity.RESULT_OK) {
            viewModel.addNote(Note(data?.getStringExtra("note") ?: ""))
        }
    }
}