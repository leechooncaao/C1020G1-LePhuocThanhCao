package managements.booking_management;

import models.contracts.Contract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingRentalServiceManagement {
    private final String targetPath = "src/data/Booking.csv";
    private final File bookingFile = new File(targetPath);
    private static final String CSV_SEPARATOR = ",";
    private final List<Contract> contracts = new ArrayList<>();

    public void addNewBooking(Contract contract) {
        contracts.add(contract);
        writeDataToFile();
    }

    public void showListBooking() {
        try (BufferedReader reader = new BufferedReader(new FileReader(bookingFile))) {
            String line;
            reader.readLine();
            var i = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(i + ". " + line);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookingFile, true))) {
            writer.newLine();

            for (var contract : contracts) {

                String contractInfo = contract.getCustomer().getFullName() +
                        CSV_SEPARATOR +
                        contract.getCustomer().getId() +
                        CSV_SEPARATOR +
                        contract.getRentalService().getNameService() +
                        CSV_SEPARATOR +
                        contract.getAccompaniedServices() +
                        CSV_SEPARATOR +
                        contract.getStartDay() +
                        CSV_SEPARATOR +
                        contract.getEndDay() +
                        CSV_SEPARATOR +
                        contract.getTotalPayment();

                writer.write(contractInfo);
            }

            writer.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
