package br.ufscar.dc.dsw.validation;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueLocacaoValidator.class)
public @interface UniqueLocacao {
	
    String message() default "Já existe uma locação para esse cliente ou locadora neste dia/horário";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}