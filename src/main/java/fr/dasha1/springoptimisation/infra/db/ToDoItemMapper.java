package fr.dasha1.springoptimisation.infra.db;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * ToDoItem mapper from/to entity/model class.
 *
 * Make it ti be managed by spring for AOT hints to be produced.
 */
@Mapper(componentModel = "spring")
public interface ToDoItemMapper {
    List<fr.dasha1.springoptimisation.domain.model.ToDoItem> map(Iterable<ToDoItemEntity> toDoItems);
    @Mapping(source = "businessId", target = "id")
    fr.dasha1.springoptimisation.domain.model.ToDoItem map(ToDoItemEntity toDoItemEntity);
}
