package shupeyko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shupeyko.dao.CustomerDao;
import shupeyko.entity.Customer;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public Customer findById(Long id){
        return customerDao.findById(id);
    }

    public Customer findByName(String name){
        return customerDao.findByName(name);
    }

    public List<Customer> findCustomersByProductId(Long id){
        return customerDao.findCustomersByProductId(id);
    }

    public List<Customer> findAll(){
        return customerDao.findAll();
    }
}
