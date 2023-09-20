package com.example.demo.TodoController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TodoItem;
import com.example.demo.repo.TodoItemRepo;

@RestController
@RequestMapping(value="/todo")
public class MyController {
	
	@Autowired
	private TodoItemRepo t;
	

	
	@GetMapping
	public List<TodoItem> findAll(){
		return t.findAll();
	}
	
	@PostMapping
	public String save(@RequestBody TodoItem todoitem) {
		t.save(todoitem);
		return "Done";
	}
	
	@PutMapping
	public String update(@RequestBody TodoItem todoitem) {
		t.save(todoitem);
		if(todoitem.isStatus()==true) {
			t.delete(todoitem);
		}
		return "updated";
	}
	
	@DeleteMapping(value="/{id}")
	public String deleTodo(@PathVariable int id) {
		t.deleteById(id);
		return "deleted";
	}

}
