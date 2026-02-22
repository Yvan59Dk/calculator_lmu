package bibliotheque;
import Temps.*;
import calculator.*;

/** La classe Donnee stocke les données émisent sur un tour et les affiche sous un format rapide 
 * permettant la lecture rapide et efficace pour faire stratégie ou save.
 */
public class Donnee {
    

    /** Le numéro de tour */
    private int numTour;

    /** Le fuel dans le réservoir à la fin du tour */
    private double fuel_actuel;
    /** Le fuel consommé durant le tour */
    private double fuel_conso;

    /** L'énergie dans la voiture à la fin du tour */
    private double energy_actuel;
    /** L'énergie consommé durant le tour */
    private double energy_conso;

    /** Le chrono de ce tour */
    private Chrono chrono;

    /** Le timer à la fin de ce tour */
    private Timer timer;

    /** Si il faut rentrer au stand durant ce tour */
    private boolean stand = false;
    private double fuelStand;
    private double energyStand;

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

    public int getTour(){
        return this.numTour;
    }

    public double getFuel_actuel(){
        return this.fuel_actuel;
    }

    public double getFuel_conso(){
        return this.fuel_conso;
    }

    public double getEnergy_actuel(){
        return this.energy_actuel;
    }

    public double getEnergy_conso(){
        return this.energy_conso;
    }

    public Chrono getChrono(){
        return this.chrono;
    }

    public Timer getTimer(){
        return this.timer;
    }

    /**
     * Retourne si dans ce tour, il faut rentrer au stand.
     * @return boolean
     */
    public boolean getStand(){
        return this.stand;
    }

    /**
     * Fonction retournant le carburant remis au stand
     * @throws IllegalAccessError si il n'y a pas eu de d'arrêt durant ce tour.
     * @return : double : le carburant remis au stand
     */
    public double getFuelStand(){
        if(stand){
            return this.fuelStand;
        } else {
            throw new IllegalAccessError("Accés non autorisé à fuelStand : pas d'arrêt au stand au tour " + this.numTour);
        }
    }

    /**
     * Fonction retournant l'énergie remis au stand
     * @throws IllegalAccessError si il n'y a pas eu de d'arrêt durant ce tour.
     * @return : double : l'énergie remis au stand
     */
    public double getEnergyStand(){
        if(stand){
            return this.energyStand;
        } else {
            throw new IllegalAccessError("Accés non autorisé à energyStand : pas d'arrêt au stand au tour " + this.numTour);
        }
    }

    public String toString(){
        String res = " | Tour " + this.numTour +
            " | Temps restant : " + this.timer +
            " | Conso : " + this.fuel_conso + "L " + this.energy_conso + "% " +
            " | Actuel : " + Convert.toStringDouble(this.fuel_actuel) + "L " + Convert.toStringDouble(this.energy_actuel)+ "% "+
            " | " + this.chrono;
        if (stand){
            res += " | Stand / Fuel : " + Convert.toStringDouble(this.fuelStand) + " / Energy : " + Convert.toStringDouble(this.energyStand) + " | \n";
        } else {
            res += " | R.A.S | \n";
        }
        return res;
    }
}
