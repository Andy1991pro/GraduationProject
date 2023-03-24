package by.shevchenko.graduationproject.controller;

import by.shevchenko.graduationproject.entity.ProductEntity;
import by.shevchenko.graduationproject.service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;
    @PostMapping("{id}")
    public ProductEntity addProduct(@RequestBody ProductEntity product){
        return productService.addProduct(product);
    }
    @GetMapping("findById{id}")
    public ProductEntity findById (@Parameter Long id){
        return productService.findById(id);
    }
    @GetMapping("findAll")
    public List<ProductEntity> findAll(){
        return productService.findAll();
    }
    @GetMapping("{productId}{quantity}")
    public ProductEntity updateProduct (@Parameter Long productId,@Parameter int quantity){
        return productService.updateProduct(productId,quantity);
    }



}
