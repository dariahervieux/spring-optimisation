package fr.dasha1.springoptimisation.infra.db;

import fr.dasha1.springoptimisation.domain.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoItemsCrudRepository extends CrudRepository<ToDoItemEntity, Long> {

    List<ToDoItemEntity> findAllByStatusIsNot(Status status);
}
