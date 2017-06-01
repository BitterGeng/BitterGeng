package com.tedu.cloud_note_1.service;

import com.tedu.cloud_note_1.util.NoteResult;

public interface DeleteBookService {
	public NoteResult<Object> deleteBookService(String bookId); 
}
