package invoicing_system_Agroceries_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ShopServices {
	public static void ADDSHOP(int howManyShop) throws ClassNotFoundException, SQLException {
		Connection con = DriverManager.getConnection(Constant.USER_URL, Constant.USER_NAME, Constant.USER_PASSWORD);
		for(int i=1;i<=howManyShop;i++) {
		if (con != null) {
			System.out.println("==============================");
			System.out.println("Plz Enter Name Of Shop");
			Scanner sc = new Scanner(System.in);
			String Name_of_shop=sc.next();
			String sql = "insert into shop(Shop_Name)"
					+ " values('"+ Name_of_shop+"')";
			Statement st = con.createStatement();
			//
			// Executing query
			int m = st.executeUpdate(sql);
			if (m >= 1)
				System.out.println("inserted successfully : " + sql);
			else
				System.out.println("insertion failed");

			// Closing the connections
		}
		}
		con.close();
		
		}
	
	public static boolean CreateTableShop () {
		try(Connection conn = DriverManager.getConnection(Constant.USER_URL, Constant.USER_NAME, Constant.USER_PASSWORD);
		        Statement stmt = conn.createStatement();
		     ) {      
		         String sql = "CREATE TABLE shop " +
		                  "(id int NOT NULL AUTO_INCREMENT, " +
		                  " Shop_Name   VARCHAR(100) not NULL, " +    
		                  " PRIMARY KEY ( id ))";
		         String sql1="ALTER TABLE shop AUTO_INCREMENT=1";
		         stmt.executeUpdate(sql);
		         stmt.executeUpdate(sql1);
		       
		      
		       
		        System.out.println("=====Table Shop Created Succeflly====");  
		       
		     } catch (SQLException e) {
		       e.getErrorCode();
		     }
		return false;
		  }
	
	public static boolean CreateTableShopDetails () {
		try(Connection conn = DriverManager.getConnection(Constant.USER_URL, Constant.USER_NAME, Constant.USER_PASSWORD);
		        Statement stmt = conn.createStatement();
		     ) {      
			String sql = "CREATE TABLE ShopDetails " + "(id int NOT NULL AUTO_INCREMENT, "
				    + "shop_id  INTEGER  ,"
					+ "FOREIGN KEY (shop_id) REFERENCES shop(id) ON DELETE CASCADE ,"
					+ "Tel  Text  ," 
					+ "Fax Text , " 
					+ "Email Text , " 
					+ "Website Text , " 
					+ " PRIMARY KEY ( id ))";
		         String sql1="ALTER TABLE ShopDetails AUTO_INCREMENT=1";
		         stmt.executeUpdate(sql);
		         stmt.executeUpdate(sql1);
		       
		      
		       
		        System.out.println("=====Table Shop Details Created Succeflly====");  
		       
		     } catch (SQLException e) {
		       System.out.println("Table Shop Details Not Created ");
		       System.out.println("=======================================");
		     }
		
		
		return false;
		  }

	
	
}
