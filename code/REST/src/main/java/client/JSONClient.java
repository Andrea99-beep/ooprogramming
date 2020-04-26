package client;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kong.unirest.Unirest;
import utils.Date;

public class JSONClient implements Runnable {
	static Logger logger = LoggerFactory.getLogger(JSONClient.class);
	ObjectMapper om = new ObjectMapper();

	@Override
	public void run() {
		String url, json;

		// HTTP request (Date)
		url = "http://localhost:8080/date";
		json = Unirest.get(url).asString().getBody();

		// JSON to object mapping
		Date d = null;
		try {
			d = om.readValue(json, Date.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// logging
		logger.info(json);
		logger.info(d.toString());
	}

	public static void main(String[] args) {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(new JSONClient(), 0, 5, TimeUnit.SECONDS);
	}

}