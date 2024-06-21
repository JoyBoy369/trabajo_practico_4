package ar.edu.unju.fi.model;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name="ALUMNOS")
public class Alumno {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="alu_id")
	private Long id;
	
	@Column(name="alu_dni")
    private String dni;
	
	@Column(name="alu_nombre")
    private String nombre;
	
	@Column(name="alu_apellido")
    private String apellido;
	
	@Column(name="alu_email")
    private String email;
	
	@Column(name="alu_telefono")
    private String telefono;
    
	@Column(name="alu_nacimiento")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    
	@Column(name="alu_domicilio")
    private String domicilio;
	
	@Column(name="alu_lu")
    private String lu; // LU = Libreta Universitaria
    
	
	// Util para hacer un borrado logico de datos //
	@Column(name="alu_estado")
	private boolean estado;
    
}
