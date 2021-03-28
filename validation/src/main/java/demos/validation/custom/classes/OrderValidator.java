package demos.validation.custom.classes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

/**
 * validation with object
 * @author Nereus Yi
 */
public class OrderValidator implements ConstraintValidator<OrderValidation,Order> {

    @Override
    public boolean isValid(Order order, ConstraintValidatorContext constraintValidatorContext) {
        if (order == null) {
            return false;
        }
        LocalDateTime startDate = order.getStartDate();
        LocalDateTime closeDate = order.getCloseDate();
        if (startDate == null || closeDate == null) {
            return false;
        }
        constraintValidatorContext.buildConstraintViolationWithTemplate("");
        return !startDate.isAfter(closeDate);
    }
}
