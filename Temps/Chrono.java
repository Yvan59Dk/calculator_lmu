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

    /**
    * {@inheritDoc}
    */
    protected void diff_valeur2(int v2){
        this.valeur2 -= v2;
        if(this.valeur1 != 0){
                this.valeur2 += 60;
                this.valeur1 -= 1;
            } else {
                this.valeur2 = 0;
            }
    }
    /**
     * {@inheritDoc}
     */
    protected void diff_valeur3(int v3){
        this.valeur3 -= v3;
        if(this.valeur2 != 0){
                this.valeur3 += 1000;
                this.valeur2 -= 1;
            } else {
                this.valeur3 = 0;
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
    
    @Override
    public String toString(){
        return this.valeur1 + ":" + this.valeur2 + "." + this.valeur3;
    }
}
