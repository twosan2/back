//게시판 새업로드를 하기 위해 사용하는 클래스
package Team1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Cleaner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardControl {
	private File target = new File("DB"); //DS DB파일 경로
	//DS 게시판에 번호를 Map key로 사용한다
	private Map<Integer,List<Object>> map = new HashMap<>();
	//DS 게시판에 번호를 제외한 정보를 List로 저장한다
	private List<Object> list = new ArrayList();
	private String title; //DS 제목
	private String password; //DS 글 작성 시 비민번호
	private String img; //DS 결과 스크린샷 이미지 저장 경로
	private String text; //DS 본문 내용
	private int number; //DS 게시판에 게시물 등록 시 최신 번호 생성
	
	//DS 받은 전체 정보를 해당 필드에 저장 후 리스트에 저장한다
	public void allSet(String title,String password,String img, String text) {
		//DS 필드에 저장
		this.title = title;
		this.password = password;
		this.img = img;
		this.text = text;
		//DS 필드를 리스트에 저장
		list.add(this.title);
		list.add(this.password);
		list.add(this.img);
		list.add(this.text);
		list.add("홍길동"); //DS 게시물을 올린 사용자의 이름을 받아서 저장(홍길동으로 우선 저장함)
		//DS 현재 날짜를 구하고 list에 저장함
		String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		list.add(date); //DS 현재 날짜와 시간을 저장함
		list.add(0); //DS 해당 게시물 조회수를 list에 저장함(0으로 우선 저장함)
	}
	//DB에서 데이터를 불러와 map에 갱신 후 게시물 번호를 가장 큰 숫자로 갱신하는 메소드
	public void mapInput() {
		 try {
			 //DS 읽어오는 스트림 생성 DB에 읽어 올 데이터가 없으면 오류 발생 catch블록으로 간다
			 ObjectInputStream in = new ObjectInputStream(
			 new BufferedInputStream(new FileInputStream(target)));
			 //DS DB에 읽어 올 데이터가 존재하면 실행 된다
			 map = (Map<Integer,List<Object>>)in.readObject();
			 //DS DB에서 불러 map에 갱신한 key값 중에 가장 큰 값을 구해 1을 더한다(게시판에 게시물 생성 번호 갱신을 위함)
			 for(int key:map.keySet()) {
				 number = key;
				 if(key > number)
					 number = key;
			 }
			 number++;
			 map.put(number, list);
		 }catch(Exception e) {
			 //DS DB에서 불러 올 데이터가 있으면 실행
			 map.put(1, list);
		 }
	}
	//DS 갱신 된 map을 DB에 갱신하는 메소드
	public void mapOutput() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
			new BufferedOutputStream(new FileOutputStream(target)));
			
			out.writeObject(map);
			out.flush();
		}catch(Exception e) {
			System.out.println("DB에 데이터를 저장 중 오류");
		}
		System.out.println(map); //DS 최신 갱신 된 DB의 데이터 값을 확인 할 수 있음
	}
	
}









