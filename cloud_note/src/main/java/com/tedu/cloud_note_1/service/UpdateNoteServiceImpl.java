package com.tedu.cloud_note_1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.cloud_note_1.dao.LoadNoteBodyDao;
import com.tedu.cloud_note_1.dao.UpdateNoteDao;
import com.tedu.cloud_note_1.entity.Note;
import com.tedu.cloud_note_1.util.NoteResult;
@Service
public class UpdateNoteServiceImpl implements UpdateNoteService{
	private static Logger logger = LoggerFactory.getLogger(UpdateNoteServiceImpl.class);

	@Autowired
	UpdateNoteDao updateNoteDao;
	
	public NoteResult<Note> UpdateNote(Note note) {
		updateNoteDao.UpdateNote(note);
		//���º���ȥ�����ݿ�
		String noteId = note.getCn_note_id();
		Note notes= updateNoteDao.findNote(noteId);
	
		NoteResult<Note> result = new NoteResult<Note>();
		if(notes != null){
			result.setStatus(0);
			result.setMsg("���±ʼǳɹ�");
			result.setData(notes);
			logger.info("���±ʼǳɹ�");
		}else{
			result.setStatus(1);
			result.setMsg("���±ʼ�ʧ��");
			logger.warn("���±ʼ�ʧ��");
		}
		return result;
	}
	
}
