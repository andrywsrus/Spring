package shupeyko.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shupeyko.dao.CustomerDao;
import shupeyko.entity.Customer;
import shupeyko.util.SessionUtil;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private SessionUtil sessionUtil;

    @Override
    public Customer findById(Long id) {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public Customer findByName(String name) {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            Customer customer = session.createQuery("Select c from Customer c where c.name=:name", Customer.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> findCustomersByProductId(Long id) {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("select c from Customer c " +
                                    "join c.orders o " +
                                    "join o.product p " +
                                    "where p.id=:id"
                            , Customer.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public List<Customer> findAll() {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            List<Customer> customers=session.createQuery("Select c from Customer c", Customer.class).getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }
}
