package shupeyko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shupeyko.models.Product;
import shupeyko.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;


    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product) {
       productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByPriceGreaterThan(Integer price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> findByPriceLessThan(Integer price) {
        return productRepository.findByPriceLessThan(price);
    }

    public List<Product> findByPriceBetween(Integer minPrice, Integer maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
