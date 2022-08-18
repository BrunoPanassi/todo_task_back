package com.todolist.todolist.resource;

import com.todolist.todolist.model.Task;
import com.todolist.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/task")
public class TaskResource {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") Long id) {

        Optional<Task> findedTask = taskService.getTask(id);

        if (findedTask.isPresent()) {
            return new ResponseEntity<>(findedTask.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public Page<Task> getTasks(Pageable pageable) {
        return taskService.getTasks(pageable);
    }

    @PostMapping()
    public ResponseEntity<String> saveTask(@RequestBody Task task) {

        Optional<Task> thereIsAlreadyThisTask = taskService.getTaskByName(task.getName());

        if (thereIsAlreadyThisTask.isPresent()) {
            return ResponseEntity.badRequest().body("There is already a task with the name " + thereIsAlreadyThisTask.get().getName());
        }
        taskService.saveTask(task);
        return ResponseEntity.ok().body("Task created: " + task.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task,
                                           @PathVariable Long id) {

        Optional<Task> findedTask = taskService.getTask(id);

        if (findedTask.isPresent()) {
            Task taskUpdated = findedTask.get();
            taskUpdated.setName(task.getName());
            taskUpdated.setDate(task.getDate());
            taskUpdated.setFinished(task.getFinished());
            return ResponseEntity.ok().body(taskService.saveTask(taskUpdated));
        }
        return (ResponseEntity<Task>) ResponseEntity.notFound();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {

        Optional<Task> findedTask = taskService.getTask(id);

        if (findedTask.isPresent()) {
            taskService.deleteTask(id);
            return ResponseEntity.ok("Task id: " + findedTask.get().getId() + " deleted.");
        }
        return (ResponseEntity<String>) ResponseEntity.notFound();
    }

    @PostMapping("/finish/{id}")
    public ResponseEntity<Long> finishTask(@PathVariable("id") Long id) {
        Optional<Task> findedTask = taskService.getTask(id);

        if (findedTask.isPresent()) {
            taskService.finishTask(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
