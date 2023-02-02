package invoicing_system_Agroceries_shop;

public class Product {
	 static String itemName;
	
	 static int shop_id;
	 static int price;
	 static int quantity;
	public  String getItemName() {
		return itemName;
	}
	public  void setItemName(String itemName) {
		Product.itemName = itemName;
	}
	public  int getShop_id() {
		return shop_id;
	}
	public  void setShop_id(int shop_id) {
		Product.shop_id = shop_id;
	}
	public  int getPrice() {
		return price;
	}
	public  void setPrice(int price) {
		Product.price = price;
	}
	public  int getQuantity() {
		return quantity;
	}
	public  void setQuantity(int quantity) {
		Product.quantity = quantity;
	}
	 
}
