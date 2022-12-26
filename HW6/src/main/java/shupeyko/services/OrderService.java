package shupeyko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shupeyko.dao.OrderDao;
import shupeyko.entity.Order;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getPriceByCustomerAndProduct(Long customerId, Long productId){
        return orderDao.getPriceByCustomerAndProduct(customerId, productId);
    }
}
