package fr.dasha1.springoptimisation.domain.cases;

import fr.dasha1.springoptimisation.domain.cases.port.in.PrioritizingService;
import fr.dasha1.springoptimisation.domain.cases.port.out.ToDoItemsRepository;
import fr.dasha1.springoptimisation.domain.model.ToDoItem;

import java.util.List;

public class PrioritizingServiceImpl implements PrioritizingService {
    private final ToDoItemsRepository toDoItemsRepository;
    private final Priorizator priorizator;

    public PrioritizingServiceImpl(ToDoItemsRepository toDoItemsRepository) {
        this.toDoItemsRepository = toDoItemsRepository;
        this.priorizator = new ToDoItmemsNoOpPriorizator();
    }

    public List<ToDoItem> getAllNotDoneItemsPrioritized() {
        return priorizator.getPrioritizedItems(toDoItemsRepository.getAllNotDone());
    }
}
