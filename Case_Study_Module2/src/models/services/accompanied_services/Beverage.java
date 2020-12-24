package models.services.accompanied_services;

public class Beverage extends AccompaniedService{
    private final double beveragePrice = 10;
    public Beverage() {
        super("Beverage", 0);
        setPrice(beveragePrice);
    }

    @Override
    public String toString() {
        return "nameService= "+getNameService() + "; price= " + getPrice() ;
    }
}
