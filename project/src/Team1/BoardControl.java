//�Խ��� �����ε带 �ϱ� ���� ����ϴ� Ŭ����
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
	private File target = new File("DB"); //DS DB���� ���
	//DS �Խ��ǿ� ��ȣ�� Map key�� ����Ѵ�
	private Map<Integer,List<Object>> map = new HashMap<>();
	//DS �Խ��ǿ� ��ȣ�� ������ ������ List�� �����Ѵ�
	private List<Object> list = new ArrayList();
	private String title; //DS ����
	private String password; //DS �� �ۼ� �� ��ι�ȣ
	private String img; //DS ��� ��ũ���� �̹��� ���� ���
	private String text; //DS ���� ����
	private int number; //DS �Խ��ǿ� �Խù� ��� �� �ֽ� ��ȣ ����
	
	//DS ���� ��ü ������ �ش� �ʵ忡 ���� �� ����Ʈ�� �����Ѵ�
	public void allSet(String title,String password,String img, String text) {
		//DS �ʵ忡 ����
		this.title = title;
		this.password = password;
		this.img = img;
		this.text = text;
		//DS �ʵ带 ����Ʈ�� ����
		list.add(this.title);
		list.add(this.password);
		list.add(this.img);
		list.add(this.text);
		list.add("ȫ�浿"); //DS �Խù��� �ø� ������� �̸��� �޾Ƽ� ����(ȫ�浿���� �켱 ������)
		//DS ���� ��¥�� ���ϰ� list�� ������
		String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		list.add(date); //DS ���� ��¥�� �ð��� ������
		list.add(0); //DS �ش� �Խù� ��ȸ���� list�� ������(0���� �켱 ������)
	}
	//DB���� �����͸� �ҷ��� map�� ���� �� �Խù� ��ȣ�� ���� ū ���ڷ� �����ϴ� �޼ҵ�
	public void mapInput() {
		 try {
			 //DS �о���� ��Ʈ�� ���� DB�� �о� �� �����Ͱ� ������ ���� �߻� catch������� ����
			 ObjectInputStream in = new ObjectInputStream(
			 new BufferedInputStream(new FileInputStream(target)));
			 //DS DB�� �о� �� �����Ͱ� �����ϸ� ���� �ȴ�
			 map = (Map<Integer,List<Object>>)in.readObject();
			 //DS DB���� �ҷ� map�� ������ key�� �߿� ���� ū ���� ���� 1�� ���Ѵ�(�Խ��ǿ� �Խù� ���� ��ȣ ������ ����)
			 for(int key:map.keySet()) {
				 number = key;
				 if(key > number)
					 number = key;
			 }
			 number++;
			 map.put(number, list);
		 }catch(Exception e) {
			 //DS DB���� �ҷ� �� �����Ͱ� ������ ����
			 map.put(1, list);
		 }
	}
	//DS ���� �� map�� DB�� �����ϴ� �޼ҵ�
	public void mapOutput() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
			new BufferedOutputStream(new FileOutputStream(target)));
			
			out.writeObject(map);
			out.flush();
		}catch(Exception e) {
			System.out.println("DB�� �����͸� ���� �� ����");
		}
		System.out.println(map); //DS �ֽ� ���� �� DB�� ������ ���� Ȯ�� �� �� ����
	}
	
}









