package com.tedu.cloud_note_1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tedu.cloud_note_1.entity.Book;
import com.tedu.cloud_note_1.service.LoadBookNoteService;
import com.tedu.cloud_note_1.util.NoteResult;

@Controller
@RequestMapping("/book")
public class LoadBookNoteController {

	@Autowired
	LoadBookNoteService loadBookNoteService;
	
	@ResponseBody
	@RequestMapping("/loadBook.do")
	public NoteResult<List<Book>> execute(String userId){
		NoteResult<List<Book>> result = loadBookNoteService.loadBookNote(userId);
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
}
