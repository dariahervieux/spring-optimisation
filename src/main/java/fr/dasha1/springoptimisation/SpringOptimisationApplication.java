package fr.dasha1.springoptimisation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.autoconfigure.ssl.SslAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
/**
 * https://timeular.com/blog/best-prioritization-techniques/
 */
@SpringBootApplication (exclude = {SslAutoConfiguration.class, ApplicationAvailabilityAutoConfiguration.class,
		ProjectInfoAutoConfiguration.class, TaskExecutionAutoConfiguration.class, TaskSchedulingAutoConfiguration.class,
		WebSocketServletAutoConfiguration.class, SpringDataWebAutoConfiguration.class,
		RestTemplateAutoConfiguration.class, ErrorMvcAutoConfiguration.class
})
public class SpringOptimisationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOptimisationApplication.class, args);
	}

}
