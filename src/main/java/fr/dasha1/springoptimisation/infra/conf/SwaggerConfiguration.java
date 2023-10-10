package fr.dasha1.springoptimisation.infra.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("!prod && swagger")
public class SwaggerConfiguration {
//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Spring Optimisation")
//                        .description("Spring Optimisation API")
//                        .version("v0.0.1")
//                );
//    }

}
