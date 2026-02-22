package calculator;
import Temps.*;
import bibliotheque.*;

/** Classe de Service qui propose des méthodes permettant de faire des calculs plus spécifiques, plus complexe. */
public class Calculator_Service {
    final static double ENERGY_MAX = 100.0;
    final static Chrono STAND_TEMPSFUEL = new Chrono(0,3,125);
    final static Chrono STAND_TEMPSENERGIE = new Chrono(0,3,125);

    /**
     * Fonction Calculatoire qui calcule le carburant après l'avoir passer avec le rendement
     * @param fuel : Variable de classe Fuel
     * @return double : le carburant.
     */
    public static double fuel_rendement(Fuel fuel){
        return fuel.getFuel_max()*fuel.getFuel_rendement();
    }

    /**
     * Fonction Calculatoire qui calcule le total de litre utilisé durant l'entiereté de la course.
     * @param fuel : La variable de classe 'Fuel' qui contient les données de voitures en rapport avec le carburant. 
     * @param nbTour : int nombre de tour de la course.
     * @return Le total de litre à utilisé.
     */
    public static double calcul_litreGlobalRequis(Fuel fuel, int nbTour){
        return nbTour*fuel.getFuel_conso();
    }

    /**
     * Fonction Calculatoire qui calcule le litre utilisé sur un tour
     * @param nbTour : int nombre de tour de la course. 
     * @param litreGlobalRequis : le litrage total de la course
     * @return la consommation sur un tour
     */
    public static double calcul_litreParTour(int nbTour, double litreGlobalRequis){
        return litreGlobalRequis/nbTour;
    }

    /**
     * Fonction Calculatoire qui calcule le total d'énergie utilisé durant l'entiereté de la course.
     * @param energy : La variable de classe 'Energy' qui contient les données de voitures en rapport avec l'énergie.
     * @param nbTour : int nombre de tour de la course. 
     * @return Le total d'énergie à utilisé.
     */
    public static double calcul_energyParTour(Energy energy, int nbTour){
        return nbTour+energy.getEnergy_conso();
    }

    /**
     * Fonction Calculatoire qui calcule l'énergie utilisé sur un tour
     * @param nbTour : int nombre de tour de la course.
     * @param energyGlobalRequis : l'énergie total sur la course.
     * @return la consommation sur la tour.
     */
    public static double calcul_energyParTour(int nbTour, double energyGlobalRequis){
        return energyGlobalRequis/nbTour;
    }

    /**
     * Fonction Calculatoire qui calcule et renvois le chrono mis au stand 
     * @param fuelStand : le carburant mis au stand
     * @param energyStand: l'énergie mis au stand
     * @return Chrono du ravitaillement
     */
    public static Chrono temps_ravitaillement(Circuit circuit, double fuelStand, double energyStand){
        Chrono tempsFuelStand = new Chrono(STAND_TEMPSFUEL);
        Chrono tempsEnergyStand = new Chrono(STAND_TEMPSENERGIE);
        tempsFuelStand.multiChrono(fuelStand);
        tempsEnergyStand.multiChrono(energyStand);
        if (tempsFuelStand.getChronoMilli() > tempsEnergyStand.getChronoMilli()){
            tempsFuelStand.somme_temps(circuit.getPitLane());
            return tempsFuelStand;
        } else {
            tempsEnergyStand.somme_temps(circuit.getPitLane());
            return tempsEnergyStand;
        }
    }

    /**
     * Fonction Calculatoire qui calcule le fuel à mettre au stand en fonction du temps restant et du chrono de référence
     * @param chrono : Le chrono de référence
     * @param timer : Le temps restant de la course
     * @param fuel : Variable de classe Fuel
     * @return le carburant à mettre au stand.
     */
    public static double fuel_stand(Chrono chrono, Timer timer, Fuel fuel){
        Fuel fuelTemp = new Fuel(fuel);
        Timer timerTemp = new Timer(timer);
        double fuelStand = 0;
        while(fuelStand < fuelTemp.getFuel_max() && timerTemp.verif()){
            fuelStand += fuelTemp.getFuel_conso();
            timerTemp.diff_Timer_Chrono(timerTemp, chrono);
        }
        if (fuelStand > fuel.getFuel_max()){
            fuelStand = fuel.getFuel_max();
        }
        return fuelStand;
    }

    /**
     * Fonction Calculatoire qui calcule l'énergie à mettre au stand en fonction du temps restant et du chrono de référence
     * @param chrono : Le chrono de référence
     * @param timer : Le temps restant de la course
     * @param fuel : Variable de classe Energie
     * @return l'énergie à mettre au stand.
     */
    public static double energy_stand(Chrono chrono, Timer timer, Energy energy){
        if (energy.getEnergy_conso() != 0){
            Energy energyTemp = new Energy(energy);
            Timer timerTemp = new Timer(timer);
            double energyStand = 0;
            while(energyStand < ENERGY_MAX && timerTemp.verif()){
                energyStand += energyTemp.getEnergy_conso();
                timerTemp.diff_Timer_Chrono(timerTemp, chrono);
            }
            if (energyStand > ENERGY_MAX){
                energyStand = ENERGY_MAX;
            }   
            return energyStand;
        } else {
            return 100;
        }
    }
}
