package shupeyko.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import shupeyko.entity.Customer;
import shupeyko.entity.Order;
import shupeyko.entity.Product;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SessionUtil {
    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();
    }


    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @PreDestroy
    public void close() {
        if (sessionFactory != null) {
            System.out.println("Close SessionFactory");
            sessionFactory.close();
        }
    }

}
