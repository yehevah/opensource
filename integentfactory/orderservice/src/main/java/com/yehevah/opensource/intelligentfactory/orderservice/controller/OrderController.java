package com.yehevah.opensource.intelligentfactory.orderservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yehevah.opensource.intelligentfactory.orderservice.entities.User;

@RestController
public class OrderController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient descoveryCient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		return this.restTemplate.getForObject("http://userservice/user/"+id, User.class);
	}
	
	@GetMapping("/user-instance")
	public List<ServiceInstance> showInfo(){
		return this.descoveryCient.getInstances("userservice");
	}
	
	@GetMapping("/log-instance")
	public void logInstance(){
		ServiceInstance serviceInstance=loadBalancerClient.choose("userservice");
		OrderController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
	}

}
