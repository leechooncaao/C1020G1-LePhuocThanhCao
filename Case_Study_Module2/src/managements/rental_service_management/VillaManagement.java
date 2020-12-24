package managements.rental_service_management;

import models.services.rental_services.RentalService;
import models.services.rental_services.RentalType;
import models.services.rental_services.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class VillaManagement implements RentalServiceManagement {
    private final String targetPath = "src/data/Villa.csv";
    private final File villaFile = new File(targetPath);
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "NameService,price,area-using,floorNumber,rentalType,otherAmenities,poolArea,numberTenants,idService";
    private List<Villa> list;

    public VillaManagement() {
        list = new ArrayList<>();
    }

    @Override
    public void addService(RentalService service) {
        list = getDataFromFile();

        list.add((Villa) service);
        writeDataToFile();

    }

    @Override
    public void showInfoService() {
        list = getDataFromFile();

        if (list.isEmpty())
            return;

        for (int i = 0; i < list.size(); i++)
            System.out.println((i + 1) + ". " + list.get(i));
    }

    @Override
    public void showInfoServiceNotDuplicate() {
        list = getDataFromFile();

        if (list.isEmpty())
            return;

        Set<Villa> setVilla = new TreeSet<>(list);
        var i = 1;
        for (var villa : setVilla) {
            System.out.println(i + ". " + villa);
            i++;
        }
    }

    @Override
    public RentalService getServiceByOrder(int index) {
        return list.get(index);
    }

    private List<Villa> getDataFromFile() {
        List<Villa> newList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(villaFile))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                var splitData = line.split(CSV_SEPARATOR);
                var villa = convertDataToObject(splitData);
                newList.add(villa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newList;
    }

    private Villa convertDataToObject(String[] splitData) {
        var villa = new Villa();
        villa.setNameService(splitData[0]);
        villa.setPrice(Double.parseDouble(splitData[1]));
        villa.setAreaUsing(Integer.parseInt(splitData[2]));
        villa.setFloorNumber(Integer.parseInt(splitData[3]));

        // setting rental type
        var rentalType = RentalType.BY_HOUR;
        switch (splitData[4]) {
            case "BY_HOUR":
                rentalType = RentalType.BY_HOUR;
                break;
            case "BY_DAY":
                rentalType = RentalType.BY_DAY;
                break;
            case "BY_MONTH":
                rentalType = RentalType.BY_MONTH;
                break;
            case "BY_YEAR":
                rentalType = RentalType.BY_YEAR;
                break;
        }
        villa.setRentalType(rentalType);

        villa.setOtherAmenities(splitData[5]);
        villa.setPoolArea(Integer.parseInt(splitData[6]));
        villa.setNumberTenants(Integer.parseInt(splitData[7]));
        villa.setIdService(splitData[8]);

        return villa;
    }

    private void writeDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(villaFile))) {
            writer.append(FILE_HEADER);
            writer.newLine();

            for (var villa : list) {
                StringBuilder builder = new StringBuilder();
                builder.append(villa.getNameService());
                builder.append(CSV_SEPARATOR);
                builder.append(villa.getPrice());
                builder.append(CSV_SEPARATOR);
                builder.append(villa.getAreaUsing());
                builder.append(CSV_SEPARATOR);
                builder.append(villa.getFloorNumber());
                builder.append(CSV_SEPARATOR);
                builder.append(villa.getRentalType());
                builder.append(CSV_SEPARATOR);
                builder.append(villa.getOtherAmenities());
                builder.append(CSV_SEPARATOR);
                builder.append(villa.getPoolArea());
                builder.append(CSV_SEPARATOR);
                builder.append(villa.getNumberTenants());
                builder.append(CSV_SEPARATOR);
                builder.append(villa.getIdService());

                writer.write(builder.toString());
                writer.newLine();
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Villa villa1 = new Villa("villa_1", 1000, 30, 3, RentalType.BY_DAY, "nothing", 20, 2, "001");
        Villa villa2 = new Villa("villa_1", 1000, 30, 3, RentalType.BY_DAY, "nothing", 20, 2, "001");
        Villa villa3 = new Villa("villa_1", 1000, 30, 3, RentalType.BY_DAY, "nothing", 20, 2, "001");
        Villa villa4 = new Villa("villa_15", 1000, 30, 3, RentalType.BY_DAY, "nothing", 20, 2, "001");

        var manager = new VillaManagement();

//        manager.addService(villa1);
//        manager.addService(villa2);
//        manager.addService(villa3);
//        manager.addService(villa4);

        manager.showInfoServiceNotDuplicate();

    }
}
