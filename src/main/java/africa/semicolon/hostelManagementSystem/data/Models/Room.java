package africa.semicolon.hostelManagementSystem.data.Models;


import lombok.Data;

@Data
public class Room {
    private String hostelId;
    private String id;
    private String name;
    private Bedspace[] bedSpaces;

    public Room(String hostelId, String roomId, String roomName, int numberOfBedSpaces){
        this.hostelId = hostelId;
        id = roomId;
        name = roomName;
        bedSpaces = new Bedspace[numberOfBedSpaces];
    }

}
