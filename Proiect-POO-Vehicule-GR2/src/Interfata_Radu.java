import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interfata_Radu extends JFrame {
    private JPanel interfata;
    private JLabel nume;
    private JButton okButton;
    private JButton resetButton;
    private JTextArea textArea;
    private JRadioButton masina;
    private JRadioButton tractor;
    private JCheckBox ledCheckBox;
    private JCheckBox locuriCheckBox;
    private JCheckBox caroserieCheckBox;
    private JCheckBox incarcatorCheckBox;
    private JCheckBox tipCauciucuriCheckBox;
    private JCheckBox consumCheckBox;

    ArrayList<Masina> masinile = Masina.getListaMasini();
    ArrayList<Tractor> tractoarele = Tractor.getListaTractor();

    public Interfata_Radu() {
        setContentPane(interfata);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        // Inițial, checkbox-urile și combobox-urile sunt dezactivate
        ledCheckBox.setEnabled(false);
        locuriCheckBox.setEnabled(false);
        caroserieCheckBox.setEnabled(false);
        incarcatorCheckBox.setEnabled(false);
        tipCauciucuriCheckBox.setEnabled(false);
        consumCheckBox.setEnabled(false);

        masina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean masinaSelected = masina.isSelected();
                ledCheckBox.setEnabled(masinaSelected);
                locuriCheckBox.setEnabled(masinaSelected);
                caroserieCheckBox.setEnabled(masinaSelected);
            }
        });

        tractor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean tractorSelected = tractor.isSelected();
                incarcatorCheckBox.setEnabled(tractorSelected);
                tipCauciucuriCheckBox.setEnabled(tractorSelected);
                consumCheckBox.setEnabled(tractorSelected);
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Resetăm zona de text
                if (masina.isSelected()) {
                    for (Masina m : masinile) {
                        boolean conditions = true;
                        if (ledCheckBox.isSelected() && !m.getTip_faruri().equalsIgnoreCase("LED")) {
                            conditions = false;
                        }
                        if (locuriCheckBox.isSelected() && m.getNrLocuri() <= 5) {
                            conditions = false;
                        }
                        if (caroserieCheckBox.isSelected() && !m.getTip_caroserie().equalsIgnoreCase("Sedan")) {
                            conditions = false;
                        }
                        if (conditions) {
                            textArea.append(m.toString() + "\n");
                        }
                    }
                }
                if (tractor.isSelected()) {
                    for (Tractor t : tractoarele) {
                        boolean conditions = true;
                        if (incarcatorCheckBox.isSelected() && !t.getIncarcator()) {
                            conditions = false;
                        }
                        if (tipCauciucuriCheckBox.isSelected() && !t.getTip_roti().equalsIgnoreCase("cauciucuri")) {
                            conditions = false;
                        }
                        if (consumCheckBox.isSelected() && t.getConsum_combustibil() > 30.0) {
                            conditions = false;
                        }
                        if (conditions) {
                            textArea.append(t.toString() + "\n");
                        }
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
        interfata.setTitle("Interfata");
        /*try{
            FileInputStream fin = new FileInputStream("C:\\Users\\ionra\\Documents\\faculta\\proiecte_poo_java\\Brutarie3\\src\\fisier.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            String linie;

            while ((linie = br.readLine()) != null) {
                if (linie.startsWith("Covrig: ")) {
                    String[] valori = linie.split(": ")[1].split(", ");
                    listacovrigi.add(new Covrig(valori[0], Boolean.parseBoolean(valori[1]), valori[2], Boolean.parseBoolean(valori[3]), valori[4]));
                } //else if (linie.startsWith("Corn: ")) {
                //String[] valori = linie.split(": ")[1].split(", ");
                //listacorn.add(new Corn(valori[0], Boolean.parseBoolean(valori[1]), valori[2]));
                //}
            }
        } catch (
                IOException e) {
            System.out.println("[EROARE!] " + e.getMessage());
        }*/
    }
}
