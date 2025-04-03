package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			// Dang ki MS SQL Server voi DriverManager
			DriverManager.registerDriver(new SQLServerDriver());
			// Cac thong so
			String url = "jdbc:sqlserver://localhost:1433;databaseName=<yourdatabasename>;encrypt=true;trustServerCertificate=true;";
			String username = "<your username>";
			String password = "<your password>";
			// Tao ket noi
			c = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
