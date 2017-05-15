package com.customer.configuration;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

import com.car.core.RentalCar;
import com.customer.request.RentalCarRequestor;
 
@Configuration
public class AppConfig {

	//TODO
	 
@Bean(name="requestor")
public RentalCarRequestor rentalCarRequestor(){
	RentalCarRequestor requestor = new RentalCarRequestor();
	requestor.setRestTemplate(new RestTemplate());
	return requestor;
}

}
