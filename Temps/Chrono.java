package Temps;

public class Chrono extends Temps{
    public int minute;
    public int seconde;
    public int milliseconde;
    
    /**
     * Sous-Classe de Temps qui permet de mettre en forme un Chronométre de format 'minute,seconde,milliseconde' 
     * et d'avoir leur spécificité d'affichage et de calcul car pas la même base.
     * @param m : Valeur des minutes.
     * @param s : Valeur des secondes.
     * @param ms : Valeur des millisecondes.
     */
    public Chrono(int m, int s, int ms){
        super(m,s,ms);
        this.minute = m; 
        this.seconde = s; 
        this.milliseconde = ms;
    }

    public int getValeur1(){
        return minute;
    }
    public int getValeur2(){
        return seconde;
    }
    public int getValeur3(){
        return milliseconde;
    }

    /**
    * {@inheritDoc}
    */
    protected void diff_valeur2(int v2){
        this.valeur2 -= v2;
        if (this.valeur2 < 0){
            this.valeur2 += 60;
            this.valeur1 -= 1;
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
    
    @Override
    public String toString(){
        return this.minute + ":" + this.seconde + "." + this.milliseconde;
    }
}
