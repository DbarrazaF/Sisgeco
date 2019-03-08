
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Daniel Barraza
 */
public class Control_Directiva {
    String rut_dirigente;
    String nombre_dirigente;
    String apellido_paterno;
    String cargo;
    String telefono;

    public Control_Directiva(String rut_dirigente, String nombre_dirigente, String apellido_paterno, String cargo, String telefono) {
        this.rut_dirigente = rut_dirigente;
        this.nombre_dirigente = nombre_dirigente;
        this.apellido_paterno = apellido_paterno;
        this.cargo = cargo;
        this.telefono = telefono;
    }

    public String getRut_dirigente() {
        return rut_dirigente;
    }

    public void setRut_dirigente(String rut_dirigente) {
        this.rut_dirigente = rut_dirigente;
    }

    public String getNombre_dirigente() {
        return nombre_dirigente;
    }

    public void setNombre_dirigente(String nombre_dirigente) {
        this.nombre_dirigente = nombre_dirigente;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Control_Directiva{" + "rut_dirigente=" + rut_dirigente + ", nombre_dirigente=" + nombre_dirigente + ", apellido_paterno=" + apellido_paterno + ", cargo=" + cargo + ", telefono=" + telefono + '}';
    }

   
}
