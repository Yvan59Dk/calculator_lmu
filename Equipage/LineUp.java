package Equipage;

public class LineUp {
    private Pilote[] lineUp;
    private int nombrePilote;

    LineUp(Pilote pilote1){
        lineUp[0] = pilote1;
        nombrePilote = 1;
    }

    LineUp(Pilote pilote1, Pilote pilote2){
        lineUp[0] = pilote1;
        lineUp[1] = pilote2;
        nombrePilote = 2;
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3){
        lineUp[0] = pilote1;
        lineUp[1] = pilote2;
        lineUp[2] = pilote3;
        nombrePilote = 3;
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4){
        lineUp[0] = pilote1;
        lineUp[1] = pilote2;
        lineUp[2] = pilote3;
        lineUp[3] = pilote4;
        nombrePilote = 4;
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4, Pilote pilote5){
        lineUp[0] = pilote1;
        lineUp[1] = pilote2;
        lineUp[2] = pilote3;
        lineUp[3] = pilote4;
        lineUp[4] = pilote5;
        nombrePilote = 5;
    }

    LineUp(Pilote pilote1, Pilote pilote2, Pilote pilote3, Pilote pilote4, Pilote pilote5, Pilote pilote6){
        lineUp[0] = pilote1;
        lineUp[1] = pilote2;
        lineUp[2] = pilote3;
        lineUp[3] = pilote4;
        lineUp[4] = pilote5;
        lineUp[5] = pilote6;
        nombrePilote = 6;
    }

    public Pilote getPilote(int n){
        if(lineUp[n-1].getNom() == null){
            return null;
        } else if (n < 0 || nombrePilote < n){
            throw new IllegalArgumentException("Problème Index-1 Pilote : index-1 reçu = " + n);
        } else {
            return lineUp[n-1];
        }
    }
}
