package com.sofkaU.software.demo.repository;

import com.sofkaU.software.demo.collection.Stockist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockistRepository extends ReactiveMongoRepository<Stockist, String> {
}
