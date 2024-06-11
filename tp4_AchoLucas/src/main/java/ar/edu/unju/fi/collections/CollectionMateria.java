package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Component
public class CollectionMateria {
	
	private static List<Materia> materias = new ArrayList<Materia>();
	
	public static List<Materia> getMaterias(){
		
		//Metodos para dejar Pre Cargado un Docente y una Carrera ala lista 
		List<Docente> listaDocente =CollectionDocente.getDocentes();		
		Docente docente1 =listaDocente.get(0);
		Docente docente2 =listaDocente.get(1);
		Docente docente3 =listaDocente.get(2);
		
		List<Carrera> listaCarrera =CollectionCarrera.getCarreras();
		Carrera carrera1 =listaCarrera.get(0);
		Carrera carrera2 =listaCarrera.get(1);
		Carrera carrera3 =listaCarrera.get(2);
		
		if(materias.isEmpty()) {
			
			// cargar //
			materias.add(new Materia(1,"Programacion Estructurada","1er Año",89,"Presencial",docente1,carrera1));
			materias.add(new Materia(2, "Bases de Datos", "2do Año", 75, "Virtual", docente2, carrera2));
		    materias.add(new Materia(3, "Redes de Computadoras", "3er Año", 60, "Presencial", docente3, carrera3));
		}

		return materias;
	}
	
	public static void agregarMateria(Materia materia) {
		
		//Verifica el ultimo codigo del Array + 1 para guardar uno nuevo//
				int ultimoCodigo = 0;
		        for (Materia m : materias) {
		            if (m.getCodigo() > ultimoCodigo) {
		                ultimoCodigo = m.getCodigo();
		            }
		        }
		        materia.setCodigo(ultimoCodigo + 1);
		        materias.add(materia);		
	}
	
	public static void eliminarMateria(int codigoMateria) {
		Iterator<Materia> iterator = materias.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo()== codigoMateria) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarMateria(Materia materia) {
		
		for(Materia m : materias) {
			if(m.getCodigo() == materia.getCodigo()) {
				m.setNombre(materia.getNombre());
				m.setCurso(materia.getCurso());
				m.setCantidadHoras(materia.getCantidadHoras());
				m.setModalidad(materia.getModalidad());
				m.setDocente(materia.getDocente());
				m.setCarrera(materia.getCarrera());
								
			}
		}	 		 				
	}
	
	public static Materia buscarMateria(int codigo) {
		
		Predicate<Materia> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();
		if (materia.isPresent()) {
			return materia.get();
		}else {
			return null;
		}	
	}

}
