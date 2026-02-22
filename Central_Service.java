import java.util.ArrayList;

import Temps.*;
import bibliotheque.*;
import calculator.*;

/**
 * Classe qui englobe de manière général les méthodes à utilisé dans le code.
 */
public class Central_Service{
    /**
     * Fonction Calculatoire qui calcul le nombre de tour à faire durant la course.
     * @param chrono : La variable de classe 'Chrono' qui contient le chrono de référence.
     * @param timer : La variable de classe 'Timer' qui contient le temps restant de la course.
     * @return un double qui est le nombre de tour.
     * @deprecated : C'est une fonction qui donne le nombre le plus précis de tour en le mettant en 
     * nombre à virgule. CE N'EST PAS LA FONCTION A UTILISER pour faire des calculs précis car peu importe 
     * la virgule, la voiture DOIT passer la ligne et donc finir avec un nombre entier de tour.
     */
    public static double calcul_nbTour(Chrono chrono, Timer timer){
        int temps_seconde_timer = timer.getValeur1()* 3600 + timer.getValeur2()*60 + timer.getValeur3();
        int temps_seconde_chrono = chrono.getValeur1()*60 + chrono.getValeur2();
        return temps_seconde_timer / temps_seconde_chrono;
    }

    /**
     * Fonction Calculatoire qui calcule le nombre de tour réel à faire durant la course .
     * @param chrono : La variable de classe 'Chrono' qui contient le chrono de référence.
     * @param timer_course : La variable de classe 'Timer' qui contient le temps restant de la course.
     * @return un integer qui est le nombre de tour réel.
     */
    public static int calcul_nbTour_théorique(Chrono chrono, Timer timer_course){
        Timer timer = new Timer(timer_course);
        int tour = 0;
        while (timer.verif()){
            timer.diff_Timer_Chrono(timer, chrono);
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
    public static double[] calcul_refuel_stand(Chrono chrono, Timer timer, Energy energy, Fuel fuel){
        double[] res = new double[2];
        res[0] = Calculator_Service.fuel_stand(chrono, timer, fuel);
        res[1] = Calculator_Service.energy_stand(chrono, timer, energy);
        return res;
    }

    /**
     * Fonction Calculatoire qui prédit d'après les statistiques données, les tours durant la course.
     * @param fuel : Variable de classe 'Fuel' qui contient les informations nécessaires du carburant.
     * @param energy : Variable de classe 'Energy' qui contient les informations nécessaires de l'énergie.
     * @param chrono : Variable de classe 'Chrono' qui contient le chrono de référence.
     * @param timer : Variable de classe 'Timer' qui contient le timer restant de la course.
     * @param nbTourActuel : int qui est le nombre de tour fait.
     * @param nbTour : int qui est le nombre de tour total.
     * @return une liste d'élément de classe Données.
     */
    public static ArrayList<Donnee> calcul_tour(Circuit circuit, Fuel fuel, Energy energy, Chrono chrono, Timer timer, int nbTourActuel){
        // L'arraylist qui va contenir les tours.
        ArrayList<Donnee> listeDonnees = new ArrayList<Donnee>();

        // Toute les variables de classe en copie pour pouvoir manipuler les données sans modifié celle de base
        Fuel fuelTemp = new Fuel(fuel);
        Energy energyTemp = new Energy(energy);
        Timer timerTemp = new Timer(timer);
        
        // Variable local.
        Chrono tempsStand = new Chrono();
        double[] refuelStand = {0,0};
        
        boolean stand = false;
        boolean timeStand = false;

        // Tour.
        int i = 0;
        int tour = nbTourActuel;

        while(timerTemp.verif()){
            tour = nbTourActuel + i;
            fuelTemp.evolutionFuel();
            energyTemp.evolutionEnergy();

            if (fuelTemp.getFuel_actuel()-fuelTemp.getFuel_conso() <= fuelTemp.getFuel_conso() 
                || energyTemp.getEnergy_actuel()-energyTemp.getEnergy_conso() <= energyTemp.getEnergy_conso()){
                refuelStand = calcul_refuel_stand(chrono, timerTemp, energyTemp, fuelTemp);
                energyTemp.MAJ_energy_actuel(refuelStand[1]);
                fuelTemp.MAJ_fuel_actuel(refuelStand[0]);

                // Temps dans la voie des stands
                tempsStand = new Chrono(Calculator_Service.temps_ravitaillement(circuit, refuelStand[0], refuelStand[1]));
                chrono.somme_temps(tempsStand);
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
                chrono.diff_temps(tempsStand);
                timeStand = false;
            }

            timerTemp.diff_Timer_Chrono(timerTemp, chrono);

            i++;
        }
        return listeDonnees;
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
