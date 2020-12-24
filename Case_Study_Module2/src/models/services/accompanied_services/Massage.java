package models.services.accompanied_services;

public class Massage extends AccompaniedService{
    private final double massagePrice = 30;

    public Massage() {
        super("Massage", 0);
        setPrice(massagePrice);
    }

    @Override
    public String toString() {
        return "nameService= " + getNameService() + "; price= " + getPrice();
    }
}
