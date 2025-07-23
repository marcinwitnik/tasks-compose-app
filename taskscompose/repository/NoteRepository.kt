package com.example.taskscompose.repository

import com.example.taskscompose.model.Note
import com.example.taskscompose.data.NoteDao
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val dao: NoteDao) {
    val notes: Flow<List<Note>> = dao.getAllNotes()

    suspend fun getNoteById(id: Int): Note? = dao.getNoteById(id)

    suspend fun addNote(note: Note) = dao.addNote(note)

    suspend fun deleteNote(note: Note) = dao.deleteNote(note)

    suspend fun deleteAllNotes() = dao.deleteAllNotes()
}
