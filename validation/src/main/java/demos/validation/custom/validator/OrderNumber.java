package demos.validation.custom.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Nereus Yi
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = OrderNumberValidator.class)
public @interface OrderNumber {

    String message() default "order number must start with on";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
