package bibliotheque;

/**
 * Classe Enum "Catégorie" répertoriant les specs de voitures du jeu.
 */
public enum Categorie {
    /** La voiture Hypercar contenant les valeurs essentiels */
    HYP("Hypercar", 120.0, 0.84, 100), 

    /** La voiture LMP2 contenant les valeurs essentiels */
    LMP2("LMP2", 75.0, 1, -1), 

    /** La voiture LMP3 contenant les valeurs essentiels */
    LMP3("LMP3", 100.0, 1, -1), 

    /** La voiture LMGT3 contenant les valeurs essentiels */
    LMGT3("LMGT3", 100.0, 0.84, 100),

    /** La voiture LMGTE contenant les valeurs essentiels */ 
    LMGTE("LMGTE", 99.0, 0.84, 100); 

    private String description;
    private double fuel_max;
    private double fuel_rendement;
    private double energy_max;

    private Categorie(String desc, double fuel_max, double fuel_rendement, double energy_max){
        this.description = desc;
        this.fuel_max = fuel_max;
        this.fuel_rendement = fuel_rendement;
        this.energy_max = energy_max;
    }

    /**
     * Fonction qui renvoit le nom de la spec.
     * @return le nom de la spec
     */
    public String getDescription(){
        return description;
    }

    /**
     * Fonction qui renvoit le max de carburant dans les voitures de la catégorie
     * @return : double : le max de carburant
     */
    public double getFuel_max(){
        return fuel_max;
    }

    /**
     * Fonction qui renvoit le rendement par defaut des voitures de la catégorie
     * @return : double : le rendement par defaut
     */
    public double getFuel_rendement(){
        return fuel_rendement;
    }

    /**
     * Fonction qui renvoit le max d'énergie des voitures de la catégorie
     * @return 100 ou 0 si la catégorie n'utilise pas d'énergie.
     */
    public double getEnergy_max(){
        return energy_max;
    }
}
