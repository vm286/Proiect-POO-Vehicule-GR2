import java.util.Objects;

public class Autobuz extends Vehicul {
    public int getLinie;
    private int capacitatePasageri;
    private int linie;
    private boolean aerConditionat;
    private String normaEmisii;
    private boolean esteElectric;

    // Constructor fără argumente
    public Autobuz() {
        super();
        this.capacitatePasageri = 0;
        this.linie = 0;
        this.aerConditionat = false;
        this.normaEmisii = "Necunoscut";
        this.esteElectric = false;
    }

    // Constructor cu toate argumentele
    public Autobuz(int id,boolean esteElectric, String normaEmisii, String marca, boolean aerConditionat, int anFabricatie, String culoare, int capacitatePasageri, int linie) {
        super(id, marca, anFabricatie, culoare);
        this.capacitatePasageri = capacitatePasageri;
        this.linie = linie;
        this.aerConditionat = aerConditionat;
        this.normaEmisii = normaEmisii;
        this.esteElectric = esteElectric;
    }

    // Constructor de copiere
    public Autobuz(Autobuz other) {
        super(other);
        this.capacitatePasageri = other.capacitatePasageri;
        this.linie = other.linie;
        this.aerConditionat = other.aerConditionat;
        this.normaEmisii = other.normaEmisii;
        this.esteElectric = other.esteElectric;
    }

    public void setAerConditionat(boolean aerConditionat) {
        this.aerConditionat = aerConditionat;
    }

    public void setEsteElectric(boolean esteElectric) {
        this.esteElectric = esteElectric;
    }

    public void setNormaEmisii(String normaEmisii) {
        this.normaEmisii = normaEmisii;
    }

    public void setLinie(int linie) {
        this.linie = linie;
    }

    public void setCapacitatePasageri(int capacitatePasageri) {
        this.capacitatePasageri = capacitatePasageri;
    }

    public boolean isAerConditionat() {
        return aerConditionat;
    }

    public boolean isEsteElectric() {
        return esteElectric;
    }

    public String getNormaEmisii() {
        return normaEmisii;
    }

    public int getLinie() {
        return getLinie;
    }

    public int getCapacitatePasageri() {
        return capacitatePasageri;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(linie);
    }

    // Metoda toString
    @Override
    public String toString() {
        return "Autobuzul " + super.getMarca() + " cu " + capacitatePasageri +
                " locuri si care circula pe" + " linia "+ linie+
                (aerConditionat ? " are aer conditionat." : " nu are aer conditionat.");
    }

}
