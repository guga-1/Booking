package com.example.demo.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(
            mappedBy = "hotel",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Room> rooms;
    private List<Builder> builder;

    public Hotel(String name, int numOfRooms) {
        this.name = name;
        createRooms(numOfRooms);
    }

    public void createRooms(int numOfRooms){
        this.rooms=new ArrayList<>();
        for (int i=1;i<=numOfRooms;i++){
            Room room=new Room(false,i,this);
            this.rooms.add(room);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Hotel(List<Builder> builder) {
        this.builder = builder;
    }

    public List<Builder> getBuilder() {
        return builder;
    }

    public void setBuilder(List<Builder> builder) {
        this.builder = builder;
    }

}