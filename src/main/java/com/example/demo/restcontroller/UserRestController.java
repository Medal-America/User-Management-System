package com.example.demo.restcontroller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserRestController {
    @Autowired
    private UserRepository userRepository;
    private final UserService userService;


//    @GetMapping("/all")
//    public  List<User> listUsers() {
//        return userRepository.findAll();
//    }
//    @GetMapping String newUserForm(Model model) {
//        model.addAttribute("user", new User());
//        return "list";
//    }
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return  userRepository.save(user);
    }
//    public User editUserForm(@PathVariable Long id, Model model) {
//        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
////        model.addAttribute("user", user);
//        return user;
//    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "user deleted";
    }




}
