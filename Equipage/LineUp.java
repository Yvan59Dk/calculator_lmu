package Equipage;

import java.util.List;
import Temps.*;

public class LineUp{
    private List<Pilote> lineUp;

    LineUp(Pilote pilote1){
        lineUp.add(pilote1);
    }

    LineUp(Pilote pilote1, Pilote pilote2){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
        lineUp.add(pilote4);
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4, Pilote pilote5){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
        lineUp.add(pilote4);
        lineUp.add(pilote5);
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4, Pilote pilote5, Pilote pilote6){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
        lineUp.add(pilote4);
        lineUp.add(pilote5);
        lineUp.add(pilote6);
    }

    LineUp(LineUp lineUp){
        this.lineUp = lineUp.getLineUp();
    }

    public Pilote getPiloteNom(String nom){
        return lineUp.get(nomToIndex(nom));
    }
    public List<Pilote> getLineUp(){
        return lineUp;
    }

    private int nomToIndex(String nom){
        for(int i = 0; i < lineUp.size(); i++){
            if(lineUp.get(i).nom == nom){
                return i;
            }
        }
        return -1;
    }

    public Pilote pilotBestTempsChrono(){
        Pilote res = lineUp.get(0);
        for(int i = 1; i < lineUp.size(); i++){
            if(lineUp.get(i).getTempsChrono().getChronoMilli() < res.getTempsChrono().getChronoMilli()){
                res = lineUp.get(i);
            }
        }
        return res;
    }

    public Pilote pilotBestTempsReference(){
        Pilote res = lineUp.get(0);
        for(int i = 1; i < lineUp.size(); i++){
            if(lineUp.get(i).getTempsReference().getChronoMilli() < res.getTempsReference().getChronoMilli()){
                res = lineUp.get(i);
            }
        }
        return res;
    }

    public Chrono bestTempsChrono(){
        Pilote res = pilotBestTempsChrono();
        return res.getTempsChrono();
    }

    public Chrono bestTempsReference(){
        Pilote res = pilotBestTempsReference();
        return res.getTempsChrono();
    }

    public void setTempsChrono(String nom, Chrono chrono){
        lineUp.get(nomToIndex(nom)).setChrono(chrono);
    }

    public void setTempsReference(String nom, Chrono chrono){
        lineUp.get(nomToIndex(nom)).setReference(chrono);
    }

    public void delPilote(String nom){
        lineUp.remove(nomToIndex(nom));
    }

    public void addPilote(Pilote pilote){
        lineUp.add(pilote);
    }
}
