package demos.actuator.info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @author Nereus Yi
 */
@Component
public class DemoInfo implements InfoContributor {

    @Value("${spring.application.name}")
    private String application;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("application", application)
                .withDetail("git-version", "2d5fg23")
                .withDetail("version", "1.0-SNAPSHOT")
                .withDetail("dev", "Nereus Yi");
    }

}
