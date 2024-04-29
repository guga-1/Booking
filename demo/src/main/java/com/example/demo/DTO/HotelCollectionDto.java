package com.example.demo.DTO;
import lombok.Builder;
import lombok.Data;
import java.util.List;
@Data
@Builder
public class HotelCollectionDto {
    List<HotelDto> hotelDtoList;
    List<Builder> builder;

    public HotelCollectionDto(List<HotelDto> hotelDtoList, List<Builder> builder) {
        this.hotelDtoList = hotelDtoList;
        this.builder = builder;
    }

    public List<HotelDto> getHotelDtoList() {
        return hotelDtoList;
    }

    public void setHotelDtoList(List<HotelDto> hotelDtoList) {
        this.hotelDtoList = hotelDtoList;
    }

    public List<Builder> getBuilder() {
        return builder;
    }

    public void setBuilder(List<Builder> builder) {
        this.builder = builder;
    }
}