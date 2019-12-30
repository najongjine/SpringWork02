package com.biz.pet.service.community;

import org.springframework.stereotype.Service;

import com.biz.pet.domain.community.PageDTO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PageService {

	private int listPerPage = 10;
	private int pageCount = 5;

	public void setListPerPage(int listPerPage) {
		this.listPerPage = listPerPage;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public PageDTO getPagination(long totalCount, int currentPageNo) {
		
		if(totalCount < 1) {
			return null;
		}
		
		int finalPageNo = ((int)totalCount + (listPerPage - 1)) / listPerPage;
		
		if(currentPageNo > finalPageNo) currentPageNo = finalPageNo;
		if(currentPageNo < 1) currentPageNo = 1;

		int startPageNo = ((currentPageNo -1) / pageCount) * pageCount + 1;
		
		int endPageNo = startPageNo + pageCount - 1;
		if(endPageNo > finalPageNo) endPageNo = finalPageNo;
		
		int prePageNo = 1;
		if(currentPageNo > 1) prePageNo = currentPageNo - 1;

		int nextPageNo = finalPageNo;
		if(currentPageNo < finalPageNo) nextPageNo = currentPageNo + 1;
		
		int offset = (currentPageNo - 1) * listPerPage + 1;
		
		int limit = offset + listPerPage - 1;
		
		PageDTO pageDTO = PageDTO.builder()
				.totalCount(totalCount)
				.pageCount(pageCount)
				.listPerPage(listPerPage)
				.offset(offset)
				.limit(limit)				
				.firstPageNo(1)
				.finalPageNo(finalPageNo)				
				.startPageNo(startPageNo)
				.endPageNo(endPageNo)				
				.prePageNo(prePageNo)
				.nextPageNo(nextPageNo)				
				.currentPageNo(currentPageNo)
				.build();
		
		return pageDTO;
		
	}
	
}
