package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Equipage.*;
import Temps.*;
import bibliotheque.*;
import calculator.Ressource.Energy;
import calculator.Ressource.Fuel;


/**
 * Classe exclusif s'occupant des calculs des tours avec des Threads.
 */
public class Calcul_Tour implements Runnable {
    public final static double DELTAVAR = 1.001;
    private List<Donnee> res;
    private Categorie spec;
    private Circuit circuit;
    private LineUp lineUp;
    private int indexP;
    private Fuel fuel;
    private Energy energy;
    private Temps timer;
    private Temps chrono;
    
    private int nbTourActuel;

    private boolean choice = false;

    /**
     * Classe exclusif s'occupant des calculs des tours avec des Threads.
     * @param spec : Catégorie : Catégorie du véhicule
     * @param circuit : Circuit : Circuit de la course
     * @param lineUp : LineUp : La lineUp du véhicule
     * @param indexP : int : l'index dans la lineUp du premier pilote à conduire
     * @param fuel : Fuel : le fuel du véhicule
     * @param energy : Energy : l'energy du véhicule
     * @param timer : Temps : Le temps restant de la course
     * @param nbTourActuel : int : le nombre de tour fait
     */
    public Calcul_Tour(Categorie spec, Circuit circuit, LineUp lineUp, int indexP, Fuel fuel, Energy energy, Temps timer, int nbTourActuel){
        this.spec = spec;
        this.circuit = circuit;
        this.lineUp = lineUp;
        this.indexP = indexP;
        this.fuel = fuel.clone();
        this.energy = energy.clone();
        this.timer = timer.clone();
        this.chrono = lineUp.getLineUp().get(indexP).getTempsReference().clone();
    }

    public Calcul_Tour(Categorie spec, Circuit circuit, LineUp lineUp, int indexP, Fuel fuel, Energy energy, Temps timer, int nbTourActuel, boolean choice){
        this.spec = spec;
        this.circuit = circuit;
        this.lineUp = lineUp;
        this.indexP = indexP;
        this.fuel = fuel.clone();
        this.energy = energy.clone();
        this.timer = timer.clone();
        this.chrono = lineUp.getLineUp().get(indexP).getTempsReference().clone();
        this.choice = true;
    }

    public List<Donnee> getResultat(){
        return res;
    }

    @Override
    public void run(){
        ArrayList<Donnee> listeDonnees = new ArrayList<Donnee>();
        // Variable local.
        Temps tempsStand = new Temps();
        double[] refuelStand = {0,0};
        
        boolean stand = false;
        boolean timeStand = false;

        // Tour.
        int i = 0;
        int tour = nbTourActuel;

        while(timer.checkNul()){
            tour = nbTourActuel + i;
            fuel.evolutionFuel();
            energy.evolutionEnergy();
            chrono = LineUp_Service.variationTempsRef(chrono, DELTAVAR);

            if (fuel.getFuel_actuel()-fuel.getFuel_conso() <= 0 
                || energy.getEnergy_actuel()-energy.getEnergy_conso() <= 0){
                refuelStand = Calculator_Service.calcul_refuel_stand(chrono, timer, energy, fuel);
                energy.MAJ_energy_actuel(refuelStand[1]);
                fuel.MAJ_fuel_actuel(refuelStand[0]);

                indexP = (indexP + 1) % lineUp.getLineUp().size();
                chrono = lineUp.getLineUp().get(indexP).getTempsReference().clone();
                fuel.MAJ_fuel_conso(lineUp.getLineUp().get(indexP).getFuel_conso());
                energy.MAJ_energy_conso(lineUp.getLineUp().get(indexP).getEnergy_conso());

                // Temps dans la voie des stands
                tempsStand = new Temps(Calculator_Service.temps_ravitaillement(spec, circuit, refuelStand[0], refuelStand[1]));
                chrono.addTemps(tempsStand);
                timeStand = true;
                stand = true;
            }

            listeDonnees.add(new Donnee(
                        tour,               // Le numéro du tour
                        lineUp.getLineUp().get(indexP),
                        fuel,           // L'état du fuel
                        energy,         // L'état de l'énergie
                        chrono,             // Le chrono du tour en question
                        timer,          // Le timer restant de la course
                        stand,              // Si il faut rentrez au stand
                        refuelStand[0],     // Fuel à remettre au stand
                        refuelStand[1]));   // Energie à mettre au stand

            if (stand){
                stand = false;
            }
            if (timeStand){
                chrono.soustractTemps(tempsStand);
                timeStand = false;
            }

            timer.soustractTemps(chrono);
            i++;
        }
        res = Collections.unmodifiableList(listeDonnees);
    }
}
