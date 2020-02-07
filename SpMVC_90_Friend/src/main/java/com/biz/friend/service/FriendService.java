package com.biz.friend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.repository.FriendDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FriendService {
	private final FriendDao friendDao;
	
	public List<FriendVO> findByf_name(String f_name,int limit, int offset){
		return friendDao.findByf_name(f_name,limit,offset);
	}
	
	public List<FriendVO> selectAll(int limit, int offset) {
		return friendDao.selectAll(limit, offset);
	}

	public FriendVO findByID(long f_id) {
		// TODO Auto-generated method stub
		return friendDao.findByID(f_id);
	}

	public int delete(long f_id) {
		// TODO Auto-generated method stub
		return friendDao.delete(f_id);
	}

	public int update(FriendVO friendVO) {
		return friendDao.update(friendVO);
	}

	public int insert(FriendVO friendVO) {
		// TODO Auto-generated method stub
		return friendDao.insert(friendVO);
	}
	
}
