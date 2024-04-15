package com.example.demologback.bbb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BbbService {

    public void test(){
        log.debug("BbbService debug");
        log.info("BbbService info");
        log.warn("BbbService warn");
        log.error("BbbService error");
    }
}
