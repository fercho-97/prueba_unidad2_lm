package com.uce.edu.demo.prueba.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.repository.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository{

	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void agendarCita(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public int actualizarCita(String numeroCita, String diagnostico, String receta,
			LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		
		Query myQuery = this.entityManager
				.createQuery("UPDATE CitaMedica c SET c.diagnostico = :diagnostico , c.receta = :receta , c.fechaProximaCita = :fechaProximaCita  WHERE c.numeroCita = :numeroCita");
		myQuery.setParameter("diagnostico", diagnostico);
		myQuery.setParameter("receta", receta);
		myQuery.setParameter("fechaProximaCita", fechaProximaCita);
		myQuery.setParameter("numeroCita", numeroCita);
		
		return myQuery.executeUpdate();
	}
}
