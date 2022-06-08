package com.sofkaU.software.demo.repository;

import com.sofkaU.software.demo.collection.Stockist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IStockistRepository extends ReactiveMongoRepository<Stockist, String> {
}
