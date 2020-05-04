package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloWorld {
	public static final String JDBCDriverMySQL = "com.mysql.jdbc.Driver";
	public static final String JDBCURLMySQL = "jdbc:mysql://localhost:3306/jdbc_test?user=nicola&password=qwerty";

	public static void main(String[] args) throws SQLException {
		Statement statement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(JDBCURLMySQL);
			statement = connection.createStatement();
			statement.executeQuery("SELECT * FROM students LIMIT 1");
		} catch (SQLException e) {
			statement.executeUpdate("DROP TABLE IF EXISTS students");
			statement.executeUpdate("CREATE TABLE students (" + "id INTEGER PRIMARY KEY, " + "name VARCHAR(30), "
					+ "lastname VARCHAR(30), " + "year INTEGER)");

			statement
					.executeUpdate("INSERT INTO students (id, name, lastname, year) VALUES(1, 'Marco', 'Rossi', 2000)");
			statement.executeUpdate(
					"INSERT INTO students (id, name, lastname, year) VALUES(2, 'Luca', 'Bianchi', 20001)");
			statement.executeUpdate(
					"INSERT INTO students (id, name, lastname, year) VALUES(3, 'Giovanni', 'Verdi', 1999)");
		}

		ResultSet rs = statement.executeQuery("SELECT * FROM students LIMIT 100");
		while (rs.next()) {
			System.out.println("id=" + rs.getInt("id") + ", name=" + rs.getString("name") + ", lastname="
					+ rs.getString("lastname") + ", year=" + rs.getInt("year"));
		}

		statement.close();
		connection.close();
	}
}
