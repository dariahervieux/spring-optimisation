package fr.dasha1.springoptimisation.domain.cases;

import fr.dasha1.springoptimisation.domain.model.ToDoItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class DueDatePriorizatorTest {

    private final DueDatePriorizator dueDatePriorizator = new DueDatePriorizator();

    @Test
    void prioritized_desnt_change_order_of_original_list() {
        List<ToDoItem> list = Arrays.asList(
                new ToDoItem("ABCF", "Item 1", "Item 1 Descr", LocalDate.now().plusDays(1)),
                new ToDoItem("AFCF", "Item 2", "Item 2 Descr", LocalDate.now().plusDays(7)),
                new ToDoItem("AFC6", "Item 3", "Item 3 Descr", LocalDate.now())
        );
        final List<ToDoItem> prioritizedItems = dueDatePriorizator.getPrioritizedItems(list);
        Assertions.assertThat(list).isNotEqualTo(prioritizedItems);
    }

    @Test
    void prioritized_sorts_by_due_date_asc() {
        final LocalDate now = LocalDate.now();
        final LocalDate tomorrow = now.plusDays(1);
        final LocalDate inOneWeek = now.plusDays(7);
        List<ToDoItem> list = Arrays.asList(
                new ToDoItem("ABCF", "Item 1", "Item 1 Descr", tomorrow),
                new ToDoItem("AFCF", "Item 2", "Item 2 Descr", inOneWeek),
                new ToDoItem("AFC6", "Item 3", "Item 3 Descr", now)
        );
        final List<ToDoItem> prioritizedItems = dueDatePriorizator.getPrioritizedItems(list);
        List<ToDoItem> expertedResult = Arrays.asList(
                new ToDoItem("AFC6", "Item 3", "Item 3 Descr", now),
                new ToDoItem("ABCF", "Item 1", "Item 1 Descr", tomorrow),
                new ToDoItem("AFCF", "Item 2", "Item 2 Descr", inOneWeek));
        Assertions.assertThat(prioritizedItems).isEqualTo(expertedResult);
    }
}
