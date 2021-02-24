package br.com.zup.casaDoCodigo.validacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {CpfOuCnpjValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface CpfOuCnpj {

  String message() default "CPF/CNPJ inválido";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}