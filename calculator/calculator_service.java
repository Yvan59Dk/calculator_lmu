package calculator;
import Temps.*;

public class calculator_service {
    final static double ENERGY_MAX = 100.0;

    /**
     * Fonction calculatoire qui calcul le carburant après l'avoir passer avec le rendement
     * @param fuel : Variable de classe Fuel
     * @return double : le carburant.
     */
    public static double fuel_rendement(Fuel fuel){
        return fuel.fuel_max*fuel.fuel_rendement;
    }

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

    public static Chrono temps_stand(Chrono chrono, double fuelStand, double energyStand){
        return chrono;
    }
}
