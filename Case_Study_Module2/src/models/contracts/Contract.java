package models.contracts;

import models.person.Customer;
import models.services.accompanied_services.AccompaniedService;
import models.services.rental_services.RentalService;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Contract implements Serializable {
    private Customer customer;
    private RentalService rentalService;
    private List<AccompaniedService> accompaniedServices;
    private String startDay;
    private String endDay;
    private double totalPayment;

    public Contract(Customer customer, RentalService rentalService,
                    List<AccompaniedService> accompaniedServices, String startDay, String endDay) {
        this.customer = customer;
        this.rentalService = rentalService;
        this.accompaniedServices = accompaniedServices;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public RentalService getRentalService() {
        return rentalService;
    }

    public void setRentalService(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    public String getAccompaniedServices() {
        return displayAccompaniedServices();
    }

    public String getStartDay() {
        return startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public double getTotalPayment() {
        return countTotalPayment();
    }

    private String displayAccompaniedServices() {
        var builder = new StringBuilder();
        for (var service : accompaniedServices) {
            builder.append(service.getNameService());
            builder.append("-");
        }

        var result = builder.toString();

        return result.substring(0,result.length() - 1);
    }

    private double countTotalPayment() {
        var numberDays = getNumberDays();

        double priceAccompanied = 0;
        for (var accompaniedService : accompaniedServices) {
            priceAccompanied += accompaniedService.getPrice();
        }

        return numberDays * rentalService.getPrice() + priceAccompanied;
    }

    private long getNumberDays() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate start = LocalDate.parse(startDay, dateTimeFormatter);
        LocalDate end = LocalDate.parse(endDay, dateTimeFormatter);

        return ChronoUnit.DAYS.between(start, end);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "nameCustomer= " + customer.getFullName() +
                "; idCustomer= " + customer.getId() +
                "; rentalService= " + rentalService.getNameService() +
                "; accompaniedServices= " + displayAccompaniedServices() +
                "; started from " + getStartDay() +
                " to " + getEndDay() +
                "; totalPayment= " + getTotalPayment() +
                "}";
    }
}
