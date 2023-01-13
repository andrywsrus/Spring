package shupeyko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import shupeyko.converters.ProductConverter;
import shupeyko.data.Product;
import shupeyko.dto.ProductDto;
import shupeyko.services.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;

    @GetMapping()
    public Page<ProductDto> showProducts(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minprice,
            @RequestParam(name = "max_price", required = false) Integer maxprice,
            @RequestParam(name = "part_title", required = false) String partTitle
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(minprice, maxprice, partTitle, page).map(productConverter::entityToDto);
    }

    @DeleteMapping()
    public void deleteProductById(@RequestParam Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productConverter.entityToDto(productService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping("/change_price")
    public void changepriceById(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changepriceById(productId, delta);
    }

    @PostMapping()
    public ProductDto addProduct(@RequestBody Product product) {
        product.setId(null);
        return productConverter.entityToDto(productService.saveProduct(product));
    }

    @PutMapping()
    public ProductDto updateProduct(@RequestBody Product product) {
        return productConverter.entityToDto(productService.saveProduct(product));
    }
}