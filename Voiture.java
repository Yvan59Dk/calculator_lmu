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
    public Categorie spec; // 0 = HYP, 1 = LMP2

    // Variable de Fuel
    public Fuel fuel;

    // Variable d'Energie
    public Energy energy;

    public int nbTour;
    public double[] save;

    public Chrono chrono;
    public Timer tempsRestant;

    public Voiture(Categorie spec){
        this.spec = spec;

        if (spec == Categorie.HYP){
            this.fuel = new Fuel(HYP_FUEL_MAX, 2.0, HYP_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else if (spec == Categorie.LMP2){
            this.fuel = new Fuel(LMP2_FUEL_MAX, 2.0, LMP2_FUEL_MAX, 1);
            this.energy = new Energy();
        } else if (spec == Categorie.LMP3){
            this.fuel = new Fuel(LMP3_FUEL_MAX, 2.0, LMP3_FUEL_MAX, 1);
            this.energy = new Energy();
        } else if (spec == Categorie.LMGT3){
            this.fuel = new Fuel(LMGT3_FUEL_MAX, 2.0, LMGT3_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else if (spec == Categorie.LMGTE){
            this.fuel = new Fuel(LMGTE_FUEL_MAX, 2.0, LMGTE_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else {
            throw new IllegalArgumentException(
                "Erreur de Categorie : cette spec n'existe pas. Spec reçu : "+ spec);
        }
        this.nbTour = 0;

        this.chrono = new Chrono(0,0,0);
        this.tempsRestant = new Timer(0, 0, 0);
    }

    public Voiture(Categorie spec, double conso_fuel, int M_Chrono, int S_Chrono, int MS_Chrono, int H_temp, int M_temp, int S_temp){
        this.spec = spec;

        if (spec == Categorie.HYP){
            this.fuel = new Fuel(HYP_FUEL_MAX, conso_fuel, HYP_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else if (spec == Categorie.LMP2){
            this.fuel = new Fuel(LMP2_FUEL_MAX, conso_fuel, LMP2_FUEL_MAX, 1);
            this.energy = new Energy();
        } else if (spec == Categorie.LMP3){
            this.fuel = new Fuel(LMP3_FUEL_MAX, conso_fuel, LMP3_FUEL_MAX, 1);
            this.energy = new Energy();
        } else if (spec == Categorie.LMGT3){
            this.fuel = new Fuel(LMGT3_FUEL_MAX, conso_fuel, LMGT3_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else if (spec == Categorie.LMGTE){
            this.fuel = new Fuel(LMGTE_FUEL_MAX, conso_fuel, LMGTE_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else {
            throw new IllegalArgumentException(
                "Erreur de Categorie : cette spec n'existe pas. Spec reçu : "+ spec);
        }
        
        this.chrono = new Chrono(M_Chrono, S_Chrono, MS_Chrono);
        this.tempsRestant = new Timer(H_temp, M_temp, S_temp);
        this.nbTour = Central_Service.calcul_nbTour_reel(this.chrono, this.tempsRestant);
    }

    public Voiture(Categorie spec, double conso_fuel, Chrono chrono, Timer timer){
        this.spec = spec;

        if (spec == Categorie.HYP){
            this.fuel = new Fuel(HYP_FUEL_MAX, conso_fuel, HYP_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else if (spec == Categorie.LMP2){
            this.fuel = new Fuel(LMP2_FUEL_MAX, conso_fuel, LMP2_FUEL_MAX, 1);
            this.energy = new Energy();
        } else if (spec == Categorie.LMP3){
            this.fuel = new Fuel(LMP3_FUEL_MAX, conso_fuel, LMP3_FUEL_MAX, 1);
            this.energy = new Energy();
        } else if (spec == Categorie.LMGT3){
            this.fuel = new Fuel(LMGT3_FUEL_MAX, conso_fuel, LMGT3_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else if (spec == Categorie.LMGTE){
            this.fuel = new Fuel(LMGTE_FUEL_MAX, conso_fuel, LMGTE_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,ENERGY_MAX);
        } else {
            throw new IllegalArgumentException(
                "Erreur de Categorie : cette spec n'existe pas. Spec reçu : "+ spec);
        }

        this.chrono = chrono;
        this.tempsRestant = timer;
        this.nbTour = Central_Service.calcul_nbTour_reel(this.chrono, this.tempsRestant);
    }

    public String toString(){
        String res = "|| Catégorie : " + spec.getDescription() + "\n"
                    + "|| Chrono : " + chrono + "\n"
                    + "|| Timer : " + tempsRestant + "\n"
                    + "|| nbTour : " + nbTour + "\n"
                    + "-------------------------\n"
                    + "|| -- FUEL -- \n"
                    + fuel
                    + "|| -- ENERGIE -- \n"
                    + energy;
        return res;

    }
}
