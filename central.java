import Temps.Chrono;
import Temps.Timer;
import calculator.Energy;
import calculator.Fuel;
import Temps.Temps;

public class central implements Interface_Central {
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
    Fuel fuel;

    // Variable d'Energie
    Energy energy;

    double nbTour;
    double[] save;

    Temps chrono;
    Temps tempsRestant;

    public central(int spec){
        this.spec = spec;

        if (spec == 1){
            this.fuel = new Fuel(HYP_FUEL_MAX,  2.0, HYP_FUEL_MAX, 0.84 );
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else if (spec == 2){
            this.fuel = new Fuel(LMP2_FUEL_MAX, 2.0, LMP2_FUEL_MAX, 1);
            this.energy = new Energy();
        } else {
            System.out.printf("ERROR : pas de spec");
        }
        this.nbTour = 0;

        this.chrono = new Chrono(0,0,0);
        this.tempsRestant = new Timer(0, 0, 0);
    }

    public central(int spec, double conso_fuel, int M_Chrono, int S_Chrono, int MS_Chrono, int H_temp, int M_temp, int S_temp){
        this.spec = spec;

        if (spec == 1){
            this.fuel = new Fuel(HYP_FUEL_MAX,  conso_fuel, HYP_FUEL_MAX, 0.84 );
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else if (spec == 2){
            this.fuel = new Fuel(LMP2_FUEL_MAX, conso_fuel, LMP2_FUEL_MAX, 1);
            this.energy = new Energy();
        } else {
            System.out.printf("ERROR : pas de spec");
        }
        this.nbTour = 0;

        this.chrono = new Chrono(M_Chrono, S_Chrono, MS_Chrono);
        this.tempsRestant = new Timer(H_temp, M_temp, S_temp);
    }

    public central(int spec, double conso_fuel, Chrono chrono, Timer timer){
        this.spec = spec;

        if (spec == 1){
            this.fuel = new Fuel(HYP_FUEL_MAX,  conso_fuel, HYP_FUEL_MAX, 0.84 );
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else if (spec == 2){
            this.fuel = new Fuel(LMP2_FUEL_MAX, conso_fuel, LMP2_FUEL_MAX, 1);
            this.energy = new Energy();
        } else {
            System.out.printf("ERROR : pas de spec");
        }
        this.nbTour = 0;

        this.chrono = chrono;
        this.tempsRestant = timer;
    }

    

    /**
     * Met à jour le chrono de référence de la voiture ( peut être son meilleur ou son moyen sur 5 tours )
     * @param m : minutes
     * @param s : secondes
     * @param ms : millisecondes
     */
    public void MAJ_chrono(int m, int s, int ms){
        this.chrono.MAJ_temps(m, s, ms);
    }
    /**
     * Met à jour le temps restant de la course
     * @param h : heures
     * @param m : minutes
     * @param s : secondes
     */
    public void MAJ_tempsRestant(int h, int m, int s){
        this.tempsRestant.MAJ_temps(h, m, s);
    }

    public int calcul_nbTour(){
        return 1;
    }

    public void refuel_stand(){
        return;
    }

    public void calcul_save(int limite){
        return;
    }

    public String toString(){
        return "test";
    }

}
