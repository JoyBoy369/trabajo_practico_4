package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.IAlumnoRepository;
import ar.edu.unju.fi.service.IAlumnoService;

@Service("alumnoServiceImp")
public class AlumnoServiceImp implements IAlumnoService {

	@Autowired
	private AlumnoMapper alumnoMapper;

	@Autowired
	private IAlumnoRepository alumnoRepository;

	@Autowired
	private Alumno alumno;

	@Override
	public List<AlumnoDTO> findAll() {

		List<Alumno> alumnosList = alumnoRepository.findByEstado(true);
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(alumnosList);

		return alumnosDTO;
	}

	@Override
	public AlumnoDTO findById(Long id) {

		Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);

		if (optionalAlumno.isPresent()) {
			Alumno alumno = optionalAlumno.get();
			AlumnoDTO alumnoDTO = alumnoMapper.toAlumnoDTO(alumno);
			return alumnoDTO;
		} else {
			return null; // O manejar el caso de no encontrar el alumno 
		}
	}

	
	@Override
	public void save(AlumnoDTO alumnoDTO) {
		
		Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
		alumno.setEstado(true);
		alumnoRepository.save(alumno);

	}

	
	@Override
	public void deleteById(AlumnoDTO alumnoDTO) {

		
		Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
		alumno.setEstado(false);
		alumnoRepository.save(alumno);
	
	}
	

	@Override
	public void edit(AlumnoDTO alumnoDTO) {
		
		Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
		

	}

}
