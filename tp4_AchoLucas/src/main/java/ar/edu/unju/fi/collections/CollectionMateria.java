package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


import ar.edu.unju.fi.model.Materia;

@Component
public class CollectionMateria {
	
	private static List<Materia> materias = new ArrayList<Materia>();
	
	public static List<Materia> getMaterias(){
		
		if(materias.isEmpty()) {
			
			// cargar //
			
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
	
	public static void eliminarCarrera(int codigoMateria) {
		Iterator<Materia> iterator = materias.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo()== codigoMateria) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarCarrera(Materia materia) {
		
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
