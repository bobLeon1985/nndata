package com.nndata.work.nndata.domain.dto;

import com.nndata.work.nndata.persintence.entity.Cliente;

public class ClientItem {

    private Long clienteid;
    private String nombre;
    private Character genero;
    private Integer edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private Boolean estado;

    public ClientItem(Cliente client){
        this(client.getClienteid(), client.getNombre(), client.getGenero(), client.getEdad(),client.getIdentificacion(),client.getDireccion(),client.getTelefono(),client.getContrasenia(),client.getEstado());
    }

    public ClientItem(Long clienteid, String nombre, Character genero, Integer edad, String identificacion, String direccion, String telefono, String contrasenia, Boolean estado) {
        this.clienteid = clienteid;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public Long getClienteid() {
        return clienteid;
    }

    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
