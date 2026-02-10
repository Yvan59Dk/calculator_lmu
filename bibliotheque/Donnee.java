package bibliotheque;
import Temps.*;
import calculator.*;

public class Donnee {
    final static int LIMITDIGIT = 2;

    public int numTour;
    public Fuel fuel;
    public Energy energy;
    public Chrono chrono;
    public Timer timer;
    public boolean stand = false;
    public double fuelStand;
    public double energyStand;

    public Donnee(int numTour, Fuel fuel, Energy energy, Chrono chrono, Timer timer, boolean stand, double fuelStand, double energyStand){
        this.numTour = numTour;
        this.fuel = fuel;
        this.energy = energy;
        this.chrono = chrono;
        this.timer = timer;

        this.stand = stand;
        if (stand){
            this.fuelStand = fuelStand;
            this.energyStand = energyStand;
        }
    }

    public boolean getStand(){
        return stand;
    }

    /**
     * @param d
     * @return
     */
    public static String toStringDouble(double d){
        String[] coco = Double.toString(d/1f).split("\\.");
        if (coco[1].length() > LIMITDIGIT){
            return coco[0] + "." + coco[1].substring(0,LIMITDIGIT);
        } else {
            return coco[0] + "." + coco[1];
        }
    }

    public String toString(){
        String res = " | Tour " + this.numTour +
            " | Temps restant : " + this.timer +
            " | Conso : " + this.fuel.getFuel_conso()+ "L " + this.energy.getEnergy_conso()+ "% " +
            " | Actuel : " + toStringDouble(this.fuel.getFuel_actuel()) + "L " + toStringDouble(this.energy.getEnergy_actuel())+ "% "+
            " | " + this.chrono;
        if (stand){
            res += " | Stand / Fuel : " + toStringDouble(this.fuelStand) + " / Energy : " + toStringDouble(this.energyStand) + " | \n";
        } else {
            res += " |       | \n";
        }
        return res;
    }
}
