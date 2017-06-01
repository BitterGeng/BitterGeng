package com.tedu.cloud_note_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.service.DeleteBookService;
import com.tedu.cloud_note_1.util.NoteResult;

@Controller
@RequestMapping("/book")
public class DeleteBookController {

	@Autowired
	DeleteBookService deleteBookService;

	@ResponseBody
	@RequestMapping("/deleteBook.do")
	public NoteResult<Object> execute(String bookId) {
		NoteResult<Object> res = deleteBookService.deleteBookService(bookId);

		return res;
	}
}
