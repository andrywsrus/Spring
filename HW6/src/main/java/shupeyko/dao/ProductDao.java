package shupeyko.dao;

import shupeyko.entity.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> findProductsByCustomerId(Long id);

    public List<Product> findAll();

}
