package com.bridgelabz.adressbook.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.adressbook.dto.ResponseDTO;

@ControllerAdvice
public class AddressBookExceptionHandler {
	
private static final String message = "Exception while processing REST Request";
	
	/**
	 * Handle Exception for Invalid REST Request.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream()
							  .map(objErr -> objErr.getDefaultMessage())
							  .collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO(message, errMsg);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Handle Custom Exception when Id is not found.
	 */
	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<ResponseDTO> handleEmployeeException(AddressBookException exception) {
		ResponseDTO responseDTO = new ResponseDTO(message, exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
