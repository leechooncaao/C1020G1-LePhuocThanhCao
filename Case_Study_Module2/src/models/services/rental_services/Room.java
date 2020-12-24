package models.services.rental_services;

import models.services.accompanied_services.AccompaniedService;

import java.util.ArrayList;
import java.util.List;

public class Room extends RentalService implements Comparable<Room>{
//    private static final long serialVersionUID = -1791606127983579203L;
    private RoomType roomType;
    private List<AccompaniedService> freeAccompaniedServices;

    public Room(String nameService, double price, int areaUsing,
                RentalType rentalType, String otherAmenities, String idService, int numberTenants, RoomType roomType) {
        super(nameService, price, areaUsing, rentalType, otherAmenities, idService, numberTenants);
        this.roomType = roomType;
        this.freeAccompaniedServices = new ArrayList<>();
    }

    public Room() {

    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "nameService= " + getNameService()+ "; id=" + getIdService() + "; areaUsing= " + getAreaUsing() +
                "; rentalType= " + getRentalType() + "; roomType= " + getRoomType() +
                "; otherAmenities= " + getOtherAmenities() + "; price= " + getPrice();
    }

    @Override
    public int compareTo(Room o) {
        return getNameService().compareTo(o.getNameService());
    }
}
