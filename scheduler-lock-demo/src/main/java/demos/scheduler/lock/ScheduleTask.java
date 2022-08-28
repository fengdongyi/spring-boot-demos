package demos.scheduler.lock;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduleTask {

    @Scheduled(cron = "0 0/1 * * * ?")
    @SchedulerLock(name = "taskExecuteLock", lockAtLeastFor = "30s")
    public void taskExecute() {
        log.info("task execute ...");
    }
}
