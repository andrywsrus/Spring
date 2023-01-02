package shupeyko.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import shupeyko.data.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;

    private String title;

    private Integer cost;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}
