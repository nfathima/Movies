package uc.cs.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)

public class PwdMisMatchException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PwdMisMatchException(String message)
	{
		super(message);
	}

}
