package calculator.Pneu;

public class Pneu {
    private String emplacement;
    private double etat;

    private boolean graining = false;
    private boolean plat = false;

    public Pneu(String emplacement, double etat){
        this.emplacement = emplacement;
        this.etat = etat;
    }

    public String getEmplacement(){
        return emplacement;
    }
    public double getEtat(){
        return etat;
    }
    public boolean getGraining(){
        return graining;
    }
    public boolean getPlat(){
        return plat;
    }
}
