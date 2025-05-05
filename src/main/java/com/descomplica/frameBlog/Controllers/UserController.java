package com.descomplica.frameBlog.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.descomplica.frameBlog.services.UserService;
import com.descomplica.frameBlog.services.v2.*;
import com.descomplica.frameBlog.models.User;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceV2 userServiceV2;

    @PostMapping("/save")
    private User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/getAll")
    private List<User> getAll() {
        return userService.getAll();
    }

    //versionamento por URI
    
    @GetMapping("/get")
    private ResponseEntity<Object> get(@RequestParam final Long id,
                                       @RequestParam final String uriVersion,
                                       @RequestHeader(name = "Accept-Version") final String acceptVersion) {
        if ("v2".equals(uriVersion) || "v2".equals(acceptVersion)) {
            return ResponseEntity.ok(userServiceV2.get(id));
        }
        return ResponseEntity.ok(userService.get(id));
    }

    @PostMapping("/update")
    private User update(@RequestParam final Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/delete")
    private ResponseEntity<Void> delete(@RequestParam final Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/")
    public String authentication() {
        return "Hello world";
    }
}
