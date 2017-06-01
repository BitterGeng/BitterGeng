package com.tedu.cloud_note_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.entity.Note;
import com.tedu.cloud_note_1.service.LoadNoteBodyService;
import com.tedu.cloud_note_1.util.NoteResult;
@Controller
@RequestMapping("/note")
public class LoadNoteBodyController {

	@Autowired
	LoadNoteBodyService loadNoteBodyService;
	
	@ResponseBody
	@RequestMapping("/loadNoteBody.do")
	public NoteResult<Note> execute(String noteId){
		NoteResult<Note> result = loadNoteBodyService.LoadNoteBody(noteId);
		return result;
		
	}
}
