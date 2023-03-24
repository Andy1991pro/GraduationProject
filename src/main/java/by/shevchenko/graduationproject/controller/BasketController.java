package by.shevchenko.graduationproject.controller;

import by.shevchenko.graduationproject.entity.ProductEntity;
import by.shevchenko.graduationproject.service.BasketService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("basket")
public class BasketController {
    private final BasketService basketService;
    @PostMapping("{id}/{userId}")
    public List<ProductEntity> addToBasket (@Parameter Long id,@Parameter Long userId){
       return basketService.addToBasket(id,userId);
    }
}
