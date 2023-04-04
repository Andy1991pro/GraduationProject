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
    public List<ProductEntity> addToBasket(Long productId, Long userId) {
        ProductEntity product = productRepository.findById(productId).orElseThrow();
        BasketEntity basket = basketRepository.findById(userId).orElseThrow();
        double prise = product.getPrice();
        int minusQuantity = product.getQuantity() - 1;
        double addAmountOfPurchases = basket.getAmountOfPurchases() + prise;
        if (product.getQuantity() > 0) {
            product.setQuantity(minusQuantity);
            product.statusInStock();
            basket.getProducts().add(product);
            basket.setAmountOfPurchases(addAmountOfPurchases);
            basket.addDiscount();
            basket.correctSum();
        }
        return basket.getProducts();
    }

    @Transactional
    public List<ProductEntity> deleteFromBasket(Long productId, Long basketId) {
        ProductEntity product = productRepository.findById(productId).orElseThrow();
        BasketEntity basket = basketRepository.findById(basketId).orElseThrow();
        double prise = product.getPrice();
        int plusQuantity = product.getQuantity() + 1;
        double minusAmountOfPurchases = basket.getAmountOfPurchases() - prise;
        List<ProductEntity> list = basket.getProducts();
        if (list.contains(product)) {
            list.remove(product);
            basket.setProducts(list);
            product.setQuantity(plusQuantity);
            product.statusInStock();
            basket.setAmountOfPurchases(minusAmountOfPurchases);
            basket.addDiscount();
            basket.correctSum();
        }
        return basket.getProducts();
    }
}
