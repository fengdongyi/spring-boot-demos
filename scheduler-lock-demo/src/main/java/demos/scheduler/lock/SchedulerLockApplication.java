package demos.scheduler.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SchedulerLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerLockApplication.class, args);
    }
}
