import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.*;

public class GUI_Mirea extends JFrame {
    private JButton vehiculeButton;
    private JButton trenuriButton;
    private JButton vapoareButton;
    private JCheckBox electricCuVitezăMinimăCheckBox;
    private JCheckBox combustibilMarfarCheckBox;
    private JCheckBox nuSuntSpărgătoareDeCheckBox;
    private JCheckBox spărgătoareDeGheațăCapacitateCheckBox;
    private JCheckBox IDParCheckBox;
    private JCheckBox maiNouDe2019CheckBox;
    private JButton readButton;
    private JButton resetButton;
    private JTextArea textArea;
    private JPanel gui;
    private JButton saveButton;

    static ArrayList<Vehicul> vehicule = new ArrayList<>();
    static ArrayList<Tren> trenuri = new ArrayList<>();
    static ArrayList<Vapor> vapoare = new ArrayList<>();

public GUI_Mirea() {
    setTitle("GUI_Mirea");
    setContentPane(gui);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1280, 720);
    setLocationRelativeTo(null);
    setVisible(true);
    vehiculeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            afisareVehicul();
        }
    });
    trenuriButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            afisareTrenuri();
        }
    });
    vapoareButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            afisareVapoare();
        }
    });

    resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
        }
    });
    readButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            citireFisier();
        }
    });
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output_Mirea.txt")))){
                bw.write(textArea.getText());
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    });
}

private void afisareVehicul() {
    textArea.setText("Vehicule conform condițiilor bifate:\n");
    for (Vehicul v : vehicule) {
        boolean meetsCondition = true;
        if (IDParCheckBox.isSelected() && v.getId()%2==1) {
            meetsCondition = false;
        }
        if (maiNouDe2019CheckBox.isSelected() && v.getAnFabricatie()<2019) {
            meetsCondition = false;
        }

        if (meetsCondition) {
            textArea.append(v.toString() + "\n");
        }
    }
}

private void afisareTrenuri() {
    textArea.setText("Trenuri conform condițiilor bifate:\n");
    for (Tren t : trenuri) {
        boolean meetsCondition = true;
        if (electricCuVitezăMinimăCheckBox.isSelected() && (!t.getEsteElectric() || t.getVitezaMaxima()<100)) {
            meetsCondition = false;
        }

        if (combustibilMarfarCheckBox.isSelected() && (t.getEsteElectric() || !t.getTipTren().contains("Marfar"))) {
            meetsCondition = false;
        }

        if (meetsCondition) {
            textArea.append(t.toString() + "\n");
        }
    }
}

private void afisareVapoare() {
    textArea.setText("Vapoare conform condițiilor bifate:\n");
    for (Vapor v : vapoare) {
        boolean meetsCondition = true;
        if (nuSuntSpărgătoareDeCheckBox.isSelected() && (v.getSpargatorGheata() || v.getCapacitateEchipaj()<=15)) {
            meetsCondition = false;
        }

        if (spărgătoareDeGheațăCapacitateCheckBox.isSelected() && (!v.getSpargatorGheata() || v.getCapacitateEchipaj()>=15 || !v.getCuloare().equals("Portocaliu"))) {
            meetsCondition = false;
        }

        if (meetsCondition) {
            textArea.append(v.toString() + "\n");
        }
    }
}

private void citireFisier() {
    try{
        FileInputStream fisier = new FileInputStream("C:/Users/mirea/Downloads/ProiectPOO/Proiect-POO-Vehicule-GR2/src/Fisier_Mirea.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fisier));
        String linie;

        while ((linie = br.readLine()) != null) {
            if(linie.startsWith("Vehicul:")){
                String[] valori = linie.split(":")[1].split(", ");
                vehicule.add(new Vehicul(Integer.parseInt(valori[0].trim()),valori[1].trim(), Integer.parseInt(valori[2].trim()), valori[3].trim()));
            } else if(linie.startsWith("Tren:")){
                String[] valori = linie.split(":")[1].split(", ");
                trenuri.add(new Tren(Integer.parseInt(valori[0].trim()),valori[1].trim(),Boolean.parseBoolean(valori[2].trim()),valori[3].trim(),Integer.parseInt(valori[4].trim()),valori[5].trim(),Integer.parseInt(valori[6].trim()),valori[7].trim(),Integer.parseInt(valori[8].trim())));
            } else if(linie.startsWith("Vapor:")){
                String[] valori = linie.split(":")[1].split(", ");
                vapoare.add(new Vapor(Integer.parseInt(valori[0].trim()),valori[1].trim(),Boolean.parseBoolean(valori[2].trim()),valori[3].trim(),Integer.parseInt(valori[4].trim()),valori[5].trim(),Double.parseDouble(valori[6].trim()),Integer.parseInt(valori[7].trim()),valori[8].trim()));
            }
        }
    } catch (IOException e) {
        System.out.println("Eroare : " + e.getMessage());
    }
}

public static void main(String[] args) {
    GUI_Mirea gui = new GUI_Mirea();
}
}
