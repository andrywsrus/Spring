package shupeyko;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shupeyko.config.Config;
import shupeyko.entity.Customer;
import shupeyko.entity.Order;
import shupeyko.entity.Product;
import shupeyko.services.CustomerService;
import shupeyko.services.OrderService;
import shupeyko.services.ProductService;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {

            CustomerService customerService = context.getBean(CustomerService.class);
            ProductService productService = context.getBean(ProductService.class);
            OrderService orderService=context.getBean(OrderService.class);
            System.out.println("Find all customers");
            List<Customer> customers = customerService.findAll();
            System.out.println(customers);

            System.out.println("Find all products");
            List<Product> products = productService.findAll();
            System.out.println(products);

            System.out.println("Find products for Customer#3");
            List<Product> products1 = productService.findProductsByCustomerId(3L);
            System.out.println(products1);

            System.out.println("Find price for Customer#2 and Product#3");
            List<Order> orders= orderService.getPriceByCustomerAndProduct(2L, 3L);
            System.out.println(orders);
        }

    }
}
