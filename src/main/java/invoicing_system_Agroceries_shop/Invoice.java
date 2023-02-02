package invoicing_system_Agroceries_shop;

import java.util.List;

public class Invoice {
	static String customer_name;
	static String phone_number;
	static int num_ofItems;
	static String Invoice_date;
	static int total_amount;
	static int paid_amount; 
	List<Product> ittemsList;
	public String getCustomer_name() {
		return customer_name;
	}
	public  void setCustomer_name(String customer_name) {
		Invoice.customer_name = customer_name;
	}
	public  String getPhone_number() {
		return phone_number;
	}
	public  void setPhone_number(String phone_number) {
		Invoice.phone_number = phone_number;
	}
	public  int getNum_ofItems() {
		return num_ofItems;
	}
	public  void setNum_ofItems(int num_ofItems) {
		Invoice.num_ofItems = num_ofItems;
	}
	public  String getInvoice_date() {
		return Invoice_date;
	}
	public  void setInvoice_date(String invoice_date) {
		Invoice_date = invoice_date;
	}
	public  int getTotal_amount() {
		return total_amount;
	}
	public  void setTotal_amount(int total_amount) {
		Invoice.total_amount = total_amount;
	}
	public  int getPaid_amount() {
		return paid_amount;
	}
	public  void setPaid_amount(int paid_amount) {
		Invoice.paid_amount = paid_amount;
	}
	public List<Product> getIttemsList() {
		return ittemsList;
	}
	public void setIttemsList(List<Product> ittemsList) {
		this.ittemsList = ittemsList;
	}
	

}
