package org.nnn4eu.mssc.msscbeerorderservice.web.mapper;

import org.nnn4eu.mssc.msscbeerorderservice.domain.BeerOrder;
import org.nnn4eu.mssc.msscbeerorderservice.web.model.BeerOrderDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
