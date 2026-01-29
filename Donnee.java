import Temps.*;

public class Donnee {
    int rangSave;
    int numTour;
    double consoFuel;
    double consoEnergy;
    Chrono chrono;
    boolean stand = false;

    public Donnee(int rangSave, int numTour, double consoFuel, double consoEnergy, Chrono chrono, boolean stand){
        this.rangSave = rangSave;
        this.numTour = numTour;
        this.consoFuel = consoFuel;
        this.consoEnergy = consoEnergy;
        this.chrono = chrono;
        this.stand = stand;
    }

    public String toString(){
        String res = "";
        res = "| Save+" + this.rangSave + 
            " | Tour " + this.numTour +
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
