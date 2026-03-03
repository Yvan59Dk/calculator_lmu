package Equipage;

import java.util.List;

public class LineUp implements Method_LineUp {
    private List<Pilote> lineUp;
    private int nombrePilote;

    LineUp(Pilote pilote1){
        lineUp.add(pilote1);
        nombrePilote = 1;
    }

    LineUp(Pilote pilote1, Pilote pilote2){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        nombrePilote = 2;
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
        nombrePilote = 3;
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
        lineUp.add(pilote4);
        nombrePilote = 4;
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4, Pilote pilote5){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
        lineUp.add(pilote4);
        lineUp.add(pilote5);
        nombrePilote = 5;
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4, Pilote pilote5, Pilote pilote6){
        lineUp.add(pilote1);
        lineUp.add(pilote2);
        lineUp.add(pilote3);
        lineUp.add(pilote4);
        lineUp.add(pilote5);
        lineUp.add(pilote6);
        nombrePilote = 6;
    }

    LineUp(LineUp lineUp){
        this.lineUp = lineUp.getLineUp();
        nombrePilote = this.lineUp.size();
    }

    public Pilote getPiloteNumero(int numero){
        if(lineUp.get(numero-1).nom == null){
            return null;
        } else if (numero < 0 || nombrePilote < numero){
            throw new IllegalArgumentException("Problème Index-1 Pilote : index-1 reçu = " + numero);
        } else {
            return lineUp.get(numero-1);
        }
    }

    public Pilote getPiloteNom(String nom){
        for(int i = 0; i < nombrePilote-1; i++){
            if (lineUp.get(i).nom == nom){
                return lineUp.get(i);
            }
        }
        return null;
    }

    public List<Pilote> getLineUp(){
        return lineUp;
    }
}
