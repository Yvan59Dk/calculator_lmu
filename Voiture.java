import java.util.Iterator;
import java.util.List;

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
    public List<Donnee> donneesTour;
    public double[] save;

    public Chrono chrono;
    public Timer tempsRestant;

    public Voiture(Categorie spec, Circuit circuit, Chrono chrono, Timer timer){
        this.spec = spec;
        this.circuit = circuit;
        this.fuel = new Fuel(DEFAULT_FUEL_CONSO, this.spec.getFuel_max(), this.spec.getFuel_rendement());
        this.energy = new Energy(spec.getEnergy_max(), DEFAULT_ENERGY_CONSO);

        this.chrono = chrono;
        this.tempsRestant = timer;

        this.donneesTour = Central_Service.calcul_tour(spec, circuit, fuel, energy, chrono, timer, 0);
        this.nbTour = donneesTour.size();
    }

    public Voiture(Categorie spec, Circuit circuit, Fuel fuel, Energy energy, Chrono chrono, Timer timer){
        this.spec = spec;
        this.circuit = circuit;
        this.fuel = fuel;
        this.energy = energy;

        this.chrono = chrono;
        this.tempsRestant = timer;

        this.donneesTour = Central_Service.calcul_tour(spec, circuit, fuel, energy, chrono, timer, 0);
        this.nbTour = donneesTour.size();
    }

    public void modifFuel(Fuel fuel){
        this.fuel = fuel;
    }
    public void modifFuelConso(double fuel_conso){
        fuel.MAJ_fuel_conso(fuel_conso);
    }

    public void donneeTour(){
        for(Iterator<Donnee> it = donneesTour.iterator(); it.hasNext();){
            System.out.print(it.next());
        }
    }

    public void donneeTourIntervalle(int debut, int fin){
        if (debut < 0 || donneesTour.size() < debut || fin < 0 || donneesTour.size() < fin ){
            throw new IllegalArgumentException("Problème d'intervalle dans les tours demandées. Argument reçu : debut = " + debut + ", fin = " + fin);
        } else {
            for(int i = debut; i <= fin; i++){
                System.out.print(donneesTour.get(i));
            }
        }
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
