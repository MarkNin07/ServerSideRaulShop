package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.collection.Product;
import com.sofkaU.software.demo.collection.Receipt;
import com.sofkaU.software.demo.collection.Stockist;
import com.sofkaU.software.demo.dto.ReceiptDto;
import com.sofkaU.software.demo.repository.IReceiptRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateReceiptUseCaseTest {

    @MockBean
    private CreateReceiptUseCase receiptUseCase;

    @Mock
    IReceiptRepository receiptRepo;

    @Test
    public void createReceiptTest(){

        Stockist stockist = new Stockist("S1", "Angel", "ST7", "1345678986");

        Product product = new Product("P123", "drill", 58, 0, "electric drill", 20, 50, 25, stockist);

        Receipt receipt = new Receipt("Rp65", 0, "29/02/2020", product);

        ReceiptDto receiptDto = new ReceiptDto();
        receiptDto.setReceiptId(receipt.getReceiptId());
        receiptDto.setQuantity(receipt.getQuantity());
        receiptDto.setDate(receipt.getDate());
        receiptDto.setProduct(receipt.getProduct());

        StepVerifier.create(Mono.just(Mockito.when(receiptUseCase.createReceipt(receiptDto))
                .thenReturn(Mono.just(receiptDto))))
                .expectComplete();

    }

}