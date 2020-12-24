package models.services.rental_services;

public class Villa extends RentalService implements Comparable<Villa>{
//    private static final long serialVersionUID = -132662428104288265L;
    private int poolArea;
    private int floorNumber;



    public Villa(String nameService, double price, int areaUsing, int floorNumber,
                 RentalType rentalType, String otherAmenities, int poolArea,
                 int numberTenants, String idService) {
        super(nameService, price, areaUsing, rentalType, otherAmenities, idService, numberTenants);
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
    }

    public Villa() {
        super();
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "nameService= " + getNameService()+ "; id=" + getIdService() + "; areaUsing= " + getAreaUsing() +
                "; numberTenants= " + getFloorNumber() + "; rentalType= " + getRentalType() +
                "; poolArea= " + getPoolArea() + "; floorNumber= " + getFloorNumber() +
                "; otherAmenities= " + getOtherAmenities() + "; price= " + getPrice();
    }

    @Override
    public int compareTo(Villa o) {
        return getNameService().compareTo(o.getNameService());
    }
}
