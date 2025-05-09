package com.example.TodoList.Servic;

import com.example.TodoList.Entity.task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface todoService {
   public task addTask(task tasktodo);

   List<task> getAllTasks();

   ResponseEntity<task> updateTaskById(Long id, task updatedTask);

   ResponseEntity<task> findbyId(Long id);

    ResponseEntity<task> deletebyId(Long id);

    ResponseEntity<task> toggleCompletedStatus(Long id);
}
