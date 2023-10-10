package fr.dasha1.springoptimisation.domain.model;

import java.time.LocalDate;
import java.util.Objects;


public class ToDoItem {
    private String id;
    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;



    public ToDoItem(String id, String title, String description, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
        this.dueDate = dueDate;
    }

//    public ToDoItem(String id, String title, String description) {
//        this(id, title, description, LocalDate.now().plusDays(3));
//    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void changeStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return Objects.equals(id, toDoItem.id) && Objects.equals(title, toDoItem.title) && Objects.equals(description, toDoItem.description) && status == toDoItem.status && Objects.equals(dueDate, toDoItem.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, status, dueDate);
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", dueDate=" + dueDate +
                '}';
    }
}
