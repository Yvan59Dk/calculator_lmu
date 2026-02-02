package Temps;

public class Timer extends Temps{
    public int heure;
    public int minute;
    public int seconde;
    
    /**
     * Sous-Classe de Temps qui permet de mettre en forme un Timer de format 'heure,minute,seconde' 
     * et d'avoir leur spécificité d'affichage et de calcul car pas la même base.
     * @param h : Valeur des heures.
     * @param m : Valeur des minutes.
     * @param s : Valeur des secondes.
     */
    public Timer(int h, int m, int s){
        super(h,m,s);
        this.heure = h; 
        this.minute = m; 
        this.seconde = s;
    }

    public Timer(Timer timer){
        super(timer);
        this.heure = timer.heure; 
        this.minute = timer.minute; 
        this.seconde = timer.seconde;
    }

    public int getValeur1(){
        return heure;
    }
    public int getValeur2(){
        return minute;
    }
    public int getValeur3(){
        return seconde;
    }

    /**
    * {@inheritDoc}
    */
    protected void diff_valeur2(int m){
        this.valeur2 -= m;
        if (this.valeur2 < 0){
            this.valeur2 += 60;
            this.valeur1 -= 1;
        }
    }
    /**
    * {@inheritDoc}
    */
    protected void diff_valeur3(int s){
        this.valeur3 -= s;
        if (this.valeur3 < 0){
            this.valeur3 += 60;
            this.valeur2 -= 1;
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
        this.valeur3 += m;
        if (this.valeur3 >= 60){
            this.valeur3 -= 60;
            this.valeur2 += 1;
        }
    }

    @Override
    public String toString(){
        return this.heure + " h " + this.minute + " min " + this.seconde + " s";
    }
}
