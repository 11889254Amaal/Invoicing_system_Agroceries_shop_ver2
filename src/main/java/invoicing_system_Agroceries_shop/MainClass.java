package invoicing_system_Agroceries_shop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainClass {
	static Map<String, Integer> map = new HashMap();

	public static <K> void incrementValue(Map<K, Integer> map, K key) {
		// get the value of the specified key
		Integer count = map.get(key);

		// if the map contains no mapping for the key,
		// map the key with a value of 1
		if (count == null) {
			map.put(key, 1);
		}
		// else increment the found value by 1
		else {
			map.put(key, count + 1);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Product> itemsList=new ArrayList<>();
		List<Invoice> invoiceList=new ArrayList<>();
		boolean ShoppingSettingExiste = true;
		boolean showMenuExiste = true;
		boolean ManageShopExiste = true;
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
		if (URL.equals(Constant.USER_URL) && UserName.equals(Constant.USER_NAME)
				&& Password.equals(Constant.USER_PASSWORD)) {

			System.out.println("*********************************************************");
			System.out.println("    'success' , 'You are successfully logged in System'  ");
			System.out.println("*********************************************************");
			System.out.println("              Plz Enter Option of Case                   ");
			System.out.println("*********************************************************");
			while (showMenuExiste) {
				for (String x : MenuClass.ShowMenu()) {

					System.out.println(x);
				}

				Scanner sc = new Scanner(System.in); 
				try {
				int userInput = sc.nextInt();
				switch (userInput) {
				case 1:
					incrementValue(map, "CASE 1");
					// this Array List for Shop Setting
					while (ShoppingSettingExiste) {
						System.out.println("==========WELCOME TO SHOPPING SEETING===================");
						for (String x : MenuClass.ShopSettingMenu()) {
							System.out.println(x);
						}
						System.out.println("========================================================");
						System.out.println("              Plz Enter Option of Case                  ");
						System.out.println("========================================================");

						int userInputForSHOPPINGSEETING = sc.nextInt();

						switch (userInputForSHOPPINGSEETING) {
						case 1:
							// this case to load Data of Items And Invoices

							// this case to set shop name

							break;

						case 2:
							System.out.println("Plz enter How many Shop You Want TO Add");
							int howManyShop = sc.nextInt();
							ShopServices.CreateTableShop();
							ShopServices.ADDSHOP(howManyShop);

							break;
						case 3:
							System.out.println("========================================================");
							System.out.println("             ADD Details of Shop                  ");
							System.out.println("========================================================");
							ShopServices.CreateTableShopDetails();
							InvoicesServices.ADDInvoiceHeader();
						break;

						case 4:
							ShoppingSettingExiste = false;
							showMenuExiste = true;
							break;

						}
					}

					showMenuExiste = true;
					break;
				case 2:
					incrementValue(map, "CASE 2");
					while (ManageShopExiste) {
						// this Array List for Manage Shop Items
						System.out.println("==========WELCOME TO Manage Shop Items===================");
						for (String x : MenuClass.ManageShopItemsMenu()) {
							System.out.println(x);
						}
						System.out.println("=========================================================");
						// show the mean menu
						System.out.println("========================================================");
						System.out.println("              Plz Enter Option of Case                  ");
						System.out.println("========================================================");
						int userInputForManageShopItems = sc.nextInt();

						switch (userInputForManageShopItems) {
						case 1:
							System.out.println("Plz enter How many Items You Want TO Add");
							int howManyItems = sc.nextInt();
							ItemsServices.CreateTableItemsFunction();
							ItemsServices.ADDITEMS(howManyItems);
							
							break;

						case 2:
							//this case for delete Items
							ItemsServices.DELETEITEMS();
							break;

						case 3:
							ItemsServices.ChangeItemsPrice();
							break;
                    
						case 4:
							ItemsServices.LoadDtatOfItems();
							break;
						case 5:
							ManageShopExiste = false;
							showMenuExiste = true;
							break;

						}
					}
					ShoppingSettingExiste = false;
					break;

				case 3:
					incrementValue(map, "CASE 3");
					System.out.println("==========Create New Invoice=============================");
					// this object To create Table For Invoices
					InvoicesServices CreateInvoicesTable = new InvoicesServices();
					CreateInvoicesTable.CreateTableInvoiceFunction();

					// This object To Insert Information of Invoices
					InvoicesServices AddInvoices = new InvoicesServices();
					AddInvoices.ADDInvoices();

					System.out.println("=========================================================");
					// show the mean menu
				
					break;

				case 4:
					incrementValue(map, "CASE 4");
					System.out.println("===Report of Invoice(NO ITEMS/NO INFOICE/TOTAL)==");
					InvoicesServices ReportClass = new InvoicesServices();
					ReportClass.REPORT();
					System.out.println("=================================================");
					// show the mean menu
				
					break;

				case 5:
					incrementValue(map, "CASE 5");
					System.out.println("==========Report all Invoice===================");
					InvoicesServices ReportInvoiceClass = new InvoicesServices();
					ReportInvoiceClass.ReportAllInvoices();
					System.out.println("==============================================");
					// show the mean menu
					
					break;

				case 6:
					incrementValue(map, "CASE 6");
					System.out.println("==========Search Invoice by id===================");
					InvoicesServices SearchInvoiceClass = new InvoicesServices();
					SearchInvoiceClass.SearchInvoicesById();
					System.out.println("==============================================");

					// show the mean menu
				
					break;

				case 7:
					// this case to count how many time Access the Case
					incrementValue(map, "CASE 7");
					System.out.println("==========view Input of user===================");
					System.out.println(map);
					System.out.println("===============================================");
					// show the mean menu
					
					break;
				case 8:
					for(Invoice i: invoiceList) {
						System.out.println("customer name "+i.getCustomer_name());
						System.out.println("number of items"+i.getNum_ofItems());
						System.out.println("phone number"+i.getPhone_number());
						for(Product p:i.getIttemsList()) {
							System.out.println("item name"+p.getItemName());
							System.out.println("item Quantity"+p.getQuantity());
							System.out.println("item price"+p.getPrice());
				
						}
					}
				case 9:

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

				}}catch(Exception e) {
					System.out.println("Invalid please Enter number");
					sc.nextLine();}

			}
			showMenuExiste = false;

		} else {
			System.out.println("*********************************************************");
			System.out.println("    'Faild' , 'You are Not logged in System'  ");
			System.out.println("*********************************************************");
		}

	}
}
