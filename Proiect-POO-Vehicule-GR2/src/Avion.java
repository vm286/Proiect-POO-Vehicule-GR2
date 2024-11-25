public class Avion extends Vehicul {
private String  Model,tipMotor;
private int maxrange,pssnr,cargolim;
public Avion(){
    super();
    Model = "";
}
public Avion(String Marca, String Model, int id, int anFabricatie, String culoare, ){
    super(id, Marca, anFabricatie, culoare );
    this.Model = Model;
}
public Avion(Avion a){
    super(a);
    this.Model = a.Model;
}


    @Override
    public String toString() {
    if(super.getMarca()=="Necunoscut"){
        return "Nu a fost definit.";
    }
    else{
     return "Avion de marca "+super.getMarca()+", de model "+Model+", ";
    }
    }
}
