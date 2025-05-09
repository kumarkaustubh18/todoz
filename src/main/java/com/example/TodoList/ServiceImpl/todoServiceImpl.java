package com.example.TodoList.ServiceImpl;

import com.example.TodoList.Entity.task;
import com.example.TodoList.Repository.todoRepository;
import com.example.TodoList.Servic.todoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class todoServiceImpl implements todoService {
    @Autowired
    private todoRepository todo;
    @Override
    public com.example.TodoList.Entity.task addTask(com.example.TodoList.Entity.task tasktodo) {

        return todo.save(tasktodo);
    }

    @Override
    public List<task> getAllTasks() {
        Iterable<task> out=todo.findAll();
        List<task> taskList = new ArrayList<>();
        for (task t : out) {
            taskList.add(t);
        }
        return taskList;
    }

    @Override
    public ResponseEntity<task> updateTaskById(Long id, task updatedTask) {
       task existingOne= todo.findById(id).orElse(null);
       if(existingOne==null)
           return ResponseEntity.notFound().build();
       else
       {

         existingOne.setDescription(updatedTask.getDescription());

           task savedTask = todo.save(existingOne);

           return ResponseEntity.ok(savedTask);
       }

    }

    @Override
    public ResponseEntity<task> findbyId(Long id) {
        Optional<task> task = todo.findById(id);

        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<task> deletebyId(Long id) {

        Optional<task> taskOptional = todo.findById(id);
        if (taskOptional.isPresent()) {
            todo.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @Override
    public ResponseEntity<task> toggleCompletedStatus(Long id) {
        Optional<task> taskOptional = todo.findById(id);
        if (taskOptional.isPresent()) {
            task task = taskOptional.get();
            task.setCompleted(!task.isCompleted());  // ✅ Toggle logic
            todo.save(task);
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
