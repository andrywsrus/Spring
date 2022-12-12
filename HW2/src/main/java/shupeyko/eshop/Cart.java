package shupeyko.eshop;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    // Создаем бин Cart, в который можно добавлять и удалять товары по id.

    private List<Product> products;

     public Cart() {
        this.products = new ArrayList<>();
    }

    public void add(Product product) {
        products.add(product);
    }

    public void remove(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

        @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }

}
