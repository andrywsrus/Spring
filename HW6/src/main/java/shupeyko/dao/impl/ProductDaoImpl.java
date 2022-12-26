package shupeyko.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shupeyko.dao.ProductDao;
import shupeyko.entity.Product;
import shupeyko.util.SessionUtil;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionUtil sessionUtil;

    @Override
    public List<Product> findProductsByCustomerId(Long id) {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            List<Product> products = session
                    .createQuery("select p from Product p " +
                                    "inner join p.orders o " +
                                    "inner join o.customer c " +
                                    "where c.id=:id",
                            Product.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            List<Product> products=session.createQuery("select p from Product p", Product.class).getResultList();
            session.getTransaction().commit();
            return products;
        }
    }
}
