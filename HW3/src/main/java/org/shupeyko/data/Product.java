package org.shupeyko.data;

import java.util.concurrent.atomic.AtomicLong;

public class Product {
    private Long id;
    private String title;

    private Double price;

    private static final AtomicLong COUNTER = new AtomicLong(0);

    public Product(String title, Double price) {
        this.id = COUNTER.incrementAndGet();
        this.title = title;
        this.price = price;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", identity=" + COUNTER +
                '}';
    }
}
