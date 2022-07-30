package com.uce.edu.demo.prueba.repository;

import java.time.LocalDateTime;

import com.uce.edu.demo.prueba.repository.modelo.CitaMedica;

public interface ICitaMedicaRepository {

	public void agendarCita(CitaMedica citaMedica);

	public int actualizarCita(String numeroCita, String diagnostico, String receta,
			LocalDateTime fechaProximaCita);

}
