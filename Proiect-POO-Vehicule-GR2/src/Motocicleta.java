import java.util.ArrayList;
public class Motocicleta extends Vehicul  {
    private int cilindree;
    private boolean areAtas;
    private boolean esteElectric;
    private int nrDiscuriFata;

    // Constructor fără argumente
    public Motocicleta() {
        super();
        this.cilindree = 0;
        this.areAtas = false;
        this.esteElectric = false;
        this.nrDiscuriFata = 0;
    }

    // Constructor cu toate argumentele
    public Motocicleta(int id, int nrDiscuriFata, boolean esteElectric, String marca, int anFabricatie, String culoare, int cilindree, boolean areAtas) {
        super(id, marca, anFabricatie, culoare);
        this.cilindree = cilindree;
        this.areAtas = areAtas;
        this.esteElectric= esteElectric;
        this.nrDiscuriFata = nrDiscuriFata;

    }

    // Constructor de copiere
    public Motocicleta(Motocicleta other) {
        super(other);
        this.cilindree = other.cilindree;
        this.areAtas = other.areAtas;
        this.esteElectric = other.esteElectric;
        this.nrDiscuriFata = other.nrDiscuriFata;
    }

    // Metoda toString
    @Override
    public String toString() {
        return "Motocicleta " + super.getMarca() + " cu " + cilindree + " cm³" +
                (areAtas ? " și ataș." : " fără ataș.")+
                (esteElectric ? " este electrica." : " nu este electrica.");
    }
    //vector 10 elemente tip ArrayList
    public static ArrayList<Motocicleta> getListaMotociclete() {
        ArrayList<Motocicleta> motociclete = new ArrayList<>();
        Motocicleta BMW = new Motocicleta(1, 2, true, "bmw", 2019, "albastra", 2000, false);
        Motocicleta HarleyDavidson = new Motocicleta(2, 3, false, "Harley Davidson", 2000, "rosie", 2000, false);
        Motocicleta Honda = new Motocicleta(3, 4, false, "Honda", 2005, "rosie", 2000, false);
        Motocicleta Kawasaki = new Motocicleta(4, 4, false, "Kawasaki", 2000, "maro", 2000, true);
        Motocicleta Yamaha = new Motocicleta(5, 2, false, "Yamaha", 2012, "neagra", 1200, false);
        Motocicleta Suzuki = new Motocicleta(6, 4, true, "Suzuki", 2000, "suzuki", 2000, true);
        Motocicleta Triumph = new Motocicleta(7, 4, false, "Triumph", 1999, "triumph", 1500, false);
        Motocicleta Ducati = new Motocicleta(8, 4, false, "Ducati", 2000, "ducati", 2000, true);
        Motocicleta Aprilia = new Motocicleta(9, 2, false, "Aprilia", 2000, "aprilia", 2000, true);
        Motocicleta KTM = new Motocicleta(10, 4, false, "KTM", 2000, "ktm", 2000, true);
    return motociclete;
    }
    }
