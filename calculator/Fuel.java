package calculator;
public class Fuel {

    // Variable de Fuel
    double fuel_conso;      // Consommation de carburant par tour
    double fuel_actuel;     // Carburant dans la voiture
    double fuel_max;        // Capacité de carburant max du véhicule
    double fuel_rendement;  // Rendement Carburant/Energy

    public Fuel(double fuel_actuel, double fuel_conso, double fuel_max, double fuel_rendement){
        this.fuel_actuel = fuel_actuel;
        this.fuel_conso = fuel_conso;
        this.fuel_rendement = fuel_rendement;
        this.fuel_actuel = fuel_actuel;
    }

    /**
     * Met à jour la valeur de fuel dans le réservoir de la voiture
     * @param fuel_actuel : double qui devient la nouvelle valeur de carburant dans la voiture
     * @throws IllegalArgumentException si le paramétre n'est pas contenu entre 0 et le réservoir max
    */
    public void MAJ_fuel_actuel(double fuel_actuel){
        if (0 > fuel_actuel || fuel_actuel > fuel_max){
            throw new IllegalArgumentException(
                "Erreur de carburant : le carburant doit être compris entre 0 et " + fuel_max 
                + " ( Carburant reçu : " + fuel_actuel + " )");
        } 
        this.fuel_actuel = fuel_actuel;
    }
    /**
     * Met à jour la valeur de consommation de carburant
     * @param fuel_conso : double qui devient la nouvelle valeur de consommation de carburant 
     */
    public void MAJ_fuel_conso(double fuel_conso){
        this.fuel_conso = fuel_conso;
    }
    /**
     * Met à jour la valeur de consommation de carburant.
     * Si energy_actuel = 0, on part du principe que c'est une voiture qui n'a pas d'energie ( une LMP2 )
     * @param fuel_conso : double qui devient la nouvelle valeur de consommation de carburant 
     */
    public void MAJ_fuel_rendement(double fuel_rendement){
        this.fuel_rendement = fuel_rendement;
    }
}
