package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Alumno;


@Repository
public interface IAlumnoRepository extends CrudRepository<Alumno, Long> {
	
	
	// Solo recupera objetos cuyo estado sea true, es decir que no se hayan eliminado de manera logica //
	public List<Alumno> findByEstado(boolean estado);

}
