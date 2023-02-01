package invoicing_system_Agroceries_shop;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// this to enter data of database===>
		System.out.println("*********************************************************");
		System.out.println("     Invoicing system for a groceries shop Main Menu     ");
		System.out.println("*********************************************************");
		System.out.println("Welcome,Please Enter all This Information to access System:");
		Scanner input = new Scanner(System.in);
		System.out.println("Plz Enter Url: ");
		String URL = input.nextLine();
		System.out.println("Plz Enter User Name: ");
		String UserName = input.nextLine();
		System.out.println("Plz Enter Password: ");
		String Password = input.nextLine();
		System.out.println("*********************************************************");
		if (URL.equals(Constant.USER_URL)) {
			if (UserName.equals(Constant.USER_NAME)) {
				if (Password.equals(Constant.USER_PASSWORD)) {
					System.out.println("*********************************************************");
					System.out.println("    'success' , 'You are successfully logged in System'  ");
					System.out.println("*********************************************************");
					System.out.println("              Plz Enter Option of Case                   ");
					System.out.println("*********************************************************");
					for (String x : MenuClass.ShowMenu()) {

						System.out.println(x);
					}
					do {
						Scanner sc = new Scanner(System.in);
					
						int userInput = sc.nextInt();
						switch (userInput) {
						case 1:
							//this Array List for Shop Setting
							System.out.println("==========WELCOME TO SHOPPING SEETING===================");
							for (String x : MenuClass.ShopSettingMenu()){
							System.out.println(x);
							}
							System.out.println("========================================================");
						break;
						
						case 2:
							//this Array List for Manage Shop Items
							System.out.println("==========WELCOME TO Manage Shop Items===================");
							for (String x : MenuClass.ManageShopItemsMenu()){
							System.out.println(x);
							}
							System.out.println("=========================================================");
						break;
						
						case 3:
							System.out.println("==========Create New Invoice=============================");
							//this object To create Table For Invoices
							InvoicesServices CreateInvoicesTable=new InvoicesServices();
							CreateInvoicesTable.CreateTableInvoiceFunction();
							
							//This object To Insert Information of Invoices 
							InvoicesServices AddInvoices=new InvoicesServices();
							AddInvoices.ADDInvoices();
							
							
							System.out.println("=========================================================");
						break;
						
						
                        
						}

					} while (true);
				}
			}
		} else {
			System.out.println("*********************************************************");
			System.out.println("    'Faild' , 'You are Not logged in System'  ");
			System.out.println("*********************************************************");
		}

	}
}
