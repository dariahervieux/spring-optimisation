package fr.dasha1.springoptimisation.infra.db;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ToDoItemMapper {
    List<fr.dasha1.springoptimisation.domain.model.ToDoItem> map(Iterable<ToDoItem> toDoItems);
    @Mapping(source = "businessId", target = "id")
    fr.dasha1.springoptimisation.domain.model.ToDoItem map(ToDoItem toDoItem);
}
