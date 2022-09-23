package de.kopf3.mshack22backend.api.controller;

import de.kopf3.mshack22backend.persistence.document.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("users")
@RequestMapping("users")
public class UserController {


    @PostMapping
    public User addUser(User user){
        return null;
    }

    @DeleteMapping
    public void deleteUser(User user){
        return;
    }

    @PutMapping
    public User updateUser(User user){
        return null;
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Long id){
        return null;
    }

    @GetMapping(params = "nickname")
    public User getByNickName(@RequestParam String nickname){
        return null;
    }

    @GetMapping
    public List<User> getAll(){
        return null;
    }
}
