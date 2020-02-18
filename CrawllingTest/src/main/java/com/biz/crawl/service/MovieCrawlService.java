package com.biz.crawl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.biz.crawl.domain.NaverMovieVO;
import com.biz.crawl.persistence.NaverDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MovieCrawlService {
	/*
	 * 네이버 현재 상영작 리스트에서 영화제목, 이미지, 순위를 가져오기 위해서 url, title이 들어있는 tag, image가 들어있는
	 * tag, rankList를 가져오기 위한 tag묶음 정보를 변수로 선언.
	 */
	private final String naverMovieURL = "https://movie.naver.com/movie/running/current.nhn";
	private final String naverStockURL = "https://finance.naver.com/item/main.nhn?code=005930";
	private final String mTitleTag = "dt.tit a";
	private final String mImageTag = "div.thumb a img";
	private final String rankListTag = "dl.lst_dsc";
	
	private final NaverDao nDao;
	
	public List<NaverMovieVO> selectAll(){
		return nDao.selectAll();
	}
	
	public String myCrawl() {
		Document naverMovieDoc = null;
		
		try {
			naverMovieDoc = Jsoup.connect(naverStockURL).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements testTags = naverMovieDoc.select("div.section.cop_analysis div.sub_section");

		return testTags.toString();
		
	}
	
	/*
	 * fixedRate:바로 이전 스케줄링이 시작된 이후에 다시 시작할수
	 * fixedDelay:바로 이전 스케줄링이 종료된 이후 
	 * 
	 * cron: Unix 시스템에서는 일정한 시간(년 월 일 시 분 초)를 지정해서
	 * 어떤 일을 정기적으로 수행할때 cron tab이라는 기능을 이용해서 작업을 지정할수 있다.
	 * 초,분,시,일,월,요일,년
	 * 매일 1:30:00 에 요 method를 실행하라.
	 */
	//@Scheduled(cron = "0 30 1 * * *")
	//@Scheduled(fixedDelay = 100000)
	public void naverMovieGet() {
		List<NaverMovieVO> naverList=movieRankGet();
		nDao.deleteAll();
		nDao.insertAll(naverList);
	}

	public List<NaverMovieVO> movieRankGet() {
		/*
		 * 방식은 gson이랑 비슷함.
		 * html 코드들을 다 가져오고 JSON으로 변환.
		 * JSON 객체에서 내장 메소드를 사용하여 java primitive 로 변환  
		 */
		// URL에 해당하는 html 페이지 코드를 가져오기
		// Document 라는 클래스에 담기
		// jsoup Document 클래스를 사용하여
		// Dom 형식의 Document를 만든다.
		Document naverMovieDoc = null;

		try {
			naverMovieDoc = Jsoup.connect(naverMovieURL).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DOM rankListTag문자열을 기준으로 리스트 추출
		Elements rankList = naverMovieDoc.select(rankListTag);

		// DOM 에서 imageTag 문자열을 기준으로 리스트 추출
		Elements imgList = naverMovieDoc.select(mImageTag);

		// Dom 에서 titleTag 문자열을 기준으로 리스트 추출
		Elements titleList = naverMovieDoc.select(mTitleTag);

		List<NaverMovieVO> naverList = new ArrayList<NaverMovieVO>();
		// rankList box들 중에 상위 1부터 10번까지만 가져오기 수행.
		for (int i = 0; i < 10; i++) {
			// dt.tit a에 담긴 text 추출하기==영화제목
			String title = titleList.get(i).text();

			// dt.tit a tag의 href 속성값을 추출==영화 자세히보기
			String detailUrl = "https://movie.naver.com"+titleList.get(i).attr("href");

			// div.thumb a img 의 src 속성값을 추출== 영화 이미지 url
			String imgUrl = imgList.get(i).attr("src");

			naverList.add(NaverMovieVO.builder().m_title(title).m_detail_url(detailUrl).
					m_image_url(imgUrl).m_rank(i+1).build());
		}
		return naverList;
	}
}
