package com.ebube.event.event.model;
import  com.ebube.event.event.Repository.EventRepository;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.http.HttpStatus;
import  org.springframework.http.ResponseEntity;
import  org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Eventcontroller {
    @Autowired
    EventRepository repo;

    @PostMapping(value="/addevent")
    public Events addevent (@RequestBody Events evn1){ // CREATE(C)

        repo.save(evn1);
        return evn1;

    }
    @GetMapping("/getall")//READ(R)
    public List<Events> allEvent(){
        return repo.findAll();

    }
    @GetMapping("/event/{id}")// to find one at a time is to READ(R)
    public Optional<Events> getEvents(@PathVariable int id ){

        return repo.findById(id);
    }
    //UPDATE is like save
    @PutMapping(value="/upevent")
    public Events upevent(@RequestBody Events evn){
        repo.save((evn));
        return evn;


    }
    @DeleteMapping("/delete/{id}")//DELETE(D)
    public ResponseEntity<Object> removeEvent(@PathVariable Integer id){
        if(repo.findById(id)!=null){
            repo.deleteById((id));
            return new ResponseEntity<>("deleted success", HttpStatus.OK);

        }
        return  new ResponseEntity<>("failed to delete",HttpStatus.NOT_FOUND);


    }


}
