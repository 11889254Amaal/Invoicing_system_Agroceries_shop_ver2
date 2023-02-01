package invoicing_system_Agroceries_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Constant {
	
	public static String REQUEST_METHOD_GET = "GET";
    public static String USER_URL = "jdbc:mysql://localhost:3306/shopSystem";
    public static String USER_NAME = "root";
    public static String USER_PASSWORD = "root";
    public static String JDBC_DRIVER_SQL_SERVER = "com.mysql.cj.jdbc.Driver";
   
    public static Connection getDatabaseConnection(String USER_URL ,String USER_NAME,String USER_PASSWORD) throws SQLException {
    	Connection con = DriverManager.getConnection(Constant.USER_URL, Constant.USER_NAME, Constant.USER_PASSWORD);
		return con;
    	
    }
}
