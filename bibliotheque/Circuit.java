package bibliotheque;
import Temps.*;

/**
 * La classe Enum 'Circuit' contient les données utiles des circuits correspondant
 * @note Les chronos ont été relevée par ma part en Ford Mustang LMGT3 au Clavier, ils sont proximatif.
 */
public enum Circuit {
    // Spa-Francorchamp
    /** Le circuit SPA classique contenant les données de stand */
    SPA("Spa",new Chrono(0,36,410)),
    /** Le circuit SPA Endurance ( celui utilisé en GTWC ou leur jeu ACC) contenant les données de stand */
    SPA_ENDU("Spa Endurance", new Chrono(1,7,970)),

    // Monza
    /** Le circuit Monza Classique contenant les données de stand */
    MONZA("Monza",new Chrono(0,28,720)),
    /** Le circuit Monza sans Chicane 1 contenant les données de stand */
    MONZA_NOCHICANE("Monza sans chicane",new Chrono(0,30,720)),

    // Imola
    /** Le circuit d'Imola contenant les données de stand */
    IMOLA("Imola",new Chrono(0,35,160)),

    // Bahrein
    /** Le circuit de Bahrein contenant les données de stand */
    BAHREIN("Bahrein",new Chrono(0,28,1)),

    // Qatar
    /** Le circuit du Qatar contenant les données de stand */
    QATAR("Qatar",new Chrono(0,32,990)),

    // Le Mans
    /** Le circuit du Mans contenant les données de stand */
    LEMANS("La Mans",new Chrono(0,34,54)),

    // COTA (Circuit Of The America)
    /** Le Circuit des Ameriques contenant les données de stand */
    // COTA("Circuit Of The America",new Chrono(0,32,760)),
    
    // Silverstone
    /** Le circuit de Silverstone contenant les données de stand */
    SILVERSTONE("Silverstone", new Chrono(0,32,760)),

    // Portimao
    /** Le circuit de Portimao contenant les données de stand */
    // PORTIMAO("PORTIMAO", new Chrono(0,0,0)),

    // Paul Ricard
    /** Le circuit du Paul Ricard contenant les données de stand */
    // PAULRICARD("Paul Ricard", new Chrono(0,0,0)),

    // Fuji
    /** Le circuit de Fuji contenant les données de stand */
    // FUJI("Fugi", new Chrono(0,0,0)),

    // Sebring
    /** Le circuit de Sebring contenant les données de stand */
    SEBRING("Sebring", new Chrono(0,35,540));

    /** Le nom du circuit */
    private String desc;
    /** Le Temps mis au stand sans compter l'arrêt au stand */
    private Chrono pit;

    private Circuit(String desc, Chrono pit){
        this.desc = desc;
        this.pit = pit;
    }

    /** 
     * Renvois le nom du circuit.
     * @return String : Description du circuit.
     */
    public String getDescription(){
        return desc;
    }

    /**
     * Renvois le temps passer dans la Pitlane ( sans compter l'arrêt au stand )
     * @return Temps mis dans la Pitlane
     */
    public Chrono getPitLane(){
        return pit;
    }
}
