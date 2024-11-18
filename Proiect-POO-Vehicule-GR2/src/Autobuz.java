public class Autobuz extends Vehicul {
    private int capacitatePasageri;
    private int linie;

    // Constructor fără argumente
    public Autobuz() {
        super();
        this.capacitatePasageri = 0;
        this.linie = 0;
    }

    // Constructor cu toate argumentele
    public Autobuz(int id, String marca, int anFabricatie, String culoare, int capacitatePasageri, int linie) {
        super(id, marca, anFabricatie, culoare);
        this.capacitatePasageri = capacitatePasageri;
        this.linie = linie;
    }

    // Constructor de copiere
    public Autobuz(Autobuz other) {
        super(other);
        this.capacitatePasageri = other.capacitatePasageri;
        this.linie = other.linie;
    }

    // Metoda toString
    @Override
    public String toString() {
        return String.format("Autobuz (ID: %d): %s [%d pasageri, linia %d]",
                super.getId(), super.getMarca(), capacitatePasageri, linie);
    }
}
