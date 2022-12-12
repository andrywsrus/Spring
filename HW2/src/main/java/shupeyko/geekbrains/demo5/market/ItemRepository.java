package shupeyko.geekbrains.demo5.market;

import org.springframework.stereotype.Component;

@Component
public interface ItemRepository {
    Item findById(Long id);
}
