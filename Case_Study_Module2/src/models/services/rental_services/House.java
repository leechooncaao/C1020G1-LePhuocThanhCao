package models.services.rental_services;

public class House extends RentalService implements Comparable<House>{
//    private static final long serialVersionUID = 3199724262091019344L;
    private int floorNumber;

    public House(String nameService, double price, int areaUsing, int numberTenants,
                 RentalType rentalType, String otherAmenities, int floorNumber,String idService) {
        super(nameService, price, areaUsing, rentalType, otherAmenities, idService, numberTenants);
        this.floorNumber = floorNumber;
    }

    public House() {

    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "nameService= " + getNameService() + "; id=" + getIdService() +"; areaUsing= " + getAreaUsing() +
                "; numberTenants= " + getNumberTenants() + "; rentalType= " + getRentalType() +
                "; floorNumber= " + getNumberTenants() + "; otherAmenities= " + getOtherAmenities() +
                "; price= " + getPrice();
    }

    @Override
    public int compareTo(House o) {
        return getNameService().compareTo(o.getNameService());
    }
}
