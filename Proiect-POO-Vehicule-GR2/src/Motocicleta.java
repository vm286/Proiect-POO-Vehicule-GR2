public class Motocicleta extends Vehicul {
    private int cilindree;
    private boolean areAtas;

    // Constructor fără argumente
    public Motocicleta() {
        super();
        this.cilindree = 0;
        this.areAtas = false;
    }

    // Constructor cu toate argumentele
    public Motocicleta(int id, String marca, int anFabricatie, String culoare, int cilindree, boolean areAtas) {
        super(id, marca, anFabricatie, culoare);
        this.cilindree = cilindree;
        this.areAtas = areAtas;
    }

    // Constructor de copiere
    public Motocicleta(Motocicleta other) {
        super(other);
        this.cilindree = other.cilindree;
        this.areAtas = other.areAtas;
    }

    // Metoda toString
    @Override
    public String toString() {
        return "Motocicleta " + super.getMarca() + " cu " + cilindree + " cm³" +
                (areAtas ? " și ataș." : " fără ataș.");
    }
}
