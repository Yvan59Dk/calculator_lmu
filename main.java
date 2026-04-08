import Temps.*;
import Temps.TempsException.*;
import bibliotheque.*;
import calculator.*;
import Equipage.*;

public class main {
    public static void main(String[] args) {
        try {
            Categorie spec = Categorie.LMP3;
            Circuit circuit = Circuit.BARCELONE;

            Pilote pilotYvan = new Pilote("Yvan","Znat", 
                              3.12, 0.0,
                                         new Temps(1, 39, 0), 
                                         new Temps(1,41,0));

            Pilote pilotGawad = new Pilote("Gawad", "Simeon", 
                             2.91, 0.0, 
                                        new Temps(1,40,001), 
                                        new Temps(1,42,865));
            LineUp lineUp = new LineUp(pilotYvan, pilotGawad);
            
            System.out.println(lineUp.getLineUp().get(0).getFuel_conso());
            Fuel fuel = new Fuel(lineUp.getLineUp().get(0).getFuel_conso(), spec.getFuel_max(), 0.89);
            Energy energy = new Energy(spec.getEnergy_max(), lineUp.getLineUp().get(0).getEnergy_conso());
            
            Temps temps = new Temps(4,0,0,0);

            Voiture voiture = new Voiture(spec, lineUp, circuit, fuel, energy, temps);
            System.out.print(voiture);

            System.out.print(Central_Service.toString_DonneeTour(Bibliotheque_Service.donneeTourIntervalle(voiture.donneesTour, 0, -1)));
        } catch (TempsException e) {
            e.printStackTrace();
        }
    }
}
