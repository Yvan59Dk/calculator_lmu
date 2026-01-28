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

    @Override
    public String toString(){
        return this.minute + ":" + this.seconde + "." + this.milliseconde;
    }
}
