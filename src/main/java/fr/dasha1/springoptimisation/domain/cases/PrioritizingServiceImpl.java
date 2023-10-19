package fr.dasha1.springoptimisation.domain.cases;

import fr.dasha1.springoptimisation.domain.cases.port.in.PrioritizingService;
import fr.dasha1.springoptimisation.domain.cases.port.out.ToDoItemsRepository;
import fr.dasha1.springoptimisation.domain.model.Algorithm;
import fr.dasha1.springoptimisation.domain.model.ToDoItem;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PrioritizingServiceImpl implements PrioritizingService {
    private final ToDoItemsRepository toDoItemsRepository;
    private final Priorizator defaultPriorizator;

    private static final Map<Algorithm, Priorizator> PRIORIZATOR_MAP =
                                    Map.of(Algorithm.DATE, new DueDatePriorizator(),
                                           Algorithm.NO_OP, new NoOpPriorizator());


    public PrioritizingServiceImpl(ToDoItemsRepository toDoItemsRepository) {
        this.toDoItemsRepository = toDoItemsRepository;
        this.defaultPriorizator = PRIORIZATOR_MAP.get(Algorithm.NO_OP);
    }

    @Override
    public List<ToDoItem> getAllNotDoneItemsPrioritized() {
        return defaultPriorizator.getPrioritizedItems(toDoItemsRepository.getAllNotDone());
    }

    @Override
    public List<ToDoItem> getAllNotDoneItemsPrioritized(Algorithm algorithm) {
        Objects.requireNonNull(algorithm);

        final Priorizator priorizator = PRIORIZATOR_MAP.get(algorithm);
        final List<ToDoItem> allNotDone = toDoItemsRepository.getAllNotDone();

        return priorizator != null ?
                priorizator.getPrioritizedItems(allNotDone) :
                defaultPriorizator.getPrioritizedItems(allNotDone);

    }
}
