import Temps.*;

public class main {
    public static void main(String[] args) {
        Chrono ch = new Chrono(1, 34, 234);
        Timer temps = new Timer(6,56,45);
        Voiture v2 = new Voiture(Categorie.HYP, 2.45, ch, temps);
        System.out.print(v2);
    }
}
