public class Tren extends Vehicul {
    private int numarVagoane;
    private String tipTren;

    // Constructor fără argumente
    public Tren() {
        super();
        this.numarVagoane = 0;
        this.tipTren = "Necunoscut";
    }

    // Constructor cu argumentele
    public Tren(int id, String marca, int anFabricatie, String culoare, int numarVagoane, String tipTren) {
        super(id, marca, anFabricatie, culoare);
        this.numarVagoane = numarVagoane;
        this.tipTren = tipTren;
    }

    // Constructor de copiere
    public Tren(Tren other) {
        super(other);
        this.numarVagoane = other.numarVagoane;
        this.tipTren = other.tipTren;
    }

    // Metoda toString
    @Override
    public String toString() {
        return super.toString() + " este Tren [Număr Vagoane: " + numarVagoane + ", Tip: " + tipTren + "]";
    }
}
