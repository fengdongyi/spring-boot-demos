package demos.validation.controller;

import demos.validation.bean.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author Nereus Yi
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private Validator validator;

    @PostMapping("order")
    public String saveOrder(@Valid @RequestBody OrderDto orderDto){
        log.info("order={}", orderDto);
        return "success";
    }

    @PostMapping("order/validateDto")
    public String orderValidateDto(@RequestBody OrderDto orderDto){
        log.info("order={}", orderDto);
        Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        return "success";
    }
}
