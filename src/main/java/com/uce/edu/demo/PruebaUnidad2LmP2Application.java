package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.repository.modelo.Doctor;
import com.uce.edu.demo.prueba.repository.modelo.Paciente;
import com.uce.edu.demo.prueba.repository.modelo.PacienteSenciilo;
import com.uce.edu.demo.prueba.service.IDoctorService;
import com.uce.edu.demo.prueba.service.IGestorCitaMedicaService;
import com.uce.edu.demo.prueba.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2LmP2Application implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(PruebaUnidad2LmP2Application.class);

	@Autowired
	private IDoctorService iDoctorService;

	@Autowired
	private IPacienteService iPacienteService;

	@Autowired
	private IGestorCitaMedicaService iGestorCitaMedicaService;

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2LmP2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Paciente p1 = new Paciente();
		p1.setApellido("Orozco");
		p1.setNombre("Juan");
		p1.setCedula("001");
		p1.setCodigoSeguro("a1");
		p1.setEstatura(new Double(1.65));
		p1.setPeso(new Double(68.8));
		p1.setGenero("M");
		p1.setFechaNacimiento(LocalDateTime.of(1997, 10,1,0,0));
		
		Paciente p2 = new Paciente();
		p2.setApellido("Benavides");
		p2.setNombre("Maria");
		p2.setCedula("002");
		p2.setCodigoSeguro("a2");
		p2.setEstatura(new Double(1.70));
		p2.setPeso(new Double(75.5));
		p2.setGenero("F");
		p2.setFechaNacimiento(LocalDateTime.of(1997, 10,1,0,0));
		
		
		Doctor d1 = new Doctor();
		d1.setCedula("003");
		d1.setNombre("Alejandro");
		d1.setApellido("Magno");
		d1.setFechaNacimiento(LocalDateTime.now());
		d1.setNumeroConsultorio("1");
		d1.setCodigoSenecyt("c1");
		d1.setGenero("M");
		
		
		Doctor d2 = new Doctor();
		d2.setCedula("004");
		d2.setNombre("Luis");
		d2.setApellido("Montalvo");
		d2.setFechaNacimiento(LocalDateTime.now());
		d2.setNumeroConsultorio("2");
		d2.setCodigoSenecyt("c2");
		d2.setGenero("M");
		
		this.iPacienteService.insertar(p1);
		LOG.debug("Se inserto el paciente: "+ p1);
		
		LOG.debug("Se inserto el paciente: "+ p2);
		this.iPacienteService.insertar(p2);
		
		LOG.debug("Se inserto el doctor: "+ d1);
		this.iDoctorService.insertar(d1);
		
		LOG.debug("Se inserto el doctor: "+ d2);
		this.iDoctorService.insertar(d2);
		
		
		
		this.iGestorCitaMedicaService.agendar("1", LocalDateTime.now(), new BigDecimal(25), "axis", "003", "001");
		
		this.iGestorCitaMedicaService.actualizarCita("1", "fractura", "inmobilida e ibuprofeno", LocalDateTime.of(2022,10,12,0,0));
		
		
		/*
		
		List<PacienteSenciilo> pacienteSenciilos =this.iGestorCitaMedicaService.reporte(LocalDateTime.of(1995, 1, 1,0, 0), "M");
		for(PacienteSenciilo item: pacienteSenciilos) {
			
			LOG.debug("Persona Sencilla:" + item);
		
			
		}
		
		*/
	}

}
