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
public class Directiva {
    String rut_dirigente;
    String rut_coves;
    String Cargo_dirigente;

    public Directiva(String rut_dirigente, String rut_coves, String Cargo_dirigente) {
        this.rut_dirigente = rut_dirigente;
        this.rut_coves = rut_coves;
        this.Cargo_dirigente = Cargo_dirigente;
    }

    public String getRut_dirigente() {
        return rut_dirigente;
    }

    public void setRut_dirigente(String rut_dirigente) {
        this.rut_dirigente = rut_dirigente;
    }

    public String getRut_coves() {
        return rut_coves;
    }

    public void setRut_coves(String rut_coves) {
        this.rut_coves = rut_coves;
    }

    public String getCargo_dirigente() {
        return Cargo_dirigente;
    }

    public void setCargo_dirigente(String Cargo_dirigente) {
        this.Cargo_dirigente = Cargo_dirigente;
    }

    @Override
    public String toString() {
        return "Directiva{" + "rut_dirigente=" + rut_dirigente + ", rut_coves=" + rut_coves + ", Cargo_dirigente=" + Cargo_dirigente + '}';
    }
    
}
