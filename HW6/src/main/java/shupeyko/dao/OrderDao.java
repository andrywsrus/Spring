package shupeyko.dao;

import shupeyko.entity.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> getPriceByCustomerAndProduct(Long customerId, Long productId);

}
