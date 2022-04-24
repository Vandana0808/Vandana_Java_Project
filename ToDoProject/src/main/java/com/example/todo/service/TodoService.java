package com.example.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.todo.entity.ToDo;
import com.example.todo.repo.ToDoRepository;

@Service
public class TodoService {
	
	@Autowired
	private ToDoRepository repo;
	
	public List<ToDo> getAllWork() {
		return repo.findAll();
	}
	
	
	public void add(ToDo todo) {
		repo.save(todo);
	}
	
	
	public ToDo getworkById(int id) {
		Optional<ToDo> td = repo.findById(id);
		if(td.isPresent())
		{
			return td.get();
		}
		return null;
	}
	
	public void deleteWorkById(int id) {
		repo.deleteById(id);
	}

	public String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

}
