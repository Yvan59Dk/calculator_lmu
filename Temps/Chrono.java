package Temps;

public class Chrono extends Temps{ 
    /**
     * Sous-Classe de Temps qui permet de mettre en forme un Chronométre de format 'minute,seconde,milliseconde' 
     * et d'avoir leur spécificité d'affichage et de calcul car pas la même base.
     * @param m : Valeur des minutes.
     * @param s : Valeur des secondes.
     * @param ms : Valeur des millisecondes.
     */
    public Chrono(int m, int s, int ms){
        super(m,s,ms);
    }

    public Chrono(Chrono chrono){
        super(chrono);
    }

    public Chrono(){
        super();
    }

    protected void diff_valeur2(int v2){
        if (this.valeur2 == 0){
            this.diff_valeur3(v2*60);;
        } else {
            this.valeur2 -= v2;
        }
        if (this.valeur2 < 0){
            if (this.valeur1 > 0){
                this.valeur2 += 60;
                this.valeur1 -= 1;
            } else {
                this.valeur2 = 0;
            }
        }
    }

    protected void diff_valeur3(int v3){
        this.valeur3 -= v3;
        if (this.valeur3 < 0){
            if (this.valeur2 > 0){
                this.valeur3 += 1000;
                this.valeur2 -= 1;
            } else if (this.valeur1 > 0){
                this.valeur3 += 1000;
                this.valeur2 = 59;
                this.valeur1 -= 1;
            } else {
                this.valeur3 = 0;
            }
        }
    }

    /**
    * {@inheritDoc}
    */
    protected void somme_valeur2(int v2){
        this.valeur2 += v2;
        if (this.valeur2 >= 60){
            this.valeur2 -= 60;
            this.valeur1 += 1;
        }
    }
    /**
     * {@inheritDoc}
     */
    protected void somme_valeur3(int v3){
        this.valeur3 += v3;
        if (this.valeur3 >= 1000){
            this.valeur3 -= 1000;
            this.valeur2 += 1;
        }
    }

    /**
     * Renvois le Chrono en une valeur entière de miliseconde.
     * @return le Chrono en milliseconde.
     */
    public int getChronoMilli(){
        return this.valeur1 * 60000 + this.valeur2 * 1000 + this.valeur3;
    }

    /**
     * Fonction Multipliant le chrono par I
     * @param i : double : le multiplicateur.
     */
    public void multiChrono(double i){
        int res = (int)(getChronoMilli() * i);
        this.somme_valeur3(res);
    }
    
    @Override
    public String toString(){
        return this.valeur1 + ":" + this.valeur2 + "." + this.valeur3;
    }
}
