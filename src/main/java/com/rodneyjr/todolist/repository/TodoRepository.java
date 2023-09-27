package com.rodneyjr.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodneyjr.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
