package com.uce.edu.demo.prueba.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.prueba.repository.modelo.PacienteSenciilo;

public interface IGestorCitaMedicaService {

	public void agendar(String numeroCita, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente);

	public int actualizarCita(String numeroCita, String diagnostico, String receta,
			LocalDateTime fechaProximaCita);

	public List<PacienteSenciilo> reporte(LocalDateTime fechaNacimiento, String genero);
}
