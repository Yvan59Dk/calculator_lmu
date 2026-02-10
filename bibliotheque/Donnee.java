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
    /** L'état du fuel durant ce tour */
    public Fuel fuel;
    /** L'état de l'énergie durant ce tour */
    public Energy energy;
    /** Le chrono de ce tour */
    public Chrono chrono;
    /** Le timer à la fin de ce tour */
    public Timer timer;
    /** Si il faut rentrer au stand durant ce tour */
    public boolean stand = false;

    public Donnee(int numTour, Fuel fuel, Energy energy, Chrono chrono, Timer timer, boolean stand){
        this.numTour = numTour;
        this.fuel = fuel;
        this.energy = energy;
        this.chrono = chrono;
        this.timer = timer;
        this.stand = stand;
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
        String res = "";
        res=" | Tour " + this.numTour +
            " | Temps restant : " + this.timer +
            " | Conso : " + this.fuel.getFuel_conso()+ "L " + this.energy.getEnergy_conso()+ "% " +
            " | Actuel : " + toStringDouble(this.fuel.getFuel_actuel()) + "L " + toStringDouble(this.energy.getEnergy_actuel())+ "% "+
            " | " + this.chrono + " | "; 
        if (stand){
            res += "Stand | \n";
        } else {
            res += "      | \n";
        }
        return res;
    }
}
