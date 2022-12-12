package org.shupeyko.services;

import org.shupeyko.data.Product;
import org.shupeyko.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/*

  РестКонтроллер должен позволять выполнять почти все CRUD операции над продуктами
	 GET /api/v1/products - вернуть список всех продуктов
	 GET /api/v1/products/{id} - вернуть продукт с указанным id
	 POST /api/v1/products - создать новый продукт (* пусть ид у продукта подставляется автоматом на бэке, макс текущий ид + 1)
	 DELETE /api/v1/products - удаляет все продукты
	 DELETE /api/v1/products/{id} - удаляет продукт с указанным id
 */

@Service
public class ProductsService implements IProductsService {

    private ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Product> getItems() {
        return productsRepository.getItems();
    }

    @Override
    public void add(Product product) {
        productsRepository.add(product);
    }

    @Override
    public Optional<Product> findById(AtomicLong id) {
        return productsRepository.findById(id);
    }

    @Override
    public void removeAll() {
        productsRepository.removeAll();
    }

    @Override
    public boolean removeId(AtomicLong id) {
        return productsRepository.removeId(id);

    }
}
