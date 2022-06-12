package com.sofkaU.software.demo.repository;

import com.sofkaU.software.demo.collection.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends ReactiveMongoRepository<Bill, String> {
}
