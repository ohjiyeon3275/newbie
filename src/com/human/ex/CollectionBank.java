package com.human.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CollectionBank {

   public static Scanner sc = new Scanner(System.in);

   public static ArrayList<String> id = new ArrayList<String>();
   public static ArrayList<String> pw = new ArrayList<String>();
   public static ArrayList<Double> account = new ArrayList<Double>();
   
   public static double accountMoney =0;
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
   public CollectionBank() {}
 

public static void init() {
      //�ʱⰪ initial value
    id.add("id1");id.add("id2");id.add("id3");
    pw.add("pw1");pw.add("pw2");pw.add("pw3");
    account.add(0.0);account.add(0.0);account.add(0.0);
	
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
    
        if(id.indexOf(inputId)==pw.indexOf(inputPw)) {
           indexCount=id.indexOf(inputId);
           isPlay=true;
           isMain=false;
        
        }else {
        	System.out.println("�ٽ� �Է����ּ���");
        }
         
         
      }
   }
   
   public static void userMenu() {
      //user���� �޴�
      
      while(isUser==true) {
         System.out.println(id.get(indexCount)+"���� �α��� �ϼ̽��ϴ�.");
         System.out.println("1.�Ա� 2.��� 3.Ȯ�� 4.����(�����Է�)");
         int input = Integer.parseInt(sc.nextLine());
         if(input==1) {
            System.out.println("�Ա��� �ݾ��� �Է��ϼ���");
             int inputMoney = Integer.parseInt(sc.nextLine());
             accountMoney = account.get(indexCount);
             accountMoney += inputMoney;
             account.set(indexCount, accountMoney);
            System.out.println("���� �ݾ���"+account.get(indexCount)+" �Դϴ�.");
         }else if(input==2) {
            System.out.println("����� �ݾ��� �Է��ϼ���");
            int withdrawMoney = Integer.parseInt(sc.nextLine());
            accountMoney = account.get(indexCount);
            accountMoney -= withdrawMoney;
            account.set(indexCount, accountMoney);
            System.out.println("���� �ݾ���"+account.get(indexCount)+" �Դϴ�.");
         }else if(input==3) {
            System.out.println("���� �ݾ���"+account.get(indexCount)+" �Դϴ�.");
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
               id.add(newId);
               System.out.println("�߰��� ������ PW�� �Է��ϼ���");
               String newPw=sc.nextLine();
               pw.add(newPw);
               account.add(0.0);
               listCount++;
               
               break;
            case 2 :
               System.out.println("������ ������ ID�� �Է��ϼ���");
               String deleteId=sc.nextLine();
               System.out.println("������ ������ PW�� �Է��ϼ���");
               String deletePw=sc.nextLine();
               
               boolean isDelete=false;
               
               for(int i=0;i<=listCount;i++) {
                  if(id.indexOf(deleteId)==pw.indexOf(deletePw)) {
                     isDelete=true;
                     id.remove((String)deleteId);
                     pw.remove((String)deletePw);
                     account.remove(listCount);
                     listCount--;
                  }
               }
               
               if(isDelete==false) {
                  System.out.println("�Է��Ͻ� Id�� Pw�� �����ϴ�.");
               }
               
               break;
            
            case 3 :
               System.out.println("��� ����� ���� Ȯ��");
               
               Iterator<String> idIter = id.iterator();
               Iterator<String> pwIter = pw.iterator();
               Iterator<Double> accIter = account.iterator();
               
               while(idIter.hasNext()) {
       			System.out.println("id : " + idIter.next()+" pw : "+pwIter.next()+" account : "+accIter.next());
               }
               break;
            case 4 :
               System.out.println("ã�� ������ id�� �Է��ϼ���");
               String findId=sc.nextLine();
               int findIndex=id.indexOf(findId);
               System.out.println("ã�� ������ id�� "+id.get(findIndex)+" pw�� "+pw.get(findIndex)+" account�� "+account.get(findIndex)+"�Դϴ�.");
                  
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