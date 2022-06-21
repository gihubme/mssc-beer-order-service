package org.nnn4eu.mssc.msscbeerorderservice.service.beer;

import org.nnn4eu.mssc.msscbeerorderservice.service.beer.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<BeerDto> getBeerByUpc(String upc);

    Optional<BeerDto> getBeerById(UUID uuid);

}
