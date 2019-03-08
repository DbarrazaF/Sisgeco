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
public class Control_Coves {
   String nombre_coves;
   String rut_coves;
   String estado_coves;
   String nombre_unidad;
   String nom_sector;

    public Control_Coves(String nombre_coves, String rut_coves, String estado_coves, String nombre_unidad, String nom_sector) {
        this.nombre_coves = nombre_coves;
        this.rut_coves = rut_coves;
        this.estado_coves = estado_coves;
        this.nombre_unidad = nombre_unidad;
        this.nom_sector = nom_sector;
    }

   

    public String getRut_coves() {
        return rut_coves;
    }

    public void setRut_coves(String rut_coves) {
        this.rut_coves = rut_coves;
    }

    public String getNombre_coves() {
        return nombre_coves;
    }

    public void setNombre_coves(String nombre_coves) {
        this.nombre_coves = nombre_coves;
    }

    public String getEstado_coves() {
        return estado_coves;
    }

    public void setEstado_coves(String estado_coves) {
        this.estado_coves = estado_coves;
    }

    public String getNombre_unidad() {
        return nombre_unidad;
    }

    public void setNombre_unidad(String nombre_unidad) {
        this.nombre_unidad = nombre_unidad;
    }

    public String getNom_sector() {
        return nom_sector;
    }

    public void setNom_sector(String nom_sector) {
        this.nom_sector = nom_sector;
    }

    @Override
    public String toString() {
        return "Control_Coves{" + "rut_coves=" + rut_coves + ", nombre_coves=" + nombre_coves + ", estado_coves=" + estado_coves + ", nombre_unidad=" + nombre_unidad + ", nom_sector=" + nom_sector + '}';
    }
   
   
   
}
