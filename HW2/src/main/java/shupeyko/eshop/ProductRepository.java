package shupeyko.eshop;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>();
        products.add(new Product(10L, "Tomato"));
        products.add(new Product(1L, "Milk"));
        products.add(new Product(5L, "Cucumber"));
        products.add(new Product(7L, "Aplle"));
        products.add(new Product(8L, "Orange"));
        products.add(new Product(1L, "Cola"));
        products.add(new Product(2L, "Steak"));
    }


    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }


    public Optional <Product> findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();

    }


}
