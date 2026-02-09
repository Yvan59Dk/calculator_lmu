package calculator;

/** La classe 'Fuel' est la classe qui correspond au systéme de carburant du véhicule. Elle contient le carburant actuel,
 * la consommation de carburant, le carburant maximal et le rendement de carburant par rapport à l'énergie.
 * Elle contient des méthodes permettant de aire évolué ces valeurs en fonction de la course.
*/
public class Fuel {

    /*** Double : Consommation de carburant par tour */
    public double fuel_conso;
    /*** Double : Carburant dans la voiture */
    public double fuel_actuel;
    /*** Double : Capacité de carburant max du véhicule */
    public double fuel_max;
    /*** Double : Rendement Carburant/Energy */
    public double fuel_rendement;

    public Fuel(double fuel_actuel, double fuel_conso, double fuel_max, double fuel_rendement){
        this.fuel_actuel = fuel_actuel;
        this.fuel_conso = fuel_conso;
        this.fuel_rendement = fuel_rendement;
        this.fuel_max = fuel_max;
    }

    public Fuel(double fuel_conso, double fuel_max, double fuel_rendement){
        this.fuel_conso = fuel_conso;
        this.fuel_rendement = fuel_rendement;
        this.fuel_max = fuel_max;
        this.fuel_actuel = calculator_service.fuel_rendement(this);
    }

    public Fuel(Fuel fuel){
        this.fuel_actuel = fuel.fuel_actuel;
        this.fuel_conso = fuel.fuel_conso;
        this.fuel_rendement = fuel.fuel_rendement;
        this.fuel_max = fuel.fuel_max;
    }

    /**
     * Met à jour la valeur de fuel dans le réservoir de la voiture
     * @param fuel_actuel : double qui devient la nouvelle valeur de carburant dans la voiture
     * @throws IllegalArgumentException si le paramétre n'est pas contenu entre 0 et le réservoir max
    */
    public void MAJ_fuel_actuel(double fuel_actuel){
        if (0 > fuel_actuel || fuel_actuel > fuel_max){
            throw new IllegalArgumentException(
                "Erreur de carburant : le carburant doit être compris entre 0 et " + fuel_max 
                + " ( Carburant reçu : " + fuel_actuel + " )");
        } 
        this.fuel_actuel = fuel_actuel;
    }

    public double getFuel_conso(){
        return fuel_conso;
    }
    public double getFuel_actuel(){
        return fuel_actuel;
    }
    public double getFuel_max(){
        return fuel_max;
    }
    public double getFuel_rendement(){
        return fuel_rendement;
    }

    /**
     * Met à jour la valeur de consommation de carburant
     * @param fuel_conso : double qui devient la nouvelle valeur de consommation de carburant 
     */
    public void MAJ_fuel_conso(double fuel_conso){
        this.fuel_conso = fuel_conso;
    }
    /**
     * Met à jour la valeur de consommation de carburant.
     * Si energy_actuel = 0, on part du principe que c'est une voiture qui n'a pas d'energie ( une LMP2 )
     * @param fuel_conso : double qui devient la nouvelle valeur de consommation de carburant 
     */
    public void MAJ_fuel_rendement(double fuel_rendement){
        this.fuel_rendement = fuel_rendement;
    }

    /**
     * Fait passer un tour de carburant au véhicule.
     */
    public void evolutionFuel(){
        this.fuel_actuel -= fuel_conso;
        if (this.fuel_actuel < 0){
            this.fuel_actuel = 0;
        }
    }

    public String toString(){
        return "|| Fuel réservoir : " + fuel_actuel + "\n"
                + "|| F/tour : " + fuel_conso + "\n"
                + "|| Fuel max : " + fuel_max + "\n"
                + "|| Fuel Rendement : " + fuel_rendement + "\n";
    }
}
