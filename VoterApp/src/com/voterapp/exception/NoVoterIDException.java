package com.voterapp.exception;

public class NoVoterIDException extends NotEligibleException {

	private static final long serialVersionUID = 1L;

	public NoVoterIDException() {
		super();
	}

	public NoVoterIDException(String message) {
		super(message);
	}

}
