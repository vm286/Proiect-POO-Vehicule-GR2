public class Autobuz extends Vehicul {

       String tipCombustibil;
       int capacitatePasageri;

       public Autobuz(int id, String culoare, String marca, int capacitatePasageri, int anFabricatie, String tipCombustibil){
           super(id, culoare, marca, anFabricatie);
           this.capacitatePasageri=capacitatePasageri;
           this.tipCombustibil=tipCombustibil;
       }

       public Autobuz (){

       }

    @Override
    public String toString() {
        return super.toString();
    }
}
