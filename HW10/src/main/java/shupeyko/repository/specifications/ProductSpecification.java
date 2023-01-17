package shupeyko.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import shupeyko.data.Product;

@Repository
public class ProductSpecification {
    public Specification<Product> priceGreaterOrEqualsThan(Integer minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public Specification<Product> priceLessOrEqualsThan(Integer maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public Specification<Product> titleLike(String titlePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%S%%", titlePart));
    }
}