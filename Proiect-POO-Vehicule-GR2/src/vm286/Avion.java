public class Avion {
private String Marca, Model;
public Avion(){
    Marca = "Not Defined";
    Model = "";
}
public Avion(String Marca, String Model){
    this.Marca = Marca;
    this.Model = Model;
}


    @Override
    public String toString() {
    if(Marca=="Not Defined"){
        return "Nu a fost definit.";
    }
    else{
     return "Avion de marca "+Marca+", de model "+Model+".";
    }
    }
}
