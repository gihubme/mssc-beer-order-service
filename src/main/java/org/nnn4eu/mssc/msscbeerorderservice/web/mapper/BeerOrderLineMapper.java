package org.nnn4eu.mssc.msscbeerorderservice.web.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.nnn4eu.mssc.msscbeerorderservice.domain.BeerOrderLine;
import org.nnn4eu.mssc.msscbeerorderservice.web.model.BeerOrderLineDto;

@DecoratedWith(BeerOrderLineMapperDecorator.class)
@Mapper(uses = {DateMapper.class})
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

//    @Named(value = "withBeerDto")
//    BeerOrderLineDto beerOrderLineToDtoWithBeerDto(BeerOrderLine line);

//    @IterableMapping(qualifiedByName = "withBeerDto")
//    List<BeerOrderLineDto> lineSetToLineDtoList(Set<BeerOrderLine> lines);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
