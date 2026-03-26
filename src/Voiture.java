import java.util.List;

import Temps.*;
import bibliotheque.*;
import calculator.*;
import Equipage.*;

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

    // Variable pour la LineUp
    public LineUp lineUp;

    public int nbTour;
    public List<Donnee> donneesTour;
    public double[] save;

    public Temps chrono;
    public Temps tempsRestant;

    public Voiture(Categorie spec, LineUp lineUp, Circuit circuit, Temps chrono, Temps timer){
        this.spec = spec;
        this.circuit = circuit;
        this.fuel = new Fuel(DEFAULT_FUEL_CONSO, this.spec.getFuel_max(), this.spec.getFuel_rendement());
        this.energy = new Energy(spec.getEnergy_max(), DEFAULT_ENERGY_CONSO);
        this.lineUp = lineUp;

        this.chrono = chrono;
        this.tempsRestant = timer;

        this.donneesTour = Central_Service.calcul_tour(spec, lineUp, circuit, fuel, energy, timer, 0);
        this.nbTour = donneesTour.size()-1;
    }

    public Voiture(Categorie spec, LineUp lineUp, Circuit circuit, Fuel fuel, Energy energy, Temps chrono, Temps timer){
        this.spec = spec;
        this.circuit = circuit;
        this.fuel = fuel;
        this.energy = energy;
        this.lineUp = lineUp;

        this.chrono = chrono;
        this.tempsRestant = timer;

        this.donneesTour = Central_Service.calcul_tour(spec, lineUp, circuit, fuel, energy, timer, 0);
        this.nbTour = donneesTour.size()-1;
    }

    public void modifFuel(Fuel fuel){
        this.fuel = fuel;
    }
    public void modifFuelConso(double fuel_conso){
        fuel.MAJ_fuel_conso(fuel_conso);
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
