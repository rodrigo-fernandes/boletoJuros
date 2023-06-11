package br.com.boletojuros.adapter.datasource.http.exception;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.boletojuros.core.exception.ApplicationException;

@ControllerAdvice
public class ApplicationExceptionHandle extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErroResponse> applicationException(ApplicationException ex, WebRequest request) {
		var response = new ErroResponse(Arrays.asList(ex.getTipoExecao().getMensagemErro()),
				ex.getTipoExecao().toString().toLowerCase(), HttpStatus.BAD_REQUEST.value(), new Date(),
				request.getDescription(false));

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		var erros = ex.getFieldErrors().stream().map(item -> item.getField() + " " + item.getDefaultMessage())
				.collect(Collectors.toList());
		var response = new ErroResponse(erros, "erro_na_validacao_xpto", HttpStatus.BAD_REQUEST.value(), new Date(),
				request.getDescription(false));

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}

}
