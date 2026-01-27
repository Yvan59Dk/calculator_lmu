import Temps.Forme_Chrono;
import Temps.Forme_Temps;
import Temps.Temps;

public class Central_service implements Interface_Central_service {
    // Variable final de l'énergie max
    final static double ENERGY_MAX = 100.0;

    // Variable final des réservoirs de chacune des catégories
    final static double HYP_FUEL_MAX = 120.0;
    final static double LMP2_FUEL_MAX = 75.0;
    final static double LMP3_FUEL_MAX = 100.0;
    final static double LMGT3_FUEL_MAX = 100.0;
    final static double LMGTE_FUEL_MAX = 99.0;
    
    // Spec de véhicule
    int spec = 0; // 1 = HYP, 2 = LMP2

    // Variable de Fuel
    double fuel_conso;
    double fuel_actuel;
    double fuel_max;
    double fuel_rendement;

    // Variable d'Energie
    double energy_actuel;
    double energy_conso;

    double nbTour;
    double[] save;

    Temps chrono;
    Temps tempsRestant;

    Central_service(int spec){
        this.spec = spec;

        this.fuel_conso = 2.0; // Valeur de base
        if (spec == 1){
            this.fuel_max = HYP_FUEL_MAX;
        } else if (spec == 2){
            this.fuel_max = LMP2_FUEL_MAX;
            this.fuel_rendement = 1;
        } else {
            System.out.printf("ERROR : pas de spec");
        }
        this.nbTour = 0;

        this.chrono = new Forme_Chrono(0,0,0);
        this.tempsRestant = new Forme_Temps(0, 0, 0);
    }

    Central_service(int spec, double conso_fuel, int M_Chrono, int S_Chrono, int MS_Chrono, int H_temp, int M_temp, int S_temp){
        this.spec = spec;

        this.fuel_conso = conso_fuel; // Valeur de base
        if (spec == 1){
            this.fuel_max = HYP_FUEL_MAX;
        } else if (spec == 2){
            this.fuel_max = LMP2_FUEL_MAX;
        } else {
            System.out.printf("ERROR : pas de spec");
        }
        this.nbTour = 0;

        this.chrono = new Forme_Chrono(M_Chrono, S_Chrono, MS_Chrono);
        this.tempsRestant = new Forme_Temps(H_temp, M_temp, S_temp);
    }

    /**
     * Met à jour la valeur de fuel dans le réservoir de la voiture
     * @param fuel_actuel : double qui devient la nouvelle valeur dans le réservoir
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
     * Si 0, on part du principe que c'est une voiture qui n'a pas d'energie ( une LMP2 )
     * @param fuel_conso : double qui devient la nouvelle valeur de consommation de carburant 
     */
    public void MAJ_fuel_rendement(double fuel_rendement){
        if (energy_actuel == 0){
            return;
        } else {
            this.fuel_rendement = fuel_rendement;
        }
    }
    
    public void MAJ_energy_actuel(double energy_actuel){
        if (0 >= energy_actuel || energy_actuel >= ENERGY_MAX){
            throw new IllegalArgumentException(
                "Erreur d'énergie : l'énergie doit être compris entre 0 et " + ENERGY_MAX 
                + " ( Energie reçu : " + energy_actuel + " )");
        } 
        this.energy_actuel = energy_actuel;
    }
    public void MAJ_energy_conso(double energy_conso){
        this.energy_conso = energy_conso;
    }

    public void MAJ_chrono(int m, int s, int ms){
        this.chrono.MAJ_temps(m, s, ms);
    }
    public void MAJ_tempsRestant(int h, int m, int ms){
        this.tempsRestant.MAJ_temps(h, m, ms);
    }
}
