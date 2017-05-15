package com.customer.request;

 
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.xml.transform.stream.StreamSource;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.car.core.Receipt;
import com.car.core.RentalCar;
import com.customer.configuration.AppConfig;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class RentalCarRequestorTestById {
	 
	@Autowired
	RentalCarRequestor rentalCarRequestor;

	@Test
	public void testGetById() throws JSONException, IOException {
		 
		RentalCar rentalCar = rentalCarRequestor.getById(5L);
	    System.out.println(rentalCar);
		
	}
	
	@Test
	public void testGetByIdHeader() throws JSONException, IOException {
		RentalCar rentalCar = rentalCarRequestor.getById1(7L);
		System.out.println(rentalCar);		
	}
	
	@Test
	public void testGetByIdExchange() throws JSONException, IOException {
		RentalCar rentalCar = rentalCarRequestor.getById2(7L);
		System.out.println("testGetByIdExchange --> " + rentalCar);		
	}
	
	 @Test
	 public void addNewCartest() throws JSONException, IOException {
		 RentalCar newCar = new RentalCar(99L,"BMI","Economy",35.00,"Nissan","Versa");
		 
		 Receipt receipt = rentalCarRequestor.add(newCar);
		 System.out.println(receipt);
	 }
}
