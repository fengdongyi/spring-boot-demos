package demos.validation.bean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * @author Nereus Yi
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {

    @NotNull
    String orderId;
    @NotNull
    @Min(value = 0,message = "price can't less than 0")
    @Max(value = 99999,message = "price can't greater than 99999")
    Integer price;
    @NotNull
    @PastOrPresent
    LocalDateTime startDate;
    @FutureOrPresent
    LocalDateTime closeDate;
}
