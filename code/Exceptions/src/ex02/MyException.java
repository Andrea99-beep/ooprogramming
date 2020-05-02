package ex02;

public class MyException extends Exception {
	/*
	 * All the constructors needed to make MyException completely compatible with
	 * Exception can be automatically generated in Eclipse by making use of:
	 * 
	 * Source Menu->Generate Constructors from Superclass...
	 */

	private static final long serialVersionUID = 1L;

	public MyException() {
		super();
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
	}

}
