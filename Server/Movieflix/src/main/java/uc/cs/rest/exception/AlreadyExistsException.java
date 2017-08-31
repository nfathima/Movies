package uc.cs.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AlreadyExistsException(String message)
	{
		super(message);
	}

	public AlreadyExistsException(String message, Throwable cause)
	{
		super(message,cause);
	}

}
