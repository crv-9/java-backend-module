package io.everyonecodes.w1springbeans.smallbusiness.logic;

import io.everyonecodes.w1springbeans.smallbusiness.model.Product;
import io.everyonecodes.w1springbeans.smallbusiness.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ShopService shopService;

    public ProductService(ProductRepository productRepository, ShopService shopService) {
        this.productRepository = productRepository;
        this.shopService = shopService;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getNonPremiumProducts() {
        if (shopService.getShopStatus().equals("OPENED")){
            return getProductsExceptThisType("premium");
        } else {
            return List.of();
        }
    }

    public List<Product> getProductsByType(String type) {
        if (shopService.getShopStatus().equals("OPENED")) {
            List<Product> productsList = productRepository.findAll();
            return productsList.stream()
                    .filter(product -> product.getProductType().equals(type))
                    .toList();
        } else return List.of();
    }

    private List<Product> getProductsExceptThisType(String type) {
        List<Product> productsList = productRepository.findAll();
        return productsList.stream()
                .filter(product -> !product.getProductType().equals(type))
                .toList();

    }

}
