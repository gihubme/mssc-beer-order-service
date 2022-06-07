package org.nnn4eu.mssc.msscbeerorderservice.web.mapper;

import org.nnn4eu.mssc.msscbeerorderservice.domain.BeerOrderLine;
import org.nnn4eu.mssc.msscbeerorderservice.web.model.BeerOrderLineDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
