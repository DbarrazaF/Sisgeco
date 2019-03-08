
package Negocio;
/**
 *
 * @author Daniel Barraza
 */
public class Tipo_Actividad {
    String cod_tipo_suceso;
    String nombre_tipo_suceso;

    public Tipo_Actividad(String cod_tipo_suceso, String nombre_tipo_suceso) {
        this.cod_tipo_suceso = cod_tipo_suceso;
        this.nombre_tipo_suceso = nombre_tipo_suceso;
    }

    public String getCod_tipo_suceso() {
        return cod_tipo_suceso;
    }

    public void setCod_tipo_suceso(String cod_tipo_suceso) {
        this.cod_tipo_suceso = cod_tipo_suceso;
    }

    public String getNombre_tipo_suceso() {
        return nombre_tipo_suceso;
    }

    public void setNombre_tipo_suceso(String nombre_tipo_suceso) {
        this.nombre_tipo_suceso = nombre_tipo_suceso;
    }

    @Override
    public String toString() {
        return "Tipo_Suceso{" + "cod_tipo_suceso=" + cod_tipo_suceso + ", nombre_tipo_suceso=" + nombre_tipo_suceso + '}';
    }
    
}
