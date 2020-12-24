package models.services.rental_services;

import models.services.Service;

public class RentalService extends Service {
    private int areaUsing;
    private RentalType rentalType;
    private String otherAmenities;
    private String idService;
    private int numberTenants;

    public RentalService(String nameService, double price, int areaUsing,
                         RentalType rentalType, String otherAmenities,
                         String idService, int numberTenants) {
        super(nameService, price);
        this.areaUsing = areaUsing;
        this.rentalType = rentalType;
        this.otherAmenities = otherAmenities;
        this.idService = idService;
        this.numberTenants = numberTenants;
    }

    public RentalService() {

    }

    public int getAreaUsing() {
        return areaUsing;
    }

    public void setAreaUsing(int areaUsing) {
        this.areaUsing = areaUsing;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

    public String getOtherAmenities() {
        return otherAmenities;
    }

    public void setOtherAmenities(String otherAmenities) {
        this.otherAmenities = otherAmenities;
    }


    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }


    public int getNumberTenants() {
        return numberTenants;
    }

    public void setNumberTenants(int numberTenants) {
        this.numberTenants = numberTenants;
    }
}
