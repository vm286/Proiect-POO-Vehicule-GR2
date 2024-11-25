public class Masina extends Vehicul{
    private int capacitate_cilindrica;
    private String tip_caroserie;
    private float consum_combustibil;


    //Constructor fara argumente
    public Masina(){
        super();
        this.capacitate_cilindrica = 0;
        this.tip_caroserie = "Nedefinit";
    }
    //Constructor cu toate argumentele
    public Masina(int id, String marca, int anFabricatie , String culoare , int capacitate_cilindrica, String tip_caroserie){
        super(id,marca,anFabricatie,culoare);
        this.capacitate_cilindrica = capacitate_cilindrica;
        this.tip_caroserie = tip_caroserie;
    }
    //Constrictor de copiere
    public Masina(Masina m){
        super(m);
        this.capacitate_cilindrica = m.capacitate_cilindrica;
        this.tip_caroserie = m.tip_caroserie;
    }
    //Metoda toString
    @Override
    public String toString(){
        return "Autoturismul " + super.getMarca() + " cu capacitatea cilindrica de " + capacitate_cilindrica + " cm³ si de tipul caroseriei " + tip_caroserie;
    }


}
