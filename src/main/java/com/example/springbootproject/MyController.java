package com.example.springbootproject;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class MyController {

    @GetMapping
    public String getHello(){
        System.out.println("Hello, World!");
        return "Hello, World!";
    }
    @GetMapping("/{name}")
    public String nameEditing(@PathVariable String name){
        System.out.println("Hello, " + name + "!");
        return "Hello, " + name + "!";
    }

    @PostMapping()
    public String printBody(@RequestBody String body){
      return "the body: " + body;
    }


}
