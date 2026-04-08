package Equipage;

import Temps.*;

public class Pilote {
    public String nom;
    public String prenom;

    private Temps tempsChrono;
    private Temps tempsReference;

    private double fuel_conso;
    private double energy_conso;

    public Pilote(){
        this.nom = null;
        this.prenom = null;
        this.tempsChrono = null;
        this.tempsReference = null;
        this.fuel_conso = 0.0;
        this.energy_conso = 0.0;
    }

    public Pilote(String prenom, String nom, double fuel_conso, double energy_conso, Temps tempsChrono, Temps tempsReference){
        this.nom = nom;
        this.prenom = prenom;
        this.tempsChrono = tempsChrono;
        this.tempsReference = new Temps(tempsReference);
        this.fuel_conso = fuel_conso;
        this.energy_conso = energy_conso;
    }

    public Pilote(String prenom, String nom, double fuel_conso, double energy_conso, Temps tempsChrono){
        this.nom = nom;
        this.prenom = prenom;
        this.tempsChrono = tempsChrono;
        this.tempsReference = new Temps(tempsChrono);
        this.fuel_conso = fuel_conso;
        this.energy_conso = energy_conso;
    }

    public String getNom(){
        return prenom.charAt(0) + " " + nom;
    }

    public Temps getTempsChrono(){
        return tempsChrono;
    }

    public Temps getTempsReference(){
        return tempsReference;
    }

    public double getFuel_conso(){
        return fuel_conso;
    }

    public double getEnergy_conso(){
        return energy_conso;
    }

    public void setChrono(Temps chrono){
        tempsChrono = chrono;
    }

    public void setReference(Temps refChrono){
        tempsReference = refChrono;
    }
}
