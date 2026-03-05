package Equipage;

import Temps.*;

public class Pilote {
    public String nom;
    public String prenom;

    private Chrono tempsChrono;
    private Chrono tempsReference;

    Pilote(){
        this.nom = null;
        this.prenom = null;
        this.tempsChrono = null;
        this.tempsReference = null;
    }

    Pilote(String prenom, String nom, Chrono tempsChrono, Chrono tempsReference){
        this.nom = nom;
        this.prenom = prenom;
        this.tempsChrono = tempsChrono;
        this.tempsReference = new Chrono(tempsReference);
    }

    Pilote(String prenom, String nom, Chrono tempsChrono){
        this.nom = nom;
        this.prenom = prenom;
        this.tempsChrono = tempsChrono;
        this.tempsReference = new Chrono(tempsChrono);
    }

    public Chrono getTempsChrono(){
        return tempsChrono;
    }

    public Chrono getTempsReference(){
        return tempsReference;
    }

    public void setChrono(Chrono chrono){
        tempsChrono = chrono;
    }

    public void setReference(Chrono refChrono){
        tempsReference = refChrono;
    }
}
