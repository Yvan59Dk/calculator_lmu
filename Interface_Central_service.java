public interface Interface_Central_service {
    // Méthode de mise à jour des données du fuel
    public void MAJ_fuel_actuel(double fuel_actuel);
    public void MAJ_fuel_conso(double fuel_conso);
    public void MAJ_fuel_rendement(double fuel_rendement); 

    // Méthode de mise à jour des données de l'énergie
    public void MAJ_energy_actuel(double energy_actuel);
    public void MAJ_energy_conso(double energy_conso);
    
    // Méthode de mise à jour des données en rapport avec le temps
    public void MAJ_chrono(int m, int s, int ms);
    public void MAJ_tempsRestant(int h, int m, int s);

    // Grosse méthode de calcul.
    // public void calcul_save(int limite);
}
