package calculator;

public class Energy {
    // Variable final de l'énergie max
    final public static double ENERGY_MAX = 100.0;

    /*** Energie dispo dans la voiture */
    public double energy_actuel;
    /*** Consommation d'énergie par tour */
    public double energy_conso;

    public Energy(){        // Cas si pas d'énergie dans la catégorie
        this.energy_actuel = 0;
        this.energy_conso = 0;
    }

    public Energy(double energy_actuel, double energy_conso){
        this.energy_actuel = energy_actuel;
        this.energy_conso = energy_conso;
    }

    public Energy(Energy energy){
        this.energy_actuel = energy.energy_actuel;
        this.energy_conso = energy.energy_conso;
    }

    public double getEnergy_actuel(){
        return energy_actuel;
    }
    public double getEnergy_conso(){
        return energy_conso;
    }

    /**
     * Met à jour la valeur actuelle d'energie disponible dans la voiture
     * @param energy_actuel : double qui devient la nouvelle valeur d'énergie dans la voiture
     * @throws IllegalArgumentException si le paramétre n'est pas contenu entre 0 et 100
     */
    public void MAJ_energy_actuel(double energy_actuel){
        if (0 >= energy_actuel || energy_actuel >= ENERGY_MAX){
            throw new IllegalArgumentException(
                "Erreur d'énergie : l'énergie doit être compris entre 0 et " + ENERGY_MAX 
                + " ( Energie reçu : " + energy_actuel + " )");
        } 
        this.energy_actuel = energy_actuel;
    }
    /**
     * Met à jour la consommation d'energie
     * @param energy_conso : double qui devient la nouvelle valeur de consommation d'energie
     */
    public void MAJ_energy_conso(double energy_conso){
        this.energy_conso = energy_conso;
    }
}
