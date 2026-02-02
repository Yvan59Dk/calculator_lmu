package calculator;

public class calculator_service {
    final static double ENERGY_MAX = 100.0;

    public static double fuel_rendement(Fuel fuel){
        return fuel.fuel_max/fuel.fuel_rendement;
    }

    public static double fuel_stand(double litreGlobalRequis, Fuel fuel){
        double litreRequis = litreGlobalRequis - fuel.getFuel_actuel();
        if (litreRequis > fuel_rendement(fuel)){
            litreRequis = fuel_rendement(fuel);
        }
        return litreRequis;
    }

    public static double energy_stand(double energyGlobalRequis, Energy energy){
        double energyRequis = energyGlobalRequis - energy.getEnergy_actuel();
        if (energyRequis > ENERGY_MAX){
            energyRequis = ENERGY_MAX;
        }
        return energyRequis;
    }
}
