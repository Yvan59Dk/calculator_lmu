package Equipage;

import Temps.*;

public interface Method_LineUp {
    public int nomToID(String nom);
    public String IDtoNom(int ID);

    public Chrono bestTempsChrono();
    public int ID_bestTempsChrono();
    public Chrono bestTempsReference();
    public int ID_bestTempsReference();

    public void setTempsChrono(int id, Chrono chrono);
    public void setTempsReference(int id, Chrono chrono);

    public void delPilote(int ID);
    public void addPilote(Pilote pilote);
}
