package fr.dasha1.springoptimisation.infra.http;

import fr.dasha1.springoptimisation.domain.cases.port.in.PrioritizingService;
import fr.dasha1.springoptimisation.domain.model.ToDoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/prioritized-items")
public class PrioritizedItemsApi {

    @Autowired
    private PrioritizingService prioritizingService;

    /**
     * Getting all non-done items prioritized. For now, the prioritization is a no-op.
     * @return the list of prioritized items.
     */
    @GetMapping()
    public List<ToDoItem> getPrioritizedItems() {
        return prioritizingService.getAllNotDoneItemsPrioritized();
    }
}
