package com.tedu.cloud_note_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.service.DeleteNoteService;
import com.tedu.cloud_note_1.util.NoteResult;

@Controller
@RequestMapping("/note")
public class DeleteNoteCobtroller {

	@Autowired
	DeleteNoteService deleteNoteService;
	
	@ResponseBody
	@RequestMapping("/deleteNote.do")
	public NoteResult<Object> execute(String noteId){
		NoteResult<Object> res=deleteNoteService.deletNote(noteId);
		return res;
		
	}
}
