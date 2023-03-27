package by.shevchenko.graduationproject.service;

import by.shevchenko.graduationproject.entity.ProductEntity;
import by.shevchenko.graduationproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductEntity add(ProductEntity product) {
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName(product.getName());
        newProduct.setPrise(product.getPrise());
        newProduct.setId(product.getId());
        newProduct.setQuantity(product.getQuantity());
        if (product.getQuantity() > 0) {
            newProduct.setInStock(true);
        } else {
            newProduct.setInStock(false);
        }
        return productRepository.save(newProduct);
    }

    @Transactional
    public ProductEntity update(Long productId, int quantity) {
        ProductEntity product = findById(productId);
        product.setQuantity(product.getQuantity() + quantity);
        if (product.getQuantity() > 0) {
            product.setInStock(true);
        }
        return product;
    }

    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
