package fr.dasha1.springoptimisation.infra.conf;

import fr.dasha1.springoptimisation.domain.cases.Priorizator;
import fr.dasha1.springoptimisation.domain.cases.port.in.PrioritizingService;
import fr.dasha1.springoptimisation.domain.cases.port.out.ToDoItemsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainBeansConfiguration {
    @Bean
    public PrioritizingService prioritizingService(ToDoItemsRepository toDoItemsRepository) {
        return new fr.dasha1.springoptimisation.domain.cases.PrioritizingServiceImpl(toDoItemsRepository);
    }

}
