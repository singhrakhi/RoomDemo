package com.test.myapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(

//    @ColumnInfo(name = "note_title")   /*if we want to different column name */
    val title: String,
    val note: String
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int=0
}