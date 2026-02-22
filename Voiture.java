import java.util.ArrayList;

import Temps.*;
import bibliotheque.*;
import calculator.*;

public class Voiture {

    // Variable final de l'énergie max
    final static double ENERGY_MAX = 100.0;

    // Variable par Défaut
    final static double DEFAULT_FUEL_CONSO = 1.78;
    final static double DEFAULT_ENERGY_CONSO = 2.75;
    
    /** Spec de Véhicule : HYP, LMP2, LMP3, LMGT3, LMGTE */
    public Categorie spec;

    /** Circuit oû est la voiture */
    public Circuit circuit;

    // Variable de Fuel
    public Fuel fuel;

    // Variable d'Energie
    public Energy energy;

    public int nbTour;
    public ArrayList<Donnee> donneesTour;
    public double[] save;

    public Chrono chrono;
    public Timer tempsRestant;

    /*public Voiture(Categorie spec, Circuit circuit){
        this.spec = spec;
        this.circuit = circuit;
        this.fuel = new Fuel(DEFAULT_FUEL_CONSO, this.spec.getFuel_max(), this.spec.getFuel_rendement());
        this.energy = new Energy(spec.getEnergy_max(), DEFAULT_ENERGY_CONSO);
        this.donneesTour = Central_Service.calcul_tour(circuit, fuel, energy, chrono, timer, 0);
        this.nbTour = donneesTour.size();

        this.chrono = new Chrono(0,0,0);
        this.tempsRestant = new Timer(0, 0, 0);
    }*/

    public Voiture(Categorie spec, Circuit circuit, Chrono chrono, Timer timer){
        this.spec = spec;
        this.circuit = circuit;
        this.fuel = new Fuel(DEFAULT_FUEL_CONSO, this.spec.getFuel_max(), this.spec.getFuel_rendement());
        this.energy = new Energy(spec.getEnergy_max(), DEFAULT_ENERGY_CONSO);

        this.chrono = chrono;
        this.tempsRestant = timer;

        this.donneesTour = Central_Service.calcul_tour(circuit, fuel, energy, chrono, timer, 0);
        this.nbTour = donneesTour.size();
    }

    public Voiture(Categorie spec, Circuit circuit, Fuel fuel, Energy energy, Chrono chrono, Timer timer){
        this.spec = spec;
        this.circuit = circuit;
        this.fuel = fuel;
        this.energy = energy;

        this.chrono = chrono;
        this.tempsRestant = timer;

        this.donneesTour = Central_Service.calcul_tour(circuit, fuel, energy, chrono, timer, 0);
        this.nbTour = donneesTour.size();
    }

    public void modifFuel(Fuel fuel){
        this.fuel = fuel;
    }
    public void modifFuelConso(double fuel_conso){
        fuel.MAJ_fuel_conso(fuel_conso);
    }

    public String donneeTour(int nbTourActuel){
        String res = "";
        for(int i = nbTourActuel; i < donneesTour.size()-nbTourActuel; i++){
            res += donneesTour.get(i);
        }
        return res;
    }

    public String toString(){
        String res = " | Catégorie : " + spec.getDescription() + "\n"
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
