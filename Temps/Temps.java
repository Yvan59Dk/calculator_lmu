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

    private void diff_valeur1(int v1){
        this.valeur1 -= v1;
        if (this.valeur1 < 0){
            this.valeur1 = 0;
        }
    }
    private void diff_valeur2(int v2){
        this.valeur2 -= v2;
        if (this.valeur2 < 0){
            this.valeur2 += 100;
            this.valeur1 -= 1;
        }
    }
    private void diff_valeur3(int v3){
        this.valeur3 -= v3;
        if (this.valeur3 < 0){
            this.valeur3 += 100;
            this.valeur2 -= 1;
        }
    }

    private void somme_valeur1(int v1){
        this.valeur1 += v1;
    }
    private void somme_valeur2(int v2){
        this.valeur2 += v2;
        if (this.valeur2 >= 100){
            this.valeur2 -= 100;
            this.valeur1 += 1;
        }
    }
    private void somme_valeur3(int v3){
        this.valeur3 += v3;
        if (this.valeur3 >= 100){
            this.valeur3 -= 100;
            this.valeur2 += 1;
        }
    }

    public void somme_temps(Temps temps){
        somme_valeur1(temps.valeur1);
        somme_valeur2(temps.valeur2);
        somme_valeur3(temps.valeur3);
    }

    public void diff_temps(Temps temps){
        diff_valeur1(temps.valeur1);
        diff_valeur2(temps.valeur2);
        diff_valeur3(temps.valeur3);
    }

    public String toString(){
        return this.valeur1 + " " + this.valeur2 + " " + this.valeur3;
    }
}
