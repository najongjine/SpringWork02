package com.biz.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.todo.domain.ToDoList;

/*
 * mybatis 3.4부터 mapper.xml을 사용하지 않는 새로운 형식이 등장
 * 
 * 아직은 완전하게 mapper.xml에 사용한 모든 코드를 사용하기가 어렵다
 * 하지만 version up이 되면서 xml을 사용하지 않고 있다.
 */
public interface ToDoListDao {
	/*
	 * mybatis의 mapper를 대신하는 Annotation
	 */
	@Select("select * from tbl_todolist")
	public List<ToDoList> selectAll();
	
	@InsertProvider(type = ToDoListSQL.class,method = "insert_sql")
	public int insert(ToDoList todoList);
	
	/*
	 * mapper Annotation레 문자열로 sql문을 작성해야 하는데
	 * sql문이 복잡할 경우는 별도의 String 문자열 변수를 불러와서 사용할수 있다.
	 * 이때 sql문을 작성하는 String 문자열 변수는 반드시 final static String 이어야한다.
	 */
	@Update(ToDoListSQL.complete_sql)
	public int complete(@Param("td_seq") long td_seq);
	
	/*
	 * ToDoListSQL 클래스에 정의된 alarm_sql method를 호출하여
	 * 동적 쿼리를 가져와서 Update을 수행하라.
	 * 
	 * @Param:= 오른쪽에 있는 변수이름을 왼쪽에 있는 (param) 이름으로 SQL에 전달하라
	 */
	@UpdateProvider(type = ToDoListSQL.class,method = "alarm_sql")
	public int alarm(@Param("td_seq") long td_seq);
	
	@Delete("delete from tbl_todolist where td_seq=#{td_seq}")
	public int delete(long td_seq);
	
	@UpdateProvider(type = ToDoListSQL.class,method = "update_sql")
	public int update(ToDoList toDoList);

	@Select("select * from tbl_todolist where td_seq=#{td_seq}")
	public ToDoList findBySeq(long td_seq);

	@Select("select * from tbl_todolist where like '%' || #{td_subject} || '%' ")
	public List<ToDoList> findBySubject(String td_subject);
}
