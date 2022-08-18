package com.todolist.todolist.repository;

import com.todolist.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Modifying
    @Query("Update Task t SET t.finished = 1 where t.id = :id")
    void finishTask(@Param("id") Long id);

    @Query(value = "SELECT t.* FROM task t where UPPER(t.name) = UPPER(:name)", nativeQuery = true)
    Optional<Task> findByName(@Param("name") String name);
}
