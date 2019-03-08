
package Negocio;
/**
 *
 * @author Daniel Barraza
 */
public class Unidad_Vecinal {
    String cod_unidad;
    String nombre_unidad;

    public String getCod_unidad() {
        return cod_unidad;
    }

    public void setCod_unidad(String cod_unidad) {
        this.cod_unidad = cod_unidad;
    }

    public String getNombre_unidad() {
        return nombre_unidad;
    }

    public void setNombre_unidad(String nombre_unidad) {
        this.nombre_unidad = nombre_unidad;
    }

    public String getCod_sector() {
        return cod_sector;
    }

    public void setCod_sector(String cod_sector) {
        this.cod_sector = cod_sector;
    }

    public Unidad_Vecinal(String cod_unidad, String nombre_unidad, String cod_sector) {
        this.cod_unidad = cod_unidad;
        this.nombre_unidad = nombre_unidad;
        this.cod_sector = cod_sector;
    }
    String cod_sector;

    @Override
    public String toString() {
        return "Unidad_Vecinal{" + "cod_unidad=" + cod_unidad + ", nombre_unidad=" + nombre_unidad + ", cod_sector=" + cod_sector + '}';
    }





}



   