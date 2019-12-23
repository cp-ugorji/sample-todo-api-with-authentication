/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologyz.stealth.controllers;

import com.technologyz.stealth.entities.Todo;
import com.technologyz.stealth.services.TodoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chukwudi Ugorji
 */
@RestController
@RequestMapping("/api/users")//RequestMapping tells springboot that the parameter "/api/users" 
//should start the url of all endpoints in this controller i.e http://domain:port/api/users"
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {
    @Autowired
    private TodoService _todoService;
    
    //we want this endpoint to be /{username}/todos for getting all todos relating to a user
    //but because of the RequestMapping annotation on the controller,
    //this endpoint will look like http://domain:port/api/users/{username}/todos"
    @GetMapping("/{username}/todos")
    //adding authorization token field to swagger ui
    @ApiImplicitParams({
        @ApiImplicitParam(
            name = "Authorization", 
            value = "Access Token", 
            required = true, 
            paramType = "header", 
            dataType = "string", 
            example = "Bearer access_token"
        )
    })
    public List<Todo> getTodos(
            @ApiParam(value = "User id from which a list of todos will be retrieve", required = true) 
            @PathVariable String username)
    {
        return _todoService.getTodos(username);
    }
    
    @GetMapping("/{username}/todos/{id}")
    @ApiImplicitParams({
        @ApiImplicitParam(
            name = "Authorization", 
            value = "Access Token", 
            required = true, 
            paramType = "header", 
            dataType = "string", 
            example = "Bearer access_token"
        )
    })
    public Optional<Todo> getTodo(@PathVariable String username, @PathVariable long id)
    {
        return _todoService.getTodo(username, id);
    }
    
    @DeleteMapping("/{username}/todos/{id}")
    @ApiImplicitParams({
        @ApiImplicitParam(
            name = "Authorization", 
            value = "Access Token", 
            required = true, 
            paramType = "header", 
            dataType = "string", 
            example = "Bearer access_token"
        )
    })
    public void deleteTodos(@PathVariable String username, @PathVariable long id)
    {
        _todoService.deleteTodos(username, id);
    }
    
    @PutMapping("/{username}/todos/{id}")
    @ApiImplicitParams({
        @ApiImplicitParam(
            name = "Authorization", 
            value = "Access Token", 
            required = true, 
            paramType = "header", 
            dataType = "string", 
            example = "Bearer access_token"
        )
    })
    public void updateTodos(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo)
    {
        _todoService.updateTodos(username, id, todo);
    }
    
    @PostMapping("/{username}/todos")
    @ApiImplicitParams({
        @ApiImplicitParam(
            name = "Authorization", 
            value = "Access Token", 
            required = true, 
            paramType = "header", 
            dataType = "string", 
            example = "Bearer access_token"
        )
    })
    public Todo saveTodos(
            @ApiParam(value = "User id to which a todos will be attached", required = true) @PathVariable String username, 
            @ApiParam(value = "Save Todo object", required = true) @RequestBody Todo todo)
    {
        return _todoService.saveTodos(username, todo);
    }
}
