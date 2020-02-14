package com.biz.rbooks.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BookReadBookViewVO;
import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.MemberReadBookBooksViewVO;
import com.biz.rbooks.domain.util.PageDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PageService {
	private long listPerPage=10;
	private long pageCount=5;
	private long maxListSize=0;;
	
	
	public void setListPerPage(long listPerPage) {
		this.listPerPage = listPerPage;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}


	/*
	 * 최소한의 조건으로 페이지를 계산하기 위한 method
	 * 전체 데이터개수와 현재 선택된 페이지번호만 매개변수로만 받아서
	 * 페이지 정보를 만들어내기
	 */
	public PageDTO makePageNation(long totalCount,long currentPageNo) {
		//데이터가 없으면 중단
		if(totalCount<1) return null;
		
		//전체데이터+보여질리스트-1  / 보여질리스트
		long finalPageNo=(totalCount+(listPerPage-1))/listPerPage;
		
		//naver는 페이지를 검색할때 1000페이지가 넘어가면 오류를 낸다.
		//finalPageNo=finalPageNo >1000? 1000:finalPageNo;
		
		//currentPageNo 가 마지막 페이지보다 크면
		if(currentPageNo>finalPageNo) currentPageNo=finalPageNo;
		
		if(currentPageNo<1) currentPageNo=1;
		
		//이전,이후를 계산하기 위해서 현재 페이지번호가 첫페이지인가, 마지막페이지인가를 검사해서
		//flag를 셋팅
		boolean isNowFirst=currentPageNo==1;
		boolean isNowFinal=currentPageNo==finalPageNo;
		
		//하단에 리스트로 보여줄 페이지 계산
		//cur:3 이면 1~5, cur 10이면 8~12
		long startPageNo=((currentPageNo-1)/pageCount)*pageCount+1;
		
		long endPageNo=startPageNo+pageCount-1;
		
		if(endPageNo>finalPageNo) endPageNo=finalPageNo;
		PageDTO pageDTO=PageDTO.builder().totalCount(totalCount).pageCount(pageCount)
				.listPerPage(listPerPage).firstPageNo(1)
				.finalPageNo(finalPageNo)
				.endPageNo(endPageNo).startPageNo(startPageNo)
				.currentPageNo(currentPageNo).build();
		if(isNowFirst) pageDTO.setPrePageNo(1);
		else pageDTO.setPrePageNo((currentPageNo-1) <1? 1:currentPageNo-1);
		if(isNowFinal) pageDTO.setNextPageNo(finalPageNo);
		else pageDTO.setNextPageNo((currentPageNo+1) > finalPageNo ? finalPageNo :currentPageNo+1);
		
		return pageDTO;
	}
	
	/*
	 * 자바코드로 구현한 pagination
	 * sql 로 select을 한 리스트에서 특정 갯수만 따로 뽑아서 리턴하는 기법.
	 */
	public List<BooksVO> makeViewAllBooksPagination(List<BooksVO> booksList, int currentPageNo) {
		List<BooksVO> perPageList=new ArrayList<BooksVO>();
		maxListSize=booksList.size();
		PageDTO pageDTO=getPage(currentPageNo);
		//1*10.   1~10.    0~9\
		int endItem=0;
		int startItem=0;
		try {
			endItem=(int) (pageDTO.getCurrentPageNo()*pageDTO.getListPerPage());
			startItem=(int) ((pageDTO.getCurrentPageNo()-1)*pageDTO.getListPerPage());
		} catch (Exception e) {
			log.debug("검색결과 리스트 없음");
			return null;
		}
		
		try {
			perPageList.removeAll(perPageList);
			for(int i=startItem;i<endItem;i++) {
				BooksVO booksVO=booksList.get(i);
				perPageList.add(booksVO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.debug("!!! pagedList: "+perPageList.size());
		return perPageList;
	}
	
	public List<BookReadBookViewVO> makeSimpleViewListPagination(List<BookReadBookViewVO> bookReadBookViewList, int currentPageNo) {
		List<BookReadBookViewVO> perPageList=new ArrayList<BookReadBookViewVO>();
		maxListSize=bookReadBookViewList.size();
		PageDTO pageDTO=getPage(currentPageNo);
		//1*10.   1~10.    0~9
		int endItem=0;
		int startItem=0;
		try {
			endItem=(int) (pageDTO.getCurrentPageNo()*pageDTO.getListPerPage());
			startItem=(int) ((pageDTO.getCurrentPageNo()-1)*pageDTO.getListPerPage());
		} catch (Exception e) {
			log.debug("검색결과 리스트 없음");
			return null;
		}
		try {
			perPageList.removeAll(perPageList);
			for(int i=startItem;i<endItem;i++) {
				BookReadBookViewVO bookReadBookViewVO=bookReadBookViewList.get(i);
				perPageList.add(bookReadBookViewVO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return perPageList;
	}
	
	public List<MemberReadBookBooksViewVO> makeMyBookListPagination(List<MemberReadBookBooksViewVO> memberReadBookBooksViewList, int currentPageNo) {
		List<MemberReadBookBooksViewVO> perPageList=new ArrayList<MemberReadBookBooksViewVO>();
		maxListSize=memberReadBookBooksViewList.size();
		PageDTO pageDTO=getPage(currentPageNo);
		//1*10.   1~10.    0~9
		int endItem=0;
		int startItem=0;
		try {
			endItem=(int) (pageDTO.getCurrentPageNo()*pageDTO.getListPerPage());
			startItem=(int) ((pageDTO.getCurrentPageNo()-1)*pageDTO.getListPerPage());
		} catch (Exception e) {
			log.debug("검색결과 리스트 없음");
			return null;
		}
		try {
			perPageList.removeAll(perPageList);
			for(int i=startItem;i<endItem;i++) {
				MemberReadBookBooksViewVO MemberReadBookBooksViewVO=memberReadBookBooksViewList.get(i);
				perPageList.add(MemberReadBookBooksViewVO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return perPageList;
	}
	
	public PageDTO getPage(long currentPageNo) {
		long totalCount=maxListSize;
		if(totalCount>maxListSize) totalCount=maxListSize;
		PageDTO pageDTO=makePageNation(totalCount, currentPageNo);
		log.debug("전체갯수: "+totalCount);
		
		return pageDTO;
	}
}
