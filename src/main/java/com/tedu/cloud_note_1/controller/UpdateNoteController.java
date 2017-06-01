package com.tedu.cloud_note_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloud_note_1.entity.Note;
import com.tedu.cloud_note_1.service.UpdateNoteService;
import com.tedu.cloud_note_1.util.NoteResult;

@Controller
@RequestMapping("/note")
public class UpdateNoteController {
	
	@Autowired
	UpdateNoteService updateNoteService;
	
	@ResponseBody
	@RequestMapping("/updateNote.do")
	public NoteResult<Note> execute(String noteId,String body,String title){
		Note note = new Note();
		note.setCn_note_body(body);
		note.setCn_note_title(title);
		note.setCn_note_id(noteId);
		NoteResult<Note> result = updateNoteService.UpdateNote(note);
		return result;
		
	}
}






