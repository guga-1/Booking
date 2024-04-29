package com.example.demo.UTIL;
import com.example.demo.DTO.HotelCollectionDto;
import com.example.demo.DTO.HotelCreationReqModel;
import com.example.demo.DTO.HotelDto;
import com.example.demo.DTO.RoomDto;
import com.example.demo.Model.Hotel;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class ModelConverter {
    public HotelDto convert(Hotel hotel){
        return HotelDto.builder()
                .name(hotel.getName())
                .rooms(hotel.getRooms().stream().map(this::convert).toList())
                .build();
    }
    public HotelCollectionDto convert(List<Hotel> hotels){
        return HotelCollectionDto.builder()
                .hotelDtoList(hotels.stream().map(this::convert).toList())
                .build();
    }
    public Hotel convert(HotelCreationReqModel hotelCreationReq){
        Hotel hotel=Hotel.builder().name(hotelCreationReq.getName()).build();
        hotel.createRooms(hotelCreationReq.getNumOfRooms());
        return hotel;
    }
}
