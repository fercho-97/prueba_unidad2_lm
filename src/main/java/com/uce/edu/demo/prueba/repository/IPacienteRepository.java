package com.uce.edu.demo.prueba.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.prueba.repository.modelo.Paciente;
import com.uce.edu.demo.prueba.repository.modelo.PacienteSenciilo;

public interface IPacienteRepository {

	public void insertar(Paciente paciente);

	public void actualizar(Paciente paciente);

	public Paciente buscarPorId(Integer id);

	public void eliminar(Integer id);
	
	public Paciente buscarPorCedula(String cedula);
	
	public List<PacienteSenciilo> reporte(LocalDateTime fechaNacimiento,String genero);
	
}
