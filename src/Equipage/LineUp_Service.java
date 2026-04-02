package Equipage;

import Temps.*;

public class LineUp_Service {

    /**
     * Fonction qui renvoit le Temps réference ayant subit le coefficient de variation Delta
     * @param tempsRef : Temps : Temps de référence
     * @param delta : double : Le delta a appliquer
     * @return Temps : Le temps réference * delta
     */
    public static Temps variationTempsRef(Temps tempsRef, double delta){
        tempsRef.multiTemps(delta);
        return tempsRef;
    }
}
