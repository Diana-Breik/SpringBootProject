package com.example.springbootproject;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class MyController {

    private final List<Message> messageListe = new ArrayList<>();
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

    @PostMapping("/messages")
    public Message addMessageToList(@RequestBody Message message){
        messageListe.add(message);
        int index = messageListe.indexOf(message);
        return  messageListe.get(index);
    }
    @GetMapping("/messages")
    public List<Message> getTheList(){
        return messageListe;
    }

    @DeleteMapping("/messages/{id}")
    public void deleteMessageWithId(@PathVariable String id){
     for(Message message : messageListe){
         if(message.getId().equals(id)){
             messageListe.remove(message);
         }
       }
    }

}
