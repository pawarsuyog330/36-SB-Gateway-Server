package com.ashokit.gateway;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		RouteLocator locator = builder.routes()
				
				               .route("customerModule", p->p.path("/c/**")
				            		  .filters(f->f.rewritePath("/c/(?<segment>.*)", "/${segment}")
				            				 .addResponseHeader("Response-Time",new Date().toString()) )
				            		  
				            		  .uri("lb://CUSTOMERS"))
				               .route("friendsModule", p->p.path("/f/**")
				            		   .filters(f->f.rewritePath("/f/(?<segment>.*)", "/${segment}"))
				            		   .uri("lb://FRIENDS"))
				               .route("plansModule", p->p.path("/p/**")
				            		   .filters(f->f.rewritePath("/p/(?<segment>.*)", "/${segment}"))
				            		   .uri("lb://PLANS"))
				               .route("calldetailsModule", p->p.path("/cd/**")
				            		   .filters(f->f.rewritePath("/p/(?<segment>.*)", "/${segment}"))
				            		   .uri("lb://CALLDETAILS"))
							   .build();
				               
		return locator;
	}
	

}
