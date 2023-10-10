package fr.dasha1.springoptimisation.domain.cases;

import fr.dasha1.springoptimisation.domain.model.ToDoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ToDoItmemsNoOpPriorizator implements Priorizator {

    @Override
    public List<ToDoItem> getPrioritizedItems(Iterable<ToDoItem> nonprioritizedItems) {
        Objects.requireNonNull(nonprioritizedItems, "nonprioritizedItems is null");
        List<ToDoItem> result = new ArrayList<>();
        for (ToDoItem item : nonprioritizedItems) {
            result.add(item);
        }
        return Collections.unmodifiableList(result);
    }
}
