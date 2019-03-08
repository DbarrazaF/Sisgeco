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
public class Control_Proyecto {
    String ano_postulacion_proyecto;
    String nro_ingreso_proyecto;
    String nombre_tipo_proyecto;

    public Control_Proyecto(String ano_postulacion_proyecto, String nro_ingreso_proyecto, String nombre_tipo_proyecto) {
        this.ano_postulacion_proyecto = ano_postulacion_proyecto;
        this.nro_ingreso_proyecto = nro_ingreso_proyecto;
        this.nombre_tipo_proyecto = nombre_tipo_proyecto;
    }

    public String getAno_postulacion_proyecto() {
        return ano_postulacion_proyecto;
    }

    public void setAno_postulacion_proyecto(String ano_postulacion_proyecto) {
        this.ano_postulacion_proyecto = ano_postulacion_proyecto;
    }

    public String getNro_ingreso_proyecto() {
        return nro_ingreso_proyecto;
    }

    public void setNro_ingreso_proyecto(String nro_ingreso_proyecto) {
        this.nro_ingreso_proyecto = nro_ingreso_proyecto;
    }

    public String getNombre_tipo_proyecto() {
        return nombre_tipo_proyecto;
    }

    public void setNombre_tipo_proyecto(String nombre_tipo_proyecto) {
        this.nombre_tipo_proyecto = nombre_tipo_proyecto;
    }

    @Override
    public String toString() {
        return "Control_Proyecto{" + "ano_postulacion_proyecto=" + ano_postulacion_proyecto + ", nro_ingreso_proyecto=" + nro_ingreso_proyecto + ", nombre_tipo_proyecto=" + nombre_tipo_proyecto + '}';
    }
    
    
    
    
}
