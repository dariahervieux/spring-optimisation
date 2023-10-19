package fr.dasha1.springoptimisation.domain.cases;

import fr.dasha1.springoptimisation.domain.model.ToDoItem;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NoOpPriorizator implements Priorizator {

    @Override
    public List<ToDoItem> getPrioritizedItems(List<ToDoItem> nonprioritizedItems) {
        Objects.requireNonNull(nonprioritizedItems, "nonprioritizedItems is null");
        return Collections.unmodifiableList(nonprioritizedItems);
    }
}
