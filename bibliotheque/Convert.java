package bibliotheque;

/** Classe regroupant les fonctions utilisé pour convertir des valeurs et d'autres ou dans certains formats */
public class Convert {

    /** Nombre de chiffre après la virgule pour les doubles */
    public final static int LIMITDIGIT = 2;

    /** 
     * Fonction qui retourne le String d'un double avec une limite de deux chiffres après la virgule
     * @param d : double à convertir
     * @return String : d avec deux chiffres après la virgule
     */
    public static String toStringDouble(double d){
        String[] coco = Double.toString(d/1f).split("\\.");
        if (coco[1].length() > LIMITDIGIT){
            return coco[0] + "." + coco[1].substring(0,LIMITDIGIT);
        } else {
            return coco[0] + "." + coco[1];
        }
    }
}
