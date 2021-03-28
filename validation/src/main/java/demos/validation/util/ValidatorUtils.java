package demos.validation.util;

import lombok.experimental.UtilityClass;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author Nereus Yi
 */
@UtilityClass
public class ValidatorUtils {

    private final ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    private final Validator validator = vf.getValidator();

    public static <T> Set<ConstraintViolation<T>> validate(T bean){
        return validator.validate(bean);
    }
}
