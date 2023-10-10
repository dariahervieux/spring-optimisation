package fr.dasha1.springoptimisation.domain.cases.port.out;

import fr.dasha1.springoptimisation.domain.model.ToDoItem;

public interface ToDoItemsRepository {

    Iterable<ToDoItem> getAllNotDone();

}
