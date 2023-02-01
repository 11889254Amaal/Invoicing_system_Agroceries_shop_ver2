package invoicing_system_Agroceries_shop;

import java.util.Arrays;
import java.util.List;

public class MenuClass {
	
	//THIS METHOD TO SHOW MENU 
	public static List<String> ShowMenu() {
		return Arrays.asList("1.Shop Settings", "2.Manage Shop Items", "3.Create New Invoice",
				"4.Report: Statistics (No Of Items, No of Invoices, Total Sales) ",
				"5.Report: All Invoices ( Invoice No, Invoice Date, Customer Name, No of items, Total, Balance) ",
				"6.Search Invoice by Invoicke number",
				"7.Program Statistics (Print each Main Menu Item with how many number selected).", "8.Exit"

		);

	}
	
	public static List<String> ShopSettingMenu() {
		return Arrays.asList("1. Load Data (Items and invoices)"
				+  "2.Set Shop Name (data should be saved)", "3.Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)",
				"4.Go Back"
				

		);

	}
	
	public static List<String>  ManageShopItemsMenu() {
		return Arrays.asList("1. Add Items (Item should be saved/serialized)"
				
				+"2.Delete Items", "3. Change Item Price",
				"4. Report All Items,  "+"5.Go Back"
				

		);

	}
}
