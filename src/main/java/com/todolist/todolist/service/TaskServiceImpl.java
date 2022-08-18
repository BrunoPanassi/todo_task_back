package com.todolist.todolist.service;

import com.todolist.todolist.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TaskServiceImpl {
    Task saveTask(Task task);
    Optional<Task> getTask(Long id);
    Page<Task> getTasks(Pageable pageable);
    void deleteTask(Long id);
    void finishTask(Long id);
}
