package fr.dasha1.springoptimisation.domain.cases;

import fr.dasha1.springoptimisation.domain.model.ToDoItem;

import java.util.List;

public interface Priorizator {
    List<ToDoItem> getPrioritizedItems(Iterable<ToDoItem> nonprioritizedItems);
}
