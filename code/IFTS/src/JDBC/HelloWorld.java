package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HelloWorld {
	public static final String JDBCDriverMySQL = "com.mysql.jdbc.Driver";
	public static final String JDBCURLMySQL = "jdbc:mysql://localhost:3306/jdbc_test?user=nicola&password=qwerty";

	public static void main(String[] args) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		ResultSet rs;
		Scanner scr;
		String[] p;
		String query;

		try {
			connection = DriverManager.getConnection(JDBCURLMySQL);
			statement = connection.createStatement();
			statement.executeQuery("SELECT * FROM students LIMIT 1");
		} catch (SQLException e) {
			statement.executeUpdate("DROP TABLE IF EXISTS students");
			statement.executeUpdate("CREATE TABLE students (" + "id INTEGER PRIMARY KEY, " + "name VARCHAR(30), "
					+ "lastname VARCHAR(30), " + "year INTEGER, " + "grade FLOAT)");

			statement.executeUpdate(
					"INSERT INTO students (id, name, lastname, year, grade) VALUES(1, 'Marco', 'Rossi', 2000, 22.3)");
			statement.executeUpdate(
					"INSERT INTO students (id, name, lastname, year, grade) VALUES(2, 'Luca', 'Bianchi', 2001, 24.6)");
			statement.executeUpdate(
					"INSERT INTO students (id, name, lastname, year, grade) VALUES(3, 'Giovanni', 'Verdi', 1999, 27.2)");
		}

		// SELECT
		rs = statement.executeQuery("SELECT * FROM students LIMIT 100");
		while (rs.next()) {
			System.out.println("id=" + rs.getInt("id") + ", name=" + rs.getString("name") + ", lastname="
					+ rs.getString("lastname") + ", year=" + rs.getInt("year") + ", grade=" + rs.getDouble("grade"));
		}

		scr = new Scanner(System.in);

		// INSERT
		System.out.println("insert new student - format: id,name,lastname,year,grade");
		p = scr.next().split(",");

		query = String.format("INSERT INTO students (id, name, lastname, year, grade) VALUES(%s, '%s', '%s', %s, %s)",
				p[0], p[1], p[2], p[3], p[4]);
		System.out.println(query);
		statement.executeUpdate(query);

		// SELECT
		rs = statement.executeQuery("SELECT * FROM students LIMIT 100");
		while (rs.next()) {
			System.out.println("id=" + rs.getInt("id") + ", name=" + rs.getString("name") + ", lastname="
					+ rs.getString("lastname") + ", year=" + rs.getInt("year") + ", grade=" + rs.getDouble("grade"));
		}

		// UPDATE
		System.out.println("modify student - format: id,grade");
		p = scr.next().split(",");
		query = String.format("UPDATE students SET grade=%s WHERE id=%s", p[1], p[0]);
		statement.executeUpdate(query);

		// SELECT
		rs = statement.executeQuery("SELECT * FROM students LIMIT 100");
		while (rs.next()) {
			System.out.println("id=" + rs.getInt("id") + ", name=" + rs.getString("name") + ", lastname="
					+ rs.getString("lastname") + ", year=" + rs.getInt("year") + ", grade=" + rs.getDouble("grade"));
		}

		// CLOSE
		scr.close();
		statement.close();
		connection.close();
	}
}
