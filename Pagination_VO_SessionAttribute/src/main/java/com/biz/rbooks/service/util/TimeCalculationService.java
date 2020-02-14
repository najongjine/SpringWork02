package com.biz.rbooks.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TimeCalculationService {
	
	/*
	 * 시차 계산을 하는 method
	 * 내가봐도 다시 짜기 싫다.
	 */
	public float calcTimeDiff(String strStartedTime) {
		//현재시간 Date
		Date curtime = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String strcurtime = dateFormat.format(curtime);
		
		Date startedTime=null;
		
		try {
			startedTime = dateFormat.parse(strStartedTime);
			curtime = dateFormat.parse(strcurtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			log.debug("날자 변환중 오류 발생");
		}
		long lcurtime=curtime.getTime();
		long lstartime=startedTime.getTime();
		float diff = (lcurtime-lstartime);
		diff=diff/60000;
		return diff;
	}
	
	//현재 시간을 구하는 method
	// 이게 어디서 호출 됬는지 까먹음
	public String getCurTime() {
		SimpleDateFormat curTime = new SimpleDateFormat ( "HH:mm:ss");
				
		Date time = new Date();
		
		String strcurTime = curTime.format(time);
		return strcurTime;
	}
	
	//현재 날짜를 구하는 method
	//이게 어디서 호출 됬는지 까먹음
	public String getCurDate() {
		SimpleDateFormat curDate = new SimpleDateFormat ( "yyyy-MM-dd");
				
		Date date = new Date();
		
		String strcurDate = curDate.format(date);
		return strcurDate;
	}
}
