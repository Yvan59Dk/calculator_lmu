package Equipage;

import java.util.ArrayList;
import java.util.List;
import Temps.*;

public class LineUp {
    private List<Pilote> lineUp = new ArrayList<Pilote>();

    public LineUp(Pilote pilote1){
        lineUp.add(pilote1);
    }

    public LineUp(Pilote pilote1, Pilote pilote2){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
    }

    public LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
    }

    public LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
        lineUp.add(pilote4);
    }

    public LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4, Pilote pilote5){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
        lineUp.add(pilote4);
        lineUp.add(pilote5);
    }

    public LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4, Pilote pilote5, Pilote pilote6){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
        lineUp.add(pilote4);
        lineUp.add(pilote5);
        lineUp.add(pilote6);
    }

    public LineUp(LineUp lineUp){
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

    public int pilotBestTempsChrono(){
        Pilote res = lineUp.get(0);
        int index = 0;
        for(int i = 0; i < lineUp.size(); i++){
            if(lineUp.get(i).getTempsChrono().compareTo(res.getTempsChrono()) < 0){
                res = lineUp.get(i);
                index = i;
            }
        }
        return index;
        
    }

    public int pilotBestTempsReference(){
        Pilote res = lineUp.get(0);
        int index = 0;
        for(int i = 0; i < lineUp.size(); i++){
            if(lineUp.get(i).getTempsReference().compareTo(res.getTempsReference()) < 0){
                res = lineUp.get(i);
                index = i;
            }
        }
        return index;
    }

    public Temps bestTempsChrono(){
        Pilote res = lineUp.get(pilotBestTempsChrono());
        return res.getTempsChrono();
    }

    public Temps bestTempsReference(){
        Pilote res = lineUp.get(pilotBestTempsReference());
        return res.getTempsChrono();
    }

    public void setTempsChrono(String nom, Temps chrono){
        lineUp.get(nomToIndex(nom)).setChrono(chrono);
    }

    public void setTempsReference(String nom, Temps chrono){
        lineUp.get(nomToIndex(nom)).setReference(chrono);
    }

    public void delPilote(int index){
        lineUp.remove(index);
    }

    public void addPilote(Pilote pilote){
        lineUp.add(pilote);
    }
}
