/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologyz.stealth.services;

import com.technologyz.stealth.entities.Todo;
import com.technologyz.stealth.interfaces.TodoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chukwudi Ugorji
 */
@Service
public class TodoService {
    
    @Autowired
    private TodoRepository _todoRepository;
    
    ///get all todos
    public List<Todo> getAllTodos()
    {
        return _todoRepository.findAll();
    }
    
    //get all todo belonging to the username
    public List<Todo> getTodos(String username)
    {
        return _todoRepository.findByUsername(username);
    }
    
    public Optional<Todo> getTodo(String username, Long id)
    {
        return _todoRepository.findById(id);
    }
    
    public void deleteTodos(String username, Long id)
    {
        _todoRepository.deleteById(id);
    }
    
    public Todo saveTodos(String username, Todo todo)
    {
        todo.setUsername(username);
        return _todoRepository.save(todo);
    }
    
    public Todo updateTodos(String username, Long id, Todo todo)
    {
        return _todoRepository.save(todo);
    }
}
