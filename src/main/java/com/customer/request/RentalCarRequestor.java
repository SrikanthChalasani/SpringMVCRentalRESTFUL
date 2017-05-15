package com.customer.request;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.car.core.Receipt;
import com.car.core.RentalCar;

public class RentalCarRequestor {

	RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public RentalCar getById(long id) {
		String url = "http://localhost:8080/rentals/car/{id}";
		return restTemplate.getForObject(url, RentalCar.class, id);
	}
	
	public RentalCar getById1(long id){
		String url = "http://localhost:8080/rentals/car/{id}";
		ResponseEntity<RentalCar> entity = restTemplate.getForEntity(url,RentalCar.class,id);
		System.out.println(entity.getStatusCode());
		System.out.println(entity.getHeaders());
		return entity.getBody();
	}
	
	public RentalCar getById2(long id){
		String url = "http://localhost:8080/rentals/car/{id}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/xml"); // I accept this from server
		headers.add("Content-Type", "application/xml"); // I am senging this from server
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<RentalCar> re = restTemplate.exchange(url, HttpMethod.GET, entity, RentalCar.class,id);
		System.out.println(re.getStatusCode());
		System.out.println(re.getHeaders());		
		return re.getBody();
	}
	
	
	public Receipt add(RentalCar car){
		HttpEntity<RentalCar> entity = new HttpEntity<RentalCar>(car);
		String url = "http://localhost:8080/rentals/car/add";
		ResponseEntity<Receipt> response = restTemplate.postForEntity(url, entity, Receipt.class);
		return response.getBody();
	}
}
