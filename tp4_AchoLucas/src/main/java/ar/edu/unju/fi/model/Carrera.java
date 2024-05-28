package ar.edu.unju.fi.model;

public class Carrera {
    private String codigo;
    private String nombre;
    private int cantidadAnios;
    private String estado;
    
    
    // Constructor sin argumentos
    public Carrera() {}

    // Constructor con argumentos
    public Carrera(String codigo, String nombre, int cantidadAnios, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadAnios = cantidadAnios;
        this.estado = estado;
    }

    // Getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadAnios() {
        return cantidadAnios;
    }

    public void setCantidadAnios(int cantidadAnios) {
        this.cantidadAnios = cantidadAnios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}