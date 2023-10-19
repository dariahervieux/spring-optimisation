package fr.dasha1.springoptimisation.domain.cases.port.out;

import fr.dasha1.springoptimisation.domain.model.ToDoItem;

import java.util.List;

public interface ToDoItemsRepository {

    List<ToDoItem> getAllNotDone();

}
