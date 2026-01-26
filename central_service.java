public class Central_service {
    final static double ENERGY_MAX = 100.0;
    final static double HYP_FUEL_MAX = 120.0;
    final static double LMP2_FUEL_MAX = 75.0;

    int spec = 0; // 1 = HYP, 2 = LMP2
    double conso_fuel;
    double fuel_max;
    double nbTour;
    double[] save;

    int[] chrono;
    int[] tempsRestant;

    Central_service(int spec){
        this.spec = spec;

        this.conso_fuel = 2.0; // Valeur de base
        if (spec == 1){
            this.fuel_max = HYP_FUEL_MAX;
        } else if (spec == 2){
            this.fuel_max = LMP2_FUEL_MAX;
        } else {
            System.out.printf("ERROR : pas de spec");
        }
        this.nbTour = 0;
        this.save = new double[10];

        this.chrono = new int[3];
        this.tempsRestant = new int[3];
    }

    Central_service(int spec, double conso_fuel, int M_Chrono, int S_Chrono, int MS_Chrono, int H_temp, int M_temp, int S_temp){
        this.spec = spec;

        this.conso_fuel = conso_fuel; // Valeur de base
        if (spec == 1){
            this.fuel_max = HYP_FUEL_MAX;
        } else if (spec == 2){
            this.fuel_max = LMP2_FUEL_MAX;
        } else {
            System.out.printf("ERROR : pas de spec");
        }
        this.nbTour = 0;
        this.save = new double[10];

        this.chrono[0] = M_Chrono; this.chrono[1] = S_Chrono; this.chrono[2] = H_temp;
        this.tempsRestant[0] = H_temp; this.tempsRestant[1] = M_temp; this.tempsRestant[2] = S_temp;
    }
}
