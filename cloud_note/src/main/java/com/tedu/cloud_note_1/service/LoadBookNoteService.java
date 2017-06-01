package com.tedu.cloud_note_1.service;

import java.util.List;

import com.tedu.cloud_note_1.entity.Book;
import com.tedu.cloud_note_1.util.NoteResult;

public interface LoadBookNoteService {
	public NoteResult<List<Book>> loadBookNote(String userId);
}
