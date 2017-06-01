package com.tedu.cloud_note_1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.cloud_note_1.controller.AddBookNoteController;
import com.tedu.cloud_note_1.dao.AddBookNoteDao;
import com.tedu.cloud_note_1.entity.Book;
import com.tedu.cloud_note_1.util.NoteResult;
@Service
public class AddBookNoteServiceImpl implements AddBookNoteService{
	private static Logger logger = LoggerFactory.getLogger(AddBookNoteServiceImpl.class);

	@Autowired
	AddBookNoteDao addBookNoteDao;
	
	public NoteResult<Object> addBookNote(Book book) {
		addBookNoteDao.AddBookNote(book);
		NoteResult<Object> result = new NoteResult<Object>();
		result.setStatus(0);
		result.setMsg("添加成功");
		logger.info("添加笔记本成功");
		return result;
	}

}
