package com.tedu.cloud_note_1.dao;

import java.util.List;

import com.tedu.cloud_note_1.entity.Note;

public interface LoadBookNotesDao {
	public List<Note> findByBookId(String bookId);
}
