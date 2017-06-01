package com.tedu.cloud_note_1.service;

import com.tedu.cloud_note_1.entity.Book;
import com.tedu.cloud_note_1.util.NoteResult;

public interface AddBookNoteService {
	public NoteResult<Object> addBookNote(Book book);
}
