package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {
	private static List<Docente> docentes = new ArrayList<Docente>();
	
	public static List<Docente> getDocentes(){
		
		if(docentes.isEmpty()) {
			
			 	docentes.add(new Docente(1001, "Juan", "Pérez", "juan.perez@gmail.com", "123456789"));
		        docentes.add(new Docente(1002, "Ana", "García", "ana.garcia@hotmail.com", "987654321"));
		        docentes.add(new Docente(1003, "Luis", "Martínez", "luis.martinez@gmail.com", "123123123"));
		        docentes.add(new Docente(1004, "María", "López", "maria.lopez@gmail.com", "456789123"));
		        docentes.add(new Docente(1005, "Pedro", "Sánchez", "pedro.sanchez@gmail.com", "789456123"));
		        docentes.add(new Docente(1006, "Laura", "Gómez", "laura.gomez@gmail.com", "321654987"));
		        docentes.add(new Docente(1007, "Carlos", "Fernández", "carlos.fernandez@gmail.com", "654987321"));
			
		}
		
		return docentes;
	}
	
	public static void agregarDocente (Docente docente) {
		
		int ultimoCodigo = 0;
        for (Docente d : docentes) {
            if (d.getLegajo() > ultimoCodigo) {
                ultimoCodigo = d.getLegajo();
            }
        }
        docente.setLegajo(ultimoCodigo+1);		
		docentes.add(docente);
	}
	
	public static void eliminarDocente(int legajoDocente) {
		Iterator<Docente> iterator = docentes.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getLegajo()== legajoDocente) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarDocente(Docente docente) {
		
		for(Docente d : docentes) {
			if(d.getLegajo() == docente.getLegajo()) {
				d.setNombre(docente.getNombre());
				d.setApellido(docente.getApellido());
				d.setEmail(docente.getEmail());
				d.setTelefono(docente.getTelefono());
				
			}
		}	 		 				
	}
	
	public static Docente buscarDocente(int legajo) {
		
		Predicate<Docente> filterLegajo = l -> l.getLegajo() == legajo;
		Optional<Docente> docente = docentes.stream().filter(filterLegajo).findFirst();
		if (docente.isPresent()) {
			return docente.get();
		}else {
			return null;
		}	
	}

}
