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


    @Operation(summary = "find by id product"
            , description = "this method return ProductEntity"
            , responses = {@ApiResponse(responseCode = "200"
            , description = "ProductEntity"
            , content = {@Content(mediaType = "application/json"
            , schema = @Schema(implementation = ProductEntity.class)
            , examples = @ExampleObject(value = "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Iphone 13\",\n" +
            "  \"inStock\": true,\n" +
            "  \"quantity\": 2,\n" +
            "  \"price\": 1000\n" +
            "}"))})
            , @ApiResponse(responseCode = "404"
            , description = "Product not find"
            , content = @Content)})
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
            , examples = @ExampleObject(value = "[\n" +
            "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Iphone\",\n" +
            "  \"inStock\": true,\n" +
            "  \"quantity\": 2,\n" +
            "  \"price\": 1000\n" +
            "},\n" +
            "{\n" +
            "  \"id\": 2,\n" +
            "  \"name\": \"Samsung\",\n" +
            "  \"inStock\": true,\n" +
            "  \"quantity\": 1,\n" +
            "  \"price\": 2000\n" +
            "}\n" +
            "]\n"))}))
    @GetMapping
    public List<ProductEntity> findAll() {
        return productService.findAll();
    }


}
