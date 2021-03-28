package demos.validation.custom.classes;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @author Nereus Yi
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@OrderValidation
public class Order {

    String orderId;
    Integer price;
    LocalDateTime startDate;
    LocalDateTime closeDate;
}
