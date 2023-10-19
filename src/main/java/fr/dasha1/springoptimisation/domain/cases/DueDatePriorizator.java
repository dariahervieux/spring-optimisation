package fr.dasha1.springoptimisation.domain.cases;

import fr.dasha1.springoptimisation.domain.model.ToDoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DueDatePriorizator implements Priorizator {

    private final Comparator<ToDoItem> comparator = Comparator.comparing(ToDoItem::getDueDate);

    @Override
    public List<ToDoItem> getPrioritizedItems(List<ToDoItem> nonprioritizedItems) {
        List<ToDoItem> prioritizedItems = new ArrayList<>(nonprioritizedItems);
        prioritizedItems.sort(comparator);
        return Collections.unmodifiableList(prioritizedItems);
    }
}
