
package Negocio;
/**
 *
 * @author Daniel Barraza
 */
public class Coves {
    String rut_coves;
    String nombre_coves;
    String estado_coves;
    String cod_unidad;
    String ano_coves;
    String direccion_coves;
    String telefono_coves;

    public Coves(String rut_coves, String nombre_coves, String estado_coves, String cod_unidad, String ano_coves, String direccion_coves, String telefono_coves) {
        this.rut_coves = rut_coves;
        this.nombre_coves = nombre_coves;
        this.estado_coves = estado_coves;
        this.cod_unidad = cod_unidad;
        this.ano_coves = ano_coves;
        this.direccion_coves = direccion_coves;
        this.telefono_coves = telefono_coves;
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

    public String getCod_unidad() {
        return cod_unidad;
    }

    public void setCod_unidad(String cod_unidad) {
        this.cod_unidad = cod_unidad;
    }

    public String getAno_coves() {
        return ano_coves;
    }

    public void setAno_coves(String ano_coves) {
        this.ano_coves = ano_coves;
    }

    public String getDireccion_coves() {
        return direccion_coves;
    }

    public void setDireccion_coves(String direccion_coves) {
        this.direccion_coves = direccion_coves;
    }

    public String getTelefono_coves() {
        return telefono_coves;
    }

    public void setTelefono_coves(String telefono_coves) {
        this.telefono_coves = telefono_coves;
    }

    @Override
    public String toString() {
        return "Coves{" + "rut_coves=" + rut_coves + ", nombre_coves=" + nombre_coves + ", estado_coves=" + estado_coves + ", cod_unidad=" + cod_unidad + ", ano_coves=" + ano_coves + ", direccion_coves=" + direccion_coves + ", telefono_coves=" + telefono_coves + '}';
    }

    
    
    
}