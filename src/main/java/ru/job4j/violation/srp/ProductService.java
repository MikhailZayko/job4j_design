package ru.job4j.violation.srp;

/**
 * Этот класс выполняет две задачи: управление данными (CRUD-операции) и бизнес-логику (вычисление скидки).
 * Эти задачи лучше разделить на два класса: один для управления данными, другой для выполнения бизнес-логики.
 */

public class ProductService {

    public void saveProduct(Product product) {

    }

    public Product getProductById(int id) {
        return new Product();
    }

    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.1;
    }

    private static class Product {

        private int id;

        private double price;

        public int getId() {
            return id;
        }

        public double getPrice() {
            return price;
        }
    }
}



