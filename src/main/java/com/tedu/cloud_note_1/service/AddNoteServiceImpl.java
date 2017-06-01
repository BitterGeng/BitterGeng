package com.tedu.cloud_note_1.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.cloud_note_1.controller.AddBookNoteController;
import com.tedu.cloud_note_1.dao.AddNoteDao;
import com.tedu.cloud_note_1.entity.Note;
import com.tedu.cloud_note_1.util.NoteResult;
import com.tedu.cloud_note_1.util.Util;
@Service
public class AddNoteServiceImpl implements AddNoteService{
	private static Logger logger = LoggerFactory.getLogger(AddNoteServiceImpl.class);

	
	@Autowired
	AddNoteDao addNotedao;
	
	public NoteResult<Note> AddNotes(String bookId, String title,String userId) {
		String noteId=Util.createId();
		NoteResult<Note> result = new NoteResult<Note>();
		Note note = new Note();
		note.setCn_note_body("");
		note.setCn_note_title(title);
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
		note.setCn_user_id(userId);
		note.setCn_note_status_id("1");
		long time =System.currentTimeMillis();
		note.setCn_note_create_time(time);
		addNotedao.AddNote(note);
		
		result.setStatus(0);
		result.setMsg("添加笔记成功");
		result.setData(note);
		logger.info("添加笔记成功");
		return result;
	}

}
