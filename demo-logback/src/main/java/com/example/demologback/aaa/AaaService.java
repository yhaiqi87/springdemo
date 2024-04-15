package com.example.demologback.aaa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AaaService {

    public void test(){
        log.debug("AaaService debug");
        log.info("AaaService info");
        log.warn("AaaService warn");
        log.error("AaaService error");
    }
}
