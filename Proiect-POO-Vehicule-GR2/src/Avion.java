import java.util.ArrayList;

public class Avion extends Vehicul {
private String  Model,tipMotor;
private int maxrange,pssnr,cargolim;
public Avion(){
    super();
    Model = "";
}
public Avion(String Marca, String Model, int id, int anFabricatie, String culoare, int maxrange, int pssnr, int cargolim, String tipMotor) {
    super(id, Marca, anFabricatie, culoare );
    this.Model = Model;
    this.maxrange = maxrange;
    this.pssnr = pssnr;
    this.cargolim = cargolim;
    this.tipMotor = tipMotor;
}
public Avion(Avion a){
    super(a);
    this.Model = a.Model;
    this.maxrange = a.maxrange;
    this.pssnr = a.pssnr;
    this.cargolim = a.cargolim;
    this.tipMotor = a.tipMotor;
}
    //vector 10 elemente tip ArrayList
    public static ArrayList<Avion> getListaAvioane() {
        ArrayList<Avion> avioane = new ArrayList<>();
        Avion Mcdonnel = new Avion("Mcdonnel", "DC117", 1, 1967, "Argintiu", 3000, 78, 25, "Turboprop x 4");
        Avion Boeing = new Avion("Boeing", "777", 2, 2008, "Alb", 23000, 99, 150, "Turbofan x 4");
        Avion Airbus = new Avion("Airbus", "A220", 3, 2012, "Alb", 22500, 120, 225, "Turbofan x 4");
        Avion Dassault = new Avion("Dassault", "Mirage", 4, 1978, "Industrial Grey", 3000, 1, 12, "Jet x 1");
        Avion Fairchild = new Avion("Fairchild", "A-10", 5, 1977, "Gri", 3000, 2, 8, "Jet x 2");



        return avioane;
    }

    @Override
    public String toString() {
    if(super.getMarca()=="Necunoscut"){
        return "Nu a fost definit.";
    }
    else{
     return "Avion de marca "+super.getMarca()+", de model "+Model+", care poate transporta "+this.pssnr+" de oameni, "+this.cargolim+" de tone de marfa cu motor tip "+this.tipMotor;
    }
    }
}
