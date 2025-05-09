package com.example.TodoList.Controller;

import com.example.TodoList.Entity.task;
import com.example.TodoList.Servic.todoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class todoController {

   @Autowired
   private todoService  todoservice;


   @PostMapping
   public task AddTasks(@RequestBody task tasktodo)
   {
      return todoservice.addTask(tasktodo);
   }
   @GetMapping
   public List<task>getAllTasks()
   {
    return todoservice.getAllTasks();
   }

   @PostMapping("/{id}/update")
   public ResponseEntity<task> updateTaskById(@PathVariable Long id ,@RequestBody task updatedTask)
   {
      return todoservice.updateTaskById(id,updatedTask);
   }
   @GetMapping("/{id}")
   public ResponseEntity<task> getTaskById(@PathVariable Long id) {
     return  todoservice.findbyId(id);
   }
   @GetMapping("/{id}/delete")
   public ResponseEntity<task> deleteTaskById(@PathVariable Long id) {
      return  todoservice.deletebyId(id);
   }
}
