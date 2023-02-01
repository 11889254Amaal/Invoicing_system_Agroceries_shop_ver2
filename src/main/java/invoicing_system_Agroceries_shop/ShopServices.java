package invoicing_system_Agroceries_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ShopServices {
	public static void ADDSHOP() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/shopSystem";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
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
		con.close();
	
		}
}
