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
   public static int indexCount=0; //로그인할때 배열에서 id 위치를 찾는 번호
   
   public static int listCount=4;//데이터 개수
   
   public static boolean isMain=false;
   public static boolean isPlay=false;
   public static boolean isUser=false;
   public static boolean isAdmin=false;
   
   
   
   //bankClass
   public String bankName="";
   public CollectionBank() {}
 

public static void init() {
      //초기값 initial value
    id.add("id1");id.add("id2");id.add("id3");
    pw.add("pw1");pw.add("pw2");pw.add("pw3");
    account.add(0.0);account.add(0.0);account.add(0.0);
	
   }
   
   
   public static void play() {
      //메뉴 실행 함수
      //사용자입장에서 입력할수있는 경우의 수
      isMain=true;
      mainMenu();
      
      while(isPlay==true) {
         if(inputId==null){
            //아무것도 안하고 다시 while문 반복
         }else if(inputId.equals("exit")) {
            isPlay=false;
         }else if(inputId.equals("admin")&&inputPw.equals("admin")) {
            isAdmin=true;
            adminMenu();
            //관리자전용메뉴 실행
         }else {
            isUser=true;
            userMenu();
            //사용자메뉴 실행
         }
      }
   }


   public static void mainMenu() {
      //처음 들어갈때 나오는 메뉴
	   while(isMain==true) {
        System.out.println("id 입력>>");
        inputId=sc.nextLine();
        System.out.println("pw 입력>>");
        inputPw=sc.nextLine();
    
        if(id.indexOf(inputId)==pw.indexOf(inputPw)) {
           indexCount=id.indexOf(inputId);
           isPlay=true;
           isMain=false;
        
        }else {
        	System.out.println("다시 입력해주세요");
        }
         
         
      }
   }
   
   public static void userMenu() {
      //user전용 메뉴
      
      while(isUser==true) {
         System.out.println(id.get(indexCount)+"님이 로그인 하셨습니다.");
         System.out.println("1.입금 2.출금 3.확인 4.종료(은행입력)");
         int input = Integer.parseInt(sc.nextLine());
         if(input==1) {
            System.out.println("입금할 금액을 입력하세요");
             int inputMoney = Integer.parseInt(sc.nextLine());
             accountMoney = account.get(indexCount);
             accountMoney += inputMoney;
             account.set(indexCount, accountMoney);
            System.out.println("현재 금액은"+account.get(indexCount)+" 입니다.");
         }else if(input==2) {
            System.out.println("출금할 금액을 입력하세요");
            int withdrawMoney = Integer.parseInt(sc.nextLine());
            accountMoney = account.get(indexCount);
            accountMoney -= withdrawMoney;
            account.set(indexCount, accountMoney);
            System.out.println("현재 금액은"+account.get(indexCount)+" 입니다.");
         }else if(input==3) {
            System.out.println("현재 금액은"+account.get(indexCount)+" 입니다.");
         }else if(input==4) {
            isUser=false;
            isPlay=false;
         
         }else {
            System.out.println("잘못 입력하셨습니다. 1~4 다시 입력해주세요");
         }
      }
      
      
      
   }


   public static void adminMenu() {
      //관리자메뉴
      
      System.out.println("관리자 계정 입니다.");
      while(isAdmin==true) {
         System.out.println("1.계정 추가 2. 계정 삭제 3.모든 사용자 정보 확인 4.id로 사용자 정보 조회 5. 종료");
         int input = Integer.parseInt(sc.nextLine());
         
         switch(input) {
            case 1 : 
               System.out.println("추가할 계정의 ID를 입력하세요");
               String newId=sc.nextLine();
               id.add(newId);
               System.out.println("추가할 계정의 PW를 입력하세요");
               String newPw=sc.nextLine();
               pw.add(newPw);
               account.add(0.0);
               listCount++;
               
               break;
            case 2 :
               System.out.println("삭제할 계정의 ID를 입력하세요");
               String deleteId=sc.nextLine();
               System.out.println("삭제할 계정의 PW를 입력하세요");
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
                  System.out.println("입력하신 Id와 Pw가 없습니다.");
               }
               
               break;
            
            case 3 :
               System.out.println("모든 사용자 정보 확인");
               
               Iterator<String> idIter = id.iterator();
               Iterator<String> pwIter = pw.iterator();
               Iterator<Double> accIter = account.iterator();
               
               while(idIter.hasNext()) {
       			System.out.println("id : " + idIter.next()+" pw : "+pwIter.next()+" account : "+accIter.next());
               }
               break;
            case 4 :
               System.out.println("찾을 계정의 id를 입력하세요");
               String findId=sc.nextLine();
               int findIndex=id.indexOf(findId);
               System.out.println("찾은 계정의 id는 "+id.get(findIndex)+" pw는 "+pw.get(findIndex)+" account는 "+account.get(findIndex)+"입니다.");
                  
               if(findIndex<0) {
                  System.out.println("찾을 계정이 없습니다.");
               }
               
               break;
            case 5 :
               isAdmin=false;
               isPlay=false;
               break;
            default :
               System.out.println("다시 입력해주세요 1~5");
            
               
         }   
      }
      
      
   }





   public static void main(String[] args) {
      init();
      play();
      

	  
   }
   
   

}