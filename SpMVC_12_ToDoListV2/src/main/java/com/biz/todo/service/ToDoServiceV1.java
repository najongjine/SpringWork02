package com.biz.todo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;
import com.biz.todo.repository.ToDoListDao;

@Service("toServiceV1")
public class ToDoServiceV1 implements ToDoService {
	/* mybatis-context에 설정해 줌
	 * <bean class="org.mybatis.spring.mapper.MapperFactoryBean">
	<property name="mapperInterface">
		<value>com.biz.todo.repository.ToDoListDao</value>
	</property>
	<property name="sqlSessionFactory" ref="sqlSessionFactory"/>
</bean>
sqlsession을 안만들어 줘도 바로 dao 사용 가능
	 */
	@Autowired
	protected ToDoListDao toDao;
	
	@Override
	public List<ToDoList> selectAll() {
		// TODO Auto-generated method stub
		return toDao.selectAll();
	}

	@Override
	public int insert(ToDoList todoList) {
		// TODO Auto-generated method stub
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st=new SimpleDateFormat("hh:mm:ss");
		String curDate=sd.format(date);
		String curTime=st.format(date);
		//todoList.setTd_date(curDate);
		//todoList.setTd_time(curTime);
		
		/*
		String strTdComp=todoList.getTd_complete();
		if(strTdComp==null || strTdComp.isEmpty()) {
			todoList.setTd_complete("N");
		}
		String strtd_alarm=todoList.getTd_alarm();
		if(strtd_alarm==null || strtd_alarm.isEmpty()) {
			todoList.setTd_alarm("N");
		}
		*/
		int ret=toDao.insert(todoList);
		return ret;
	}

	@Override
	public ToDoList findBySeq(long td_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ToDoList> findBySubject(String Subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ToDoList todoList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long td_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int complete(String strSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alarm(String strSeq) {
		// TODO Auto-generated method stub
		return 0;
	}


}
