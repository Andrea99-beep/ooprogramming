package server;
import static spark.Spark.get;
import static spark.Spark.port;

import java.util.Calendar;

import com.fasterxml.jackson.databind.ObjectMapper;

import utils.Date;
import utils.Time;

public class JSONServer {
	ObjectMapper om = new ObjectMapper();

	public void run() {
		// Start embedded server at this port
		port(8080);

		// Main Page, welcome
		get("/", (request, response) -> "Welcome!");

		// Date
		get("/date", (request, response) -> {
			Date d = new Date("frida.org", Calendar.getInstance().get(Calendar.YEAR),
					Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
			return om.writeValueAsString(d);
		});

		// Time
		get("/time", (request, response) -> {
			Time t = new Time("frida.org", Calendar.getInstance().get(Calendar.HOUR),
					Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND));
			return om.writeValueAsString(t);
		});
	}

	public static void main(String[] args) {
		new JSONServer().run();
	}
}