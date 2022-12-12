package org.shupeyko.repositories;

import org.shupeyko.data.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Component
public class ProductsRepository {
    private List<Product> items;

    public ProductsRepository() {
        this.items = new ArrayList<>(List.of(
                new Product("Tomato", 1.0),
                new Product("Milk", 1.80),
                new Product("Cucumber", 1.0),
                new Product("Apple", 3.40),
                new Product("Orange", 17.25),
                new Product("Cola", 17.25),
                new Product("Steak", 17.25)
                ));
    }

    public List<Product> getItems() {
        //вернуть список всех продуктов
        return Collections.unmodifiableList(items);
    }

    public void add(Product product) {
        items.add(product);
    }

    public Optional <Product> findById(AtomicLong id) {
        // вернуть продукт с указанным id
        return items.stream().filter(p -> p.getId().equals(id)).findFirst();

    }

    public void removeAll(){
        // удаляет все продукты
        items.clear();
    }

    public boolean removeId(AtomicLong id){
        // удаляет продукт с указанным id
       return items.removeIf(p -> p.getId().equals(id));

    }

}
