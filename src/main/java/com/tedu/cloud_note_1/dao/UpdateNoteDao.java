package com.tedu.cloud_note_1.dao;

import com.tedu.cloud_note_1.entity.Note;

public interface UpdateNoteDao {
	public void UpdateNote(Note note);
	public Note findNote(String noteId);
}
