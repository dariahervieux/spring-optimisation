package fr.dasha1.springoptimisation.domain.cases.port.in;

import fr.dasha1.springoptimisation.domain.model.Algorithm;
import fr.dasha1.springoptimisation.domain.model.ToDoItem;
import java.util.List;

public interface PrioritizingService {
    public List<ToDoItem> getAllNotDoneItemsPrioritized();

    List<ToDoItem> getAllNotDoneItemsPrioritized(Algorithm algorithm);
}
