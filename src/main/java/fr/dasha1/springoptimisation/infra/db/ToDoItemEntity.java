package fr.dasha1.springoptimisation.infra.db;

import fr.dasha1.springoptimisation.domain.model.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TO_DO_ITEM")
public class ToDoItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String businessId;
    private String title;
    private String description;

    @Convert(converter = StatusConverter.class)
    private Status status;
    private LocalDate dueDate;


    public ToDoItemEntity() {
    }

    public ToDoItemEntity(String businessId, String title, String description, Status status, LocalDate dueDate) {
        this.businessId = businessId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public ToDoItemEntity(String businessId, String title, String description) {
        this(businessId, title, description, Status.NEW, null);
    }


    public String getTitle() {
        return title;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessId() {
        return businessId;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
