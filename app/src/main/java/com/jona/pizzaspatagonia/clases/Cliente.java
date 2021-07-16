package com.jona.pizzaspatagonia.clases;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String email, nombres, apellidos, numero, direccion, clave, administrador;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return email;
    }

    public Cliente(int id, String email, String nombres, String apellidos, String numero, String direccion, String clave) {
        this.id = id;
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numero = numero;
        this.direccion = direccion;
        this.clave = clave;
        this.administrador = "no";
    }
}
