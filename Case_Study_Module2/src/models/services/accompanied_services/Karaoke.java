package models.services.accompanied_services;

public class Karaoke extends AccompaniedService{
    private final double karaokePrice = 15;

    public Karaoke() {
        super("Karaoke", 0);
        setPrice(karaokePrice);
    }

    @Override
    public String toString() {
        return "nameService= " + getNameService() + "; price= " + getPrice();
    }
}
