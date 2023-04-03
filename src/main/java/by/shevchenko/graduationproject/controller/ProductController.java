package by.shevchenko.graduationproject.controller;

import by.shevchenko.graduationproject.entity.ProductEntity;
import by.shevchenko.graduationproject.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("product")
@SecurityRequirement(name = "JWT")
@Tag(name = "Product controller", description = "Product controller designed to work with products")
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "add product to date"
            , description = "this method return ProductEntity"
            , responses = @ApiResponse(responseCode = "200"
            , description = "ProductEntity"
            , content = {@Content(mediaType = "application/json"
            , schema = @Schema(implementation = ProductEntity.class)
            , examples = @ExampleObject(value = "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Andy\",\n" +
            "  \"inStock\": false,\n" +
            "  \"quantity\": 2,\n" +
            "  \"price\": 1000\n" +
            "}"))}))
    @PostMapping("{id}")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productService.add(product);
    }

    @Operation(summary = "find by id product"
            , description = "this method return ProductEntity"
            , responses = @ApiResponse(responseCode = "200"
            , description = "ProductEntity"
            , content = {@Content(mediaType = "application/json"
            , schema = @Schema(implementation = ProductEntity.class)
            , examples = @ExampleObject(value = "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Andy\",\n" +
            "  \"inStock\": false,\n" +
            "  \"quantity\": 2,\n" +
            "  \"price\": 1000\n" +
            "}"))}))
    @GetMapping("{id}")
    public ProductEntity findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @Operation(summary = "find all product"
            , description = "this method return List product"
            , responses = @ApiResponse(responseCode = "200"
            , description = "List product"
            , content = {@Content(mediaType = "application/json"
            , schema = @Schema(implementation = ProductEntity.class)
            , examples = @ExampleObject(value = "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Iphone\",\n" +
            "  \"inStock\": false,\n" +
            "  \"quantity\": 0,\n" +
            "  \"price\": 1000\n" +
            "},\n"))}))
    @GetMapping
    public List<ProductEntity> findAll() {
        return productService.findAll();
    }

    @Operation(summary = "update product"
            , description = "this method return ProductEntity"
            , responses = @ApiResponse(responseCode = "200"
            , description = "ProductEntity"
            , content = {@Content(mediaType = "application/json"
            , schema = @Schema(implementation = ProductEntity.class)
            , examples = @ExampleObject(value = "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Andy\",\n" +
            "  \"inStock\": false,\n" +
            "  \"quantity\": 2,\n" +
            "  \"price\": 1000\n" +
            "}"))}))
    @GetMapping("update/{productId}/{quantity}")
    public ProductEntity update(@PathVariable Long productId, @PathVariable int quantity) {
        return productService.update(productId, quantity);
    }

    @Operation(summary = "Removes a product from date"
            , description = "method returns nothing"
            , responses = @ApiResponse(responseCode = "200"
            , content = {@Content(mediaType = "application/json"
            , schema = @Schema(implementation = ProductEntity.class))}))
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
