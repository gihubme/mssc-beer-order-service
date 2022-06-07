package org.nnn4eu.mssc.msscbeerorderservice.repository;

import org.nnn4eu.mssc.msscbeerorderservice.domain.BeerOrderLine;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerOrderLineRepository extends PagingAndSortingRepository<BeerOrderLine, UUID> {
}
