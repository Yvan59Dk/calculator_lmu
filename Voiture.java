import Temps.*;
import calculator.*;

public class Voiture {

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

    Chrono chrono;
    Timer tempsRestant;

    public Voiture(int spec){
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

    public Voiture(int spec, double conso_fuel, int M_Chrono, int S_Chrono, int MS_Chrono, int H_temp, int M_temp, int S_temp){
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
        
        this.chrono = new Chrono(M_Chrono, S_Chrono, MS_Chrono);
        this.tempsRestant = new Timer(H_temp, M_temp, S_temp);
        this.nbTour = Central_Service.calcul_nbTour(this.chrono, this.tempsRestant);
    }

    public Voiture(int spec, double conso_fuel, Chrono chrono, Timer timer){
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

        this.chrono = chrono;
        this.tempsRestant = timer;
        this.nbTour = Central_Service.calcul_nbTour(this.chrono, this.tempsRestant);
    }
}
