package com.example.TodoList.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class task {

    @Id
    private Long id;

    private String description;

    // No-arg constructor
    public task() {
    }

    // Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
