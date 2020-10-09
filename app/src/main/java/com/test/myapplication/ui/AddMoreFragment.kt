package com.test.myapplication.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.test.myapplication.R
import com.test.myapplication.db.Note
import com.test.myapplication.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_more.*
import kotlinx.coroutines.launch


class AddMoreFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_more, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnSave.setOnClickListener { view->
            val noteTitle = edtTitle.text.toString().trim()
            val noteBody = edtNote.text.toString().trim()

            if (noteTitle.isEmpty()){
                edtTitle.error = "title required"
                edtTitle.requestFocus()
                return@setOnClickListener
            }

            if (noteBody.isEmpty()){
                edtNote.error = "Note required"
                edtNote.requestFocus()
                return@setOnClickListener
            }


            launch {
                val note = Note(noteTitle,noteBody)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(note)
                    it.toast("Note Saved.")
                    val action = AddMoreFragmentDirections.actionSaveNote()
                    Navigation.findNavController(view).navigate(action)
                }
            }
//            saveNote(note)


        }

    }

//    private fun saveNote(note: Note) {
//        class SaveData : AsyncTask<Void, Void, Void>() {
//            override fun doInBackground(vararg params: Void?): Void ?{
//                NoteDatabase(requireActivity()).getNoteDao().addNote(note)
//                return null
//            }
//
//            override fun onPostExecute(result: Void?) {
//                super.onPostExecute(result)
//                Toast.makeText(activity, "Note Saved", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        SaveData().execute()
//
//    }

}