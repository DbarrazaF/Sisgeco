
package Negocio;
/**
 *
 * @author Daniel Barraza
 */
public class Sector {
   String cod_sector;
   String nom_sector;

    public Sector(String cod_sector, String nom_sector) {
        this.cod_sector = cod_sector;
        this.nom_sector = nom_sector;
    }

    public String getCod_sector() {
        return cod_sector;
    }

    public void setCod_sector(String cod_sector) {
        this.cod_sector = cod_sector;
    }

    public String getNom_sector() {
        return nom_sector;
    }

    public void setNom_sector(String nom_sector) {
        this.nom_sector = nom_sector;
    }

    @Override
    public String toString() {
        return "Sector{" + "cod_sector=" + cod_sector + ", nom_sector=" + nom_sector + '}';
    }
   
}
