package utils;

public class Time {
	String host;
	int hour;
	int minute;
	int second;

	public Time() {

	}

	public Time(String host, int hour, int minute, int second) {
		super();
		this.host = host;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "Time [host=" + host + ", hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
}
