package com.example.demo.DTO;
import lombok.Data;
@Data
public class HotelCreationReqModel {
    String name;
    int numOfRooms;

    public HotelCreationReqModel(String name, int numOfRooms) {
        this.name = name;
        this.numOfRooms = numOfRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }
}