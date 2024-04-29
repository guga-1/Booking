package com.example.demo.DTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {
    private boolean booked;
    private int roomNum;
    private Integer hotel_id;
}