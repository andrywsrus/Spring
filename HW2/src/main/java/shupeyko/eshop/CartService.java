package shupeyko.eshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class CartService {
    private ProductService productService;
    private Cart cart;

    @PostConstruct
    public void CartServiceInit(){
        this.cart = new Cart();
    }
    @Autowired
    public CartService(ProductService productService) {
        this.productService = productService;
    }

    public Cart getCurrentCart(){
        return cart;
    }

    public void addToCartByProductId(Long productId){
    Product product = productService.findById(productId).get();
    cart.add(product);
    }

    public void removeFromCart(Long id){
        cart.remove(id);

    }

}
