package com.tedu.cloud_note_1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.cloud_note_1.dao.LoadBookNoteDao;
import com.tedu.cloud_note_1.entity.Book;
import com.tedu.cloud_note_1.util.NoteResult;
@Service
public class LoadBookNoteServiceImpl implements LoadBookNoteService{
	private static Logger logger = LoggerFactory.getLogger(LoadBookNoteServiceImpl.class);

	@Autowired
	LoadBookNoteDao loadBookNoteDao;
	
	public NoteResult<List<Book>> loadBookNote(String userId) {
		List<Book> books = loadBookNoteDao.findByBookId(userId);
//		for(Book bo:books){
//			System.out.println(bo.getCn_notebook_name());
//		}
		NoteResult<List<Book>> result = new NoteResult<List<Book>>();
		if(books.size()>0){
			
			result.setStatus(0);
			result.setMsg("���رʼǱ��ɹ�");
			result.setData(books);
			logger.info("���رʼǱ��ɹ�");
		}else{
			result.setStatus(1);
			result.setMsg("���رʼǱ�ʧ��");
			result.setData(books);
			logger.warn("���رʼǱ�ʧ��");
		}
		
		return result;
	}

}
