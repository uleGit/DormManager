package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class DBUtil {

	private static final String driver = "com.mysql.jdbc.Driver";//数据库驱动
	//连接数据库的url地址
	private static final String url = "jdbc:mysql://localhost:3306/ssglxt?useUnicode=true&characterEncoding=utf-8";
	private static final String username = "root";
	private static final String password = "root";
	private static Connection conn = null;
	
	//静态代码块加载驱动
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		if(conn==null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	

}
