
package Negocio;
/**
 *
 * @author Daniel Barraza
 */
public class Decreto {
    String nro_decreto;
    String fecha_decreto;
    String fecha_retiro_cheque_decreto;
    String retira_cheque_decreto;
    String ano_postu_proyecto;
    String nro_ingreso_proyecto;
    String Estado_decreto;

    public Decreto(String nro_decreto, String fecha_decreto, String fecha_retiro_cheque_decreto, String retira_cheque_decreto, String ano_postu_proyecto, String nro_ingreso_proyecto, String Estado_decreto) {
        this.nro_decreto = nro_decreto;
        this.fecha_decreto = fecha_decreto;
        this.fecha_retiro_cheque_decreto = fecha_retiro_cheque_decreto;
        this.retira_cheque_decreto = retira_cheque_decreto;
        this.ano_postu_proyecto = ano_postu_proyecto;
        this.nro_ingreso_proyecto = nro_ingreso_proyecto;
        this.Estado_decreto = Estado_decreto;
    }

    
    
    
    
    
    public String getEstado_decreto() {
        return Estado_decreto;
    }

    public void setEstado_decreto(String Estado_decreto) {
        this.Estado_decreto = Estado_decreto;
    }

  

    public String getNro_decreto() {
        return nro_decreto;
    }

    public void setNro_decreto(String nro_decreto) {
        this.nro_decreto = nro_decreto;
    }

    public String getFecha_decreto() {
        return fecha_decreto;
    }

    public void setFecha_decreto(String fecha_decreto) {
        this.fecha_decreto = fecha_decreto;
    }

    public String getFecha_retiro_cheque_decreto() {
        return fecha_retiro_cheque_decreto;
    }

    public void setFecha_retiro_cheque_decreto(String fecha_retiro_cheque_decreto) {
        this.fecha_retiro_cheque_decreto = fecha_retiro_cheque_decreto;
    }

    public String getRetira_cheque_decreto() {
        return retira_cheque_decreto;
    }

    public void setRetira_cheque_decreto(String retira_cheque_decreto) {
        this.retira_cheque_decreto = retira_cheque_decreto;
    }

    public String getAno_postu_proyecto() {
        return ano_postu_proyecto;
    }

    public void setAno_postu_proyecto(String ano_postu_proyecto) {
        this.ano_postu_proyecto = ano_postu_proyecto;
    }

    public String getNro_ingreso_proyecto() {
        return nro_ingreso_proyecto;
    }

    public void setNro_ingreso_proyecto(String nro_ingreso_proyecto) {
        this.nro_ingreso_proyecto = nro_ingreso_proyecto;
    }

    @Override
    public String toString() {
        return "Decreto{" + "nro_decreto=" + nro_decreto + ", fecha_decreto=" + fecha_decreto + ", fecha_retiro_cheque_decreto=" + fecha_retiro_cheque_decreto + ", retira_cheque_decreto=" + retira_cheque_decreto + ", ano_postu_proyecto=" + ano_postu_proyecto + ", nro_ingreso_proyecto=" + nro_ingreso_proyecto + ", Estado_decreto=" + Estado_decreto + '}';
    }

    
    
    
    
}
