package application;

import java.util.HashMap;

public class Rooms {
    private HashMap <String, Room> rooms;

    public HashMap<String, Room> getRooms(){
        return rooms;
    }

    public void setRooms(){
        this.rooms = rooms;
    }

    public Room getRoom(String roomName){
        Room roominfo = rooms.get(roomName);
        return rooms.get(roomName);
    }

    public Object returnDay(String roomName, int dayOfWeek){
        return rooms.get(roomName).getDays()[dayOfWeek];
    }
}
