package demos.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Nereus Yi
 */
@Component
@Endpoint(id = "demo")
public class DemoEndpoint {

    private String ready = "READY";

    @ReadOperation
    public String getDemo(){
        return ready;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setReady(){
        ready = "READY";
    }
}
