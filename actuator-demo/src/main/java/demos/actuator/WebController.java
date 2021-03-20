package demos.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nereus Yi
 */
@RestController
@RequestMapping
public class WebController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
