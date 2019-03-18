/**
 * 
 */
package com.zuul.gateway.proxy.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @author 109726
 *
 */
/*@Component
@Primary
@EnableAutoConfiguration*/
@Configuration
public class DocumentationController{

	private static final Logger LOG = LoggerFactory.getLogger(DocumentationController.class);

	/*@Override
	public List<SwaggerResource> get() {
		LOG.info("Loading the swagger resourcs of the downstream services");
		List<SwaggerResource> resources = new ArrayList<>();
		resources.add(swaggerResource("student-service", "/student/", "2.0"));
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}*/
	
	@Autowired
    ZuulProperties properties;
 
    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        return () -> {
            List resources = new ArrayList();
            properties.getRoutes().values().stream()
                    .forEach(route -> resources.add(createResource(route.getServiceId(), route.getId(), "2.0")));
            return resources;
        };
    }
 
    private SwaggerResource createResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation("/" + location + "/v2/api-docs");
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
