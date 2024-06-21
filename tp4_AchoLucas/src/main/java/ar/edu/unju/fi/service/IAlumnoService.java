package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;

public interface IAlumnoService {
	
	List<AlumnoDTO> findAll();
	
	AlumnoDTO findById(Long id);
	
	void save(AlumnoDTO alumnoDTO);
	
	
	/*void deleteById(Long id);*/
	void deleteById(AlumnoDTO alumnoDTO);
	
	void edit(AlumnoDTO alumnoDTO);

}
