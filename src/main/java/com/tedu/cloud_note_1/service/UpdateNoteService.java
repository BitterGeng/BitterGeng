package com.tedu.cloud_note_1.service;

import com.tedu.cloud_note_1.entity.Note;
import com.tedu.cloud_note_1.util.NoteResult;

public interface UpdateNoteService {
	public NoteResult<Note> UpdateNote(Note note);
}
