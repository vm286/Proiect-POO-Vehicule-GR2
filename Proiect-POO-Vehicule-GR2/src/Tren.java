public class Tren extends Vehicul {
    private int numarVagoane;
    private String tipTren;
    private boolean esteElectric;
    private String ruta;
    private int vitezaMaxima;


    // Constructor fără argumente
    public Tren() {
        super();
        this.numarVagoane = 0;
        this.esteElectric = false;
        this.ruta = "Necunoscut";
        this.vitezaMaxima = 0;
        this.tipTren = "Necunoscut";
    }

    // Constructor cu argumentele
    public Tren(int id, String marca, int anFabricatie, String culoare, int numarVagoane, String tipTren, boolean electric, String ruta, int vitezaMaxima) {
        super(id, marca, anFabricatie, culoare);
        this.numarVagoane = numarVagoane;
        this.tipTren = tipTren;
        this.esteElectric = electric;
        this.ruta = ruta;
        this.vitezaMaxima = vitezaMaxima;
    }

    // Constructor de copiere
    public Tren(Tren other) {
        super(other);
        this.numarVagoane = other.numarVagoane;
        this.tipTren = other.tipTren;
        this.esteElectric = other.esteElectric;
        this.ruta = other.ruta;
        this.vitezaMaxima = other.vitezaMaxima;
    }

    // Metoda toString
    @Override
    public String toString() {
        return super.toString() + " este Tren [Număr Vagoane: " + numarVagoane + ", Tip: " + tipTren + (esteElectric ? " este electric" : " nu este electrica") + ", Ruta: " + ruta +
                ", Viteza Maxima: " + vitezaMaxima + " km/h" + "]";
    }
}
