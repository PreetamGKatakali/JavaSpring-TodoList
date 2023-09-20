package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TodoItem;

public interface TodoItemRepo extends JpaRepository<TodoItem, Integer>{

}
