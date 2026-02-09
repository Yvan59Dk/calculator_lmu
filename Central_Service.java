import java.util.ArrayList;

import Temps.*;
import bibliotheque.Donnee;
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
    public static double[] calcul_refuel_stand(double litreGlobalRequis, Energy energy, Fuel fuel){
        double[] res = new double[2];
        res[0] = calculator_service.fuel_stand(litreGlobalRequis, fuel);
        res[1] = calculator_service.energy_stand(litreGlobalRequis, energy);
        return res;
    }

    /**
     * Fonction Calculatoire qui calcule le total de litre utilisé durant l'entiereté de la course.
     * @param fuel : La variable de classe 'Fuel' qui contient les données de voitures en rapport avec le carburant. 
     * @param nbTour : int nombre de tour de la course.
     * @return Le total de litre à utilisé.
     */
    public static double calcul_litreGlobalRequis(Fuel fuel, int nbTour){
        return nbTour*fuel.getFuel_conso();
    }

    /**
     * Fonction Calculatoire qui calcule le litre utilisé sur un tour
     * @param nbTour : int nombre de tour de la course. 
     * @param litreGlobalRequis : le litrage total de la course
     * @return la consommation sur un tour
     */
    public static double calcul_litreParTour(int nbTour, double litreGlobalRequis){
        return litreGlobalRequis/nbTour;
    }

    /**
     * Fonction Calculatoire qui calcule le total d'énergie utilisé durant l'entiereté de la course.
     * @param energy : La variable de classe 'Energy' qui contient les données de voitures en rapport avec l'énergie.
     * @param nbTour : int nombre de tour de la course. 
     * @return Le total d'énergie à utilisé.
     */
    public static double calcul_energyParTour(Energy energy, int nbTour){
        return nbTour+energy.getEnergy_conso();
    }

    /**
     * Fonction Calculatoire qui calcule l'énergie utilisé sur un tour
     * @param nbTour : int nombre de tour de la course.
     * @param energyGlobalRequis : l'énergie total sur la course.
     * @return la consommation sur la tour.
     */
    public static double calcul_energyParTour(int nbTour, double energyGlobalRequis){
        return energyGlobalRequis/nbTour;
    }

    /**
     * Fonction Calculatoire qui prédit d'après les statistiques données, les tours durant la course.
     * @param fuel : Variable de classe 'Fuel' qui contient les informations nécessaires du carburant.
     * @param energy : Variable de classe 'Energy' qui contient les informations nécessaires de l'énergie.
     * @param chrono : Variable de classe 'Chrono' qui contient le chrono de référence.
     * @param timer : Variable de classe 'Timer' qui contient le timer restant de la course.
     * @param nbTourActuel : int qui est le nombre de tour fait.
     * @param nbTour : int qui est le nombre de tour total.
     * @param litreGlobalRequis : double qui est le carburant total requis pour atteindre la ligne d'arrivée.
     * @return une liste d'élément de classe Données.
     */
    public static ArrayList<Donnee> calcul_tour(Fuel fuel, Energy energy, Chrono chrono, Timer timer, int nbTourActuel, int nbTour, double litreGlobalRequis){
        ArrayList<Donnee> listeDonnees = new ArrayList<Donnee>();
        Fuel fuelTemp = new Fuel(fuel);
        Energy energyTemp = new Energy(energy);
        Timer timerTemp = new Timer(timer);
        double[] refuelStand = new double[2];
        boolean stand = false;
        boolean timeStand = false;
        int i = 0;
        while(timerTemp.verif()){

            if (stand){
                refuelStand = calcul_refuel_stand(litreGlobalRequis, energyTemp, fuelTemp);
                energyTemp.MAJ_energy_actuel(refuelStand[1]);
                fuelTemp.MAJ_fuel_actuel(refuelStand[0]);
                chrono.somme_temps(new Chrono(1,10,0));
                stand = false;
                timeStand = true;
            } else if (timeStand){
                chrono.diff_temps(new Chrono(1,10,0));
                timeStand = false;
            }

            int tour = nbTourActuel + i;
            fuelTemp.evolutionFuel();
            energyTemp.evolutionEnergy();

            if (fuelTemp.getFuel_actuel()-fuelTemp.getFuel_conso() <= fuelTemp.getFuel_conso() 
                || energyTemp.getEnergy_actuel()-energyTemp.getEnergy_conso() <= energyTemp.getEnergy_conso()){
                stand = true;
            }

            timerTemp.diff_Timer_Chrono(timerTemp, chrono);
            listeDonnees.add(new Donnee(tour, new Fuel(fuelTemp), new Energy(energyTemp), new Chrono(chrono), new Timer(timerTemp), stand));
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
