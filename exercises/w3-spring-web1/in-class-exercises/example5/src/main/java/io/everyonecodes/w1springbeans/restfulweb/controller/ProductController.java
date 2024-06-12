package io.everyonecodes.w1springbeans.restfulweb.controller;

import io.everyonecodes.w1springbeans.restfulweb.controller.model.ProductID;
import io.everyonecodes.w1springbeans.restfulweb.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


// this indicates to Spring that we will be interacting with the web
// this class will be a handler for HTTP to control
@RestController
public class ProductController {

    // @RequestBody will automatically bind our parameters into this object
    @PostMapping("/product")
    public String createProduct(@RequestBody Product product) {
        System.out.println(product);
        return "This is " + product.getName();
    }
    // with the code above the response is 200, it should be 201 to show everything went okay

    // we return the UUID of this specific product we have created
    @PostMapping("/pro-product")
    // we will be returning a custom class as the response
    public ResponseEntity<ProductID> createProd(@RequestBody Product product) {
        System.out.println(product);

        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    // now we will do GET for the client to obtain a list of products

    List<Product> products = new ArrayList<>(List.of(
            new Product(11, "prod1", BigDecimal.valueOf(11.11)),
            new Product(22, "prod2", BigDecimal.valueOf(22.22)),
            new Product(33, "prod3", BigDecimal.valueOf(33.33))
    ));

    @GetMapping("/products")
    public List<Product> getProducts() {
        return products;
    }

    // Getting a product by specific ID

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable final String id){
        System.out.println(id);
        return new Product(444, "prod4", BigDecimal.valueOf(444.44));
    }

    // PATCH to update - but not replace

    @PatchMapping("/product")
    public void patchProduct(@RequestBody final Product product) {
        System.out.println(product);
    }

    // DELETE to delete one specific product
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable final String id) {
        System.out.println(id);
    }



}
