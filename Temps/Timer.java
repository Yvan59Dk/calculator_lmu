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

    @Override
    public String toString(){
        return this.heure + " h " + this.minute + " min " + this.seconde + " s";
    }
}
