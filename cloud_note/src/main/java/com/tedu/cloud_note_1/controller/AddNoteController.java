package com.tedu.cloud_note_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.entity.Note;
import com.tedu.cloud_note_1.service.AddNoteService;
import com.tedu.cloud_note_1.util.NoteResult;
@Controller
@RequestMapping("/note")
public class AddNoteController {

	@Autowired
	AddNoteService addNoteService;
	
	@ResponseBody
	@RequestMapping("/addNote.do")
	public NoteResult<Note> execute(String bookId,String title,String userId){
		
		NoteResult<Note> result=addNoteService.AddNotes(bookId, title,userId);
		return result;
		
	}
}
