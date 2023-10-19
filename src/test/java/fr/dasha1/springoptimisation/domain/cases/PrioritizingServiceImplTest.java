package fr.dasha1.springoptimisation.domain.cases;

import fr.dasha1.springoptimisation.domain.cases.port.out.ToDoItemsRepository;
import fr.dasha1.springoptimisation.domain.model.Algorithm;
import fr.dasha1.springoptimisation.domain.model.ToDoItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class PrioritizingServiceImplTest {
    @InjectMocks
    private PrioritizingServiceImpl tested;
    @Mock
    private ToDoItemsRepository repositoryMock;

    @BeforeEach
    void setUp() {
        Mockito.when(repositoryMock.getAllNotDone())
                .thenReturn(
                    Arrays.asList(
                        new ToDoItem("ABCF", "Item 1", "Item 1 Descr", LocalDate.of(2021, Month.APRIL, 1)),
                        new ToDoItem("AFC6", "Item 3", "Item 3 Descr", LocalDate.of(2021, Month.MARCH, 28)),
                        new ToDoItem("AFCF", "Item 2", "Item 2 Descr", LocalDate.of(2021, Month.APRIL, 4)))
                );
    }

    @Test
    void no_prioritization_by_default() {
        Assertions.assertThat(tested.getAllNotDoneItemsPrioritized())
                .isEqualTo(
                    Arrays.asList(
                        new ToDoItem("ABCF", "Item 1", "Item 1 Descr", LocalDate.of(2021, Month.APRIL, 1)),
                        new ToDoItem("AFC6", "Item 3", "Item 3 Descr", LocalDate.of(2021, Month.MARCH, 28)),
                        new ToDoItem("AFCF", "Item 2", "Item 2 Descr", LocalDate.of(2021, Month.APRIL, 4))
                    ));
    }

    @Test
    void due_date_prioritization_ok() {
        Assertions.assertThat(tested.getAllNotDoneItemsPrioritized(Algorithm.DATE))
                .isEqualTo(
                        Arrays.asList(
                                new ToDoItem("AFC6", "Item 3", "Item 3 Descr", LocalDate.of(2021, Month.MARCH, 28)),
                                new ToDoItem("ABCF", "Item 1", "Item 1 Descr", LocalDate.of(2021, Month.APRIL, 1)),
                                new ToDoItem("AFCF", "Item 2", "Item 2 Descr", LocalDate.of(2021, Month.APRIL, 4))

                        ));
    }
}
