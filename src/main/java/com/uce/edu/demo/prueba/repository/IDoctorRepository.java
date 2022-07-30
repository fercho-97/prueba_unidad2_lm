package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.repository.modelo.Doctor;

public interface IDoctorRepository {

	public void insertar(Doctor doctor);

	public void actualizar(Doctor doctor);
	
	public Doctor buscarPorId(Integer id);

	public void eliminar(Integer id);
	
	public Doctor buscarPorCedula(String cedula);
}
