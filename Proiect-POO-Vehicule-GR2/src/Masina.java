public class Masina extends Vehicul{
    private int capacitate_cilindrica;
    private String tip_caroserie;
    private int nrKilometri;
    private int nrLocuri;
    private String tip_faruri;


    //Constructor fara argumente
    public Masina(){
        super();
        this.capacitate_cilindrica = 0;
        this.tip_caroserie = "Nedefinit";
        this.nrKilometri = 0;
        this.nrLocuri = 0;
        this.tip_faruri = "Nedefinit";

    }
    //Constructor cu toate argumentele
    public Masina(int id, String marca, int anFabricatie , String culoare , int capacitate_cilindrica, String tip_caroserie , int nrKilometri, int nrLocuri, String tip_faruri){
        super(id,marca,anFabricatie,culoare);
        this.capacitate_cilindrica = capacitate_cilindrica;
        this.tip_caroserie = tip_caroserie;
        this.nrKilometri = nrKilometri;
        this.nrLocuri = nrLocuri;
        this.tip_faruri = tip_faruri;
    }
    //Constrictor de copiere
    public Masina(Masina m){
        super(m);
        this.capacitate_cilindrica = m.capacitate_cilindrica;
        this.tip_caroserie = m.tip_caroserie;
        this.nrKilometri = m.nrKilometri;
        this.nrLocuri = m.nrLocuri;
        this.tip_faruri = m.tip_faruri;
    }
    //Metoda toString
    @Override
    public String toString(){
        return "Autoturismul " + super.getMarca() + " cu capacitatea cilindrica de " + capacitate_cilindrica + " cm³ si tipul caroseriei " + tip_caroserie + ", numarul de kilometri este "+ nrKilometri + " km, are un numar de " + nrLocuri + " locuri si are faruri de tipul "+ tip_faruri;
    }


}
