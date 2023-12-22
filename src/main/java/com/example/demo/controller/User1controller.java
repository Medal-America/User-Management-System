package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import javassist.bytecode.FieldInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class User1controller {
    Logger logger = LoggerFactory.getLogger(User1controller.class);

    @RequestMapping("/")
    public String home() {
        logger.info("Home method accessed");
        return "Hello from Spring Boot";
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public User1controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/add_newUser")
    public String listUsers() {
        logger.info("Starting to get the form method with info log level");
        logger.trace("Starting to get the form method with the trace log level");
        // return userRepository.findAll();
        return "form";
    }

    @GetMapping("/list_all_users")
    public String listAllUsers(Model model) {
        logger.info("getAllUsers method in service class started");
        try {
            logger.info("getAllUsers method in the service class ended");
            List<User> users = userService.getUsers();
            model.addAttribute("users", users);
            return "list";
        } catch (Exception e) {
            logger.error("Something went wrong");
            e.printStackTrace();

        }
        return "list";
    }


    @GetMapping("/save")
    public String getUser(@ModelAttribute("user") User user) {
        logger.info("User saved");
        logger.warn("Provide a valid email");

        userService.saveUser(user);
        logger.info("{}", user);
        return "list";
    }



    @PostMapping("/save")
    public String saveUser(User user) {
        userRepository.save(user);
        logger.info("User Added: {}",user);
        return "redirect:/list_all_users";
    }


//    public String editUserForm(@PathVariable Long id, ) {
//        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
//        FieldInfo model;
//        model.addAttribute("user", user);
//        return null;
//    }


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user", new User());
        return "form";
    }}

