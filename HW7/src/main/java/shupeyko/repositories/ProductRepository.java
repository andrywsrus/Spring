package shupeyko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import shupeyko.models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(Integer price);
    List<Product> findByPriceLessThan(Integer price);

    List<Product> findByPriceBetween(Integer minPrice, Integer maxPrice);
}
