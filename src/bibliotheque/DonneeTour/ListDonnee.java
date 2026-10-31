package bibliotheque.DonneeTour;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ListDonnee implements Iterable<Donnee>{
    private ArrayList<Donnee> list;

    public ListDonnee(){
        this.list = new ArrayList<>();
    }

    public ListDonnee(ArrayList<Donnee> list){
        this.list = list;
    }

    public ListDonnee(List<Donnee> list){
        this.list = new ArrayList<>();
        for(Donnee d : list){
            ajouter(d);
        }
    }

    public ListDonnee(ListDonnee liste){
        this.list = new ArrayList<>();
        for(Donnee d : liste){
            ajouter(d);
        }
    }

    public void ajouter(Donnee d){
        list.add(d);
    }

    public int size(){
        return list.size();
    }

    public Stream<Donnee> stream(){
        return list.stream();
    }

    @Override 
    public Iterator<Donnee> iterator(){
        return new Iterator<Donnee>() {
            private int courant = 0;

            public boolean hasNext(){
                return (courant < list.size());
            }

            public Donnee next(){
                return list.get(courant++);
            }
        };
    }
}
