package shupeyko.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shupeyko.dao.OrderDao;
import shupeyko.entity.Order;
import shupeyko.util.SessionUtil;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    SessionUtil sessionUtil;
    @Override
    public List<Order> getPriceByCustomerAndProduct(Long customerId, Long productId) {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            List<Order> orders = session.createQuery("select o from Order o " +
                            "where o.customer.id=:customerId and o.product.id=:productId", Order.class)
                    .setParameter("customerId", customerId)
                    .setParameter("productId", productId)
                    .getResultList();
            session.getTransaction().commit();
            return orders;
        }
    }
}
