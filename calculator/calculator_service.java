package calculator;
import Temps.*;

/** Classe de Service qui propose des méthodes permettant de faire des calculs plus spécifiques, plus complexe. */
public class calculator_service {
    final static double ENERGY_MAX = 100.0;
    final static double STAND_TEMPSENERGIE = 3.125;

    /**
     * Fonction calculatoire qui calcule le carburant après l'avoir passer avec le rendement
     * @param fuel : Variable de classe Fuel
     * @return double : le carburant.
     */
    public static double fuel_rendement(Fuel fuel){
        return fuel.fuel_max*fuel.fuel_rendement;
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

    /** @deprecated A finir */
    public static Chrono temps_stand(Chrono chrono, double fuelStand, double energyStand){
        return chrono;
    }
}
