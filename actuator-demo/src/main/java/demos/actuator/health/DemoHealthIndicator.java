package demos.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @author Nereus Yi
 */
@Component
public class DemoHealthIndicator implements HealthIndicator {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    @Override
    public Health health() {
        return checkFooServiceHealth();
    }

    public Health checkFooServiceHealth(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://start.spring.io/"))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return Health.up()
                        .withDetail("statusCode", response.statusCode()).build();
            }
            return Health.down()
                    .withDetail("statusCode", response.statusCode()).build();
        } catch (Exception e) {
            return Health.unknown()
                    .withDetail("exception", e.getMessage()).build();
        }
    }


}
