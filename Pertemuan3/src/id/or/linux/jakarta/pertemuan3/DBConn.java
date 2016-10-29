package id.or.linux.jakarta.pertemuan3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConn implements DatabaseConnecter {
	private String userName = "root";
	private String password = "";
	private String url = "jdbc:mysql://localhost:3306/test";
	@Override
	public Connection createConnection() throws SQLException {

		    Connection conn = null;
		    Properties connectionProps = new Properties();
		    connectionProps.put("user", this.userName);
		    connectionProps.put("password", this.password);
		    conn = DriverManager.getConnection(url, connectionProps);
		    System.out.println("Connected to database");
		    return conn;
	}

	@Override
	public String getConnectionUrl() {
		return url;
	}

}
