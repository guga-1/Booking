package com.example.demo.Service;
import com.example.demo.DTO.HotelCollectionDto;
import com.example.demo.DTO.HotelCreationReqModel;
import com.example.demo.Model.Hotel;
import com.example.demo.Repository.HotelRepository;
import com.example.demo.UTIL.ModelConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class HotelService {
    HotelRepository repo;
    ModelConverter converter;
    @Autowired
    public HotelService(HotelRepository repo, ModelConverter converter) {
        this.repo = repo;
        this.converter = converter;
    }
    public void addHotel(HotelCreationReqModel hotelCreationReq){
        repo.save(converter.convert(hotelCreationReq));
    }
    public HotelCollectionDto getHotelList() throws JsonProcessingException {
        return converter.convert(findAll());
    }
    private List<Hotel> findAll(){
        return repo.findAll();
    }
}