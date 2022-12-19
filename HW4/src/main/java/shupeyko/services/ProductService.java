package shupeyko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shupeyko.model.Product;
import shupeyko.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changePrice(Long id, int delta) {
        Product product=productRepository.getById(id);
        product.setPrice(product.getPrice()+delta);
    }

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }
}
