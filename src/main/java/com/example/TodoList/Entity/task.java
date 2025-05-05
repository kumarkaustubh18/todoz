package com.example.TodoList.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class task {

    @Id
    String task;

    public task(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
