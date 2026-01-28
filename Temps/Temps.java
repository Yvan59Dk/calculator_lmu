package Temps;

public class Temps {
    int valeur1;
    int valeur2;
    int valeur3;

    public Temps(int v1, int v2, int v3){
        this.valeur1 = v1; 
        this.valeur2 = v2; 
        this.valeur3 = v3;
    }

    /**
     * Met à jour le chrono de référence de la voiture ( peut être son meilleur ou son moyen sur 5 tours )
     * @param valeur1 : la premiere valeur
     * @param valeur2 : la deuxiéme valeur
     * @param valeur3 : la troisiéme valeur
     */
    public void MAJ_temps(int v1, int v2, int v3){
        this.valeur1 = v1; 
        this.valeur2 = v2; 
        this.valeur3 = v3;
    }

    public String toString(){
        return this.valeur1 + " " + this.valeur2 + " " + this.valeur3;
    }
}
