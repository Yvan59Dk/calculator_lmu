import Temps.*;
import bibliotheque.Categorie;
import bibliotheque.Circuit;
import calculator.Energy;
import calculator.Fuel;

public class main {
    public static void main(String[] args) {
        Categorie spec = Categorie.HYP;
        Circuit circuit = Circuit.LEMANS;
        
        Fuel fuel = new Fuel(7.42, spec.getFuel_max(), 0.89);
        Energy energy = new Energy(spec.getEnergy_max(), 8.11);
        Chrono chrono = new Chrono(3, 27, 654);
        Timer temps = new Timer(12,0,0);

        Voiture voiture = new Voiture(spec, circuit, fuel, energy, chrono, temps);
        System.out.print(voiture);

        voiture.donneeTourIntervalle(45, -1);
    }
}
