package com.tedu.cloud_note_1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.cloud_note_1.controller.AddBookNoteController;
import com.tedu.cloud_note_1.dao.DeleteBookDao;
import com.tedu.cloud_note_1.util.NoteResult;
@Service
public class DeleteBookServiceImpl implements DeleteBookService{
	private static Logger logger = LoggerFactory.getLogger(DeleteBookServiceImpl.class);

	@Autowired
	DeleteBookDao deleteBookDao;
	
	public NoteResult<Object> deleteBookService(String bookId) {
		int row=deleteBookDao.deleteBookDao(bookId);
		NoteResult<Object> res = new NoteResult<Object>();
		if(row == 1){
			res.setStatus(0);
			res.setMsg("É¾³ý³É¹¦");
			logger.info("É¾³ý±Ê¼Ç±¾³É¹¦");
		}else{
			res.setStatus(1);
			res.setMsg("É¾³ýÊ§°Ü");
			logger.warn("É¾³ý±Ê¼Ç±¾Ê§°Ü");
		}
		return res;
	}

}
