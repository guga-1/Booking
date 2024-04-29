package com.example.demo.Controller;
import com.example.demo.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    RoomService service;

    @Autowired
    public RoomController(RoomService service) {
        this.service = service;
    }

    @PutMapping("/{num}")
    public void bookRoom(@PathVariable("num") Integer roomNum, @RequestParam("hotelId") Integer hotelId){
        service.bookRoom(roomNum,hotelId);
    }
}