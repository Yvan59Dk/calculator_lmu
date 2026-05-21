import java.util.Iterator;
import java.util.List;

import Equipage.LineUp;
import Temps.*;
import bibliotheque.*;
import calculator.*;
import calculator.Ressource.Energy;
import calculator.Ressource.Fuel;

/**
 * Classe qui englobe de manière général les méthodes à utilisé dans le code.
 */
public class Central_Service{

    /** Delta de variation des tours durant un stint */
    public final static double DELTAVAR = 1.001;

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

    // -- Fonction en rapport avec les données --
    public static List<Donnee> calcul_tour(Categorie spec, Circuit circuit, LineUp lineUp, int indexP, Fuel fuel, Energy energy, Temps timer, int nbTourActuel){
        Calcul_Tour prediThread = new Calcul_Tour(spec, circuit, lineUp, indexP, fuel, energy, timer, nbTourActuel);
        Thread thread = new Thread(prediThread);
        thread.run();
        try {
            thread.join();
            return prediThread.getResultat();
        } catch (InterruptedException e) {
            System.out.println("Problème d'exécution de la prédiction des tours");
            e.printStackTrace();
            return null;
        }
    }


    public static StringBuilder toString_DonneeTour(List<Donnee> donnee){
        StringBuilder res = new StringBuilder();
        for(Iterator<Donnee> it = donnee.iterator(); it.hasNext();){
           res.append(it.next());
        }
        return res;
    }
}
