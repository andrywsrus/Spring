package shupeyko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shupeyko.dao.ProductDao;
import shupeyko.entity.Product;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> findProductsByCustomerId(Long id){
        return productDao.findProductsByCustomerId(id);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

}
