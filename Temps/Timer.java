package Temps;

public class Timer extends Temps{
    int heure;
    int minute;
    int seconde;
    
    public Timer(int h, int m, int s){
        super(h,m,s);
        this.heure = h; 
        this.minute = m; 
        this.seconde = s;
    }

    void diff_valeur2(int v2){
        this.valeur2 -= v2;
        if (this.valeur2 < 0){
            this.valeur2 += 60;
            this.valeur1 -= 1;
        }
    }
    void diff_valeur3(int v3){
        this.valeur3 -= v3;
        if (this.valeur3 < 0){
            this.valeur3 += 60;
            this.valeur2 -= 1;
        }
    }

    void somme_valeur2(int v2){
        this.valeur2 += v2;
        if (this.valeur2 >= 60){
            this.valeur2 -= 60;
            this.valeur1 += 1;
        }
    }
    void somme_valeur3(int v3){
        this.valeur3 += v3;
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
