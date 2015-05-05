package com.bestteam.exception;

public class SlideSaveException extends Exception {

	private static final long serialVersionUID = 83750709401286205L;

	public SlideSaveException(String message) {
		super(message);
	}

	public SlideSaveException(Throwable cause) {
		super(cause);
	}

	public SlideSaveException(String message, Throwable cause) {
		super(message, cause);
	}
}
