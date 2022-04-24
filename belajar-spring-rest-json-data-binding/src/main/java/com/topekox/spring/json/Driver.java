package com.topekox.spring.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topekox.spring.json.entity.Address;
import com.topekox.spring.json.entity.Student;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create JSON object Mapper
			ObjectMapper objectMapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO
			// sample-lite.json
			Student student = 
					objectMapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print out
			System.out.println("First name = " + student.getFirstName());
			System.out.println("Last name = " + student.getLastName());
			
			// print address
			Address address = student.getAddress();
			
			System.out.println("Street = " + address.getStreet());
			System.out.println("City = " + address.getCity());
			
			// print language
			for (String lang : student.getLanguages()) {
				System.out.println(lang);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
