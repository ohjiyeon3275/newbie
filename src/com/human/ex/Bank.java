package com.human.ex;
import java.util.Scanner;

public class Bank {

   public static Scanner sc = new Scanner(System.in);
   
   public static String id[]=new String[100];
   public static String pw[]=new String[100];
   public static double account[]=new double[100];
   public static String inputId=null;
   public static String inputPw=null;
   public static int indexCount=0; //�α����Ҷ� �迭���� id ��ġ�� ã�� ��ȣ
   
   public static int listCount=4;//������ ����
   
   public static boolean isMain=false;
   public static boolean isPlay=false;
   public static boolean isUser=false;
   public static boolean isAdmin=false;
   
   
   
   //bankClass
   public String bankName="";
   public Bank() {}
 

public static void init() {
      //�ʱⰪ initial value
      id[0]="admin";id[1]="id1";id[2]="id2";id[3]="id3";
      pw[0]="admin";pw[1]="pw1";pw[2]="pw2";pw[3]="pw3";
      account[0]=0;account[1]=0;account[2]=0;account[3]=0;
   }
   
   
   public static void play() {
      //�޴� ���� �Լ�
      //��������忡�� �Է��Ҽ��ִ� ����� ��
      isMain=true;
      mainMenu();
      
      while(isPlay==true) {
         if(inputId==null){
            //�ƹ��͵� ���ϰ� �ٽ� while�� �ݺ�
         }else if(inputId.equals("exit")) {
            isPlay=false;
         }else if(inputId.equals("admin")&&inputPw.equals("admin")) {
            isAdmin=true;
            adminMenu();
            //����������޴� ����
         }else {
            isUser=true;
            userMenu();
            //����ڸ޴� ����
         }
      }
   }


   public static void mainMenu() {
      //ó�� ���� ������ �޴�
      while(isMain==true) {
         System.out.println("id �Է�>>");
         inputId=sc.nextLine();
         System.out.println("pw �Է�>>");
         inputPw=sc.nextLine();
            
         for(int i=0;i<id.length;i++) {
            if(inputId.equals(id[i])&&inputPw.equals(pw[i])) {
               indexCount=i;
               isPlay=true;
               isMain=false;
            }
         }
         
         
      }
   }
   
   public static void userMenu() {
      //user���� �޴�
      
      while(isUser==true) {
         System.out.println(id[indexCount]+"���� �α��� �ϼ̽��ϴ�.");
         System.out.println("1.�Ա� 2.��� 3.Ȯ�� 4.����(�����Է�)");
         int input = Integer.parseInt(sc.nextLine());
         if(input==1) {
            System.out.println("�Ա��� �ݾ��� �Է��ϼ���");
            int inputMoney = Integer.parseInt(sc.nextLine());
            account[indexCount]+=inputMoney;
            System.out.println("���� �ݾ���"+account[indexCount]+" �Դϴ�.");
         }else if(input==2) {
            System.out.println("����� �ݾ��� �Է��ϼ���");
            int withdrawMoney = Integer.parseInt(sc.nextLine());
            account[indexCount]-=withdrawMoney;
            System.out.println("���� �ݾ���"+account[indexCount]+" �Դϴ�.");
         }else if(input==3) {
            System.out.println("���� �ݾ���"+account[indexCount]+" �Դϴ�.");
         }else if(input==4) {
            isUser=false;
            isPlay=false;
         
         }else {
            System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~4 �ٽ� �Է����ּ���");
         }
      }
      
      
      
   }


   public static void adminMenu() {
      //�����ڸ޴�
      
      System.out.println("������ ���� �Դϴ�.");
      while(isAdmin==true) {
         System.out.println("1.���� �߰� 2. ���� ���� 3.��� ����� ���� Ȯ�� 4.id�� ����� ���� ��ȸ 5. ����");
         int input = Integer.parseInt(sc.nextLine());
         
         switch(input) {
            case 1 : 
               System.out.println("�߰��� ������ ID�� �Է��ϼ���");
               String newId=sc.nextLine();
               id[listCount]=newId;
               System.out.println("�߰��� ������ PW�� �Է��ϼ���");
               String newPw=sc.nextLine();
               pw[listCount]=newPw;
               account[listCount]=0;
               listCount++;
               
               break;
            case 2 :
               System.out.println("������ ������ ID�� �Է��ϼ���");
               String deleteId=sc.nextLine();
               System.out.println("������ ������ PW�� �Է��ϼ���");
               String deletePw=sc.nextLine();
               
               boolean isDelete=false;
               
               for(int i=0;i<=listCount;i++) {
                  if(deleteId.equals(id[i])&&deletePw.equals(pw[i])) {
                     isDelete=true;
                     for(int j=i;j<=listCount;j++) {
                        id[j]=id[j+1]; pw[j]=pw[j+1]; account[j]=account[j+1];
                        
                     }
                     listCount--;
                  }
               }
               
               
               
               if(isDelete==false) {
                  System.out.println("�Է��Ͻ� Id�� Pw�� �����ϴ�.");
               }
               
               break;
            
            case 3 :
               System.out.println("��� ����� ���� Ȯ��");
               for(int i=0;i<listCount;i++) {
                  System.out.println((i+1)+"��° ������� id : " +id[i]+" pw : "+pw[i]+" account : "+account[i]);
               }
               break;
            case 4 :
               System.out.println("ã�� ������ id�� �Է��ϼ���");
               String findId=sc.nextLine();
               int findIndex=-1;
               for(int i=0;i<listCount;i++) {
                  if(findId.equals(id[i])) {
                     findIndex=i;
                     System.out.println("ã�� ������ id : "+id[findIndex]+" pw : "+pw[findIndex]+" account : "+account[findIndex]);
                  }
               }
                  
               if(findIndex<0) {
                  System.out.println("ã�� ������ �����ϴ�.");
               }
               
               break;
            case 5 :
               isAdmin=false;
               isPlay=false;
               break;
            default :
               System.out.println("�ٽ� �Է����ּ��� 1~5");
            
               
         }   
      }
      
      
   }





   public static void main(String[] args) {
      init();
      play();
      

      
   }
   
   

}