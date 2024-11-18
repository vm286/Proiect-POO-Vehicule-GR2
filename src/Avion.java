public class Avion extends Vehicul {
private String  Model;
public Avion(){
    super();
    Model = "";
}
public Avion(String Marca, String Model, int id, int anFabricatie, String culoare){
    super(id, Marca, anFabricatie, culoare );
    this.Marca = Marca;
    this.Model = Model;
}
public Avion(Avion a){
    super(a);
    this.Model = a.Model;
}


    @Override
    public String toString() {
    if(this.getMarca()=="Necunoscut"){
        return "Nu a fost definit.";
    }
    else{
     return "Avion de marca "+this.getMarca()+", de model "+Model+".";
    }
    }
}
