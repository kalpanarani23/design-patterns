package IteratorPattern.example2;

import java.util.List;

public class ProductIterator implements Iterator {
    private List<Product> products;
    private int current;

    public ProductIterator(List<Product> products) {
        this.products = products;
        this.current = 0;
    }

    @Override
    public Product first() {
        if (products.isEmpty()) {
            return null;
        }
        current = 0;
        return products.get(current);
    }

    @Override
    public Product next() {
        if (hasNext()) {
            return products.get(current++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return current < products.size();
    }
}
