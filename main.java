import Temps.*;
import Temps.TempsException.*;
import bibliotheque.*;
import calculator.*;

public class main {
    public static void main(String[] args) {
        try {
            Categorie spec = Categorie.HYP;
            Circuit circuit = Circuit.LEMANS;
            
            Fuel fuel = new Fuel(7.42, spec.getFuel_max(), 0.89);
            Energy energy = new Energy(spec.getEnergy_max(), 8.11);
            Temps chrono = new Temps(3, 27, 654);
            Temps temps = new Temps(12,0,0,0);

            Voiture voiture = new Voiture(spec, circuit, fuel, energy, chrono, temps);
            System.out.print(voiture);

            voiture.donneeTourIntervalle(0, -1);
        } catch (TempsException e) {
            e.printStackTrace();
        }
    }
}
