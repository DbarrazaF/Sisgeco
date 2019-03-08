
package Negocio;
/**
 *
 * @author Daniel Barraza
 */
public class Actividad {
   int cod_suceso;
   String fecha_suceso;
   String descripcion_suceso;
   String afiche_suceso;
   String rut_coves;
   String rut_funcionario;
   String cod_tipo_suceso;
   String nro_participantes;

    public Actividad(int cod_suceso, String fecha_suceso, String descripcion_suceso, String afiche_suceso, String rut_coves, String rut_funcionario, String cod_tipo_suceso, String nro_participantes) {
        this.cod_suceso = cod_suceso;
        this.fecha_suceso = fecha_suceso;
        this.descripcion_suceso = descripcion_suceso;
        this.afiche_suceso = afiche_suceso;
        this.rut_coves = rut_coves;
        this.rut_funcionario = rut_funcionario;
        this.cod_tipo_suceso = cod_tipo_suceso;
        this.nro_participantes = nro_participantes;
    }

    

    public int getCod_suceso() {
        return cod_suceso;
    }

    public void setCod_suceso(int cod_suceso) {
        this.cod_suceso = cod_suceso;
    }

    public String getFecha_suceso() {
        return fecha_suceso;
    }

    public void setFecha_suceso(String fecha_suceso) {
        this.fecha_suceso = fecha_suceso;
    }

    public String getDescripcion_suceso() {
        return descripcion_suceso;
    }

    public void setDescripcion_suceso(String descripcion_suceso) {
        this.descripcion_suceso = descripcion_suceso;
    }

    public String getAfiche_suceso() {
        return afiche_suceso;
    }

    public void setAfiche_suceso(String afiche_suceso) {
        this.afiche_suceso = afiche_suceso;
    }

    public String getRut_coves() {
        return rut_coves;
    }

    public void setRut_coves(String rut_coves) {
        this.rut_coves = rut_coves;
    }

    public String getRut_funcionario() {
        return rut_funcionario;
    }

    public void setRut_funcionario(String rut_funcionario) {
        this.rut_funcionario = rut_funcionario;
    }

    public String getCod_tipo_suceso() {
        return cod_tipo_suceso;
    }

    public void setCod_tipo_suceso(String cod_tipo_suceso) {
        this.cod_tipo_suceso = cod_tipo_suceso;
    }

    public String getNro_participantes() {
        return nro_participantes;
    }

    public void setNro_participantes(String nro_participantes) {
        this.nro_participantes = nro_participantes;
    }

    @Override
    public String toString() {
        return "Suceso{" + "cod_suceso=" + cod_suceso + ", fecha_suceso=" + fecha_suceso + ", descripcion_suceso=" + descripcion_suceso + ", afiche_suceso=" + afiche_suceso + ", rut_coves=" + rut_coves + ", rut_funcionario=" + rut_funcionario + ", cod_tipo_suceso=" + cod_tipo_suceso + ", nro_participantes=" + nro_participantes + '}';
    }

    
   
}
