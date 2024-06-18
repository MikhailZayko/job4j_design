package ru.job4j.violation.ocp;

/**
 * Если нужно добавить новый тип продукта, то придется изменить метод printProduct, добавив новый else if блок.
 * Это нарушает принцип OCP, так как требует изменения существующего кода для добавления новой функциональности.
 */

public class Product {

    private final String name;

    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    private static class ProductPrinter {
        public void printProduct(Product product, String productType) {
            if (productType.equals("Electronic")) {
                System.out.println("Electronic Product: " + product.getName() + " - " + product.getPrice());
            } else if (productType.equals("Grocery")) {
                System.out.println("Grocery Product: " + product.getName() + " - " + product.getPrice());
            } else {
                System.out.println("Unknown Product: " + product.getName() + " - " + product.getPrice());
            }
        }
    }
}



