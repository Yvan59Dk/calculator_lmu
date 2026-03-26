package Equipage;

import Temps.*;

public class Pilote {
    public String nom;
    public String prenom;

    private Temps tempsChrono;
    private Temps tempsReference;

    public Pilote(){
        this.nom = null;
        this.prenom = null;
        this.tempsChrono = null;
        this.tempsReference = null;
    }

    public Pilote(String prenom, String nom, Temps tempsChrono, Temps tempsReference){
        this.nom = nom;
        this.prenom = prenom;
        this.tempsChrono = tempsChrono;
        this.tempsReference = new Temps(tempsReference);
    }

    public Pilote(String prenom, String nom, Temps tempsChrono){
        this.nom = nom;
        this.prenom = prenom;
        this.tempsChrono = tempsChrono;
        this.tempsReference = new Temps(tempsChrono);
    }

    public Temps getTempsChrono(){
        return tempsChrono;
    }

    public Temps getTempsReference(){
        return tempsReference;
    }

    public void setChrono(Temps chrono){
        tempsChrono = chrono;
    }

    public void setReference(Temps refChrono){
        tempsReference = refChrono;
    }
}
