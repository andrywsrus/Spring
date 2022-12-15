package org.eshop;

import java.util.concurrent.atomic.AtomicLong;
public class Items {
    private static final AtomicLong COUNTER = new AtomicLong(1);
     private Long id;
     private String title;
     private double cost;

    public Items( String title, double cost) {
        id = COUNTER.getAndIncrement();
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
