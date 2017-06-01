package com.tedu.cloud_note_1.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.entity.Book;
import com.tedu.cloud_note_1.service.AddBookNoteService;
import com.tedu.cloud_note_1.util.NoteResult;
import com.tedu.cloud_note_1.util.Util;
@Controller
@RequestMapping("/book")
public class AddBookNoteController {
	private static Logger logger = LoggerFactory.getLogger(AddBookNoteController.class);
	
	@Autowired
	AddBookNoteService addBookNoteService;
	
	@ResponseBody
	@RequestMapping("/addBook.do")
	public NoteResult<Object> execute(String bookName,String userId){
		Book book = new Book();
		book.setCn_notebook_name(bookName);
		book.setCn_user_id(userId);
		book.setCn_notebook_id(Util.createId());
//		book.setCn_notebook_createtime();
		NoteResult<Object> result = addBookNoteService.addBookNote(book);
		return result;
		
	}
}
