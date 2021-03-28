package demos.validation.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Nereus Yi
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String,String> handleError(ConstraintViolationException e){
        return Map.of("msg", "invalid parameter :: " +
                e.getConstraintViolations().stream()
                        .map(v -> v.getPropertyPath().toString() + ":" + v.getMessage())
                        .collect(Collectors.joining(",")));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String,String> handleError(MethodArgumentNotValidException e){
        String msg = e.getBindingResult().getFieldErrors().isEmpty() ? e.getMessage()
                : e.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + ":" + f.getDefaultMessage())
                .collect(Collectors.joining(","));
        return Map.of("msg", "invalid parameter :: " + msg);
    }

}
