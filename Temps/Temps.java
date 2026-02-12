package Temps;

public class Temps {
    protected int valeur1;
    protected int valeur2;
    protected int valeur3;

    /**
     * Classe de temps permettant de faire un temps à trois valeur de base 100.
     * @param v1 : Première valeurs.
     * @param v2 : Deuxième valeurs.
     * @param v3 : Troisième valeurs.
     */
    public Temps(int v1, int v2, int v3){
        this.valeur1 = v1; 
        this.valeur2 = v2; 
        this.valeur3 = v3;
    }

    public Temps(Temps temps){
        this.valeur1 = temps.valeur1;
        this.valeur2 = temps.valeur2;
        this.valeur3 = temps.valeur3;
    }

    public Temps(){
        this.valeur1 = 0;
        this.valeur2 = 0;
        this.valeur3 = 0;
    }

    public int getValeur1(){
        return valeur1;
    }
    public int getValeur2(){
        return valeur2;
    }
    public int getValeur3(){
        return valeur3;
    }

    /**
     * Met à jour le chrono de référence de la voiture ( peut être son meilleur ou son moyen sur 5 tours ).
     * @param v1 : la premiere valeur.
     * @param v2 : la deuxiéme valeur.
     * @param v3 : la troisiéme valeur.
     */
    public void MAJ_temps(int v1, int v2, int v3){
        this.valeur1 = v1; 
        this.valeur2 = v2; 
        this.valeur3 = v3;
    }

    /**
     * Soustrait deux valeurs numéro 1 de temps.
     * @param v1 Valeur numéro 1.
     */
    protected void diff_valeur1(int v1){
        this.valeur1 -= v1;
        if (this.valeur1 <= 0){
            this.valeur1 = 0;
        }
    }
    /**
     * Soustrait deux valeurs numéro 2 de temps.
     * @param v2 Valeur numéro 2.
     */
    protected void diff_valeur2(int v2){
        if (this.valeur2 == 0){
            this.diff_valeur3(v2*60);
        } else {
            this.valeur2 -= v2;
        }
        if (this.valeur2 <= 0){
            if(this.valeur1 != 0){
                this.valeur2 += 100;
                this.valeur1 -= 1;
            } else {
                this.valeur2 = 0;
            }
        }
    }
    /**
     * Soustrait deux valeurs numéro 3 de temps.
     * @param v3 Valeur numéro 3.
     */
    protected void diff_valeur3(int v3){
        this.valeur3 -= v3;
        if (this.valeur3 < 0){
            if (this.valeur2 > 0){
                this.valeur3 += 100;
                this.valeur2 -= 1;
            } else if (this.valeur1 > 0){
                this.valeur3 += 100;
                this.valeur2 = 99;
                this.valeur1 -= 1;
            } else {
                this.valeur3 = 0;
            }
        }
    }

    /** 
     * Additionne deux valeurs numéro 1 de temps
     * @param v1 Valeur numéro 1.
     */
    protected void somme_valeur1(int v1){
        this.valeur1 += v1;
    }
    /** 
     * Additionne deux valeurs numéro 2 de temps
     * @param v2 Valeur numéro 2.
     */
    protected void somme_valeur2(int v2){
        this.valeur2 += v2;
        if (this.valeur2 >= 100){
            this.valeur2 -= 100;
            this.valeur1 += 1;
        }
    }
    /** 
     * Additionne deux valeurs numéro 3 de temps
     * @param v3 Valeur numéro 3.
     */
    protected void somme_valeur3(int v3){
        this.valeur3 += v3;
        if (this.valeur3 >= 100){
            this.valeur3 -= 100;
            this.valeur2 += 1;
        }
    }

    /**
     * Additionne deux temps ensembles.
     * Le calcul est fait en sorte pour que les bases soit bonnes en fonction de ce qu'on utilise comme type de temps.
     * @param temps : Variable de classe Temps.
     */
    public void somme_temps(Temps temps){
        somme_valeur1(temps.valeur1);
        somme_valeur2(temps.valeur2);
        somme_valeur3(temps.valeur3);
    }

    /**
     * Soustrait deux temps ensembles.
     * Le calcul est fait en sorte pour que les bases soit bonnes en fonction de ce qu'on utilise comme type de temps.
     * @param temps : Variable de classe Temps.
     */
    public void diff_temps(Temps temps){
        diff_valeur1(temps.valeur1);
        diff_valeur2(temps.valeur2);
        diff_valeur3(temps.valeur3);
    }

    /**
     * Soustrait au timer un chrono
     * @param timer : Le timer à modifier
     * @param chrono : Le chrono de référence
     */
    public void diff_Timer_Chrono(Timer timer, Chrono chrono){
        timer.diff_valeur2(chrono.valeur1);
        timer.diff_valeur3(chrono.valeur2);
    }

    public String toString(){
        return this.valeur1 + " " + this.valeur2 + " " + this.valeur3;
    }
}
