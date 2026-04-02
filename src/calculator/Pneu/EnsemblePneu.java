package calculator.Pneu;

import java.util.ArrayList;
import java.util.List;

public class EnsemblePneu {
    private List<Pneu> listPneu;

    public EnsemblePneu(){
        listPneu = new ArrayList<Pneu>();
        listPneu.add(new Pneu("AVG", 100));
        listPneu.add(new Pneu("AVD", 100));
        listPneu.add(new Pneu("ARG", 100));
        listPneu.add(new Pneu("ARD", 100));
    }

    public List<Pneu> getEnsemblePneus(){
        return listPneu;
    }
}
