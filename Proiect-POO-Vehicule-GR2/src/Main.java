//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
Avion av = new Avion();
Submarin sub=new Submarin();
System.out.println(av);
System.out.println(sub);
Tractor tractor1= new Tractor(22,"Same",2010,"ROSU",110, "functional" );
System.out.println(tractor1);
Tren IR1801 = new Tren(1801,"CFR",2004,"ALBASTRU",3,"NORMAL");
System.out.println(IR1801);
    }
}