package binaryfile_serialization.bai_tap.quan_li_sp_qua_file_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement implements Serializable {
    private List<Product> list;
    private static final String targetPath = "src/binaryfile_serialization/bai_tap/quan_li_sp_qua_file_nhi_phan/products";
    private static final File targetFile = new File(targetPath);


    public ProductManagement() {
        list = new ArrayList<>();
    }

    public void add(Product product) {
        if (!list.isEmpty())
            list = getDataFromFile();

        if (validateId(product.getId())) {
            list.add(product);
            writeDataToFile();
        } else
            System.out.println("The product already existed");
    }

    private boolean validateId(int id) {
        for (var product : list) {
            if (product.getId() == id) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        var listProducts = getDataFromFile();

        if (listProducts.isEmpty())
            return;

        for (var product : listProducts)
            System.out.println(product);

    }

    public Product searchById(int id) {
        var products = getDataFromFile();
        Product result = null;
        for (var product : products) {
            if (product.getId() == id) {
                result = product;
                break;
            }
        }

        return result;

    }

    private List<Product> getDataFromFile() {
        List<Product> productsFromFile = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(targetFile);
             ObjectInputStream reader = new ObjectInputStream(fis)) {

            while (reader.available() > 0) {
                productsFromFile.add((Product) reader.readObject());
            }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return productsFromFile;
    }

    private void writeDataToFile() {

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(targetFile))) {

            for (var product : list) {
                writer.writeObject(product);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
