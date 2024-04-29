package com.example.demo.DTO;
import lombok.Builder;
import lombok.Data;
import java.util.List;
@Data
@Builder
public class HotelDto {
    private String name;
    private List<RoomDto> rooms;

    private static List<Builder> builder;

    public HotelDto(String name, List<RoomDto> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }

    public static List<Builder> getBuilder() {
        return builder;
    }

    public static void setBuilder(List<Builder> builder) {
        HotelDto.builder = builder;
    }
}