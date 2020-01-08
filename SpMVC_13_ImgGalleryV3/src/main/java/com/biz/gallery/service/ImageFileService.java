package com.biz.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.repository.ImageFilesDao;

@Service
public class ImageFileService {
	protected final FileService fService;
	protected final ImageFilesDao ifDao;
	
	@Autowired
	public ImageFileService(ImageFilesDao ifDao,FileService fService) {
		this.ifDao=ifDao;
		this.fService=fService;
	}
	
	public int imageFileInsert(List<ImageFilesVO> img_files) {
		int ret=0;
		for(ImageFilesVO file: img_files) {
			ret+=ifDao.insert(file);
		}
		return ret;
	}
	
	public int imageFileInsert(List<ImageFilesVO> img_files,long img_p_code) {
		int ret=0;
		if(img_files==null) return -1;
		ret= ifDao.bulk_insert(img_files, img_p_code);
		return ret;
	}
	
	public int imageFileDeleteByPCode(long img_seq) {
		int ret=ifDao.delete(img_seq);
		return ret;
	}

	public int deleteBySeq(long img_file_seq) {
		// TODO Auto-generated method stub
		ImageFilesVO imgsVO=ifDao.findBySeq(img_file_seq);
		fService.file_delete(imgsVO.getImg_file_upload_name());
		return ifDao.deleteBySeq(img_file_seq);
	}

	public ImageFilesVO findBySeq(String img_id) {
		return ifDao.findBySeq(Long.valueOf(img_id));
	}

	public int img_file_delete(String img_id) {
		return ifDao.deleteBySeq(Long.valueOf(img_id));
		
	}
}
