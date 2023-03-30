package by.shevchenko.graduationproject.controller;

import by.shevchenko.graduationproject.entity.ProductEntity;
import by.shevchenko.graduationproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("{id}")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productService.add(product);
    }

    @GetMapping("findById/{id}")
    public ProductEntity findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("findAll")
    public List<ProductEntity> findAll() {
        return productService.findAll();
    }

    @GetMapping("update/{productId}/{quantity}")
    public ProductEntity update(@PathVariable Long productId, @PathVariable int quantity) {
        return productService.update(productId, quantity);
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
