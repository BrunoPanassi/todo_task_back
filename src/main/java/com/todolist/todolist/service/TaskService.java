package com.todolist.todolist.service;

import com.todolist.todolist.model.Task;
import com.todolist.todolist.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service @AllArgsConstructor @NoArgsConstructor @Transactional
public class TaskService implements TaskServiceImpl {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    public Optional<Task> getTaskByName(String name) {
        return taskRepository.findByName(name);

    }

    @Override
    public Page<Task> getTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void finishTask(Long id) {
        taskRepository.finishTask(id);
    }
}
