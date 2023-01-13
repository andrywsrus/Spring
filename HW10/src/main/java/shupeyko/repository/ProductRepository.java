package shupeyko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shupeyko.data.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Modifying
    @Query("update Product p set p.price = p.price + :price where p.id= :id")
    void changepriceById(@Param(value = "id") Long id, @Param(value = "price") Integer price);

    List<Product> findAllBypriceGreaterThan(Integer price);

    List<Product> findAllBypriceLessThan(Integer price);

    List<Product> findAllBypriceBetween(Integer min, Integer max);
}