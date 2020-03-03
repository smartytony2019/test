package com.alibaba.nacos.example.spring.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider")
public interface EchoService {

    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable(value = "message") String message);


}
