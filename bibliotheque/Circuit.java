package bibliotheque;
import Temps.*;

public enum Circuit {
    SPA("Spa",new Chrono(0,34,0));

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
