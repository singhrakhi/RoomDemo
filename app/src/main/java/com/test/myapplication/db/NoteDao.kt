package com.test.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note)

    @Query(value = "SELECT * FROM note ORDER BY id DESC")
    suspend fun getAllNote(): List<Note>

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)
}