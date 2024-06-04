package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CollectionCarrera {
	
	private static List<Carrera> carreras = new ArrayList<Carrera>();
	
	
	public static List<Carrera> getCarreras(){	
		//al iniciar la pagina se pre-cargan datos
		if(carreras.isEmpty()) {
			
			carreras.add(new Carrera(1,"Ingenieria Informatica",5,true));
			carreras.add(new Carrera(2,"Ingenieria en Sistemas",5,false));
			carreras.add(new Carrera(3,"Ingenieria Quimica",5,true));
			carreras.add(new Carrera(4,"Ingenieria Mecatronica",5,false));
			carreras.add(new Carrera(5,"Analista Programador",3,true));
			carreras.add(new Carrera(6,"Administracion Empresas",3,false));
		}
				
		return carreras;
	}
	
	
	public static void agregarCarrera(Carrera carrera) {
				
		//Verifica el ultimo codigo del Array + 1 para guardar uno nuevo//
		int ultimoCodigo = 0;
        for (Carrera c : carreras) {
            if (c.getCodigo() > ultimoCodigo) {
                ultimoCodigo = c.getCodigo();
            }
        }
        carrera.setCodigo(ultimoCodigo + 1);
        carreras.add(carrera);

	}
	
	public static void eliminarCarrera(int codigoCarrera) {
		Iterator<Carrera> iterator = carreras.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo()== codigoCarrera) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarCarrera(Carrera carrera) {
		
		for(Carrera c : carreras) {
			if(c.getCodigo() == carrera.getCodigo()) {
				c.setNombre(carrera.getNombre());
				c.setCantidadAnios(carrera.getCantidadAnios());  
				c.setEstado(carrera.getEstado());  
				
			}else {
				System.out.println("No se encontro");
			}
		}	 		 				
	}
	
	
	public static Carrera buscarCarrera(int codigo) {
		
		Predicate<Carrera> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
		if (carrera.isPresent()) {
			return carrera.get();
		}else {
			return null;
		}	
	}

}
