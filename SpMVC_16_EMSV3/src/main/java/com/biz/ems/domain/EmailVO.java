package com.biz.ems.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

/*
 * @entity: import javax.persistence.Entity - JPA interface에 정의된 속성 지정
 * -지금부터 이 클래스는 entity 이니 물리적 테이블과 연동 되도록 준비하라.
 * 속성중에 다음 항목이 지정되어 있으면
 * <prop key="hibernate.hbm2ddl.auto">create</prop>
 * Entity에 지정된 속성에 따라 table을 생성하라.
 * create value: drop and create
 * 지정하지 않으면 기본값이 create
 * update로 지정하면 table이 없으면 생성을 하고
 * 만약 물리적  table과 구조가 다르면 오류가 발생한다. 
 * 주의
 *  -만약 hib.hbm2ddl.auto 속성을 지정하지 않으면 기본값으로 create가 지정되어 기존의 테이블을
 *  drop 한 후 재 작성해 버린다.
 *  create-only
 *  drop
 *  create
 *  create-drop: 시작할때 drop and create을 수행하고 session이 끝나면 다시 drop을 한다.
 *  validate:검증만
 *  update: 없으면 만들고, 있으면 validate.
 */
@Entity
@Table(name="tbl_ems",schema = "emsDB")
public class EmailVO {
//보내는 emial
	//받는 eamil
	//보내는 사람 이름
	//받는 사람 이름
	//제목
	//내용
	//작성일자
	//작성시각
	
	/*
	 * 필드변수에 @column, @id 속성을 지정
	 * -테이블에 칼럼으로 생성.
	 * @id:primary key 칼럼을 생성
	 * @GeneratedValue() 속성을 AUTO로 지정하면
	 *  auto_increament를 수행하여 insert할때 자동 값 채우기가 된다.
	 *  
	 *  table 컬럼명은 ems_seq로 지정하고
	 *  vo 클래스의 필드변수는 emsSeq로 사용.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ems_seq")
	private long ems_seq;
	
	/*
	 * @column()
	 * nullable: not null과 연관.
	 * nullable=false: not null
	 * nullable=true:default null 설정.
	 * length: 칼럼의 길이. 지정하지 않으면 DB기본값인 255.
	 * 칼럼을 생성할때는 필드변수의 이름과 같이 생성.
	 */
	@Column(name="from_email",nullable = false,length = 125)
	private String from_email;
	
	/*
	 * @Column(name="")
	 * 필드변수와 칼럼의 이름을 달리 설정하고자 할때
	 */
	@Column(name="to_email",nullable = false,length = 125)
	private String to_email;
	
	/*
	 * @Column(columnDefenition="")
	 * 칼럼의 type을 DB의 고유한 type으로 강제 적용.
	 */
	@Column(name="from_name",nullable = true,length = 125)
	@Nationalized//문자열 칼럼 type을 locale type에 따라 변경
	private String from_name;
	
	@Column(nullable = true,length = 125)
	@Nationalized
	private String to_name;
	
	@Column(nullable = false,length = 255)
	@Nationalized
	private String subject;
	
	@Column(nullable = true,length = 1000)
	@Nationalized
	private String content;
	
	@Column(name="send_date" ,nullable = true)
	private String send_date;
	
	@Column(name="send_time",nullable = true)
	private String send_time;
}
