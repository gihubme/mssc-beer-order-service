package org.nnn4eu.mssc.msscbeerorderservice.web.mapper;

import lombok.NoArgsConstructor;
import org.nnn4eu.mssc.msscbeerorderservice.domain.BeerOrderLine;
import org.nnn4eu.mssc.msscbeerorderservice.service.beer.BeerService;
import org.nnn4eu.mssc.msscbeerorderservice.service.beer.model.BeerDto;
import org.nnn4eu.mssc.msscbeerorderservice.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

@NoArgsConstructor
public class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {
    private BeerService beerService;
    private BeerOrderLineMapper mapper;

    @Autowired
    public void setBeerService(BeerService beerService) {
        this.beerService = beerService;
    }

    @Qualifier("delegate")
    @Autowired
    public void setMapper(BeerOrderLineMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
        BeerOrderLineDto orderLineDto = mapper.beerOrderLineToDto(line);
        Optional<BeerDto> beerDtoOptional = beerService.getBeerByUpc(line.getUpc());

        beerDtoOptional.ifPresent(beerDto -> {
            orderLineDto.setBeerName(beerDto.getBeerName());
            orderLineDto.setBeerStyle(beerDto.getBeerStyle());
            orderLineDto.setPrice(beerDto.getPrice());
            orderLineDto.setBeerId(beerDto.getId());
        });

        return orderLineDto;
    }

//    @Override
//    public List<BeerOrderLineDto> lineSetToLineDtoList(Set<BeerOrderLine> lines) {
//        return lines.stream().map(line -> beerOrderLineToDtoWithBeerDto(line)).collect(Collectors.toList());
//    }

    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto) {
        return mapper.dtoToBeerOrderLine(dto);
    }
}
