public enum Categorie {
    HYP("Hypercar"), 
    LMP2("LMP2"), 
    LMP3("LMP3"), 
    LMGT3("LMGT3"), 
    LMGTE("LMGTE"); 

    private String description;

    private Categorie(String desc){
        this.description = desc;
    }

    public String getDescription(){
        return description;
    }
}
