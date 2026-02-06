import java.util.ArrayList;

import Temps.*;
import calculator.*;

public class Voiture {

    // Variable final de l'énergie max
    final static double ENERGY_MAX = 100.0;

    // Variable par Défaut
    final static double DEFAULT_FUEL_CONSO = 2.5;
    final static double DEFAULT_ENERGY_CONSO = 2.75;
    
    /** Spec de Véhicule : HYP, LMP2, LMP3, LMGT3, LMGTE */
    public Categorie spec;

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
        this.fuel = new Fuel(DEFAULT_FUEL_CONSO, this.spec.getFuel_max(), this.spec.getFuel_rendement());
        this.energy = new Energy(this.spec.getEnergy_max(),DEFAULT_ENERGY_CONSO);
        this.nbTour = 0;

        this.chrono = new Chrono(0,0,0);
        this.tempsRestant = new Timer(0, 0, 0);
    }

    public Voiture(Categorie spec, Chrono chrono, Timer timer){
        this.spec = spec;
        this.fuel = new Fuel(DEFAULT_FUEL_CONSO, this.spec.getFuel_max(), this.spec.getFuel_rendement());
        this.energy = new Energy(this.spec.getEnergy_max(),DEFAULT_ENERGY_CONSO);

        this.chrono = chrono;
        this.tempsRestant = timer;
        this.nbTour = Central_Service.calcul_nbTour_théorique(this.chrono, this.tempsRestant);
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
