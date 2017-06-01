package com.tedu.cloud_note_1.dao;

import com.tedu.cloud_note_1.entity.Note;

public interface LoadNoteBodyDao {
	public Note findNoteBodyByNoteId(String noteId);
}
