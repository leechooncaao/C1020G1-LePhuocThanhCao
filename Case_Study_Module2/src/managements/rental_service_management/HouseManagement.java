package managements.rental_service_management;

import models.services.rental_services.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HouseManagement implements RentalServiceManagement {
    private final String targetPath = "src/data/House.csv";
    private final File houseFile = new File(targetPath);
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "NameService,price,area-using,numberTenants,rentalType,otherAmenities,floorNumber,idService";
    private List<House> list;

    public HouseManagement() {
        list = new ArrayList<>();
    }

    @Override
    public void addService(RentalService service) {
        list = getDataFromFile();

        list.add((House) service);
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

        Set<House> setHouse = new TreeSet<>(list);
        int i = 1;
        for (var house : setHouse){
            System.out.println(i + ". " + house);
            i++;
        }
    }

    @Override
    public RentalService getServiceByOrder(int index) {
        return (House) list.get(index);
    }

    private List<House> getDataFromFile() {
        List<House> newList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(houseFile))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                var splitData = line.split(CSV_SEPARATOR);
                var house = convertDataToObject(splitData);
                newList.add(house);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return newList;
    }

    private void writeDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(houseFile))) {
            writer.append(FILE_HEADER);
            writer.newLine();

            //String nameService, double price, int areaUsing, int numberTenants,
            //                 RentalType rentalType, String otherAmenities, int floorNumber,String idService)
            for (var house : list) {
                StringBuilder builder = new StringBuilder();
                builder.append(house.getNameService());
                builder.append(CSV_SEPARATOR);
                builder.append(house.getPrice());
                builder.append(CSV_SEPARATOR);
                builder.append(house.getAreaUsing());
                builder.append(CSV_SEPARATOR);
                builder.append(house.getNumberTenants());
                builder.append(CSV_SEPARATOR);
                builder.append(house.getRentalType());
                builder.append(CSV_SEPARATOR);
                builder.append(house.getOtherAmenities());
                builder.append(CSV_SEPARATOR);
                builder.append(house.getFloorNumber());
                builder.append(CSV_SEPARATOR);
                builder.append(house.getIdService());

                writer.write(builder.toString());
                writer.newLine();
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private House convertDataToObject(String[] splitData) {
        var house = new House();
        house.setNameService(splitData[0]);
        house.setPrice(Double.parseDouble(splitData[1]));
        house.setAreaUsing(Integer.parseInt(splitData[2]));
        house.setNumberTenants(Integer.parseInt(splitData[3]));

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

        house.setRentalType(rentalType);

        house.setOtherAmenities(splitData[5]);
        house.setFloorNumber(Integer.parseInt(splitData[6]));
        house.setIdService(splitData[7]);

        return house;
    }

    private static void main(String[] args) {
        var house_1 = new House("house_1", 1000, 30, 2, RentalType.BY_YEAR, "nothing", 2, "001");
        var house_2 = new House("house_2", 1000, 30, 2, RentalType.BY_YEAR, "nothing", 2, "001");
        var house_3 = new House("house_3", 1000, 30, 2, RentalType.BY_YEAR, "nothing", 2, "001");
        var house_4 = new House("house_4", 1000, 30, 2, RentalType.BY_YEAR, "nothing", 2, "001");

        var manager = new HouseManagement();

        manager.addService(house_1);
        manager.addService(house_2);
        manager.addService(house_3);
        manager.addService(house_4);

        manager.showInfoService();
    }
}
