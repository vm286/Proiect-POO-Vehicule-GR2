public class Submarin {
private String model;
private int tonaj;
public Submarin(String model, int tonaj) {
    this.model = model;
    this.tonaj = tonaj;
}
public Submarin() {
    this.model = "Not Defined";
}

    @Override
    public String toString() {
        if(model=="Not Defined"){
            return "Nu a fost definit.";
        }
        else{
            return "Submarin model "+model+" de tonaj:"+tonaj+" de tone."    ;
        }
    }
}
