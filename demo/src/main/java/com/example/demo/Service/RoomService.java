package com.example.demo.Service;
import java.util.List;
import java.util.Objects;

import com.example.demo.Model.Hotel;
import com.example.demo.Model.Room;
import com.example.demo.Repository.HotelRepository;
import com.example.demo.Repository.RoomRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    HotelRepository repo;
    RoomRepository roomRepo;

    @Autowired
    public RoomService(HotelRepository repo, RoomRepository roomRepo) {
        this.repo = repo;
        this.roomRepo = roomRepo;
    }

    public void bookRoom(Integer roomNum,Integer hotelId) {
        Room room=findRoomByRoomNum(hotelId,roomNum);
        assert room != null;
        val hotel= (val) findHotelById(room.getHotel().getId());
        hotel.setRooms(bookedRoom(room.getHotel(),room));
        repo.save(hotel);
    }
    private List<Room> bookedRoom(Hotel hotel, Room room){
        List<Room> rooms=hotel.getRooms();
        for (int i=0;i<rooms.size();i++){
            if (Objects.equals(rooms.get(i).getRoomId(), room.getRoomId())){
                rooms.get(i).setBooked(true);
            }
        }
        return rooms;
    }
    private Hotel findHotelById(int id){
        return repo.findById(id).orElseThrow();
    }
    private Room findRoomByRoomNum(Integer hotelId, Integer RoomNum){
        Hotel hotel=findHotelById(hotelId);
        for (Room room:hotel.getRooms()){
            if (room.getRoomNum()==RoomNum){
                return room;
            }
        }
        return null;
    }
}