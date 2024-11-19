public class Vapor extends Vehicul {
    private double tonaj;
    private String tipVapor;

    // Constructor fără argumente
    public Vapor() {
        super();
        this.tonaj = 0.0;
        this.tipVapor = "Necunoscut";
    }

    // Constructor cu argumentele
    public Vapor(int id, String marca, int anFabricatie, String culoare, double tonaj, String tipVapor) {
        super(id, marca, anFabricatie, culoare);
        this.tonaj = tonaj;
        this.tipVapor = tipVapor;
    }

    // Constructor de copiere
    public Vapor(Vapor other) {
        super(other);
        this.tonaj = other.tonaj;
        this.tipVapor = other.tipVapor;
    }

    // Metoda toString
    @Override
    public String toString() {
        return super.toString() + " este Vapor [Tonaj: " + tonaj + " tone, Tip: " + tipVapor + "]";
    }
}

