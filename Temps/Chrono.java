package Temps;

public class Chrono extends Temps{
    int minute;
    int seconde;
    int milliseconde;
    
    public Chrono(int m, int s, int ms){
        super(m,s,ms);
        this.minute = m; 
        this.seconde = s; 
        this.milliseconde = ms;
    }

    void diff_valeur2(int v2){
        this.valeur2 -= v2;
        if (this.valeur2 < 0){
            this.valeur2 += 60;
            this.valeur1 -= 1;
        }
    }

    void somme_valeur2(int v2){
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
