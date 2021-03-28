package demos.validation.custom.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Nereus Yi
 */
public class OrderNumberValidator implements ConstraintValidator<OrderNumber, String> {

    @Override
    public void initialize(OrderNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.startsWithIgnoreCase(value, "on");
    }

}
