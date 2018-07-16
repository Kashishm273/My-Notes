package com.example.kashishmalhotra.room.ui.addNote

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kashishmalhotra.room.R
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        setListeners()
    }

    private fun setListeners() {
        btnAdd.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnAdd -> validate()
        }
    }

    private fun validate() {
        if(etEnterNote.text.toString().trim().isEmpty())
            etEnterNote.error = "Enter a note"
        else {
            val intent = Intent()
            intent.putExtra("note", etEnterNote.text.toString().trim())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
