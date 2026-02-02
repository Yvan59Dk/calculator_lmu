import Temps.*;

public class Donnee {
    public int numTour;
    public double consoFuel;
    public double consoEnergy;
    public Chrono chrono;
    public Timer timer;
    public boolean stand = false;

    public Donnee(int numTour, double consoFuel, double consoEnergy, Chrono chrono, Timer timer, boolean stand){
        this.numTour = numTour;
        this.consoFuel = consoFuel;
        this.consoEnergy = consoEnergy;
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
            " | Conso : " + this.consoFuel + "L " + this.consoEnergy + "% " +
            " | " + this.chrono + " | ";
        if (stand){
            res += "Stand ! | \n";
        } else {
            res += "        | \n";
        }
        return res;
    }
}
