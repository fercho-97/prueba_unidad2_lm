package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.repository.modelo.Doctor;

public interface IDoctorService {

	public void insertar(Doctor doctor);

	public void actualizar(Doctor doctor);
	
	public Doctor buscarPorId(Integer id);

	public void eliminar(Integer id);
	
}
