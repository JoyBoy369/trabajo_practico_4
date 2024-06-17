package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlumnoMapper {
	
	 	//source = Alumno.java // target = AlumnoDTo.java //
	
	@Mappings({
		@Mapping(source="fechaNacimiento",target = "fechaNacimiento",dateFormat = "yyyy-MM-dd")
	})	
	AlumnoDTO toAlumnoDTO(Alumno alumno);
	
	
	@InheritInverseConfiguration
	Alumno toAlumno(AlumnoDTO alumnoDTO);
	
	
	List<AlumnoDTO> toAlumnoDTOList(List<Alumno> alumnos);
	
	List<Alumno> toAlumnoList(List<AlumnoDTO>alumnosDTO);

}
