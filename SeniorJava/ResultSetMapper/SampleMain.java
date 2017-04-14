package ResultSetMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SampleMain {
	public static void main(String... args) {

		try {
			ResultSetMapper<SamplePojo> resultSetMapper = new ResultSetMapper<SamplePojo>();
			ResultSet resultSet = null;
			String dbName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String dbUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=RoleBasedAccessContorlDB";
			String userName = "sa";
			String password = "LF20forYY";
			// simple JDBC code to run SQL query and populate resultSet - START
			Class.forName(dbName);
			Connection connection = DriverManager.getConnection(dbUrl, userName,
					password);
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Users");
			resultSet = statement.executeQuery();
			// simple JDBC code to run SQL query and populate resultSet - END
			List<SamplePojo> pojoList = resultSetMapper.mapRersultSetToObject(
					resultSet, SamplePojo.class);
			// print out the list retrieved from database
			if (pojoList != null) {
				for (SamplePojo pojo : pojoList) {
					System.out.println(pojo);
				}
			} else {
				System.out
						.println("ResultSet is empty. Please check if database table is empty");
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}