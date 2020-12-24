package models.services.accompanied_services;

public class CarRental extends AccompaniedService {
    private final double carRentalPrice = 50;

    public CarRental() {
        super("Car rental", 0);
        setPrice(carRentalPrice);
    }

    @Override
    public String toString() {
        return "nameService= " + getNameService() + "; price= " + getPrice();
    }
}
