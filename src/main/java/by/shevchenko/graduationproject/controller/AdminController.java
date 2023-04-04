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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
@SecurityRequirement(name = "JWT")
@Tag(name = "Admin controller", description = "Admin controller designed to work with products")


public class AdminController {
    private final ProductService productService;

    @Operation(summary = "add product to date"
            , description = "this method return ProductEntity"
            , responses = @ApiResponse(responseCode = "200"
            , description = "ProductEntity"
            , content = {@Content(mediaType = "application/json"
            , schema = @Schema(implementation = ProductEntity.class)
            , examples = @ExampleObject(value = "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Iphone 13ProMax\",\n" +
            "  \"inStock\": true,\n" +
            "  \"quantity\": 2,\n" +
            "  \"price\": 1000\n" +
            "}"))}))

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("{id}")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productService.add(product);
    }

    @Operation(summary = "update product"
            , description = "this method return ProductEntity"
            , responses = {@ApiResponse(responseCode = "200"
            , description = "ProductEntity"
            , content = {@Content(mediaType = "application/json"
            , schema = @Schema(implementation = ProductEntity.class)
            , examples = @ExampleObject(value = "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Iphone 12\",\n" +
            "  \"inStock\": true,\n" +
            "  \"quantity\": 2,\n" +
            "  \"price\": 1000\n" +
            "}"))})
            , @ApiResponse(responseCode = "404"
            , description = "Product not find"
            , content = @Content)})
    @GetMapping("update/{productId}/{quantity}")
    public ProductEntity update(@PathVariable Long productId, @PathVariable int quantity) {
        return productService.update(productId, quantity);
    }

    @Operation(summary = "Removes a product from date"
            , description = "method returns nothing"
            , responses = {@ApiResponse(responseCode = "200")
            , @ApiResponse(responseCode = "404"
            , description = "Product not find"
            , content = @Content)})
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
