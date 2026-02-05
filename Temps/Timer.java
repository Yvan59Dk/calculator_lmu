package Temps;

public class Timer extends Temps{
    
    /**
     * Sous-Classe de Temps qui permet de mettre en forme un Timer de format 'heure,minute,seconde' 
     * et d'avoir leur spécificité d'affichage et de calcul car pas la même base.
     * @param h : Valeur des heures.
     * @param m : Valeur des minutes.
     * @param s : Valeur des secondes.
     */
    public Timer(int h, int m, int s){
        super(h,m,s);
    }

    public Timer(Timer timer){
        super(timer);
    }

    /**
    * {@inheritDoc}
    */
    protected void diff_valeur2(int m){
        this.valeur2 -= m;
        if (this.valeur2 <= 0){
            if(this.valeur1 != 0){
                this.valeur2 += 60;
                this.valeur1 -= 1;
            } else {
                this.valeur2 = 0;
            }
        }
    }
    /**
    * {@inheritDoc}
    */
    protected void diff_valeur3(int s){
        this.valeur3 -= s;
        if (this.valeur3 < 0){
            if (this.valeur2 > 0){
                this.valeur3 += 60;
                this.valeur2 -= 1;
            } else if (this.valeur1 > 0){
                this.valeur3 += 60;
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
    protected void somme_valeur2(int m){
        this.valeur2 += m;
        if (this.valeur2 >= 60){
            this.valeur2 -= 60;
            this.valeur1 += 1;
        }
    }
    /**
    * {@inheritDoc}
    */
    protected void somme_valeur3(int m){
        this.valeur1 += m;
        if (this.valeur1 >= 60){
            this.valeur1 -= 60;
            this.valeur2 += 1;
        }
    }

    public boolean verif(){
        int temps_seconde_timer = valeur1* 3600 + valeur2*60 + valeur3;
        if(temps_seconde_timer > 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.valeur1 + " h " + this.valeur2 + " min " + this.valeur3 + " s";
    }
}
