package org.nnn4eu.mssc.msscbeerorderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class SchedulerService {

    private final TastingRoomService tastingRoomService;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void placeTastingRoomOrder() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        tastingRoomService.placeTastingCustomerRoomOrder();
    }
}
