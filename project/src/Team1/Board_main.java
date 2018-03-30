package Team1;


import java.awt.Font;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Board_main extends JFrame{
	//DS 선언식으로 모아 둔 변수 생성 위치들 변경함
   JPanel mainPanel = new JPanel();
   JLabel lblNewLabel = new JLabel("제목");
   JTextField textField = new JTextField();
   JLabel label = new JLabel("번호");
   JTextField textField_1 = new JTextField();
   JLabel label_1 = new JLabel("날짜");
   JTextField textField_2 = new JTextField();
   JTextArea textArea = new JTextArea();
   JTextArea textArea_1 = new JTextArea();
   JTextArea textArea_2 = new JTextArea();
   JTextArea textArea_3 = new JTextArea();
   JButton btnNewButton = new JButton("수정");
   JButton button = new JButton("삭제");
   //DS DB경로 생성
   private File target = new File("DB");
   private ImageIcon img;
   //DS 게시판 번호가 저장 되는 변수
   private int number;
   //DS 클릭한 게시물의 map데이터를 가져와 갱신할 map,list생성
   private Map<Integer,List<Object>> map = new HashMap<>();
   private List<Object> list = new ArrayList();
   
   //main에 하던 설정들을 생성자에서 진행
   public Board_main(int number) {
	   //DS 생성자에서 게시물 번호를 전달 받아 number변수에 저장한다
	  this.number = number;
	  //DS DB에서 전체 map데이터를 불러와서 number에 해당하는 map데이터만을 list에 갱신한다
	  try{
		  //DS DB에서 읽어오는 스트림 생성
		  ObjectInputStream mapInput = new ObjectInputStream(
		  new BufferedInputStream(new FileInputStream(target)));
		  //DS DB에서 전체 map 정보를 불러와 현재 map에 갱신
		  map = (Map<Integer,List<Object>>)mapInput.readObject();
		  //DS 현재 map에서 number(게시물 번호)에 해당하는 key값의 value만을 현재 list에 저장
		  list = map.get(number);
		  //System.out.println(list.get(1)); //DS DB에서 가져온 해당 게시물 내용을 확인할 수 있다
	  }catch(Exception e) {
		  System.out.println("DB에서 데이터를 가져올 때 오류");
	  }
	  
	  
      this.display();//화면 구성 관련 처리
      this.event();//이벤트 관련 처리
      this.menu();//메뉴 관련 처리
      
      this.setTitle("게시판 내용 확인");
      this.setSize(1000, 600);
      //this.setLocation(100, 100);
      //위치를 운영체제가 결정하도록 한다
      this.setLocationByPlatform(true);
      this.setResizable(false);
      this.setVisible(true);
   }

   private void display() {
      this.setContentPane(mainPanel);
      mainPanel.setLayout(null);
      
     
      lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
      lblNewLabel.setBounds(12, 10, 28, 21);
      mainPanel.add(lblNewLabel);
      
      
      label.setFont(new Font("굴림", Font.PLAIN, 14));
      label.setBounds(254, 10, 28, 21);
      mainPanel.add(label);
      
      
      label_1.setFont(new Font("굴림", Font.PLAIN, 14));
      label_1.setBounds(495, 10, 28, 21);
      mainPanel.add(label_1);
      
      
      textField.setBounds(47, 11, 145, 26);
      mainPanel.add(textField);
      //list의 0인덱스(제목)를 필드에 채움
      textField.setText((String)list.get(0));
      
      
      textField_1.setColumns(10);
      textField_1.setBounds(294, 11, 145, 26);
      mainPanel.add(textField_1);
      //Main_Form에서 받은 게시판 번호(number)를 필드에 채움
      textField_1.setText(String.valueOf(number));
      
      textField_2.setColumns(10);
      textField_2.setBounds(535, 11, 167, 26);
      mainPanel.add(textField_2);
      //list의 5인덱스(날짜)를 필드에 채움
      textField_2.setText((String)list.get(5));
      
      
      textArea.setBounds(12, 41, 481, 320);
      mainPanel.add(textArea);
    //list의 2인덱스(캡쳐한 이미지 경로)를 이미지 변수에 저장
      img = (ImageIcon)list.get(2);
      //여기서부터 진행   TextArea에는 ImageIcon을 넣기가 힘들다 TextArea를 변경해야 할 것 같다..
	  
      
      textArea_1.setBounds(505, 41, 197, 320);
      mainPanel.add(textArea_1);
      
      JScrollPane scroll = new JScrollPane(textArea_1);
      scroll.setBounds(505, 41, 197, 320);
      mainPanel.add(scroll);
      
      
      textArea_2.setBounds(12, 371, 690, 130);
      mainPanel.add(textArea_2);
      
      JScrollPane scroll_1 = new JScrollPane(textArea_2);
      scroll_1.setBounds(12, 371, 690, 130);
      mainPanel.add(scroll_1);
      
      
      textArea_3.setBounds(720,30,240,500);
      mainPanel.add(textArea_3);
      //textArea_3.setText("광고"); //광고 내용이 담길 공간
      
      btnNewButton.setBounds(500, 511, 97, 45);
      mainPanel.add(btnNewButton);
      
      
      button.setBounds(605, 511, 97, 45);
      mainPanel.add(button);
   }

   private void event() {
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      //setDefaultCloseOperation(HIDE_ON_CLOSE);
      //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//JFrame 기본 이벤트 방지
      
   }

   private void menu() {
      
   }



//   public static void main(String[] args) {
//      /*
////스킨 설치
//      try {
//         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//      } catch (Exception e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//      */
//      //창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
//	   Board_main window = new Board_main();
//      
//   }
}