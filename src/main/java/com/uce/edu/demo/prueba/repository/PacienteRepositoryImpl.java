package com.uce.edu.demo.prueba.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.repository.modelo.Paciente;
import com.uce.edu.demo.prueba.repository.modelo.PacienteSenciilo;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public Paciente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula = :datoCedula", Paciente.class);
		myQuery.setParameter("datoCedula", cedula);
		return  myQuery.getSingleResult();
	}

	@Override
	public List<PacienteSenciilo> reporte(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteSenciilo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.prueba.repository.modelo.PacienteSenciilo(p.cedula, p.nombre, p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento > :datoFechaNacimiento AND p.genero = :datoGenero",
				PacienteSenciilo.class);
		myQuery.setParameter("datoFechaNacimiento", fechaNacimiento);
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}

}
