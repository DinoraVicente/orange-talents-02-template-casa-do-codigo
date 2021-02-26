package br.com.zup.casaDoCodigo.validacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR) // specifies OR as boolean operator instead of AND
@ReportAsSingleViolation // the error reports of each individual composing constraint are ignored
@Documented
@Constraint(validatedBy = { }) // we don't need a validator :-)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfOuCnpj {

    String message() default "CPF ou CNPJ invalido";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}