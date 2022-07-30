package com.uce.edu.demo;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.service.IDoctorService;

@SpringBootApplication
public class PruebaUnidad2LmP2Application implements CommandLineRunner{

	private static Logger LOG = Logger.getLogger(PruebaUnidad2LmP2Application.class);
	
	
	@Autowired
	
	private IDoctorService iDoctorService;
	
	private 
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2LmP2Application.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
	}

}
