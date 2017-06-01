package com.tedu.cloud_note_1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.cloud_note_1.dao.DeleteNoteDao;
import com.tedu.cloud_note_1.util.NoteResult;
@Service
public class DeleteNoteServiceImpl implements DeleteNoteService{
	private static Logger logger = LoggerFactory.getLogger(DeleteNoteServiceImpl.class);
	@Autowired
	DeleteNoteDao deleteNoteDao;
	
	public NoteResult<Object> deletNote(String noteId) {
		int row=deleteNoteDao.deleteNote(noteId);
		NoteResult<Object> res = new NoteResult<Object>();
		if(row ==1){
			res.setStatus(0);
			res.setMsg("删除成功");
			logger.info("删除笔记成功");
		}else{
			res.setStatus(1);
			res.setData("删除失败");
			logger.warn("删除笔记失败");
		}
		return res;
	}

}
