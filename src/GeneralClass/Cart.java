/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GeneralClass;

import java.util.ArrayList;

/**
 *
 * @author pongp
 */
public class Cart {
    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void removeProduct(int index) {
        products.remove(index);
    }

    public void clear() {
        products.clear();
    }

    public int size() {
        return products.size();
    }

    public float getTotalPrice() {
        float totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public int getProductIndexByName(String name, double price) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name) && products.get(i).getPrice() == price) {
                return i;
            }
        }
        return -1;
    }

    public int totalQuantity() {
        int totalQuantity = 0;
        for (Product product : products) {
            totalQuantity += product.getQuantity();
        }
        return totalQuantity;
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    public void print() {
        System.out.println("Cart:");
        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getPrice());
        }
        System.out.println("Total price: " + getTotalPrice());
    }

}
