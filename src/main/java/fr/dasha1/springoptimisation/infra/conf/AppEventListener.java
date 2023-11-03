package fr.dasha1.springoptimisation.infra.conf;

import jakarta.enterprise.event.Observes;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AppEventListener {
    private final Logger logger = LoggerFactory.getLogger(AppEventListener.class);


    void onStart(@Observes StartupEvent startup) {
        final String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        logger.info("*** Application is ready : {}", now);
    }
}
