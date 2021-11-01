package africa.semicolon.hostelManagementSystem.data.Models;

import lombok.Data;

@Data
public class Hostel {
    private String name;
    private String id;
    private Room[] rooms;

    public Hostel(String hostelName, String hostelId, int numberOfRooms){
        name = hostelName;
        id = hostelId;
        rooms = new Room[numberOfRooms];
    }
}
