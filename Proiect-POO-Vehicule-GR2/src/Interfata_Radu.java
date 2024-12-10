import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Interfata_Radu extends JFrame {
    private JPanel interfata;
    private JRadioButton vehiculebutton;
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
    private JButton savebutton;
    private JRadioButton citestedinfisierButton;

    ArrayList<Masina> masinile = Masina.getListaMasini();
    ArrayList<Tractor> tractoarele = Tractor.getListaTractor();
    ArrayList<Vehicul> vehicule =Vehicul.getListaVehicule();
    ArrayList<Masina> masinute= new ArrayList<>();
    ArrayList<Tractor> tractoare= new ArrayList<>();
    ArrayList<Vehicul> vehicule2= new ArrayList<>();

    public Interfata_Radu() {
        setContentPane(interfata);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
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
                boolean dinfisier=citestedinfisierButton.isSelected();
                if (masina.isSelected()) {
                    for (Masina m : (dinfisier?masinute:masinile)) {
                        boolean conditions = true;
                        if (ledCheckBox.isSelected() && !m.getTip_faruri().equalsIgnoreCase("LED")) {
                            conditions = false;
                        }
                        if (locuriCheckBox.isSelected() && m.getNrLocuri() != 2) {
                            conditions = false;
                        }
                        if (caroserieCheckBox.isSelected() && !m.getTip_caroserie().equalsIgnoreCase("SUV")) {
                            conditions = false;
                        }
                        if (conditions) {
                            textArea.append(m.toString() + "\n");
                        }
                    }
                }

                if (tractor.isSelected()) {
                    for (Tractor t : (dinfisier?tractoare:tractoarele)) {
                        boolean conditions = true;
                        if (incarcatorCheckBox.isSelected() && !t.getIncarcator()) {
                            conditions = false;
                        }
                        if (tipCauciucuriCheckBox.isSelected() && !t.getTip_roti().equalsIgnoreCase("senile")) {
                            conditions = false;
                        }
                        if (consumCheckBox.isSelected() && t.getConsum_combustibil() >=30.0) {
                            conditions = false;
                        }
                        if (conditions) {
                            textArea.append(t.toString() + "\n");
                        }
                    }
                }
                if(vehiculebutton.isSelected()) {
                    for(Vehicul v : (dinfisier? vehicule2:vehicule)) {
                        textArea.append(v.toString() + "\n");
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
        citestedinfisierButton.addActionListener(new ActionListener() {int i=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i<1){
                try{
                    FileInputStream fin = new FileInputStream("C:\\Users\\ionra\\Documents\\faculta\\proiecte_poo_java\\Proiect-POO\\Proiect-POO-Vehicule-GR2\\src\\fisierRadu.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    String linie;

                    while ((linie = br.readLine()) != null) {
                        if (linie.startsWith("Masina: ")) {
                            String[] valori = linie.split(": ")[1].split(", ");
                            masinute.add(new Masina(Integer.parseInt(valori[0]), valori[1], Integer.parseInt(valori[2]), valori[3], Integer.parseInt(valori[4]),valori[5],Integer.parseInt(valori[6]),Integer.parseInt(valori[7]),valori[8]));
                        } else if (linie.startsWith("Tractor: ")) {
                        String[] valori = linie.split(": ")[1].split(", ");
                        tractoare.add(new Tractor(Integer.parseInt(valori[0]), valori[1], Integer.parseInt(valori[2]), valori[3], Integer.parseInt(valori[4]),valori[5],Double.parseDouble(valori[6]),Integer.parseInt(valori[7]),Boolean.parseBoolean(valori[8])));
                        } else if (linie.startsWith("Vehicul: ")) {
                            String[] valori = linie.split(": ")[1].split(", ");
                            vehicule2.add(new Vehicul(Integer.parseInt(valori[0]),valori[1],Integer.parseInt(valori[2]),valori[3]));
                        }
                    }
                }
                catch (
                        IOException f) {
                    System.out.println("[EROARE!] " + f.getMessage());
                } i=i+1;}
                else {ArrayList<Masina> masinute= Masina.getListaMasini();
                    ArrayList<Tractor> tractoare= Tractor.getListaTractor();
                    ArrayList<Vehicul> vehicule2= Vehicul.getListaVehicule();}
            }
        });
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(interfata);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                        bw.write(textArea.getText());
                        JOptionPane.showMessageDialog(interfata, "Rezultatele au fost salvate.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog( interfata,"Eroare la salvarea fișierului.");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        Interfata_Radu interfata = new Interfata_Radu();
        interfata.setTitle("Interfata Vehicule");

    }
}
