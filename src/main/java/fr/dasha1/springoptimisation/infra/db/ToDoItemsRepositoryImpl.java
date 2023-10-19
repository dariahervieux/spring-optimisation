package fr.dasha1.springoptimisation.infra.db;

import fr.dasha1.springoptimisation.domain.cases.port.out.ToDoItemsRepository;
import fr.dasha1.springoptimisation.domain.model.Status;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoItemsRepositoryImpl implements ToDoItemsRepository {
    private final ToDoItemsCrudRepository toDoItemsCrudRepository;

    private final ToDoItemMapper mapper = Mappers.getMapper(ToDoItemMapper.class);

    @Autowired
    public ToDoItemsRepositoryImpl(ToDoItemsCrudRepository toDoItemsCrudRepository) {
        this.toDoItemsCrudRepository = toDoItemsCrudRepository;
    }

    public List<fr.dasha1.springoptimisation.domain.model.ToDoItem> getAllNotDone() {
        final Iterable<ToDoItemEntity> allByStatusIsNot = toDoItemsCrudRepository.findAllByStatusIsNot(Status.DONE);
        return mapper.map(allByStatusIsNot);
    }


}
