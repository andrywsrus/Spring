package shupeyko.geekbrains.market2;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
    void addProduct(Product product);
}
