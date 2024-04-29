package com.example.demo.Controller;
import com.example.demo.DTO.HotelCollectionDto;
import com.example.demo.DTO.HotelCreationReqModel;
import com.example.demo.Service.HotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    HotelService service;

    @Autowired
    public HotelController(HotelService service) {
        this.service = service;
    }

    @PostMapping
    public void addHotel(@RequestBody HotelCreationReqModel hotel) throws JsonProcessingException {
        service.addHotel(hotel);
    }
    @GetMapping
    @ResponseBody
    public HotelCollectionDto getHotelList() throws JsonProcessingException {
        return service.getHotelList();
    }
}