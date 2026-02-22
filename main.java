import Temps.*;
import bibliotheque.Categorie;
import bibliotheque.Circuit;
import calculator.Energy;
import calculator.Fuel;

public class main {
    public static void main(String[] args) {
        Categorie spec = Categorie.LMP2_WEC;
        Circuit circuit = Circuit.LEMANS;
        
        Fuel fuel = new Fuel(3.17, spec.getFuel_max(), 0);
        Energy energy = new Energy(0, 0);
        Chrono chrono = new Chrono(3, 32, 200);
        Timer temps = new Timer(12,0,0);

        Voiture voiture = new Voiture(spec, circuit, fuel, energy, chrono, temps);
        System.out.print(voiture);

        System.out.print(voiture.donneeTour(0));
    }
}
