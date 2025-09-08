package IteratorPattern.example3;

import IteratorPattern.example2.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductInventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Iterator createIterator() {
        return new ProductIterator(products);
    }
}
