import java.util.ArrayList;

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

    // Variable par Défaut
    final static double DEFAULT_FUEL_CONSO = 2.5;
    final static double DEFAULT_ENERGY_CONSO = 2.75;
    
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
            this.fuel = new Fuel(HYP_FUEL_MAX, DEFAULT_FUEL_CONSO, HYP_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,DEFAULT_ENERGY_CONSO);
        } else if (spec == Categorie.LMP2){
            this.fuel = new Fuel(LMP2_FUEL_MAX, DEFAULT_FUEL_CONSO, LMP2_FUEL_MAX, 1);
            this.energy = new Energy();
        } else if (spec == Categorie.LMP3){
            this.fuel = new Fuel(LMP3_FUEL_MAX, DEFAULT_FUEL_CONSO, LMP3_FUEL_MAX, 1);
            this.energy = new Energy();
        } else if (spec == Categorie.LMGT3){
            this.fuel = new Fuel(LMGT3_FUEL_MAX, DEFAULT_FUEL_CONSO, LMGT3_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,DEFAULT_ENERGY_CONSO);
        } else if (spec == Categorie.LMGTE){
            this.fuel = new Fuel(LMGTE_FUEL_MAX, DEFAULT_FUEL_CONSO, LMGTE_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,DEFAULT_ENERGY_CONSO);
        } else {
            throw new IllegalArgumentException(
                "Erreur de Categorie : cette spec n'existe pas. Spec reçu : "+ spec);
        }
        this.nbTour = 0;

        this.chrono = new Chrono(0,0,0);
        this.tempsRestant = new Timer(0, 0, 0);
    }

    public Voiture(Categorie spec, Chrono chrono, Timer timer){
        this.spec = spec;

        if (spec == Categorie.HYP){
            this.fuel = new Fuel(HYP_FUEL_MAX, DEFAULT_FUEL_CONSO, HYP_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,DEFAULT_ENERGY_CONSO);
        } else if (spec == Categorie.LMP2){
            this.fuel = new Fuel(LMP2_FUEL_MAX, DEFAULT_FUEL_CONSO, LMP2_FUEL_MAX, 1);
            this.energy = new Energy();
        } else if (spec == Categorie.LMP3){
            this.fuel = new Fuel(LMP3_FUEL_MAX, DEFAULT_FUEL_CONSO, LMP3_FUEL_MAX, 1);
            this.energy = new Energy();
        } else if (spec == Categorie.LMGT3){
            this.fuel = new Fuel(LMGT3_FUEL_MAX, DEFAULT_FUEL_CONSO, LMGT3_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,DEFAULT_ENERGY_CONSO);
        } else if (spec == Categorie.LMGTE){
            this.fuel = new Fuel(LMGTE_FUEL_MAX, DEFAULT_FUEL_CONSO, LMGTE_FUEL_MAX, 0.84);
            this.energy = new Energy(ENERGY_MAX,DEFAULT_ENERGY_CONSO);
        } else {
            throw new IllegalArgumentException(
                "Erreur de Categorie : cette spec n'existe pas. Spec reçu : "+ spec);
        }
        this.chrono = chrono;
        this.tempsRestant = timer;
        this.nbTour = Central_Service.calcul_nbTour_reel(this.chrono, this.tempsRestant);
    }

    public String donneeTour(int nbTourActuel){
        double litreGlobalRequis = Central_Service.calcul_litreGlobalRequis(fuel, nbTour);
        ArrayList<Donnee> save = Central_Service.calcul_tour(fuel, energy, chrono, tempsRestant, nbTourActuel, nbTour, litreGlobalRequis);
        String res = "";
        for(int i = nbTourActuel; i < save.size()-nbTourActuel; i++){
            res += save.get(i);
        }
        return res;
    }

    public String toString(){
        String res = "| Catégorie : " + spec.getDescription() + "\n"
                    + "| Chrono : " + chrono + "\n"
                    + "| Timer : " + tempsRestant + "\n"
                    + "| nbTour : " + nbTour + "\n"
                    + "-------------------------\n"
                    + "| -- FUEL -- \n"
                    + fuel
                    + "| -- ENERGIE -- \n"
                    + energy;
        return res;
    }
}
