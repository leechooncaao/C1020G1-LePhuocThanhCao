package binaryfile_serialization.bai_tap.quan_li_sp_qua_file_nhi_phan;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private int id;
    private double price;
    private String description;

    public Product(String name, int id, double price, String description) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
