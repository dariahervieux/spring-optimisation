package fr.dasha1.springoptimisation.infra.db;

import fr.dasha1.springoptimisation.domain.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoItemsCrudRepository extends CrudRepository<ToDoItem, Long> {

    Iterable<ToDoItem> findAllByStatusIsNot(Status status);
}
