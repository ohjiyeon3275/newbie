package com.human.ex;
import java.util.Scanner;

public class Bank {

   public static Scanner sc = new Scanner(System.in);
   
   public static String id[]=new String[100];
   public static String pw[]=new String[100];
   public static double account[]=new double[100];
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
   public Bank() {}
 

public static void init() {
      //초기값 initial value
      id[0]="admin";id[1]="id1";id[2]="id2";id[3]="id3";
      pw[0]="admin";pw[1]="pw1";pw[2]="pw2";pw[3]="pw3";
      account[0]=0;account[1]=0;account[2]=0;account[3]=0;
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
      //user전용 메뉴
      
      while(isUser==true) {
         System.out.println(id[indexCount]+"님이 로그인 하셨습니다.");
         System.out.println("1.입금 2.출금 3.확인 4.종료(은행입력)");
         int input = Integer.parseInt(sc.nextLine());
         if(input==1) {
            System.out.println("입금할 금액을 입력하세요");
            int inputMoney = Integer.parseInt(sc.nextLine());
            account[indexCount]+=inputMoney;
            System.out.println("현재 금액은"+account[indexCount]+" 입니다.");
         }else if(input==2) {
            System.out.println("출금할 금액을 입력하세요");
            int withdrawMoney = Integer.parseInt(sc.nextLine());
            account[indexCount]-=withdrawMoney;
            System.out.println("현재 금액은"+account[indexCount]+" 입니다.");
         }else if(input==3) {
            System.out.println("현재 금액은"+account[indexCount]+" 입니다.");
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
               id[listCount]=newId;
               System.out.println("추가할 계정의 PW를 입력하세요");
               String newPw=sc.nextLine();
               pw[listCount]=newPw;
               account[listCount]=0;
               listCount++;
               
               break;
            case 2 :
               System.out.println("삭제할 계정의 ID를 입력하세요");
               String deleteId=sc.nextLine();
               System.out.println("삭제할 계정의 PW를 입력하세요");
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
                  System.out.println("입력하신 Id와 Pw가 없습니다.");
               }
               
               break;
            
            case 3 :
               System.out.println("모든 사용자 정보 확인");
               for(int i=0;i<listCount;i++) {
                  System.out.println((i+1)+"번째 사용자의 id : " +id[i]+" pw : "+pw[i]+" account : "+account[i]);
               }
               break;
            case 4 :
               System.out.println("찾을 계정의 id를 입력하세요");
               String findId=sc.nextLine();
               int findIndex=-1;
               for(int i=0;i<listCount;i++) {
                  if(findId.equals(id[i])) {
                     findIndex=i;
                     System.out.println("찾은 계정의 id : "+id[findIndex]+" pw : "+pw[findIndex]+" account : "+account[findIndex]);
                  }
               }
                  
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