//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Vehicul{
    public static void main(String[] args) {
        Avion av = new Avion();
        Submarin sub = new Submarin();
        System.out.println(av);
        System.out.println(sub);

        Tractor tractor1= new Tractor(22,"Same",2010,"ROSU",110, "functional" );
    System.out.println(tractor1);
    }
}