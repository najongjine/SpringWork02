package com.biz.ems.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biz.ems.domain.EmailVO;
/*
 * VO에서 이미 어떤 table이랑 mapping이 되서, VO랑 mapping 시켜주면 해당 table이랑 chain mapping
 */
@Repository
public interface EmailDao extends CrudRepository<EmailVO, Long>{

	//EmailVO findByEms_seq(long ems_seq);
	//List<EmailVO> findAllByFromEmail(String from_email);
	//List<EmailVO> findAllByFromEmailOrderByEmsSeqAsc(String from_email);
	//List<EmailVO> findAllBySendDateGreaterThan(String send_date);
	//List<EmailVO> findAllBySendDateLessThan(String send_date);
	//List<EmailVO> findAllByFromEmailAndFromName(@Param("form_email") String from_email,@Param("from_name") String from_name);
	//List<EmailVO> findAllByFromEmailOrFromName(@Param("form_email") String from_email,@Param("from_name") String from_name);
}
