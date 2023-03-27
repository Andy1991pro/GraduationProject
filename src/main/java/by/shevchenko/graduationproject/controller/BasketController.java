package by.shevchenko.graduationproject.controller;

import by.shevchenko.graduationproject.entity.ProductEntity;
import by.shevchenko.graduationproject.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("basket")
public class BasketController {
    private final BasketService basketService;

    @PostMapping("{id}/{userId}")
    public List<ProductEntity> addToBasket(@PathVariable Long id, @PathVariable Long userId) {
        return basketService.addToBasket(id, userId);
    }

    @GetMapping("deleteProduct/{id}/{basketId}")
    public List<ProductEntity> deleteFromBasket(@PathVariable Long id, @PathVariable Long basketId) {
        return basketService.deleteFromBasket(id, basketId);
    }
}
