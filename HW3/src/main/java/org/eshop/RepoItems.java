package org.eshop;

import java.util.ArrayList;
import java.util.List;

public class RepoItems {

    private final List<Items> products;

    public RepoItems() {
        this.products = new ArrayList<>(List.of(
                new Items("Tomato", 4.0),
                new Items("Milk", 1.0),
                new Items("Cucumber", 4.0),
                new Items("Apple", 6.0),
                new Items("Orange", 10.0),
                new Items("Cola", 2.0),
                new Items("Steak", 2.0)

        ));

    }

    public void getItems() {

        for (Items s: products) {
            System.out.println(s);
        }
    }
}
