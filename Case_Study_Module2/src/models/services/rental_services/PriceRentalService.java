package models.services.rental_services;

public class PriceRentalService {
    private static final double VILLA_PRICE = 1000;
    private static final double HOUSE_PRICE = 600;
    private static final double ROOM_PRICE = 100;

    public static double getPrice(RentalService rentalService){
       if(rentalService instanceof Villa)
           return VILLA_PRICE;
       else if(rentalService instanceof House)
           return HOUSE_PRICE;
       else return ROOM_PRICE;
    }
}
