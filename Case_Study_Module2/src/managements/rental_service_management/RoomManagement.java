package managements.rental_service_management;

import models.services.rental_services.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RoomManagement implements RentalServiceManagement {
    private final String targetPath = "src/data/Room.csv";
    private final File roomFile = new File(targetPath);
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "NameService,price,area-using,rentalType,otherAmenities,idService,numberTenants,roomType";
    private List<Room> list;

    public RoomManagement() {
        list = new ArrayList<>();
    }

    @Override
    public void addService(RentalService service) {
        list = getDataFromFile();

        list.add((Room) service);
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

        Set<Room> setRoom = new TreeSet<>(list);
        var i = 1;
        for (var room : setRoom) {
            System.out.println(i + ". " + room);
            i++;
        }
    }

    @Override
    public RentalService getServiceByOrder(int index) {
        return list.get(index);
    }

    private List<Room> getDataFromFile() {
        List<Room> newList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(roomFile))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                var splitData = line.split(CSV_SEPARATOR);
                var room = convertDataToObject(splitData);
                newList.add(room);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return newList;
    }

    private void writeDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(roomFile))) {
            writer.append(FILE_HEADER);
            writer.newLine();

            for (var room : list) {
                StringBuilder builder = new StringBuilder();
                builder.append(room.getNameService());
                builder.append(CSV_SEPARATOR);
                builder.append(room.getPrice());
                builder.append(CSV_SEPARATOR);
                builder.append(room.getAreaUsing());
                builder.append(CSV_SEPARATOR);
                builder.append(room.getRentalType());
                builder.append(CSV_SEPARATOR);
                builder.append(room.getOtherAmenities());
                builder.append(CSV_SEPARATOR);
                builder.append(room.getIdService());
                builder.append(CSV_SEPARATOR);
                builder.append(room.getNumberTenants());
                builder.append(CSV_SEPARATOR);
                builder.append(room.getRoomType());

                writer.write(builder.toString());
                writer.newLine();
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Room convertDataToObject(String[] splitData) {
        var room = new Room();
        room.setNameService(splitData[0]);
        room.setPrice(Double.parseDouble(splitData[1]));
        room.setAreaUsing(Integer.parseInt(splitData[2]));

        // setting rental type
        var rentalType = RentalType.BY_HOUR;
        switch (splitData[3]) {
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

        room.setRentalType(rentalType);

        room.setOtherAmenities(splitData[4]);
        room.setIdService(splitData[5]);
        room.setNumberTenants(Integer.parseInt(splitData[6]));

        // setting room type
        var roomType = RoomType.STANDARD;
        switch (splitData[7]) {
            case "VIP":
                roomType = RoomType.VIP;
                break;
            case "LUXURIOUS":
                roomType = RoomType.LUXURIOUS;
                break;
            case "STANDARD":
                roomType = RoomType.STANDARD;
                break;
            case "PRESIDENT":
                roomType = RoomType.PRESIDENT;
                break;
            case "SINGLE":
                roomType = RoomType.SINGLE;
                break;
            case "DOUBLE":
                roomType = RoomType.DOUBLE;
                break;
        }
        room.setRoomType(roomType);

        return room;
    }

    public static void main(String[] args) {
        var manager = new RoomManagement();

        var room1 = new Room("room_1", 1000, 30, RentalType.BY_HOUR, "nothing", "001", 3, RoomType.LUXURIOUS);
        var room2 = new Room("room_2", 1000, 30, RentalType.BY_DAY, "nothing", "001", 3, RoomType.LUXURIOUS);
        var room3 = new Room("room_3", 1000, 30, RentalType.BY_YEAR, "nothing", "001", 3, RoomType.LUXURIOUS);
        var room4 = new Room("room_4", 1000, 30, RentalType.BY_YEAR, "nothing", "001", 3, RoomType.LUXURIOUS);
        var room5 = new Room("room_5", 1000, 30, RentalType.BY_YEAR, "nothing", "001", 3, RoomType.LUXURIOUS);

        manager.addService(room1);
        manager.addService(room2);
        manager.addService(room3);
        manager.addService(room4);
        manager.addService(room5);

        manager.showInfoService();
    }
}
