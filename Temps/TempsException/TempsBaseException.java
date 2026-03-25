package Temps.TempsException;

public class TempsBaseException extends TempsException {
    public TempsBaseException(int valeur, int base){
        super("TempsBaseException : La valeur de milliseconde " + valeur + " > la base " + base );
    }
}
