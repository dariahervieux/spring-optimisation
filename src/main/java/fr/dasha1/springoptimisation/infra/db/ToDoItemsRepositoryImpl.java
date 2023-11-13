package fr.dasha1.springoptimisation.infra.db;

import fr.dasha1.springoptimisation.domain.cases.port.out.ToDoItemsRepository;
import fr.dasha1.springoptimisation.domain.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoItemsRepositoryImpl implements ToDoItemsRepository {
    private final ToDoItemsCrudRepository toDoItemsCrudRepository;

    private final ToDoItemMapper mapper;

    @Autowired
    public ToDoItemsRepositoryImpl(ToDoItemsCrudRepository toDoItemsCrudRepository, ToDoItemMapper mapper) {
        this.toDoItemsCrudRepository = toDoItemsCrudRepository;
        this.mapper = mapper;
    }

    public List<fr.dasha1.springoptimisation.domain.model.ToDoItem> getAllNotDone() {
        final Iterable<ToDoItemEntity> allByStatusIsNot = toDoItemsCrudRepository.findAllByStatusIsNot(Status.DONE);
        return mapper.map(allByStatusIsNot);
    }


}
