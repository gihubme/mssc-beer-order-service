package org.nnn4eu.mssc.msscbeerorderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nnn4eu.mssc.msscbeerorderservice.bootstrap.BeerOrderBootStrap;
import org.nnn4eu.mssc.msscbeerorderservice.domain.Customer;
import org.nnn4eu.mssc.msscbeerorderservice.repository.BeerOrderRepository;
import org.nnn4eu.mssc.msscbeerorderservice.repository.CustomerRepository;
import org.nnn4eu.mssc.msscbeerorderservice.web.model.BeerOrderDto;
import org.nnn4eu.mssc.msscbeerorderservice.web.model.BeerOrderLineDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class TastingRoomServiceImpl implements TastingRoomService {

    private final CustomerRepository customerRepository;
    private final BeerOrderService beerOrderService;
    private final BeerOrderRepository beerOrderRepository;
    private final List<String> beerUpcs = //new ArrayList<>(3);
            new ArrayList<>(Arrays.asList(BeerOrderBootStrap.BEER_1_UPC, BeerOrderBootStrap.BEER_2_UPC,
                    BeerOrderBootStrap.BEER_3_UPC));

    @Override
    @Transactional //(propagation= Propagation.REQUIRES_NEW)
    public void placeTastingCustomerRoomOrder() {
        List<Customer> customerList = customerRepository.findAllByCustomerNameLike(BeerOrderBootStrap.TASTING_ROOM);

        if (customerList.size() == 1) { //should be just one
            doPlaceOrder(customerList.get(0));
        } else {
            log.error("Too many or too few tasting room customers found");
        }
    }

    private void doPlaceOrder(Customer customer) {
        String beerToOrder = getRandomBeerUpc();

        BeerOrderLineDto beerOrderLine = BeerOrderLineDto.builder()
                .upc(beerToOrder)
                .orderQuantity(new Random().nextInt(6)) //todo externalize value to property
                .build();

        List<BeerOrderLineDto> beerOrderLineSet = new ArrayList<>();
        beerOrderLineSet.add(beerOrderLine);

        BeerOrderDto beerOrder = BeerOrderDto.builder()
                .customerId(customer.getId())
                .customerRef(UUID.randomUUID().toString())
                .beerOrderLines(beerOrderLineSet)
                .build();

        BeerOrderDto savedOrder = beerOrderService.placeOrder(customer.getId(), beerOrder);

    }

    private String getRandomBeerUpc() {
        return beerUpcs.get(new Random().nextInt(beerUpcs.size() - 0));
    }
}
