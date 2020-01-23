package com.biz.gallery.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/*
 * 실제 파일을 filepath에 지정된 경로에 이름 바꾸고 업로드
 */
@Service
public class FileService {
	private final String filePath;
	
	@Autowired
	public FileService(String filePath) {
		super();
		this.filePath = filePath;
	}

	public String file_up(MultipartFile mFile) {
		if(mFile==null) {
			return null;
		}
		
		//folder object 생성
		File dir=new File(filePath);
		if(!dir.exists()) {
			//c:/bizwork/files
			//bizwork 폴더가 있고 files폴더만 없을때는 mkdir();
			//bizwork 폴더도 없고, files 폴더도 찾을수 없을땐 mkdirs()
			dir.mkdirs();
		}
		String strUUID=UUID.randomUUID().toString();
		String originalName=mFile.getOriginalFilename();
		String uploadFileName=strUUID+originalName;
		
		//upload할 파일객체 생성
		File uploadFile=new File(filePath,uploadFileName);
		try {
			mFile.transferTo(uploadFile);
			return uploadFileName;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void file_delete(String img_file) {
		/*
		 * filepath: /biz/files/
		 * img_file:aaa.jpg
		 * 결과값: /biz/files/aa.jpg 라는 형식으로 생성
		 */
		File file=new File(filePath,img_file);
		if(file.exists()) {
			file.delete();
		}
	}

	/*
	 * 서버에 파일이 저장된 path와 파일이름을 결합하여
	 * download가 가능한 file 객체를 생성하여 return
	 */
	public File file_down(String downFileName) {
		// TODO Auto-generated method stub
		File file=new File(filePath,downFileName);
		if(!file.exists() ) return null;
		return file;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
