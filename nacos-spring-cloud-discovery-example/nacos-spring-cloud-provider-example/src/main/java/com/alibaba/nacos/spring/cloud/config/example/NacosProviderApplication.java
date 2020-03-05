package com.alibaba.nacos.spring.cloud.config.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaojing
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosProviderApplication.class, args);
	}



	@RestController
	class EchoController {

		@Value("${server.port}")
		private String port;

		@RequestMapping(value = "/echo/{message}", method = RequestMethod.GET)
		public String echo(@PathVariable String message) {
			return "jackaaaaaaaaaaaaa"+ message +" Nacos 213333213333Discovery i am port:" + port;
		}


		@RequestMapping(value = "/test/{message}", method = RequestMethod.GET)
		public String test(@PathVariable String message) {
			return "213333"+ message +" tes213333t" + port;
		}



	}
}
