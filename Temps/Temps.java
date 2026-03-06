package Temps;

import Temps.TempsException.*;

/**
 * Classe permettant une gestion simplifiée des temps que ce soit un timer de course ou un chrono.
 * Il convertit tout les données qui lui sont données en milliseconde pour simplifiée les calculs.
 * @version v2.0
 * @author Yvan
 */
public class Temps implements Comparable<Temps>{
    private int milliseconde;

    public Temps(){
        this.milliseconde = 0;
    }

    public Temps(int minute, int seconde, int milliseconde){
        if ( minute < 0 ) {
            throw new TempsNegatifException(minute);
        } else if ( seconde < 0 ){
            throw new TempsNegatifException(seconde);
        } else if ( milliseconde < 0 ){
            throw new TempsNegatifException(milliseconde);
        }

        this.milliseconde = convertMilliseconde(0, minute, seconde, milliseconde);
    }

    public Temps(int heure, int minute, int seconde, int milliseconde){
        if ( heure < 0 ) {
            throw new TempsNegatifException(heure);
        } else if ( minute < 0 ) {
            throw new TempsNegatifException(minute);
        } else if ( seconde < 0 ){
            throw new TempsNegatifException(seconde);
        } else if ( milliseconde < 0 ){
            throw new TempsNegatifException(milliseconde);
        }

        this.milliseconde = convertMilliseconde(heure, minute, seconde, milliseconde);
    }

    public Temps(Temps temps){
        this.milliseconde = temps.milliseconde;
    }

    /**
     * Fonction convertissant les valeurs données en millisecondes
     * @param heure
     * @param minute
     * @param seconde
     * @param milliseconde
     * @return la valeur total en milliseconde
     */
    private int convertMilliseconde(int heure, int minute, int seconde, int milliseconde){
        int milli = milliseconde 
                    + seconde * 1000 
                    + minute * 60000
                    + heure * 3600000;
        return milli;
    }

    /**
     * Renvois les Millisecondes du temps.
     * @return int milliseconde
     */
    public int getMilliseconde(){
        return this.milliseconde;
    }

    public int compareTo(Temps temps){
        return this.milliseconde - temps.milliseconde;
    }

    /**
     * Ajoute du temps
     * @param temps Une variable de classe Temps
     */
    public void addTemps(Temps temps){
        this.milliseconde += temps.milliseconde;
    }

    /**
     * Enleve du temps
     * @param temps Une variable de classe Temps
     */
    public void soustractTemps(Temps temps){
        this.milliseconde -= temps.milliseconde;
    }

    /**
     * Multiplie le temps
     * @param multi un double qui multiplira le temps
     */
    public void multiTemps(double multi){
        this.milliseconde *= multi;
    }

    /**
     * Verifie si le temps est négatif.
     * @return un boolean `True` si les millisecondes sont négatif et `False` si ils sont positifs
     */
    public boolean checkNul(){
        return (milliseconde > 0);
    }

    public String toString(){
        String chronoString = "";
        int ms = milliseconde;

        int heure = ms / 3600000;
        ms %= 3600000;
        int minute = ms / 60000;
        ms %= 60000;
        int seconde = ms / 1000;
        ms %= 1000;
        int millisecondeRestante = ms;

        if (heure == 0) {
            chronoString = String.format("%02d:%02d.%03d",
                minute, seconde, millisecondeRestante);
        } else {
            chronoString = String.format("%02d::%02d:%02d.%03d",
                heure, minute, seconde, millisecondeRestante);
        }
        
        return chronoString;
    }
}
