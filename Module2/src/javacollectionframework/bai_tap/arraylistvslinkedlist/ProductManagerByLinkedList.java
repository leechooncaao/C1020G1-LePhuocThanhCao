package javacollectionframework.bai_tap.arraylistvslinkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManagerByLinkedList {
    private LinkedList<Product> list;

    public ProductManagerByLinkedList() {
        list = new LinkedList<>();
    }

    public void add(Product product) {
        var existedProduct = getProductById(product.getId());
        if (existedProduct != null)
            System.out.println("The ID has existed !");
        else list.add(product);
    }

    public void edit(int id, Scanner scanner) {
        var edited = getProductById(id);
        if (edited == null)
            System.out.println("Not found !");
        else {
            System.out.println("Enter name of product : ");
            var nameProduct = scanner.nextLine();
            System.out.println("Enter price : ");
            var priceProduct = scanner.nextDouble();

            edited.setName(nameProduct);
            edited.setPrice(priceProduct);

        }
    }

    public void delete(int id) {
        var deleted = getProductById(id);
        if (deleted == null) {
            System.out.println("Not found !");
        } else {
            list.remove(deleted);
        }
    }

    public void display() {
        list.forEach(System.out::println);
    }

    public Product searchByName(String nameProduct) {
        return list.stream()
                .filter(product -> product.getName().equals(nameProduct))
                .findAny()
                .orElse(null);
    }

    public void sortByAscending() {
        Collections.sort(list);
    }

    public void sortByDescending() {
        Collections.reverse(list);
    }

    private Product getProductById(int id) {
        return list.stream()
                .filter(product -> product.getId() == id)
                .findAny()
                .orElse(null);
    }
}
