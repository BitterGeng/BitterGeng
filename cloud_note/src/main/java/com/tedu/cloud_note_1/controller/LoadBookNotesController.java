package com.tedu.cloud_note_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.entity.Note;
import com.tedu.cloud_note_1.service.LoadBookNotesService;
import com.tedu.cloud_note_1.util.NoteResult;
@Controller
@RequestMapping("/book")
public class LoadBookNotesController {

	@Autowired
	LoadBookNotesService loadBookNotesService;
	
	@ResponseBody
	@RequestMapping("/loadNotes.do")
	public NoteResult<List<Note>> execute(String bookId){
		NoteResult<List<Note>> result =loadBookNotesService.loadBookNotes(bookId);
		return result;
		
	}
}
