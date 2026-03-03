package Equipage;

import Temps.*;
import java.util.Random;

public class Pilote {
    final private int ID;
    public String nom;
    public String prenom;

    private Chrono tempsChrono;
    private Chrono tempsReference;

    Pilote(){
        this.ID = 0;
        this.nom = null;
        this.prenom = null;
        this.tempsChrono = null;
        this.tempsReference = null;
    }

    Pilote(String prenom, String nom, Chrono tempsChrono, Chrono tempsReference){
        this.ID = createID();
        this.nom = nom;
        this.prenom = prenom;
        this.tempsChrono = tempsChrono;
        this.tempsReference = new Chrono(tempsReference);
    }

    Pilote(String prenom, String nom, Chrono tempsChrono){
        this.ID = createID();
        this.nom = nom;
        this.prenom = prenom;
        this.tempsChrono = tempsChrono;
        this.tempsReference = new Chrono(tempsChrono);
    }

    private int createID(){
        Random random = new Random();
        return random.nextInt();
    }

    public int getID(){
        return ID;
    }

    public Chrono getTempsChrono(){
        return tempsChrono;
    }

    public Chrono getTempsReference(){
        return tempsReference;
    }
}
