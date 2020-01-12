package com.biz.rbooks.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TimeCalculationService {
	public float calcTimeDiff(String strStartedTime) {
		//현재시간 Date
		Date curtime = new Date();
		log.debug("!!! curtime:"+curtime);
		
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
		System.out.println("!!! 요청시간 : " + lstartime);
		System.out.println("!!! 현재시간 : " + lcurtime);
		System.out.println(diff+"시 차이");
		return diff;
	}
	
	public String getCurTime() {
		SimpleDateFormat curTime = new SimpleDateFormat ( "HH:mm:ss");
				
		Date time = new Date();
		
		String strcurTime = curTime.format(time);
		return strcurTime;
	}
	
	public String getCurDate() {
		SimpleDateFormat curDate = new SimpleDateFormat ( "yyyy-MM-dd");
				
		Date date = new Date();
		
		String strcurDate = curDate.format(date);
		return strcurDate;
	}
}
