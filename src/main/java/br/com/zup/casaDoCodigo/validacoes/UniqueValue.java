package br.com.zup.casaDoCodigo.validacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD) 
@Constraint(validatedBy = {UniqueValueValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
    String message() default "{custom.unique.field.validator}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName();
    Class<?> domainClass();
}