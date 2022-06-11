package com.sofkaU.software.demo.mapper;


import com.sofkaU.software.demo.collection.Product;
import com.sofkaU.software.demo.collection.Stockist;
import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.dto.StockistDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ShopModelMapper {

    private final ModelMapper mapper;

    public ShopModelMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public StockistDto toStockistDto(Stockist stockist){
        return mapper.map(stockist, StockistDto.class);
    }

    public Stockist toStockistCollection(StockistDto stockistDto){
        return mapper.map(stockistDto, Stockist.class);
    }

    public ProductDto toProductDto(Product product){
        return mapper.map(product, ProductDto.class);
    }

    public Product toProductCollection(ProductDto productDto){
        return mapper.map(productDto, Product.class);
    }

}
