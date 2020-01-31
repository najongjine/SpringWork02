package com.biz.todo.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EncService {
	private StandardPBEStringEncryptor pbeEncryptor=new StandardPBEStringEncryptor();
	
	//시스템에 등록된 환경변수 전체를 이름,값 으로 뽑아옴.
	private Map<String, String> envList = System.getenv();
			
	//한경변수 목록들 중에서 이름이 "NAVER"로 된 값을 salt로 씀
	private String saltPass = envList.get("NAVER");
	
	{
		// 암호화 설정
		pbeEncryptor.setAlgorithm("PBEWithMD5AndDES");
		pbeEncryptor.setPassword(saltPass);
	}
	
	public String encString(String strPlain) {
		if(strPlain.isEmpty() || strPlain==null) {
			log.debug("plain text is null");
			return null;
		}
		if (saltPass == null || saltPass.isEmpty()) {
			log.debug("salt Password Not Found");
			return null;
		}
		
		String strEncrypted=pbeEncryptor.encrypt(strPlain);
		return strEncrypted;
	}//end encrypt
	
	public String decString(String strEnc){
		if(strEnc.isEmpty() || strEnc==null) {
			log.debug("strEnc is null");
			return null;
		}
		if (saltPass == null || saltPass.isEmpty()) {
			log.debug("salt Password Not Found");
			return null;
		}
		
		String strPlain=pbeEncryptor.decrypt(strEnc);
		return strPlain;
	}//end decrypt
	
	private static void writeToPropsFile() {
		StandardPBEStringEncryptor pbeEncryptor=new StandardPBEStringEncryptor();
		
		//시스템에 등록된 환경변수 전체를 이름,값 으로 뽑아옴.
		Map<String, String> envList = System.getenv();
				
		//한경변수 목록들 중에서 이름이 "NAVER"로 된 값을 salt로 씀
		String saltPass = envList.get("NAVER");
		pbeEncryptor.setAlgorithm("PBEWithMD5AndDES");
		pbeEncryptor.setPassword(saltPass);
		
		Scanner scanner=new Scanner(System.in);
		String proFileDir = "./src/main/webapp/WEB-INF/spring/appServlet/props";
		
		//내가 원하는 properties 파일 이름과 변수목록 설정
		Map<String, String[]> secFileList = new TreeMap<String, String[]>();
		secFileList.put("hiber.user.properties", new String[] { "mysql.user", "mysql.password" });
		secFileList.put("naver.email.properties",
				new String[] { "naver.username", "naver.password", "naver.client.id", "naver.client.secret" });
		Set<String> files = secFileList.keySet();
		
		try {
			for (String file : files) {
				File proFile = new File(proFileDir, file);
				System.out.println("================================");
				System.out.println(proFile.getAbsolutePath() + "파일생성");
				System.out.println("-------------------------------------");

				PrintWriter out = new PrintWriter(proFile);
				
				for(String key: secFileList.get(file)) {
					System.out.print(key+":");
					String plainString=scanner.nextLine();
					if(plainString.isEmpty()) {
						System.out.println("Exit!!!");
						out.close();
						return;
					}
					String encString = pbeEncryptor.encrypt(plainString);
					
					//변수=ENC(값)
					encString=String.format("%s=ENC(%s)",key,encString);
					System.out.println(encString);
					out.println(encString);
					out.flush();
				}
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		scanner.close();
	}//end write props file
	public static void main(String[] args) {
		writeToPropsFile();
	}
}
