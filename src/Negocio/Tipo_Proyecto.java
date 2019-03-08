
package Negocio;
/**
 *
 * @author Daniel Barraza
 */
public class Tipo_Proyecto {
    String nro_tipo_proyecto;
    String nombre_tipo_proyecto;

    public Tipo_Proyecto(String nro_tipo_proyecto, String nombre_tipo_proyecto) {
        this.nro_tipo_proyecto = nro_tipo_proyecto;
        this.nombre_tipo_proyecto = nombre_tipo_proyecto;
    }

    public String getNro_tipo_proyecto() {
        return nro_tipo_proyecto;
    }

    public void setNro_tipo_proyecto(String nro_tipo_proyecto) {
        this.nro_tipo_proyecto = nro_tipo_proyecto;
    }

    public String getNombre_tipo_proyecto() {
        return nombre_tipo_proyecto;
    }

    public void setNombre_tipo_proyecto(String nombre_tipo_proyecto) {
        this.nombre_tipo_proyecto = nombre_tipo_proyecto;
    }

    @Override
    public String toString() {
        return "Tipo_Proyecto{" + "nro_tipo_proyecto=" + nro_tipo_proyecto + ", nombre_tipo_proyecto=" + nombre_tipo_proyecto + '}';
    }
    
    
}
