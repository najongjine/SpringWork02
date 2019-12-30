<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td   rowspan="2">WBC</td>
			<td   rowspan="2">백혈구</td>
			<td   rowspan="2">6~12(10x9/L)</td>
			<td  >증가 – 감염, 급만성 백혈병 임신</td>
		</tr>
		<tr>
			<td  >감소 – 재생불량선 빈혈, 골수이형성 증후군, 급성 백혈병, 항암 치료후등심</td>
		</tr>
		
		<tr>
			<td   rowspan="2">RBC</td>
			<td   rowspan="2">적혈구수(산소를 운반하는 중요한 역할)</td>
			<td   rowspan="2">5.5~8.5(10x12/L)</td>
			<td  >증가 : 탈수, 심폐질환, 다혈구혈증, 쇼크, 신장암, 구토, 설사등 의심</td>
		</tr>
		<tr>
			<td  >감소는 실혈성 빈혈, 용혈 (약물, 신수종, 양파등) 적혈구 생산불량, 골수억제
				의심</td>
		</tr>
		
		<tr>
			<td   rowspan="2">Hemoglobin(HB)</td>
			<td   rowspan="2">헤모글로빈</td>
			<td   rowspan="2">12~18(g/dl)</td>
			<td  >적혈구의 산소 운반능력 판정 낮으면 산소를 제대로 운반하지 못하게 됨.</td>
		</tr>
		<tr>
			<td  >감소: 빈혈, 출혈, 철 결핍 의미</td>
		</tr>
		
		<tr>
			<td >Hematocrit(Hct)</td>
			<td >헤마토크릿</td>
			<td >37~55(%)</td>
			<td  >적혈구의 비율로 빈혈/ 탈수 판정 /25%이하면 심각한 빈혈- 수혈필요/</td>
		</tr>
		
		<tr>
			<td  >MCV</td>
			<td ></td>
			<td  >60~77(fl)</td>
			<td  >평균 적혈구 용적, 적혈구 한 개의 크기가 얼마인지 나타내는 것으로 적혈구 수와 헤마토크릿 값을 계산하고 빈혈의 종류를 특정하기 위한 검사</td>
		</tr>
		
		<tr>
			<td  >MCH</td>
			<td  ></td>
			<td >60~77(fl)</td>
			<td  >평균 적혈구의 혈색소량, 한 개 적혈구 안에 헤모글로빈의 수치.</td>
		</tr>
				
		<tr>
			<td  >RDW-CV</td>
			<td  ></td>
			<td  >14~17(%)</td>
			<td  >적혈구 크기 차이 분포도, 적혈구 간의 크기의 차이가 크면수치가 높고 크기의 차이가 작으면 낮게 나온다.</td>
		</tr>
		
		<tr>
			<td  >Platelet</td>
			<td  >혈소판</td>
			<td  >200~500(10x9/L)</td>
			<td  >혈액 응고 – 지혈능력 판정 / 혈소판의 개수가 적으면 지혈작용에 문제가 있다. - 잦은출혈</td>
		</tr>
		
		<tr>
			<td   rowspan="2">MPV</td>
			<td   rowspan="2">평균혈소판 용적.</td>
			<td   rowspan="2">6.7~11.1(fl)</td>
			<td  >증가 : 혈소판 파괴 – 염증성 잘 질환, 백혈병, 골수</td>
		</tr>
		<tr>
			<td  >감소: 재생불량성 빈혈, 혈소판 수치가 정상이면서 MPV가 낮은 경우는 만성신부전증일 경우가 있다.</td>
		</tr>
				
		<tr>
			<td   rowspan="2">PCT</td>
			<td   rowspan="2">혈소판 용적의 백분율</td>
			<td   rowspan="2">0.14~0.46</td>
			<td  >증가 : 보통 악성종양</td>
		</tr>
		<tr>
			<td  >감소 : 의미없음</td>
		</tr>
				
		<tr>
			<td  >PDW-CV</td>
			<td  >혈소판 입자 분포 폭</td>
			<td  >9~17.5(%)</td>
			<td  >혈소판 입자 분포 폭. 혈소판 크기가 얼마나 일정한가. 혈소판 크기가 크다면 생성 초기의 혈소판을 반영하고 작다면 후기 혈소판을 의미한다.</td>
		</tr>
						
		<tr>
			<td  >WBC-Lymph(#)</td>
			<td  >림프구</td>
			<td  >1~4.8(10x9/L)</td>
			<td  ></td>
		</tr>
						
		<tr>
			<td   rowspan="2">WBC-Mono(#)</td>
			<td   rowspan="2">단핵 백혈구</td>
			<td   rowspan="2">0.15~1.35(10x9/L)</td>
			<td  >증가: 스트레스, 만성염증 의심</td>
		</tr>
		<tr>
			<td  >감소: 약물치료, 스테로이드 처방</td>
		</tr>
								
		<tr>
			<td  >WBC-Gran(#)</td>
			<td  >과립구(Granuocyte)</td>
			<td  >3~10(10x9/L)</td>
			<td  >특정 백혈구의 종류, 성장하는 어린동물 높고 나이가 들면 줄어드는 백혈구</td>
		</tr>
								
		<tr>
			<td   rowspan="2">WBC-Eos(#)</td>
			<td   rowspan="2">호산구(Eosinophils)</td>
			<td   rowspan="2">1~12.5(10x9/L)</td>
			<td  >증가: 염증성 질환, 알러지, 기생충, 심장사상충 감염을 나타냄.</td>
		</tr>
		<tr>
			<td  >감소 : 쿠싱증후군+ 알러지성 질환, 기생충증, 피부질환, PIE 증후군 등에서 호산구 증가는 진단에 꼭 필요한 소견</td>
		</tr>
										
		<tr>
			<td  >WBC-Baso</td>
			<td  >호염기성 백혈구</td>
			<td  ></td>
			<td  >증가; 심장사상충, 기생충 감염</td>
		</tr>
												
		<tr>
			<td  >WBC-Segs</td>
			<td  >분절호중성 백혈구</td>
			<td  ></td>
			<td  ></td>
		</tr>
	</table>
</body>
</html>