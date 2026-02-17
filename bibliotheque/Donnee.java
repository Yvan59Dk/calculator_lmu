package bibliotheque;
import Temps.*;
import calculator.*;

/** La classe Donnee stocke les données émisent sur un tour et les affiche sous un format rapide 
 * permettant la lecture rapide et efficace pour faire stratégie ou save.
 */
public class Donnee {
    final static int LIMITDIGIT = 2;

    /** Le numéro de tour */
    public int numTour;

    /** Le fuel dans le réservoir à la fin du tour */
    public double fuel_actuel;
    /** Le fuel consommé durant le tour */
    public double fuel_conso;

    /** L'énergie dans la voiture à la fin du tour */
    public double energy_actuel;
    /** L'énergie consommé durant le tour */
    public double energy_conso;

    /** Le chrono de ce tour */
    public Chrono chrono;

    /** Le timer à la fin de ce tour */
    public Timer timer;

    /** Si il faut rentrer au stand durant ce tour */
    public boolean stand = false;
    public double fuelStand;
    public double energyStand;

    public Donnee(int numTour, Fuel fuel, Energy energy, Chrono chrono, Timer timer, boolean stand, double fuelStand, double energyStand){
        this.numTour = numTour;
        this.fuel_actuel = fuel.getFuel_actuel();
        this.fuel_conso = fuel.getFuel_conso();
        this.energy_actuel = energy.getEnergy_actuel();
        this.energy_conso = energy.getEnergy_conso();
        this.chrono = new Chrono(chrono);
        this.timer = new Timer(timer);

        this.stand = stand;
        if (stand || fuelStand != 0 || energyStand != 0){
            this.fuelStand = fuelStand;
            this.energyStand = energyStand;
        }
    }

    /**
     * Retourne si dans ce tour, il faut rentrer au stand.
     * @return boolean
     */
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
            " | Conso : " + this.fuel_conso + "L " + this.energy_conso + "% " +
            " | Actuel : " + toStringDouble(this.fuel_actuel) + "L " + toStringDouble(this.energy_actuel)+ "% "+
            " | " + this.chrono;
        if (stand){
            res += " | Stand / Fuel : " + toStringDouble(this.fuelStand) + " / Energy : " + toStringDouble(this.energyStand) + " | \n";
        } else {
            res += " | R.A.S | \n";
        }
        return res;
    }
}
