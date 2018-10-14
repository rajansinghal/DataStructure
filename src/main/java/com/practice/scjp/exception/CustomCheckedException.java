package com.practice.scjp.exception;

public class CustomExceptionExample {
	public static void main(String[] args) {
		// We demonstrate with a short password
		try {
			CustomExceptionExample.checkPass("pass");
		} catch (InvalidPassException e) {
			e.printStackTrace();
		}
		// We demonstrate with no password
		try {
			CustomExceptionExample.checkPass(null);
		} catch (InvalidPassException e) {
			e.printStackTrace();
		}
	}

	// Our business method that check password validity and throws
	// InvalidPassException
	public static void checkPass(String pass) throws InvalidPassException {
		int minPassLength = 5;
		try {
			if (pass.length() < minPassLength)
				throw new InvalidPassException(
						"The password provided is too short");
		} catch (NullPointerException e) {
			throw new InvalidPassException("No password provided", e);
		}
	}
}

// A custom business exception
class InvalidPassException extends Exception {
	InvalidPassException() {
	}

	InvalidPassException(String message) {

		super(message);
	}

	InvalidPassException(String message, Throwable cause) {

		super(message, cause);

	}

}
