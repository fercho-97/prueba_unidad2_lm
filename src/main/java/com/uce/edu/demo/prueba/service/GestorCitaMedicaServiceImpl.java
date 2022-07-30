package com.uce.edu.demo.prueba.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.repository.ICitaMedicaRepository;
import com.uce.edu.demo.prueba.repository.IDoctorRepository;
import com.uce.edu.demo.prueba.repository.IPacienteRepository;
import com.uce.edu.demo.prueba.repository.modelo.CitaMedica;
import com.uce.edu.demo.prueba.repository.modelo.Doctor;
import com.uce.edu.demo.prueba.repository.modelo.Paciente;
import com.uce.edu.demo.prueba.repository.modelo.PacienteSenciilo;

@Service
public class GestorCitaMedicaServiceImpl implements IGestorCitaMedicaService {

	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Autowired
	private IDoctorRepository iDoctorRepository;
	
	@Autowired
	private ICitaMedicaRepository iCitaMedicaRepository;

	@Override
	public void agendar(String numeroCita, LocalDateTime fechaCita, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente) {
		// TODO Auto-generated method stub
		CitaMedica cm = new CitaMedica();

		cm.setNumeroCita(numeroCita);
		cm.setFechaCita(fechaCita);
		cm.setValorCita(valor);
		cm.setLugarCita(lugar);

		Doctor d = this.iDoctorRepository.buscarPorCedula(cedulaDoctor);

		Paciente p = this.iPacienteRepository.buscarPorCedula(cedulaPaciente);

		cm.setDoctor(d);
		cm.setPaciente(p);

		this.iCitaMedicaRepository.agendarCita(cm);

	}

	@Override
	public int actualizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		
		return this.iCitaMedicaRepository.actualizarCita(numeroCita, diagnostico, receta, fechaProximaCita);
	}

	@Override
	public List<PacienteSenciilo> reporte(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		return this.iPacienteRepository.reporte(fechaNacimiento, genero);
	}

}
