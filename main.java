import Temps.*;
import bibliotheque.Categorie;
import bibliotheque.Circuit;

public class main {
    public static void main(String[] args) {
        Chrono ch = new Chrono(1, 12, 200);
        Timer temps = new Timer(4,0,0);
        Voiture v2 = new Voiture(Categorie.LMP2, Circuit.BAHREIN, ch, temps);
        System.out.print(v2);

        /*Chrono ch1 = new Chrono(1, 0, 0);
        Timer temps1 = new Timer(24,00,00);
        Voiture v1 = new Voiture(Categorie.LMP2, ch1, temps1);
        System.out.print(v1);*/

        System.out.print(v2.donneeTour(0));
    }
}
