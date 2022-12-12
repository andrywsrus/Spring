package shupeyko.eshop;

import java.util.concurrent.atomic.AtomicLong;

public class Product {
    private long ID;
     private String title;
     private int pict;

    private static final AtomicLong COUNTER = new AtomicLong(0);

    public Product(String title, int pict) {
        this.ID = COUNTER.incrementAndGet();
        this.title = title;
        this.pict = pict;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", cost=" + pict +
                '}';
    }
}
