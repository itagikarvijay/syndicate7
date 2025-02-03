/**
 * 
 */
package com.syndicate.app.exception;

import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.Date;

/**
 * @author User
 *
 */

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ TokenExpiredException.class })
	public ResponseEntity<ErrorDetails> handleTokenExpiredException(TokenExpiredException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
				"Token has expired please login agian.!");
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), "Party Not Found Exception..!!");
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ SQLException.class })
	public ResponseEntity<ErrorDetails> handleNotFoundException(SQLException ex, WebRequest request) {
		ex.printStackTrace();
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), "Something went wrong.!");
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ DataAccessResourceFailureException.class })
	public ResponseEntity<ErrorDetails> handleNotFoundException(DataAccessResourceFailureException ex, WebRequest request) {
		ex.printStackTrace();
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
				"Something went wrong, unable to connect to database.!");
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
