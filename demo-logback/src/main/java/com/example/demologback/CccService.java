package com.example.demologback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CccService {

    public void test(){
        log.debug("CccService debug");
        log.info("CccService info");
        log.warn("CccService warn");
        log.error("CccService error");
    }
}
