package com.tedu.cloud_note_1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.cloud_note_1.dao.LoadBookNotesDao;
import com.tedu.cloud_note_1.entity.Note;
import com.tedu.cloud_note_1.util.NoteResult;
@Service
public class LoadBookNotesServiceImpl implements LoadBookNotesService{
	private static Logger logger = LoggerFactory.getLogger(LoadBookNotesServiceImpl.class);

	@Autowired
	LoadBookNotesDao loadBookNotesDao;
	
	public NoteResult<List<Note>> loadBookNotes(String noteId) {
		List<Note> list=loadBookNotesDao.findByBookId(noteId);
		NoteResult<List<Note>> result = new NoteResult<List<Note>>();
		result.setStatus(0);
		result.setMsg("加载笔记成功");
		result.setData(list);
		logger.info("加载笔记成功");
		return result;
	}

	

}
