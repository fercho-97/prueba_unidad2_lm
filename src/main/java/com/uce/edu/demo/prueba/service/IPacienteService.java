package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.repository.modelo.Paciente;

public interface IPacienteService {

	public void insertar(Paciente paciente);

	public void actualizar(Paciente paciente);

	public Paciente buscarPorId(Integer id);

	public void eliminar(Integer id);
	
	
}
