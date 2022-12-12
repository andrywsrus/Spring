package shupeyko.eshop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cartService = context.getBean(CartService.class);
        System.out.println(" Who is now (первая корзина) ? " + cartService.getCurrentCart());
        cartService.addToCartByProductId(1L);
        cartService.addToCartByProductId(2L);
        cartService.addToCartByProductId(3L);
        System.out.println(" Who is now (первая корзина) ? " + cartService.getCurrentCart());

        cartService.removeFromCart(1L);
        System.out.println(" Who is now (первая корзина) ? " + cartService.getCurrentCart());

        CartService cartService1 = context.getBean(CartService.class);
        System.out.println(" Who is now (вторая корзина) ? " + cartService1.getCurrentCart());
        cartService1.addToCartByProductId(5L);
        cartService1.addToCartByProductId(2L);
        System.out.println(" Who is now (вторая корзина) ? " + cartService1.getCurrentCart());

        cartService.removeFromCart(3L);
        System.out.println(" Who is now (вторая корзина) ? " + cartService.getCurrentCart());

        context.close();



    }
}
