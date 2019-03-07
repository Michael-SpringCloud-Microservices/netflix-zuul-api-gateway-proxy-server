package com.zuul.gateway.proxy.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zuul.gateway.proxy.server.filters.ErrorFilter;
import com.zuul.gateway.proxy.server.filters.PostFilter;
import com.zuul.gateway.proxy.server.filters.PreFilter;
import com.zuul.gateway.proxy.server.filters.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class NetflixZuulApiGatewayProxyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayProxyServerApplication.class, args);
	}
	
	@Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

}
