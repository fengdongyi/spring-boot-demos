package demos.actuator.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

/**
 * @author Nereus Yi
 */
@Service
public class DemoMetrics {

    private final Timer timer;
    public DemoMetrics(MeterRegistry registry) {
        timer = registry.timer("running.demo.timer");
    }

    public void service(){
        timer.record( () -> System.out.println("HelloWorld"));
    }
}
