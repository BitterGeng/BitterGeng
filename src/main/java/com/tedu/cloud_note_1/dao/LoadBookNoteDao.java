package com.tedu.cloud_note_1.dao;

import java.util.List;

import com.tedu.cloud_note_1.entity.Book;

public interface LoadBookNoteDao {
	public List<Book> findByBookId(String bookId);
}
