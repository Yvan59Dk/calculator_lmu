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

    /**
     * Fonction calculatoire qui calcul le carburant nécessaire à mettre au stand.
     * @param litreGlobalRequis : double : le litre total qui va être utilisé durant la course
     * @param fuel : Variable de classe Fuel
     * @return le carburant requis.
     */
    public static double fuel_stand(double litreGlobalRequis, Fuel fuel){
        double litreRequis = litreGlobalRequis - fuel.getFuel_actuel();
        if (litreRequis > fuel_rendement(fuel)){
            litreRequis = fuel_rendement(fuel);
        }
        return litreRequis;
    }

    /**
     * Fonction calculatoire qui calcul l'énergie nécessaire à mettre au stand.
     * @param energyGlobalRequis : double : l'énergie total qui va être utilisé durant la course
     * @param energy : Variable de classe Energy
     * @return l'énergie requis
     */
    public static double energy_stand(double energyGlobalRequis, Energy energy){
        double energyRequis = energyGlobalRequis - energy.getEnergy_actuel();
        if (energyRequis > ENERGY_MAX){
            energyRequis = ENERGY_MAX;
        }
        return energyRequis;
    }

    public static Chrono temps_stand(Chrono chrono, double fuelStand, double energyStand){
        return chrono;
    }
}
