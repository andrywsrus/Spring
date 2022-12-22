package shupeyko;

import shupeyko.dao.ProductDao;
import shupeyko.dao.ProductDaoImpl;
import shupeyko.model.Product;

public class MainApp {
    public static void main(String[] args) {
        SessionUtil.init();
        ProductDao productDao=new ProductDaoImpl();
        System.out.println("FindByID: 3");
        System.out.println(productDao.findById(3L));

        System.out.println("FindAll:");
        System.out.println(productDao.findAll());

        System.out.println("FindByTitle: 'Milk','Cucumber'");
        System.out.println(productDao.findByTitle("Milk"));
        System.out.println(productDao.findByTitle("Cucumber"));

        System.out.println("DeleteByID: 1");
        productDao.deleteById(1L);
        System.out.println(productDao.findAll());

        System.out.println("SaveNew:");
        Product productOne=new Product("Carrot", 40);
        Product productTwo=new Product("Apple", 50);
        System.out.println(productOne);
        System.out.println(productTwo);

        productDao.saveOrUpdate(productOne);
        productDao.saveOrUpdate(productTwo);

        System.out.println(productOne);
        System.out.println(productTwo);

        System.out.println(productDao.findAll());

        System.out.println("UpdateProduct");
        Product product=productDao.findByTitle("Carrot");
        System.out.println(product);
        product.setPrice(555);
        productDao.saveOrUpdate(product);
        System.out.println(product);
        System.out.println(productDao.findAll());

        System.out.println("PersistTest");
        Product productPersist=new Product("productPersist", 777);
        System.out.println("New product: " + productPersist);
        productDao.saveOrUpdate(productPersist);
        System.out.println(productDao.findAll());
        System.out.println("SetPrice 777");
        productOne.setPrice(555);
        System.out.println(productPersist);
        System.out.println("ProductsIntoDB: ");
        System.out.println(productDao.findAll());
        SessionUtil.close();
    }
}
