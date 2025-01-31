package br.com.zup.casaDoCodigo.validacoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerValidator {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorFormDto> handleAutor(MethodArgumentNotValidException exception) {
		List<ErrorFormDto> dto = new ArrayList<ErrorFormDto>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e ->{
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorFormDto erro = new ErrorFormDto(e.getField(), mensagem);
			dto.add(erro);
		});
		return dto;
	}
}