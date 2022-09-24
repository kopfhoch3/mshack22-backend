package de.kopf3.mshack22backend.api.controller;

import de.kopf3.mshack22backend.persistence.document.User;
import de.kopf3.mshack22backend.persistence.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("users")
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user){
        userRepository.delete(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public User getById(@PathVariable String id){
        return userRepository.findById(new ObjectId(id)).orElse(null);
    }



    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
