import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfata_Radu extends JFrame{
    private JPanel interfata;
    private JLabel nume;
    private JCheckBox maiNouDe2015CheckBox;
    private JButton okButton;
    private JButton resetButton;
    private JTextArea textArea;
    private JCheckBox masina;
    private JCheckBox tractor;
    private JComboBox comboBox1;
    ArrayList<Masina> masinile= Masina.getListaMasini();
    public Interfata_Radu() {
        setContentPane(interfata);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              for(Masina m : masinile){
                  boolean advconditi=true;
                  if(m.getAnFabricatie()>=2015 && maiNouDe2015CheckBox.isSelected()){
                      advconditi=false;
                  }
                  if(advconditi){
                      textArea.append(m.toString()+ "\n");
                  }
              }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Interfata_Radu interfata = new Interfata_Radu();
    }
}
