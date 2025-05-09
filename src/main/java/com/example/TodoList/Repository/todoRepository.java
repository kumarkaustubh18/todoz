package com.example.TodoList.Repository;

import com.example.TodoList.Entity.task;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface todoRepository extends CrudRepository<com.example.TodoList.Entity.task,Long> {

}
