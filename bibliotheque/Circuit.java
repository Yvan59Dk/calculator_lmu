package bibliotheque;
import Temps.*;

public enum Circuit {
    // Spa-Francorchamp
    SPA("Spa",new Chrono(0,34,0)),
    SPAENDU("Spa Endurance", new Chrono(0,0,0)),

    MONZA("Monza",new Chrono(0,0,0)),

    IMOLA("Imola",new Chrono(0,0,0)),

    BAHREIN("Bahrein",new Chrono(0,0,0)),

    QATAR("Qatar",new Chrono(0,0,0)),

    LEMANS("La Mans",new Chrono(0,0,0)),

    COTA("Circuit Of The America",new Chrono(0,0,0)),
    
    SILVERSTONE("Silverstone", new Chrono(0,0,0));

    private String desc;
    private Chrono pit;

    private Circuit(String desc, Chrono pit){
        this.desc = desc;
        this.pit = pit;
    }

    public String getDescription(){
        return desc;
    }

    public Chrono getPitLane(){
        return pit;
    }
}
