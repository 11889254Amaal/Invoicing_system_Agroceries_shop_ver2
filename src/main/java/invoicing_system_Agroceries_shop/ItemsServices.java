package invoicing_system_Agroceries_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class ItemsServices {

	public static boolean CreateTableItemsFunction () {
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
			e.getErrorCode();
		}
		return false;
}
	
	public static void DELETEITEMS() {
		System.out.println("plz enter name of items that want to delete");
		Scanner sc11 = new Scanner(System.in); // System.in is a standard input stream
		String items_name = sc11.next();
		Connection conn111 = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e);
			}
			conn111 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shopSystem", "root",
					"root");
			
			stmt = (Statement) conn111.createStatement();
			String query1 = "DELETE FROM items WHERE item_name='"+items_name + "'";
			stmt.executeUpdate(query1);
			System.out.println("Record is deleted from the table successfully..................");
		} catch (SQLException excep) {
			excep.printStackTrace();
		} catch (Exception excep) {
			excep.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn111.close();
			} catch (SQLException se) {
			}
			try {
				if (conn111 != null)
					conn111.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
public static void ChangeItemsPrice() throws ClassNotFoundException {
		
		System.out.println("==========Update From Table Items===================");
		System.out.println("plz enter name that want to update price");
		Scanner sc1 = new Scanner(System.in); // System.in is a standard input stream
		String items_name = sc1.next();
		System.out.println("plz enter new price");
		int price = sc1.nextInt();
		String sqlDB1 = " update items set price = ? where item_name =?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url1111 = "jdbc:mysql://localhost:3306/shopSystem";
		String username1 = "root";
		String password1 = "root";
		try (
				// gets connection with database
				Connection connection = DriverManager.getConnection(url1111, username1, password1);

				// sends queries and receives results
				PreparedStatement statement = connection.prepareStatement(sqlDB1);) {
			// this way to prevent sql injection
			statement.setInt(1, price);
			statement.setString(2, items_name);
            
			statement.executeUpdate();

			System.out.println(" updated item successfuly>>> " );
		} catch (SQLException e) {
			// some logic depending on scenario
			// maybe LOGGER.log(e.getMessage()) and "result false"
			e.printStackTrace();
		}
		
		
	
	}
public static void LoadDtatOfItems() {
	String url = "jdbc:mysql://localhost:3306/shopSystem";
	String username = "root";
	String password = "root";
	String sql = "SELECT * from items";
	Connection con = null;

	try {
		Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		// Registering drivers
		DriverManager.registerDriver(driver);
		// Reference to connection interface
		con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		// Executing query

		
		ResultSet n = st.executeQuery(sql);
		while (n.next()) {
			System.out.println("==================================");
			System.out.println(" id:" + n.getString(1));
		    System.out.println(" item_name:" + n.getString(2));
		    System.out.println(" shopDetails_id:" + n.getString(3));
		    System.out.println(" price:" + n.getString(4));
		    System.out.println(" quantity:" + n.getString(5));
		    System.out.println("==================================");
		   
		}
		
		con.close();
	} catch (Exception ex) {
		System.err.println(ex);
	}
}
	
	public static void ADDITEMS(int howManyItems) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/shopSystem";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			;
			for(int i=1;i<=howManyItems;i++) {
			System.out.println("==============ADD ITEMS================");
			Scanner sc = new Scanner(System.in);
			System.out.println("Plz Enter name of shop ");
			String shop_name = sc.next();
			System.out.println("Plz Enter item name ");
			String item_name = sc.next();
			System.out.println("Plz Enter price ");
			String price = sc.next();
			System.out.println("Plz Enter quantity");
			String quantity = sc.next();
			
			

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url1111111 = "jdbc:mysql://localhost:3306/shopSystem";
			String username1 = "root";
			String password1 = "root";
			String Sql2 = "SELECT shopdetails.id FROM shopdetails INNER JOIN shop ON shop.id = shopdetails.shop_id  where shop.Shop_Name=?";
			Connection con1 = DriverManager.getConnection(url1111111, username1, password1);
			PreparedStatement shopPreparedStatment = con1.prepareStatement(Sql2);
			shopPreparedStatment.setString(1, shop_name);
			int shopDetails_id = 0;
            //int item_ID=0;
			ResultSet shopResultSet = shopPreparedStatment.executeQuery();
			if (shopResultSet.next()) {
				shopDetails_id = shopResultSet.getInt("id");
				System.out.println(shopDetails_id);
			}
			
			String sql1 = "insert into items(item_name,shopDetails_id,price,quantity)" + " values('"+ item_name + "','"
					+ shopDetails_id + "','" + price + "','" + quantity + "')";
			Statement st = con.createStatement();
			//
			// Executing query
			int m = st.executeUpdate(sql1);
			if (m >= 1) {
				System.out.println("inserted successfully : " + sql1);
			}
			else
				System.out.println("insertion failed");

			con.close();
		}
		
	}}

}
