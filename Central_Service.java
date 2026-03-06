import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Temps.*;
import bibliotheque.*;
import calculator.*;

/**
 * Classe qui englobe de manière général les méthodes à utilisé dans le code.
 */
public class Central_Service{

    /**
     * Fonction Calculatoire qui calcule le nombre de tour réel à faire durant la course .
     * @param chrono : La variable de classe 'Temps' qui contient le chrono de référence.
     * @param timer_course : La variable de classe 'Temps' qui contient le temps restant de la course.
     * @return un integer qui est le nombre de tour réel.
     */
    public static int calcul_nbTour_théorique(Temps chrono, Temps temps_course){
        Temps timer = new Temps(temps_course);
        int tour = 0;
        while (timer.checkNul()){
            timer.soustractTemps(chrono);
            tour++;
        }
        return tour;
    }

    /**
     * Fonction Calculatoire qui calcule le carburant et l'énergie à mettre au prochain stand de la course.
     * @param litreGlobalRequis : Le litre total utilisé durant la course.
     * @param energy : La variable de classe 'Energy' qui contient les données de voitures en rapport avec l'énergie.
     * @param fuel : La variable de classe 'Fuel' qui contient les données de voitures en rapport avec le carburant.
     * @return un tuple de double de taille 2 au format [Carburant à mettre,Energie à mettre] 
     */
    public static double[] calcul_refuel_stand(Temps chrono, Temps timer, Energy energy, Fuel fuel){
        double[] res = new double[2];
        res[0] = Calculator_Service.fuel_stand(chrono, timer, fuel);
        res[1] = Calculator_Service.energy_stand(chrono, timer, energy);
        return res;
    }

    /**
     * Fonction Calculatoire qui prédit d'après les statistiques données, les tours durant la course.
     * @param fuel : Variable de classe 'Fuel' qui contient les informations nécessaires du carburant.
     * @param energy : Variable de classe 'Energy' qui contient les informations nécessaires de l'énergie.
     * @param chrono : Variable de classe 'Temps' qui contient le chrono de référence.
     * @param timer : Variable de classe 'Temps' qui contient le timer restant de la course.
     * @param nbTourActuel : int qui est le nombre de tour fait.
     * @param nbTour : int qui est le nombre de tour total.
     * @return une liste d'élément de classe Données.
     */
    public static List<Donnee> calcul_tour(Categorie spec, Circuit circuit, Fuel fuel, Energy energy, Temps chrono, Temps timer, int nbTourActuel){
        // L'arraylist qui va contenir les tours.
        ArrayList<Donnee> listeDonnees = new ArrayList<Donnee>();

        // Toute les variables de classe en copie pour pouvoir manipuler les données sans modifié celle de base
        Fuel fuelTemp = new Fuel(fuel);
        Energy energyTemp = new Energy(energy);
        Temps timerTemp = new Temps(timer);
        
        // Variable local.
        Temps tempsStand = new Temps();
        double[] refuelStand = {0,0};
        
        boolean stand = false;
        boolean timeStand = false;

        // Tour.
        int i = 0;
        int tour = nbTourActuel;

        while(timerTemp.checkNul()){
            tour = nbTourActuel + i;
            fuelTemp.evolutionFuel();
            energyTemp.evolutionEnergy();

            if (fuelTemp.getFuel_actuel()-fuelTemp.getFuel_conso() <= 0 
                || energyTemp.getEnergy_actuel()-energyTemp.getEnergy_conso() <= 0){
                refuelStand = calcul_refuel_stand(chrono, timerTemp, energyTemp, fuelTemp);
                energyTemp.MAJ_energy_actuel(refuelStand[1]);
                fuelTemp.MAJ_fuel_actuel(refuelStand[0]);

                // Temps dans la voie des stands
                tempsStand = new Temps(Calculator_Service.temps_ravitaillement(spec, circuit, refuelStand[0], refuelStand[1]));
                chrono.addTemps(tempsStand);
                timeStand = true;
                stand = true;
            }

            listeDonnees.add(new Donnee(
                        tour,               // Le numéro du tour
                        fuelTemp,           // L'état du fuel
                        energyTemp,         // L'état de l'énergie
                        chrono,             // Le chrono du tour en question
                        timerTemp,          // Le timer restant de la course
                        stand,              // Si il faut rentrez au stand
                        refuelStand[0],     // Fuel à remettre au stand
                        refuelStand[1]));   // Energie à mettre au stand

            if (stand){
                stand = false;
            }
            if (timeStand){
                chrono.soustractTemps(tempsStand);
                timeStand = false;
            }

            timerTemp.soustractTemps(chrono);
            i++;
        }
        List<Donnee> res = Collections.unmodifiableList(listeDonnees);
        return res;
    }

    /**
     * Fonction de Recherche qui donne les tours oû il faut rentrer au stand.
     * @param donnee : Liste d'élément de classe 'Donnee' contennant les données des tours.
     * @return les donnees des tours correspondant au arrêt au stand.
     */
    public static ArrayList<Donnee> Donnee_tourStand(ArrayList<Donnee> donnee){
        ArrayList<Donnee> stand = new ArrayList<Donnee>();
        for(int i = 0; i < donnee.size(); i++){
            if (donnee.get(i).getStand()){
                stand.add(donnee.get(i));
            }
        }
        return stand;
    }
}
