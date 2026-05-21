import Temps.*;
import Temps.TempsException.*;
import bibliotheque.*;
import calculator.Ressource.Energy;
import calculator.Ressource.Fuel;
import Equipage.*;

public class main {
    public static void main(String[] args) {
        try {
            Categorie spec = Categorie.HYP;
            Circuit circuit = Circuit.LEMANS;

            Pilote pilotYvan = new Pilote("Yvan","Znat", 
                              7.42, 0.0,
                                        new Temps(3, 27, 684), 
                                        new Temps(3,31,005));

            Pilote pilotGawad = new Pilote("Giovanni", "Mungillo", 
                             7.31, 0.0, 
                                        new Temps(3, 27, 450), 
                                        new Temps(3,30,845));

            Pilote pilot3 = new Pilote("Benj", "Etiot", 
                             7.54, 0.0, 
                                        new Temps(3,25,784), 
                                        new Temps(3,28,152));
            LineUp lineUp = new LineUp(pilotYvan, pilotGawad,pilot3);
            
            System.out.println(lineUp.getLineUp().get(0).getFuel_conso());
            Fuel fuel = new Fuel(lineUp.getLineUp().get(0).getFuel_conso(), spec.getFuel_max(), spec.getFuel_rendement());
            Energy energy = new Energy(spec.getEnergy_max(), lineUp.getLineUp().get(0).getEnergy_conso());
            
            Temps temps = new Temps(24,0,0,0);

            Voiture voiture = new Voiture(spec, lineUp, circuit, fuel, energy, temps);
            System.out.print(voiture);

            System.out.print(Central_Service.toString_DonneeTour(Bibliotheque_Service.donneeTourIntervalle(voiture.donneesTour, 0, -1)));
        } catch (TempsException e) {
            e.printStackTrace();
        }
    }
}
