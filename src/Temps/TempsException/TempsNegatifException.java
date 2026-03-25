package Temps.TempsException;

public class TempsNegatifException extends TempsException {
    public TempsNegatifException(int valeur){
        super("TempsNegatifException : La valeur de milliseconde est négative, valeur reçu = " + valeur);
    }
}
