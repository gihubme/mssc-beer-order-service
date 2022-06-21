package org.nnn4eu.mssc.msscbeerorderservice.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nnn4eu.mssc.msscbeerorderservice.domain.BeerOrder;
import org.nnn4eu.mssc.msscbeerorderservice.web.model.BeerOrderDto;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    @Mapping(target = "customerId", source = "customer.id")
    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
