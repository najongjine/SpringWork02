package com.biz.pet.service.najongjinUtil;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JongFileService {
	@Autowired
	String winFilePath;
	@Autowired
	String macFilePath;
	String fileUpLoadPath;
	
	@Autowired
	public void fileUpPath() {
		fileUpLoadPath=winFilePath;
		File path=new File(macFilePath);
		if(path.exists()){
			fileUpLoadPath=macFilePath;
		}
	}
	public String getFileUpLoadPath() {
		return fileUpLoadPath;
	}
	public String fileUp(MultipartFile u_file) {
		//업로드된 파일정보에서 파일이름만 추출
		String originName=u_file.getOriginalFilename();
		
		//tomcat server가 작동되고있는 곳에대한 정보
		//getRealPath("/"):= tomcat server가 우리 프로젝트를 서비스할때
		//root로 설정하여 여러가지 정보를 저장하고있는 폴더정보
		
		log.debug("ufile 상태: "+u_file.getOriginalFilename());
		if(u_file!=null) {
			// /files/ 폴더에대한 IO 정보를 추출
			File dir=new File(fileUpLoadPath);
			
			//현재 서버에 /files/라는 폴더가 없으면
			if(!dir.exists()) {
				dir.mkdirs();
			}
			//original 파일이름을 사용을 하면 해킹사고를 일으킬수 있기 때문에
			//파일 이름을 UUID로 설정하여 DB 테이블에 저장하자
			String strUUID=UUID.randomUUID().toString();
			strUUID+=originName;
			//uploadName+originName;
			// /product/files/2019.jpg 라는 이름으로 파일명을 만들고
			// 해당하는 파일에대한 정보를 객체로 생성하라
			File uploadFile= new File(fileUpLoadPath,strUUID);
			
			//web에서 upload된 파일(u_file)을 방금 설정한 파일이름(uploadFile)에 전송하라
			// web >> server로 파일이 복사가 된다.
			try {
				// u_file을 uploadFile로 복사하라
				//uploadFile로 저장하라
				u_file.transferTo(uploadFile);
				
				//파일이 정상적으로 upload가 되면 originalName을 controller로 return할 것이다.
				return strUUID;
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

	public void fileDelete(String p_file) {
		// TODO Auto-generated method stub
		File dFile=new File(winFilePath,p_file);
		if(dFile.exists()) {
			boolean ok=dFile.delete();
			if(ok) {
				log.debug("파일 삭제성공");
			} else {
				log.debug("파일삭제 실패");
			}
		} else {
			log.debug("삭제할 파일이 없음");
		}
	}
}
