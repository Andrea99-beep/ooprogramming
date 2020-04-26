package utils;

public class Date {
	String host;
	int year;
	int month;
	int day;

	public Date() {
	}

	public Date(String host, int year, int month, int day) {
		super();
		this.host = host;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Date [host=" + host + ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}
}
