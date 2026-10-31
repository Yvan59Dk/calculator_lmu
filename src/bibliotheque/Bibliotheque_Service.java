package bibliotheque;

import bibliotheque.DonneeTour.Donnee;
import bibliotheque.DonneeTour.ListDonnee;

/** Classe regroupant les fonctions utilisé pour la recherche ainsi que pour convertir des valeurs dans certains formats */
public class Bibliotheque_Service {

    /** Nombre de chiffre après la virgule pour les doubles */
    public final static int LIMITDIGIT = 2;

    /** 
     * Fonction de Conversion qui retourne le String d'un double avec une limite de deux chiffres après la virgule
     * @param d : double à convertir
     * @return String : d avec deux chiffres après la virgule
     */
    public static String toStringDouble(double d){
        String[] coco = Double.toString(d/1f).split("\\.");
        if (coco[1].length() > LIMITDIGIT){
            return coco[0] + "." + coco[1].substring(0,LIMITDIGIT);
        } else {
            return coco[0] + "." + coco[1];
        }
    }

    /**
     * Fonction de Recherche qui donne les tours oû il faut rentrer au stand.
     * @param donnee : Liste d'élément de classe 'Donnee' contenant les données des tours.
     * @return les donnees des tours correspondant au arrêt au stand.
     */
    public static ListDonnee donneetourStand(ListDonnee donnee){
        ListDonnee stand = new ListDonnee();
        for( Donnee d : donnee){
            if (d.getStand()){
                stand.ajouter(d);
            }
        }
        return stand;
    }

    /**
     * Fonction de recherche qui donne les tours dans un intervalle donné
     * @param donnee : Liste d'éléments de classe 'Donnee' contenant les données des tours
     * @param debut : int : Debut de l'intervalle
     * @param fin : int : Fin de l'intervalle ( si -1, intervalle infinie )
     * @return les donnees des tours correspondant à l'intervalle
     */
    public static ListDonnee donneeTourIntervalle(ListDonnee donnee, int debut, int fin){
        ListDonnee tour = new ListDonnee();
        if ( fin == -1 ){
            fin = donnee.size();
        }
        if (debut < 0 || donnee.size() < debut || fin < 0 || donnee.size() < fin ){
            throw new IllegalArgumentException("Problème d'intervalle dans les tours demandées. Argument reçu : debut = " + debut + ", fin = " + fin);
        } else {
            tour = new ListDonnee(donnee.stream()
                        .skip(debut) // on saute les naturels de 0 a 4
                        .limit(fin-debut) // on ne garde que les 6 suivants
                        .toList());
        }
        return tour;
    }
}
