import Temps.*;
import Temps.TempsException.*;
import bibliotheque.*;
import calculator.*;
import Equipage.*;

public class main {
    public static void main(String[] args) {
        try {
            Categorie spec = Categorie.HYP;
            Circuit circuit = Circuit.LEMANS;

            Pilote pilotYvan = new Pilote("Yvan","Znat",new Temps(3, 27, 0), new Temps(3,30,0));
            Pilote pilotGawad = new Pilote("Gawad", "Simeon", new Temps(3,31,0), new Temps(3,32,865));
            LineUp lineUp = new LineUp(pilotYvan, pilotGawad);
            
            Fuel fuel = new Fuel(7.42, spec.getFuel_max(), 0.89);
            Energy energy = new Energy(spec.getEnergy_max(), 8.11);
            Temps chrono = new Temps(3, 27, 654);
            Temps temps = new Temps(24,0,0,0);

            Voiture voiture = new Voiture(spec, lineUp, circuit, fuel, energy, chrono, temps);
            System.out.print(voiture);

            System.out.print(Central_Service.toString_DonneeTour(Bibliotheque_Service.donneeTourIntervalle(voiture.donneesTour, 0, -1)));
        } catch (TempsException e) {
            e.printStackTrace();
        }
    }
}
