package com.example.TodoList.Controller;

import com.example.TodoList.Servic.todoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class todoController {

   @Autowired
   private todoService  todoservice;


   @PostMapping

   public String AddTasks(@RequestParam String tasktodo)
   {
      return todoservice.addTask(tasktodo);
   }
   public void getAllTasks()
   {

   }
}
