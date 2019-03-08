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

public class Dirigente {
    String rut_dirigente;
    String nombre_dirigente;
    String apellido_pat_dirigente;
    String apellido_mat_dirigente;
    String nro_casa_dirigente;
    String block_dirigente;
    String depar_dirigente;
    String poblacion_dirigente;
    String telefono_dirigente;
    String email_dirigente;
    String calle_dirigente;
    String cod_sector;

    public Dirigente(String rut_dirigente, String nombre_dirigente, String apellido_pat_dirigente, String apellido_mat_dirigente, String nro_casa_dirigente, String block_dirigente, String depar_dirigente, String poblacion_dirigente, String telefono_dirigente, String email_dirigente, String calle_dirigente, String cod_sector) {
        this.rut_dirigente = rut_dirigente;
        this.nombre_dirigente = nombre_dirigente;
        this.apellido_pat_dirigente = apellido_pat_dirigente;
        this.apellido_mat_dirigente = apellido_mat_dirigente;
        this.nro_casa_dirigente = nro_casa_dirigente;
        this.block_dirigente = block_dirigente;
        this.depar_dirigente = depar_dirigente;
        this.poblacion_dirigente = poblacion_dirigente;
        this.telefono_dirigente = telefono_dirigente;
        this.email_dirigente = email_dirigente;
        this.calle_dirigente = calle_dirigente;
        this.cod_sector = cod_sector;
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

    public String getApellido_pat_dirigente() {
        return apellido_pat_dirigente;
    }

    public void setApellido_pat_dirigente(String apellido_pat_dirigente) {
        this.apellido_pat_dirigente = apellido_pat_dirigente;
    }

    public String getApellido_mat_dirigente() {
        return apellido_mat_dirigente;
    }

    public void setApellido_mat_dirigente(String apellido_mat_dirigente) {
        this.apellido_mat_dirigente = apellido_mat_dirigente;
    }

    public String getNro_casa_dirigente() {
        return nro_casa_dirigente;
    }

    public void setNro_casa_dirigente(String nro_casa_dirigente) {
        this.nro_casa_dirigente = nro_casa_dirigente;
    }

    public String getBlock_dirigente() {
        return block_dirigente;
    }

    public void setBlock_dirigente(String block_dirigente) {
        this.block_dirigente = block_dirigente;
    }

    public String getDepar_dirigente() {
        return depar_dirigente;
    }

    public void setDepar_dirigente(String depar_dirigente) {
        this.depar_dirigente = depar_dirigente;
    }

    public String getPoblacion_dirigente() {
        return poblacion_dirigente;
    }

    public void setPoblacion_dirigente(String poblacion_dirigente) {
        this.poblacion_dirigente = poblacion_dirigente;
    }

    public String getTelefono_dirigente() {
        return telefono_dirigente;
    }

    public void setTelefono_dirigente(String telefono_dirigente) {
        this.telefono_dirigente = telefono_dirigente;
    }

    public String getEmail_dirigente() {
        return email_dirigente;
    }

    public void setEmail_dirigente(String email_dirigente) {
        this.email_dirigente = email_dirigente;
    }

    public String getCalle_dirigente() {
        return calle_dirigente;
    }

    public void setCalle_dirigente(String calle_dirigente) {
        this.calle_dirigente = calle_dirigente;
    }

    public String getCod_sector() {
        return cod_sector;
    }

    public void setCod_sector(String cod_sector) {
        this.cod_sector = cod_sector;
    }

    @Override
    public String toString() {
        return "Dirigente{" + "rut_dirigente=" + rut_dirigente + ", nombre_dirigente=" + nombre_dirigente + ", apellido_pat_dirigente=" + apellido_pat_dirigente + ", apellido_mat_dirigente=" + apellido_mat_dirigente + ", nro_casa_dirigente=" + nro_casa_dirigente + ", block_dirigente=" + block_dirigente + ", depar_dirigente=" + depar_dirigente + ", poblacion_dirigente=" + poblacion_dirigente + ", telefono_dirigente=" + telefono_dirigente + ", email_dirigente=" + email_dirigente + ", calle_dirigente=" + calle_dirigente + ", cod_sector=" + cod_sector + '}';
    }
    
}
