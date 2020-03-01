package server;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import db.DBManager;
import utils.Mortadella;

public class JDBCServer {
	static Logger logger = LoggerFactory.getLogger(JDBCServer.class);
	ObjectMapper om = new ObjectMapper();
	DBManager db;

	public void dbConnection() {
		try {
			db = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
			db.executeQuery("SELECT * FROM mortadella LIMIT 1");
		} catch (ClassNotFoundException e) {
			System.out.println("Missign lib...");
			throw new RuntimeException();
		} catch (SQLException e) {
			try {
				db.executeUpdate("DROP TABLE IF EXISTS mortadella");
				db.executeUpdate("DROP TABLE IF EXISTS log");
				db.executeUpdate("CREATE TABLE mortadella (" + "id VARCHAR(50) PRIMARY KEY, " + "length REAL, "
						+ "diameter REAL, " + "weight REAL, " + "quality VARCHAR(50))");
				db.executeUpdate(
						"CREATE TABLE log (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "query VARCHAR(1024))");

				/* Examples for developing */
				db.executeUpdate(
						"INSERT INTO mortadella (id, length, diameter, weight, quality) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae79', 30.2, 30.0, 2.6, 'High')");
				db.executeUpdate(
						"INSERT INTO mortadella (id, length, diameter, weight, quality) VALUES ('03e9e721-f241-4539-9cc7-baecd8b3a931', 40.3, 35.5, 2.2, 'Low')");
				db.executeUpdate(
						"INSERT INTO mortadella (id, length, diameter, weight, quality) VALUES ('e1f0dcb0-181b-4463-97d7-edcfed736ae1', 35.1, 28.2, 4.3, 'High')");
			} catch (SQLException e1) {
				throw new RuntimeException();
			}
		}
	}

	public void run() {
		dbConnection();

		port(8080);

		get("/", (request, response) -> "Welcome!");

		// POST - Add new
		post("/mortadella/add", (request, response) -> {
			double length = Double.parseDouble(request.queryParams("length"));
			double diameter = Double.parseDouble(request.queryParams("diameter"));
			double weight = Double.parseDouble(request.queryParams("weight"));
			String quality = request.queryParams("quality");
			UUID uuid = UUID.randomUUID();

			Mortadella m = new Mortadella(uuid, length, diameter, weight, quality);
			String query = String.format(
					"INSERT INTO mortadella (id, length, diameter, weight, quality) VALUES ('%s', %f, %f, %f, '%s')",
					uuid, length, diameter, weight, quality);
			db.executeUpdate(query);

			response.status(201);
			return om.writeValueAsString(m);
		});

		// PUT - Update
		put("/mortadella/:id", (request, response) -> {
			UUID uuid = UUID.fromString(request.params(":id"));
			double length = Double.parseDouble(request.queryParams("length"));
			double diameter = Double.parseDouble(request.queryParams("diameter"));
			double weight = Double.parseDouble(request.queryParams("weight"));
			String quality = request.queryParams("quality");
			String query;

			query = String.format("SELECT * FROM mortadella WHERE ID = '%s'", uuid);
			ResultSet rs = db.executeQuery(query);
			if (rs.next() == false) {
				response.status(404);
				return om.writeValueAsString("{status: failed}");
			}

			Mortadella m = new Mortadella(uuid, length, diameter, weight, quality);
			query = String.format(
					"UPDATE mortadella SET length=%f, diameter=%f, weight=%f, quality='%s' WHERE ID = '%s'", length,
					diameter, weight, quality, uuid);
			db.executeUpdate(query);
			return om.writeValueAsString(m);

		});

		// DELETE - delete
		delete("/mortadella/:id", (request, response) -> {
			String id = request.params(":id");
			String query;

			query = String.format("SELECT * FROM mortadella WHERE ID = '%s'", id);
			ResultSet rs = db.executeQuery(query);
			if (rs.next() == false) {
				response.status(404);
				return om.writeValueAsString("{status: failed}");
			}

			query = String.format("DELETE FROM mortadella WHERE ID = '%s'", id);
			db.executeUpdate(query);
			return om.writeValueAsString("{status: ok}");
		});

		// GET - get one
		get("/mortadella/:id", (request, response) -> {
			String id = request.params(":id");
			String query;

			query = String.format("SELECT * FROM mortadella WHERE ID = '%s'", id);
			ResultSet rs = db.executeQuery(query);
			if (rs.next() == false) {
				response.status(404);
				return om.writeValueAsString("{status: failed}");
			}

			Mortadella m = new Mortadella(java.util.UUID.fromString(rs.getString("id")), rs.getDouble("length"),
					rs.getDouble("diameter"), rs.getDouble("weight"), rs.getString("quality"));
			return om.writeValueAsString(m);
		});

		// GET - get all
		get("/mortadella", (request, response) -> {
			String query;

			query = String.format("SELECT * FROM mortadella");
			ResultSet rs = db.executeQuery(query);

			ArrayList<Mortadella> l = new ArrayList<Mortadella>();
			while (rs.next()) {
				l.add(new Mortadella(java.util.UUID.fromString(rs.getString("id")), rs.getDouble("length"),
						rs.getDouble("diameter"), rs.getDouble("weight"), rs.getString("quality")));

			}
			return om.writeValueAsString(l);
		});

		// GET - get by length
		get("/mortadella/bylength", (request, response) -> {
			String min = request.queryParams("min");
			String max = request.queryParams("max");
			String query = String.format("SELECT * FROM mortadella WHERE length BETWEEN %s AND %s ORDER BY length", min,
					max);
			ResultSet rs = db.executeQuery(query);

			ArrayList<Mortadella> l = new ArrayList<Mortadella>();
			while (rs.next()) {
				l.add(new Mortadella(java.util.UUID.fromString(rs.getString("id")), rs.getDouble("length"),
						rs.getDouble("diameter"), rs.getDouble("weight"), rs.getString("quality")));

			}
			return om.writeValueAsString(l);
		});

		// GET - get by quality
		get("/mortadella/byquality", (request, response) -> {
			String quality = request.queryParams("quality");
			String query = String.format("SELECT * FROM mortadella WHERE quality=\'%s\'", quality);
			ResultSet rs = db.executeQuery(query);

			ArrayList<Mortadella> l = new ArrayList<Mortadella>();
			while (rs.next()) {
				l.add(new Mortadella(java.util.UUID.fromString(rs.getString("id")), rs.getDouble("length"),
						rs.getDouble("diameter"), rs.getDouble("weight"), rs.getString("quality")));

			}
			return om.writeValueAsString(l);
		});
	}

	public static void main(String[] args) {
		new JDBCServer().run();
	}
}