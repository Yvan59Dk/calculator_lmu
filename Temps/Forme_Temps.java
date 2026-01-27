package Temps;

public class Forme_Temps extends Temps{
    int heure;
    int minute;
    int seconde;
    
    public Forme_Temps(int h, int m, int s){
        super(h,m,s);
        this.heure = h; 
        this.minute = m; 
        this.seconde = s;
    }

    @Override
    public String toString(){
        return this.heure + " h " + this.minute + " min " + this.seconde + " s";
    }
}
