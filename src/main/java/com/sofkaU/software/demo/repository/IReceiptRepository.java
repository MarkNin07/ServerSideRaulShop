package com.sofkaU.software.demo.repository;

import com.sofkaU.software.demo.collection.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceiptRepository extends ReactiveMongoRepository<Receipt, String> {
}
