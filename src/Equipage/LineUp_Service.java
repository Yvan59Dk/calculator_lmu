package Equipage;

import Temps.*;

public class LineUp_Service {
    public static Temps variationTempsRef(Temps tempsRef, double pourcents){
        tempsRef.multiTemps(pourcents/100);
        return tempsRef;
    }
}
