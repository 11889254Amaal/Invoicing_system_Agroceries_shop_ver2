package invoicing_system_Agroceries_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ItemsServices {
	public boolean CreateTableItemsFunction () {
		try {
			Connection conn = Constant.getDatabaseConnection(Constant.USER_URL, Constant.USER_NAME,Constant.USER_PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "CREATE TABLE Items " + "(item_ID int NOT NULL AUTO_INCREMENT, "
				    + "item_name  VARCHAR(100) not NULL  ,"
				    + "shopDetails_id  INTEGER  ,"
					+ "FOREIGN KEY (shopDetails_id) REFERENCES ShopDetails(id) ON DELETE CASCADE ,"
					+ "price  float  ," 
					+ "quantity int , " 
					+ " PRIMARY KEY ( item_ID ))";
		         String sql1="ALTER TABLE Items AUTO_INCREMENT=1";
		         stmt.executeUpdate(sql);
		         stmt.executeUpdate(sql1);

		} catch (SQLException e) {
			System.out.println("Table Invoice Not Created ");
			System.out.println("=======================================");
		}
		return false;
}
	
	
	
	
}
