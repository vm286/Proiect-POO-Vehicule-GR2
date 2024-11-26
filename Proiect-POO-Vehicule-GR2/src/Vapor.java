public class Vapor extends Vehicul implements StareVehicul {
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
    public Vapor(int id, String tipVapor, boolean spargatorGheata, String marca, int anFabricatie, String culoare, double tonaj, int capacitateEchipaj, String traseu) {
        super(id, marca, anFabricatie, culoare);
        this.tonaj = tonaj;
        this.tipVapor = tipVapor;
        this.spargatorGheata = spargatorGheata;
        this.capacitateEchipaj = capacitateEchipaj;
        this.traseu = traseu;
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

    public void setTipVapor(String tipVapor) {
        this.tipVapor = tipVapor;
    }
    public String getTipVapor() {
        return tipVapor;
    }

    public void setSpargatorGheata(boolean spargatorGheata) {
        this.spargatorGheata = spargatorGheata;
    }
    public boolean getSpargatorGheata() {
        return spargatorGheata;
    }

    public void setTonaj(double tonaj) {
        this.tonaj = tonaj;
    }
    public double getTonaj() {
        return tonaj;
    }

    public void setTraseu(String traseu) {
        this.traseu = traseu;
    }
    public String getTraseu() {
        return traseu;
    }

    public void setCapacitateEchipaj(int capacitateEchipaj) {
        this.capacitateEchipaj = capacitateEchipaj;
    }
    public int getCapacitateEchipaj() {
        return capacitateEchipaj;
    }

    // Metoda toString
    @Override
    public String toString() {
        return super.toString() + " este Vapor [Tonaj: " + tonaj + " tone, Tip: " + tipVapor + (spargatorGheata ? " este spărgător de gheață" : " nu este spărgător de gheață") + ", Capacitate Echipaj: " + capacitateEchipaj + ", Traseu: " + traseu + "]";
    }

    @Override
    public void functional() {
        System.out.println("Funcțional");
    }

    @Override
    public void nefunctional() {
        System.out.println("Nefuncțional");
    }
}

