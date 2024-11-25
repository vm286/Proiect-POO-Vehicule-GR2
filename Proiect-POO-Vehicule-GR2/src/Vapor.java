public class Vapor extends Vehicul {
    private String tipVapor;
    private double tonaj;
    private boolean spargatorGheata;
    private int capacitateEchipaj;
    private String traseu;

    // Constructor fără argumente
    public Vapor() {
        super();
        this.tonaj = 0.0;
        this.tipVapor = "Necunoscut";
        this.spargatorGheata = false;
        this.capacitateEchipaj = 0;
        this.traseu = "Necunoscut";
    }

    // Constructor cu argumentele
    public Vapor(int id, String marca, int anFabricatie, String culoare, double tonaj, String tipVapor, boolean spargatorGheata, int capacitateEchipaj, String destinatie) {
        super(id, marca, anFabricatie, culoare);
        this.tonaj = tonaj;
        this.tipVapor = tipVapor;
        this.spargatorGheata = spargatorGheata;
        this.capacitateEchipaj = capacitateEchipaj;
        this.traseu = destinatie;
    }

    // Constructor de copiere
    public Vapor(Vapor other) {
        super(other);
        this.tonaj = other.tonaj;
        this.tipVapor = other.tipVapor;
        this.spargatorGheata = other.spargatorGheata;
        this.capacitateEchipaj = other.capacitateEchipaj;
        this.traseu = other.traseu;
    }

    // Metoda toString
    @Override
    public String toString() {
        return super.toString() + " este Vapor [Tonaj: " + tonaj + " tone, Tip: " + tipVapor + (spargatorGheata ? " este spărgător de gheață" : " nu este spărgător de gheață") + ", Capacitate Echipaj: " + capacitateEchipaj + ", Traseu: " + traseu + "]";
    }
}

