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
public class Funcionario {
   String rut_funcionario;
   String nombre_funcionario;
   String apell_pat_funcionario;
   String apell_mat_funcionario;
   String contra_funcionario;
   String tipo_funcionario;
   String estado_funcionario;

    public Funcionario(String rut_funcionario, String nombre_funcionario, String apell_pat_funcionario, String apell_mat_funcionario, String contra_funcionario, String tipo_funcionario, String estado_funcionario) {
        this.rut_funcionario = rut_funcionario;
        this.nombre_funcionario = nombre_funcionario;
        this.apell_pat_funcionario = apell_pat_funcionario;
        this.apell_mat_funcionario = apell_mat_funcionario;
        this.contra_funcionario = contra_funcionario;
        this.tipo_funcionario = tipo_funcionario;
        this.estado_funcionario = estado_funcionario;
    }

    public String getRut_funcionario() {
        return rut_funcionario;
    }

    public void setRut_funcionario(String rut_funcionario) {
        this.rut_funcionario = rut_funcionario;
    }

    public String getNombre_funcionario() {
        return nombre_funcionario;
    }

    public void setNombre_funcionario(String nombre_funcionario) {
        this.nombre_funcionario = nombre_funcionario;
    }

    public String getApell_pat_funcionario() {
        return apell_pat_funcionario;
    }

    public void setApell_pat_funcionario(String apell_pat_funcionario) {
        this.apell_pat_funcionario = apell_pat_funcionario;
    }

    public String getApell_mat_funcionario() {
        return apell_mat_funcionario;
    }

    public void setApell_mat_funcionario(String apell_mat_funcionario) {
        this.apell_mat_funcionario = apell_mat_funcionario;
    }

    public String getContra_funcionario() {
        return contra_funcionario;
    }

    public void setContra_funcionario(String contra_funcionario) {
        this.contra_funcionario = contra_funcionario;
    }

    public String getTipo_funcionario() {
        return tipo_funcionario;
    }

    public void setTipo_funcionario(String tipo_funcionario) {
        this.tipo_funcionario = tipo_funcionario;
    }

    public String getEstado_funcionario() {
        return estado_funcionario;
    }

    public void setEstado_funcionario(String estado_funcionario) {
        this.estado_funcionario = estado_funcionario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "rut_funcionario=" + rut_funcionario + ", nombre_funcionario=" + nombre_funcionario + ", apell_pat_funcionario=" + apell_pat_funcionario + ", apell_mat_funcionario=" + apell_mat_funcionario + ", contra_funcionario=" + contra_funcionario + ", tipo_funcionario=" + tipo_funcionario + ", estado_funcionario=" + estado_funcionario + '}';
    }



}