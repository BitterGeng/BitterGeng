package com.tedu.cloud_note_1.service;

import java.util.List;

import com.tedu.cloud_note_1.entity.Note;
import com.tedu.cloud_note_1.util.NoteResult;

public interface LoadBookNotesService {
	public NoteResult<List<Note>> loadBookNotes(String bookId);
}
