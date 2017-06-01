package com.tedu.cloud_note_1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.cloud_note_1.dao.LoadNoteBodyDao;
import com.tedu.cloud_note_1.entity.Note;
import com.tedu.cloud_note_1.util.NoteResult;
@Service
public class LoadNoteBodyServiceImpl implements LoadNoteBodyService{
	private static Logger logger = LoggerFactory.getLogger(LoadNoteBodyServiceImpl.class);

	@Autowired
	LoadNoteBodyDao loadNoteBodyDao;
	
	public NoteResult<Note> LoadNoteBody(String NoteId) {
		Note note = loadNoteBodyDao.findNoteBodyByNoteId(NoteId);
		NoteResult<Note> result = new NoteResult<Note>();
		if(note != null){
			result.setStatus(0);
			result.setMsg("���رʼ����ݳɹ�");
			result.setData(note);
			logger.info("���رʼ����ݳɹ�");
		}else{
			result.setStatus(0);
			result.setMsg("���رʼ�����ʧ��");
			logger.warn("���رʼ�����ʧ��");
		}
		return result;
	}

}
