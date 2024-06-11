package ar.edu.unju.fi.collections;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class CollectionAlumno {
	
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	
	public static List<Alumno> getAlumnos() {
		
		
		
		if(alumnos.isEmpty()) {
			
				alumnos.add(new Alumno("12345678", "Juan", "Pérez", "juan.perez@example.com", "123456789", LocalDate.of(2000, 1, 1), "Calle Falsa 123", "LU001"));
		        alumnos.add(new Alumno("87654321", "Ana", "García", "ana.garcia@example.com", "987654321", LocalDate.of(1999, 2, 15), "Avenida Siempreviva 742", "LU002"));
		        alumnos.add(new Alumno("23456789", "Luis", "Martínez", "luis.martinez@example.com", "234567890", LocalDate.of(2001, 3, 22), "Calle de la Paz 100", "LU003"));
		        alumnos.add(new Alumno("34567890", "María", "López", "maria.lopez@example.com", "345678901", LocalDate.of(1998, 4, 5), "Avenida del Sol 200", "LU004"));
		        alumnos.add(new Alumno("45678901", "Carlos", "Fernández", "carlos.fernandez@example.com", "456789012", LocalDate.of(2002, 5, 18), "Calle Luna 300", "LU005"));
		        alumnos.add(new Alumno("56789012", "Lucía", "Sánchez", "lucia.sanchez@example.com", "567890123", LocalDate.of(2000, 6, 9), "Avenida Estrella 400", "LU006"));
		        alumnos.add(new Alumno("67890123", "Jorge", "González", "jorge.gonzalez@example.com", "678901234", LocalDate.of(1997, 7, 30), "Calle del Río 500", "LU007"));
		        alumnos.add(new Alumno("78901234", "Laura", "Rodríguez", "laura.rodriguez@example.com", "789012345", LocalDate.of(2003, 8, 15), "Avenida del Lago 600", "LU008"));
          
		}
		
		return alumnos;
	}
	
	public static void agregarAlumno(Alumno alumno) {
		
		alumnos.add(alumno);
		
	}
	
	public static void eliminarAlumno(String dniAlumno) {
		
		Iterator<Alumno> iterator = alumnos.iterator();
		
		while(iterator.hasNext()) {
			if(iterator.next().getDni().equals(dniAlumno) ) {
				iterator.remove();
			}
		}
	}
	
	
	public static void modificarAlumno(Alumno alumno) {
		
		for (Alumno a : alumnos) {
			if(a.getDni().equals(alumno.getDni())) {
				
				a.setNombre(alumno.getNombre());
				a.setApellido(alumno.getApellido());
				a.setEmail(alumno.getEmail());
				a.setTelefono(alumno.getTelefono());
				a.setFechaNacimiento(alumno.getFechaNacimiento());
				a.setDomicilio(alumno.getDomicilio());
				a.setLu(alumno.getLu());
				break;
			}			
		}
	}
	
	public static Alumno buscarAlumno(String dni) {
		
		Predicate<Alumno> filterDni = d -> d.getDni().equals(dni);
		Optional<Alumno> alumno = alumnos.stream().filter(filterDni).findFirst();
		
		if(alumno.isPresent()) {
			
			return alumno.get();			
		}else {
			return null;
		}
		
		
	}
	
	

}
