package Team1;


public class Project_Main {
   private static boolean islogin = false;   //true : �α���â �����ϰ� �ٷ� ����  false : �α���â ȣ��
   
   public static void main(String[] args) {

      
      if(islogin == false) {
         LogIn window = new LogIn();
      }else
      {
         Main_Form window = new Main_Form();//�Ű������� �α��� ���� �Ѱ��ִ°� �����ؾ��� 
         //Main_Window window = new Main_Window(�����,�̸�,.....);
      }

   }
}