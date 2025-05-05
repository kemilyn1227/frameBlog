package com.descomplica.frameBlog.Controllers;

import com.descomplica.frameBlog.clients.TodosServiceClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TodoController {

    @Autowired
    TodosServiceClient todosServiceClient;

    @GetMapping("/getFakeApiData")
    public @ResponseBody List<Object> getAll(){
        return List.of(todosServiceClient.getAllTodos());
    }

}
