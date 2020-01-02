package com.biz.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;
import com.biz.todo.repository.ToDoListDao;

@Service("toServiceV2")
public class ToDoServiceV2 extends ToDoServiceV1 {

	@Override
	public int complete(String strSeq) {
		long td_seq = Long.valueOf(strSeq);
		return toDao.complete(td_seq);
	}

	@Override
	public int alarm(String strSeq) {
		long td_seq = Long.valueOf(strSeq);
		return toDao.alarm(td_seq);
	}

	@Override
	public int update(ToDoList todoList) {
		
		return toDao.update(todoList);
		
	}

	@Override
	public int delete(long td_seq) {
		return toDao.delete(td_seq);
	}

}
