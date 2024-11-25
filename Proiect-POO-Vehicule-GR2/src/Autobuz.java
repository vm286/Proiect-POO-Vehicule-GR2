public class Autobuz extends Vehicul {
    private int capacitatePasageri;
    private int linie;
    private boolean aerConditionat;
    private String normaEmisii;

    // Constructor fără argumente
    public Autobuz() {
        super();
        this.capacitatePasageri = 0;
        this.linie = 0;
        this.aerConditionat = false;
        this.normaEmisii = "Necunoscut";
    }

    // Constructor cu toate argumentele
    public Autobuz(int id, String marca, boolean aerConditionat, int anFabricatie, String culoare, int capacitatePasageri, int linie) {
        super(id, marca, anFabricatie, culoare);
        this.capacitatePasageri = capacitatePasageri;
        this.linie = linie;
        this.aerConditionat = aerConditionat;
        this.normaEmisii = normaEmisii;
    }

    // Constructor de copiere
    public Autobuz(Autobuz other) {
        super(other);
        this.capacitatePasageri = other.capacitatePasageri;
        this.linie = other.linie;
        this.aerConditionat = other.aerConditionat;
        this.normaEmisii = other.normaEmisii;
    }

    // Metoda toString
    @Override
    public String toString() {
        return "Autobuzul " + super.getMarca() + " cu " + capacitatePasageri +
                " locuri si care circula pe" + linie + " linia "+
                (aerConditionat ? " are aer conditionat." : " nu are aer conditionat.");
    }

}
