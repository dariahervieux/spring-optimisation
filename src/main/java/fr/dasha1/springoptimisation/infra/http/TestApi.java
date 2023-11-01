package fr.dasha1.springoptimisation.infra.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/test")
public class TestApi {
    private final Logger logger = LoggerFactory.getLogger(TestApi.class);

    @GetMapping
    public String getOK() {
        final String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        logger.info("*** API served: {}", now);
        return "OK";
    }

}
