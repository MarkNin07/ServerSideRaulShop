package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.collection.Product;
import com.sofkaU.software.demo.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteProductUseCase {

    private final IProductRepository productRepo;

    private Mono<Product> findProductById(String id){
        return productRepo.findById(id)
                .switchIfEmpty(Mono.error(()-> new Throwable("The id has been found")));
    }

    public Mono<Void> deleteProduct(String id){
        return findProductById(id)
                .flatMap(product -> productRepo.deleteById(product.getProductId()));
    }

}
