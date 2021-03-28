package demos.validation.custom.classes;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Nereus Yi
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = OrderValidator.class)
public @interface OrderValidation {

    String message() default "order validation failed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
