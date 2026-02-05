import Temps.*;
import calculator.*;

public class Donnee {
    public int numTour;
    public Fuel fuel;
    public Energy energy;
    public Chrono chrono;
    public Timer timer;
    public boolean stand = false;

    public Donnee(int numTour, Fuel fuel, Energy energy, Chrono chrono, Timer timer, boolean stand){
        this.numTour = numTour;
        this.fuel = fuel;
        this.energy = energy;
        this.chrono = chrono;
        this.timer = timer;
        this.stand = stand;
    }

    public boolean getStand(){
        return stand;
    }

    public String toString(){
        String res = "";
        res =" | Tour " + this.numTour +
            " | Conso : " + this.fuel.getFuel_conso()+ "L " + this.energy.getEnergy_conso()+ "% " +
            " | Actuel : " + this.fuel.getFuel_actuel()+ "L " + this.energy.getEnergy_actuel()+ "% "+
            " | " + this.chrono + " | ";
        if (stand){
            res += "Stand ! | \n";
        } else {
            res += "        | \n";
        }
        return res;
    }
}
