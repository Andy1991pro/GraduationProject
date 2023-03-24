package by.shevchenko.graduationproject.service;


import by.shevchenko.graduationproject.entity.BasketEntity;
import by.shevchenko.graduationproject.entity.ProductEntity;
import by.shevchenko.graduationproject.repository.BasketRepository;
import by.shevchenko.graduationproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasketService {
    private final BasketRepository basketRepository;
    public final ProductRepository productRepository;

    @Transactional
    public List<ProductEntity> addToBasket (Long id,Long userId){
    ProductEntity product = productRepository.findById(id).orElseThrow();
    BasketEntity basket = basketRepository.findById(userId).orElseThrow();
    double prise=product.getPrise();
    int minusQuantity= product.getQuantity()-1;
    double addAmountOfPurchases = basket.getAmountOfPurchases()+prise;
    if(product.getQuantity()>0){
        product.setQuantity(minusQuantity);
        product.statusInStock();
        basket.getProducts().add(product);
        basket.setAmountOfPurchases(addAmountOfPurchases);
        basket.addDiscount();
        basket.correctSum();
    }
    return basket.getProducts();
    }
}
