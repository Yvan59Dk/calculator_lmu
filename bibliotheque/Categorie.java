package bibliotheque;

/**
 * Classe Enum "Catégorie" répertorie les specs de voitures du jeu ainsi que les informations crucial 
 * des calculs comme le carburant max,le rendement du fuel par rapport à l'énergie 
 * ou l'énergie max ( surtout pour différencier les LMP et les autres catégorie utilisant l'énergie ).
 */
public enum Categorie {
    /** La voiture Hypercar contenant les valeurs essentiels */
    HYP("Hypercar", 120.0, 0.84, 100), 

    /** La voiture LMP2 ELMS contenant les valeurs essentiels */
    LMP2_ELMS("LMP2 Spec ELMS", 75.0, 1, -1), 

    /** La voiture LMP2 WEC contenant les valeurs essentiels */
    LMP2_WEC("LMP2 Spec WEC", 67.0, 1, -1), 

    /** La voiture LMP3 contenant les valeurs essentiels */
    LMP3("LMP3", 100.0, 1, -1), 

    /** La voiture LMGT3 contenant les valeurs essentiels */
    LMGT3("LMGT3", 100.0, 0.84, 100),

    /** La voiture LMGTE contenant les valeurs essentiels */ 
    LMGTE("LMGTE", 99.0, 0.84, 100); 

    /** Le nom de la catégorie */
    private String description;
    /** Le réservoir de la catégorie */
    private double fuel_max;
    /** Le rendement de la catégorie */
    private double fuel_rendement;
    /** L'energie max de la catégorie ( surtout pour différencier les LMP et les autres catégorie utilisant l'énergie ).*/
    private double energy_max;

    private Categorie(String desc, double fuel_max, double fuel_rendement, double energy_max){
        this.description = desc;
        this.fuel_max = fuel_max;
        this.fuel_rendement = fuel_rendement;
        this.energy_max = energy_max;
    }

    /**
     * Renvois le nom de la catégorie
     * @return String : nom de la catégorie
     */
    public String getDescription(){
        return description;
    }

    /**
     * Renvois le carburant maximal du véhicule
     * @return double : max de carburant
     */
    public double getFuel_max(){
        return fuel_max;
    }

    /**
     * Renvois le rendement du véhicule
     * @return double : rendement du véhicule
     */
    public double getFuel_rendement(){
        return fuel_rendement;
    }

    /**
     * Renvois l'énergie max du véhicule
     * @return 100 ou 0 si la catégorie n'utilise pas d'énergie.
     */
    public double getEnergy_max(){
        return energy_max;
    }
}
