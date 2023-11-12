package fr.dasha1.springoptimisation.domain.model.conveymatrix;

import fr.dasha1.springoptimisation.domain.model.ToDoItem;

import java.time.LocalDate;
// @Reflective - doesn't work like @RegisterForReflection in Quarkus
// @RegisterReflectionForBinding should be used on an element of a Spring Bean
public class ConveyToDoItem extends ToDoItem {
    private boolean isImportant;
    private boolean isUrgent;

    public ConveyToDoItem(String id, String title, String description, LocalDate date, boolean isImportant, boolean isUrgent) {
        super(id, title, description, date);
        this.isImportant = isImportant;
        this.isUrgent = isUrgent;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }
}
