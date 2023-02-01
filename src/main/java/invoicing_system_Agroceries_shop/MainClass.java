package invoicing_system_Agroceries_shop;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
    
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		boolean ShoppingSettingExiste=true;
	    boolean showMenuExiste=true;
	    boolean  ManageShopExiste=true;
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
					while(showMenuExiste) {
					for (String x : MenuClass.ShowMenu()) {

						System.out.println(x);
					}
					
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
							System.out.println("              Plz Enter Option of Case                  ");
							System.out.println("========================================================");
							int userInputForSHOPPINGSEETING = sc.nextInt();
						    while(ShoppingSettingExiste) {
						    	switch(userInputForSHOPPINGSEETING) {
						    	case 1:
						    		//this case to load Data of Items And Invoices 
						    		
									
						    	break;
						    	
						    	case 2:
							    break;
							    
						    	case 3:
							    break;
							    
						    	case 4:
						    		ShoppingSettingExiste=false;
						    		showMenuExiste=true;
								break;
						    	
						    	}
						    }ShoppingSettingExiste=false;
					       break;
						case 2:
							//this Array List for Manage Shop Items
							System.out.println("==========WELCOME TO Manage Shop Items===================");
							for (String x : MenuClass.ManageShopItemsMenu()){
							System.out.println(x);
							}
							System.out.println("=========================================================");
							//show the mean menu
							System.out.println("========================================================");
							System.out.println("              Plz Enter Option of Case                  ");
							System.out.println("========================================================");
							int userInputForManageShopItems = sc.nextInt();
						    while(ManageShopExiste) {
						    	switch(userInputForManageShopItems) {
						    	case 1:
						    		
						    	break;
						    	
						    	case 2:
							    break;
							    
						    	case 3:
							    break;
							    
						    	case 4:
						    		
								break;
						    	case 5:
						    		ManageShopExiste=false;
						    		showMenuExiste=true;
						    	break;
						    	
						    	}
						    }ShoppingSettingExiste=false;
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
							//show the mean menu
							for (String x : MenuClass.ShowMenu()) {

								System.out.println(x);
							}
						break;
						
						case 4:
							System.out.println("===Report of Invoice(NO ITEMS/NO INFOICE/TOTAL)==");
							InvoicesServices ReportClass = new InvoicesServices();
							ReportClass.REPORT();
							System.out.println("=================================================");
							//show the mean menu
							for (String x : MenuClass.ShowMenu()) {

								System.out.println(x);
							}
						break;
						
						case 5:
							System.out.println("==========Report all Invoice===================");
							InvoicesServices ReportInvoiceClass = new InvoicesServices();
							ReportInvoiceClass.ReportAllInvoices();
							System.out.println("==============================================");
							//show the mean menu
							for (String x : MenuClass.ShowMenu()) {

								System.out.println(x);
							}
							
						break;
						
						case 6:
							System.out.println("==========Search Invoice by id===================");
							InvoicesServices SearchInvoiceClass = new InvoicesServices();
							SearchInvoiceClass.SearchInvoicesById();
							System.out.println("==============================================");
							
							//show the mean menu
							for (String x : MenuClass.ShowMenu()) {

								System.out.println(x);
							}
							break;
							
						case 7:
							//this case to count how many time Access the Case
							
							//show the mean menu
							for (String x : MenuClass.ShowMenu()) {

								System.out.println(x);
							}
						break;
						
						case 8:
							
							System.out.println("Are You Want To existe from system if yes press 1 IF NOT press 0");
							int Existe_from_system = sc.nextInt();
							if (Existe_from_system == 1) {
								System.out.println("System is exsite");
								System.exit(0);
							} else if (Existe_from_system == 0) {
								for (String x : MenuClass.ShowMenu()) {
									System.out.println(x);
								}
							}
							break;
							
                        
						}

					} showMenuExiste=false;
				}
			}
		} else {
			System.out.println("*********************************************************");
			System.out.println("    'Faild' , 'You are Not logged in System'  ");
			System.out.println("*********************************************************");
		}

	}
}
