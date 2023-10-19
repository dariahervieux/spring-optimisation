package fr.dasha1.springoptimisation.domain.cases.port;

import fr.dasha1.springoptimisation.domain.model.Status;
import fr.dasha1.springoptimisation.domain.model.ToDoItem;
import fr.dasha1.springoptimisation.infra.db.ToDoItemEntity;
import fr.dasha1.springoptimisation.infra.db.ToDoItemsCrudRepository;
import fr.dasha1.springoptimisation.infra.db.ToDoItemsRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToDoItemsRepositoryTest {

    @Mock
    private ToDoItemsCrudRepository toDoItemsRepositoryMock;
    @InjectMocks
    private ToDoItemsRepositoryImpl toDoItemsRepository;

    @Test
    public void model_items_converted_returned() {
        final LocalDate dueDate = LocalDate.now();
        when(toDoItemsRepositoryMock.findAllByStatusIsNot(Status.DONE))
                .thenReturn(
                  Arrays.asList(new ToDoItemEntity("ABCF", "Item 1", "Item 1 Descr", Status.NEW, dueDate),
                                new ToDoItemEntity("AFCF", "Item 2", "Item 2 Descr",Status.NEW, dueDate),
                                new ToDoItemEntity("AFC6", "Item 3", "Item 3 Descr",Status.NEW, dueDate)));

        assertThat(toDoItemsRepository.getAllNotDone())
                .allMatch(toDoItem -> toDoItem.getStatus() != Status.DONE)
                .containsExactly(
                        new ToDoItem("ABCF", "Item 1", "Item 1 Descr", dueDate),
                        new ToDoItem("AFCF", "Item 2", "Item 2 Descr", dueDate),
                        new ToDoItem("AFC6", "Item 3", "Item 3 Descr", dueDate));
    }



}
