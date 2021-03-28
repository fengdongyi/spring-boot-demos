package demos.validation.controller;

import demos.validation.custom.classes.Order;
import demos.validation.custom.validator.OrderNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @author Nereus Yi
 */
@Slf4j
@Validated
@RestController
public class OrderQueryController {

    @GetMapping("order/{orderId}")
    public String getOrder(@PathVariable @Min(0) String orderId){
        log.info("orderId={}", orderId);
        return orderId;
    }

    @GetMapping("order")
    public String getOrderByNumber(@OrderNumber String orderNumber){
        log.info("order number={}", orderNumber);
        return orderNumber;
    }

    @PostMapping("order/validation")
    public Order orderValidation(@Valid @RequestBody Order order){
        log.info("order={}", order);
        return order;
    }
}
