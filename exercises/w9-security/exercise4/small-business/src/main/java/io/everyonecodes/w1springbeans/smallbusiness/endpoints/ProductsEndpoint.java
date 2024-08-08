package io.everyonecodes.w1springbeans.smallbusiness.endpoints;

import io.everyonecodes.w1springbeans.smallbusiness.logic.ProductService;
import io.everyonecodes.w1springbeans.smallbusiness.logic.ShopService;
import io.everyonecodes.w1springbeans.smallbusiness.model.Product;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsEndpoint {

    private final ProductService productService;
    private final ShopService shopService;

    public ProductsEndpoint(ProductService productService, ShopService shopService) {
        this.productService = productService;
        this.shopService = shopService;
    }

    // saves the Product in the database and returns it with an id [for owner only]
    @PostMapping
    @Secured("ROLE_OWNER")
    public Product createProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // returns all saved Product entries that are not premium, if the shop is open.
    // Returns an empty list of Product entries, if the shop is closed.

    @GetMapping
    public List<Product> getAllNonPremiumProducts() {
        return productService.getNonPremiumProducts();
    }

    @GetMapping("/premium")
    @Secured("ROLE_PREMIUM")
    public List<Product> getPremiumProducts() {
        return productService.getProductsByType("premium");
    }





}
