package com.cashier.ex;

import com.customer.ex.Customer;
import com.product.ex.Product;

public class Execute {

	public static java.util.Scanner sc = new java.util.Scanner(System.in);
	

	public static Product[] product = new Product[100];
	public static Customer[] customer = new Customer[20];
	public static POSMachine pos = new POSMachine();
	public static boolean isCheckout = false;
	public static boolean isAdmin = false;
	public static int[] checkout = new int[99];
	public static int checkoutIndex = 0;
	public static int productIndex = 4;
	public static int customerIndex = 0;
	public static int barcodeIndex=0;
	public static double price = 0;
	public static double sales = 0;
	
	public static void initial() {
		for(int i = 0 ; i <100 ; i++) {
			product[i] = new Product();
		}
		
		for(int i=0;i<customer.length;i++) {
			customer[i] = new Customer();
		}
		for(int i=0;i<checkout.length;i++) {
			checkout[i] = 0;
		}
	}
	public static void init() {
		
		product[0].setBarcode(11111110);product[0].setName("초콜릿");product[0].setPrice(1500);
		product[1].setBarcode(11111111);product[1].setName("과자");product[1].setPrice(1000);
		product[2].setBarcode(11111112);product[2].setName("삼각김밥");product[2].setPrice(900);
		product[3].setBarcode(11111113);product[3].setName("사탕");product[3].setPrice(2000);
		
		
		customer[0].setDiscountCard(true);customer[1].setMembership(0);
		customer[1].setDiscountCard(true);customer[1].setMembership(300);
		customer[2].setDiscountCard(true);customer[2].setMembership(100);
		customer[3].setDiscountCard(false);customer[3].setMembership(0);
		customer[4].setDiscountCard(true);customer[4].setMembership(1000);
		customer[5].setDiscountCard(false);customer[5].setMembership(350);
		

		pos.setChange(50000);
		
	}
	public static void greeting() {
		System.out.println("안녕하세요 지연편의점 입니다.");
		price=0;
	}
	
	public static void chooseCustomer() {
		System.out.println("회원번호를 입력해주세요");
		int userinput = Integer.parseInt(sc.nextLine());
		System.out.println("할인카드 여부 : "+customer[userinput].isDiscountCard()+" / 멤버십 잔액은 :"+customer[userinput].getMembership()+" 입니다.");
		customerIndex = userinput;
	}
	
	
	public static void usePoint() {
		double userpoint = customer[customerIndex].getMembership();
		System.out.println("포인트 잔액은 "+userpoint+" 입니다.");
		System.out.println("사용할 포인트를 입력하세요");
		double userinput=Double.parseDouble(sc.nextLine());
		
		while (userinput > userpoint) {
			System.out.println("입력한 금액이 잔액보다 큽니다. 다시 입력하세요");
			userinput=Double.parseDouble(sc.nextLine());
		}
		price-=userinput;
		customer[customerIndex].setMembership(userpoint-userinput);
	}
	
	
	public static void checkout() {
		System.out.println("계산할 물품의 번호나 바코드를 입력하세요. 계산하려면 '계산'을 입력하세요.");
		isCheckout=true;
		
		while(isCheckout) {	

			boolean isBarcode=false;
			
			
			for(int i=0;i<productIndex;i++) {
				
				System.out.println("상품 번호: "+(i+1)+" / 상품이름 : "+product[i].getName()+" / 상품가격 : "+product[i].getPrice());
			}
			String userinput = sc.nextLine();
			
			if(userinput.equals("계산")) {
				isCheckout=false;
				break;
			}else if(userinput.equals("admin")) {
				isAdmin=true;
				admin();
				break;
			}else{
				for(int i=0;i<productIndex;i++) {
					if(Double.parseDouble(userinput)==product[i].getBarcode()) {
						barcodeIndex=i;
						isBarcode=true;
					}
				}
				if(isBarcode) {
					checkout[checkoutIndex] = barcodeIndex;
				}else {
					checkout[checkoutIndex] = Integer.parseInt(userinput)-1;
				}
				
				checkoutIndex++;
			}
			
		}
		
		System.out.print("장바구니에 담은 상품은 ");
		for(int i=0;i<checkoutIndex;i++) {
			System.out.print(product[checkout[i]].getName()+",");
		}
		System.out.println("입니다.");

	}
	
	public static void showBasket() {
		
		
	}
	public static void useDiscount() {
		
		System.out.println("할인카드는 10%할인 가능합니다. ");
		price *= 0.9;
		
	}
	
	public static void currentPrice() {
		
		for(int i=0;i<checkoutIndex;i++) {
			price += product[checkout[i]].getPrice();
		}
		
	}
	
	public static void cashPayment() {
		
	
		System.out.println("현금 결제 입니다. 현금을 입력해 주세요.");
		double userinput = Double.parseDouble(sc.nextLine());
		while(userinput < price) {
			System.out.println("결제할 금액보다 적습니다. 다시 입력해주세요.");
			System.out.println("결제할 금액 :"+price);
			userinput = Double.parseDouble(sc.nextLine());
		}
	
		System.out.println("거스름돈은 "+(userinput-price)+"원 입니다.");
		pos.setChange(pos.getChange()-price);
		System.out.println("거래가 완료되었습니다.");
		
		System.out.println("현재 거스름돈 잔액은"+pos.getChange()+" 입니다.");
		
	}
	
	
	public static void payment() {

		chooseCustomer();
		currentPrice();
		System.out.println("결제할 금액 :"+price);
		
		if(customer[customerIndex].isDiscountCard().equals("예")) {
			System.out.println("할인카드를 사용하시겠습니까?");
			System.out.println("1.예 2.아니오");
			int userinput2 = Integer.parseInt(sc.nextLine());
			if(userinput2 == 1) {
				useDiscount();
			}
		}

		System.out.println("결제할 금액 :"+price);
		
		System.out.println("포인트를 사용하시겠습니까?");
		System.out.println("1.예 2.아니오");
		int userinput = Integer.parseInt(sc.nextLine());
		if(userinput == 1) {
			usePoint();
		}
		System.out.println("결제할 금액 :"+price);
		
		System.out.println("결제를 어떻게 하시겠습니까?");
		System.out.println("1.카드 2.현금");
		int userinput1 = Integer.parseInt(sc.nextLine());
		if(userinput1 == 1) {
			System.out.println("카드 결제입니다. >>> 결제가 완료되었습니다.");
		}else if(userinput1 ==2 ) {
			cashPayment();
		}
		
		
		for(int i=0;i<checkoutIndex;i++) {
			checkout[i] = 0;
		}
		checkoutIndex=0;
		sales+=price;
	}
	
	public static void admin() {
		System.out.println("관리자메뉴");
		while(isAdmin) {
			System.out.println("1.상품 추가 2.멤버십 추가 3.잔돈 관리 4.매출액 조회 5.환불// 나가려면 아무키나 누르세요.");
			int input = Integer.parseInt(sc.nextLine());
			if(input == 1) {
				System.out.println("추가할 상품의 이름을 입력하세요");
				String inputName = sc.nextLine();
				System.out.println("추가할 상품의 가격을 입력하세요");
				double inputPrice = Double.parseDouble(sc.nextLine());
				System.out.println("추가할 상품의 바코드를 입력하세요");
				double inputBarcode = Double.parseDouble(sc.nextLine());
				
				product[productIndex].setName(inputName);
				product[productIndex].setPrice(inputPrice);
				product[productIndex].setBarcode(inputBarcode);
				
				productIndex++;
				
				System.out.println("상품이 등록되었습니다.");
				
			}else if(input == 2) {
				
				int memberLen = customer.length;
				System.out.println("추가할 멤버십의 번호는 "+memberLen+"입니다.");
				boolean isDisCount = Boolean.parseBoolean(sc.nextLine());
				
				customer[memberLen].setDiscountCard(isDisCount);
				customer[memberLen].setMembership(0);
				
			}else if(input == 3) {
				double currChange = pos.getChange();
				System.out.println("1.시재 채우기 2.금고 보관 ");
				int input3 = Integer.parseInt(sc.nextLine());
				if(input3 == 1) {
					System.out.println("채울 금액을 입력하세요");
					double input31 = Double.parseDouble(sc.nextLine());
					pos.setChange(currChange+=input31);
				}else if(input3 == 2) {
					System.out.println("보관할 금액을 입력하세요");
					double input32 = Double.parseDouble(sc.nextLine());
					pos.setChange(currChange-=input32);
				}
			}else if(input == 4){
				System.out.println("매출 조회 입니다. 현재 매출액은 "+sales+"원 입니다.");
			}else if(input ==5) {
				System.out.println("환불 메뉴 입니다.");
				System.out.println("환불할 금액을 입력하세요");
				double refund = Double.parseDouble(sc.nextLine());
				
				System.out.println("1.카드 2.현금");
				int refund1 = Integer.parseInt(sc.nextLine());
				if(refund1==1) {
					System.out.println("결제시 이용했던 카드를 입력해 주세요");
					System.out.println("==============================");
					sales-=refund;
					System.out.println("환불 완료");
				}else if(refund==2) {
					System.out.println("현금 "+refund+"원을 지급하세요");
					double currChange = pos.getChange();
					pos.setChange(currChange-refund);
					System.out.println("환불 완료");
				}
	
			}else {
				isAdmin=false;
				break;
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		initial();
		init();
		
		while(true) {
			greeting();
			checkout();
			payment();
		}


	}

}
