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
