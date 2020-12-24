package models.services.accompanied_services;

public class Food extends AccompaniedService{
    private final double foodPrice = 20;

    public Food() {
        super("Food", 0);
        setPrice(foodPrice);
    }

    @Override
    public String toString() {
        return "nameService= " + getNameService() + "; price= " + getPrice();
    }
}
