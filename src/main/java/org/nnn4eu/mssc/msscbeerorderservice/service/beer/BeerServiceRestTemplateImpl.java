package org.nnn4eu.mssc.msscbeerorderservice.service.beer;

import lombok.extern.slf4j.Slf4j;
import org.nnn4eu.mssc.msscbeerorderservice.service.beer.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@ConfigurationProperties(prefix = "sfg.beer", ignoreUnknownFields = false)
public class BeerServiceRestTemplateImpl implements BeerService {

    private final String BEER_PATH_V1 = "/api/v1/beer/";
    private final String BEER_UPC_PATH_V1 = "/api/v1/beer/beerUpc/";
    private final RestTemplate restTemplate;

    private String beerServiceHost;

//    public BeerDto getBeerByUpc(String upc,Boolean showInventoryOnHand) {//, Boolean showBeerData
//        log.debug("Calling beer Service");
//        private final String BEER_UPC_PATH = "/api/v1/beer/beerUpc/{upc}";
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("upc", upc);
//        URI uri = UriComponentsBuilder.fromUriString(BEER_PATH)
//                .buildAndExpand(params)
//                .toUri();
//
//        uri = UriComponentsBuilder
//                .fromUri(uri)
//                .queryParam("showInventoryOnHand", showInventoryOnHand)
//                .build()
//                .toUri();
//
//        ResponseEntity<BeerDto> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, BeerDto.class);
//
//        return responseEntity.getBody();
//    }

    @Override
    public Optional<BeerDto> getBeerById(UUID uuid) {
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class));
    }

    @Override
    public Optional<BeerDto> getBeerByUpc(String upc) {
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_UPC_PATH_V1 + upc, BeerDto.class));
    }

    public void setBeerServiceHost(String beerServiceHost) {
        this.beerServiceHost = beerServiceHost;
    }

    public BeerServiceRestTemplateImpl(@Autowired RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


}
