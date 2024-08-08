package io.everyonecodes.w1springbeans.smallbusiness.repository;

import io.everyonecodes.w1springbeans.smallbusiness.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
