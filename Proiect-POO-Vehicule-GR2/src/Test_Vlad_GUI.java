/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;

public class Test_Vlad_GUI extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Test_Vlad_GUI::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        // Main Frame
        JFrame frame = new JFrame("Vehicul Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Main Components
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane textScrollPane = new JScrollPane(textArea);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Checkboxes for filtering
        JCheckBox showNuclearSubmarines = new JCheckBox("Nuclear Submarines");
        JCheckBox showConventionalSubmarines = new JCheckBox("Conventional Fuel Submarines (Diesel)");
        JCheckBox showMilitaryJets = new JCheckBox("Military Jets");
        JCheckBox showPropellerMilitaryPlanes = new JCheckBox("Propeller Military Planes");
        JCheckBox showDeepDivingSubmarines = new JCheckBox("Submarines with Depth > 1500m");
        JCheckBox showLongRangePlanes = new JCheckBox("Airplanes with Range > 10,000km");

        leftPanel.add(showNuclearSubmarines);
        leftPanel.add(showConventionalSubmarines);
        leftPanel.add(showMilitaryJets);
        leftPanel.add(showPropellerMilitaryPlanes);
        leftPanel.add(showDeepDivingSubmarines);
        leftPanel.add(showLongRangePlanes);

        // Add components to frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(textScrollPane, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Buttons
        JButton readFromFileButton = new JButton("Citeste din Fisier");
        JButton writeToFileButton = new JButton("Scriere intr-un Fisier");
        bottomPanel.add(readFromFileButton);
        bottomPanel.add(writeToFileButton);

        // Load data from file
        ArrayList<Submarin> submarines = new ArrayList<>();
        ArrayList<Avion> airplanes = new ArrayList<>();

        readFromFileButton.addActionListener(e -> {
            try (BufferedReader br = new BufferedReader(new FileReader(new File("text.txt")))) {
                String line;

                // Read each line from the file
                while ((line = br.readLine()) != null) {
                    if (line.contains("Submarin")) {  // Check if it's a Submarin entry
                        String model = line.split("model ")[1].split(" de tonaj:")[0].trim();
                        int tonaj = Integer.parseInt(line.split(" de tonaj:")[1].split(" de tone")[0].trim());
                        int id = Integer.parseInt(line.split("\\.")[0].trim());
                        int adancimeMax = Integer.parseInt(line.split("adancime maxima de:")[1].split(" cu combustibil")[0].trim());
                        String combustibil = line.split("cu combustibil ")[1].split(" si cu armamentul:")[0].trim();
                        String armament = line.split("si cu armamentul:")[1].split(" ,fabricat in ")[0].trim();
                        int anFabricatie = Integer.parseInt(line.split("fabricat in ")[1].trim());
                        String culoare = line.split("cu culoare: ")[1].split(" si cu armamentul:")[0].trim();  // Extract color

                        submarines.add(new Submarin(model, tonaj, id, anFabricatie, culoare, adancimeMax, combustibil, armament));
                    } else if (line.contains("Avion")) {  // Check if it's an Avion entry
                        String model = line.split("model ")[1].split(" care poate transporta")[0].trim();
                        String marca = line.split("marca ")[1].split(", de model")[0].trim();
                        int id = Integer.parseInt(line.split("\\.")[0].trim());
                        int maxrange = Integer.parseInt(line.split("cu raza:")[1].split(" fabricat in")[0].trim());
                        String tipMotor = line.split("motor tip ")[1].split(" cu culoare:")[0].trim();
                        int pssnr = Integer.parseInt(line.split("poate transporta ")[1].split(" de oameni")[0].trim());
                        int cargolim = Integer.parseInt(line.split("de tone de marfa")[0].split(" transporta")[1].trim());
                        int anFabricatie = Integer.parseInt(line.split("fabricat in anul:")[1].split(" cu scop")[0].trim());
                        boolean mil = line.contains("cu scop militar");
                        String culoare = line.split("cu culoare: ")[1].split(" cu raza:")[0].trim();  // Extract color

                        airplanes.add(new Avion(marca, model, id, anFabricatie, culoare, maxrange, pssnr, cargolim, tipMotor, mil));
                    }
                }

                // Sort the lists (you can choose any property to sort, here we're using 'id' for both)
                submarines.sort((s1, s2) -> Integer.compare(s1.getId(), s2.getId()));
                airplanes.sort((a1, a2) -> Integer.compare(a1.getId(), a2.getId()));

                // Clear previous text from the text area
                textArea.setText("");

                // Display the sorted list in the text area
                for (Submarin sub : submarines) {
                    textArea.append(sub.toString());
                }
                for (Avion av : airplanes) {
                    textArea.append(av.toString());
                }

            } catch (IOException ex) {
                // Handle the exception silently or print to console for debugging
                ex.printStackTrace();
            }
        });


        // Action Listeners for Checkboxes
        ItemListener updateRightPanel = e -> {
            rightPanel.removeAll();
            if (showNuclearSubmarines.isSelected()) {
                for (Submarin sub : submarines) {
                    if (sub.isNuclear() && sub.getTipArmament().contains("Torpile")) {
                        rightPanel.add(new JLabel(sub.toString()));
                    }
                }
            }
            if (showConventionalSubmarines.isSelected()) {
                for (Submarin sub : submarines) {
                    if (!sub.isNuclear()) {
                        rightPanel.add(new JLabel(sub.toString()));
                    }
                }
            }
            if (showMilitaryJets.isSelected()) {
                for (Avion av : airplanes) {
                    if (av.isJetType() && av.isMil()) {
                        rightPanel.add(new JLabel(av.toString()));
                    }
                }
            }
            if (showPropellerMilitaryPlanes.isSelected()) {
                for (Avion av : airplanes) {
                    if (!av.isJetType() && av.isMil()) {
                        rightPanel.add(new JLabel(av.toString()));
                    }
                }
            }
            if (showDeepDivingSubmarines.isSelected()) {
                for (Submarin sub : submarines) {
                    if (sub.getAdancimeMax() > 1500) {
                        rightPanel.add(new JLabel(sub.toString()));
                    }
                }
            }
            if (showLongRangePlanes.isSelected()) {
                for (Avion av : airplanes) {
                    if (av.getMaxrange() > 10000) {
                        rightPanel.add(new JLabel(av.toString()));
                    }
                }
            }
            rightPanel.revalidate();
            rightPanel.repaint();
        };

        showNuclearSubmarines.addItemListener(updateRightPanel);
        showConventionalSubmarines.addItemListener(updateRightPanel);
        showMilitaryJets.addItemListener(updateRightPanel);
        showPropellerMilitaryPlanes.addItemListener(updateRightPanel);
        showDeepDivingSubmarines.addItemListener(updateRightPanel);
        showLongRangePlanes.addItemListener(updateRightPanel);

        // Action Listener for "Read From File"
        readFromFileButton.addActionListener(e -> {
            StringBuilder newFileContent = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(new File("text.txt")))) {
                String line;
                while ((line = br.readLine()) != null) {
                    newFileContent.append(line).append("\n");
                }
                textArea.setText(newFileContent.toString());
            } catch (IOException ex) {
                textArea.setText("Error reading the file: " + ex.getMessage());
            }
        });

        // Action Listener for "Write To File"
        writeToFileButton.addActionListener(e -> {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("textout.txt")))) {
                String textAreaContent = textArea.getText(); // Get the content of the text area
                bw.write(textAreaContent); // Write it to the file
            } catch (IOException ex) {
                // Silent catch; no feedback to the user.
            }
        });



        // Display the frame
        frame.setVisible(true);
    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;

public class Test_Vlad_GUI extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Test_Vlad_GUI::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        // Main Frame
        JFrame frame = new JFrame("Vehicul Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Main Components
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane textScrollPane = new JScrollPane(textArea);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Checkboxes for filtering
        JCheckBox showNuclearSubmarines = new JCheckBox("Nuclear Submarines");
        JCheckBox showConventionalSubmarines = new JCheckBox("Conventional Fuel Submarines (Diesel)");
        JCheckBox showMilitaryJets = new JCheckBox("Military Jets");
        JCheckBox showPropellerMilitaryPlanes = new JCheckBox("Propeller Military Planes");
        JCheckBox showDeepDivingSubmarines = new JCheckBox("Submarines with Depth > 1500m");
        JCheckBox showLongRangePlanes = new JCheckBox("Airplanes with Range > 10,000km");

        leftPanel.add(showNuclearSubmarines);
        leftPanel.add(showConventionalSubmarines);
        leftPanel.add(showMilitaryJets);
        leftPanel.add(showPropellerMilitaryPlanes);
        leftPanel.add(showDeepDivingSubmarines);
        leftPanel.add(showLongRangePlanes);

        // Add components to frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(textScrollPane, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Buttons
        JButton readFromFileButton = new JButton("Citeste din Fisier");
        JButton writeToFileButton = new JButton("Scriere intr-un Fisier");
        bottomPanel.add(readFromFileButton);
        bottomPanel.add(writeToFileButton);

        // Load data from file
        ArrayList<Submarin> submarines = new ArrayList<>();
        ArrayList<Avion> airplanes = new ArrayList<>();

        // Read From File Button
        readFromFileButton.addActionListener(e -> {
            submarines.clear();
            airplanes.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(new File("text.txt")))) {
                String line;

                // Read each line from the file
                while ((line = br.readLine()) != null) {
                    if (line.contains("Submarin")) {
                        // Parse Submarin data
                        String model = line.split("model ")[1].split(" de tonaj:")[0].trim();
                        int tonaj = Integer.parseInt(line.split(" de tonaj:")[1].split(" de tone")[0].trim());
                        int id = Integer.parseInt(line.split("\\.")[0].trim());
                        int adancimeMax = Integer.parseInt(line.split("adancime maxima de:")[1].split(" cu combustibil")[0].trim());
                        String combustibil = line.split("cu combustibil ")[1].split(" cu culoare")[0].trim();
                        String culoare = line.split("cu culoare: ")[1].split(" si cu armamentul:")[0].trim();
                        String armament = line.split("si cu armamentul:")[1].split(" ,fabricat in ")[0].trim();
                        int anFabricatie = Integer.parseInt(line.split("fabricat in ")[1].trim());
                        System.out.println(combustibil);
                        submarines.add(new Submarin(model, tonaj, id, anFabricatie, culoare, adancimeMax, combustibil, armament));
                    } else if (line.contains("Avion")) {
                        // Parse Avion data
                        String model = line.split("model ")[1].split(" care poate transporta")[0].trim();
                        String marca = line.split("marca ")[1].split(", de model")[0].trim();
                        int id = Integer.parseInt(line.split("\\.")[0].trim());

                        String maxrangeString = line.split("cu raza:")[1].split(" fabricat in")[0].trim();
                        maxrangeString = maxrangeString.replaceAll("[^\\d]", "");
                        int maxrange = Integer.parseInt(maxrangeString);

                        String tipMotor = line.split("motor tip ")[1].split(" cu culoare:")[0].trim();

                        String pssnrString = line.split("poate transporta ")[1].split(" de oameni")[0].trim();
                        pssnrString = pssnrString.replaceAll("[^\\d]", "");
                        int pssnr = Integer.parseInt(pssnrString);

                        String cargolimString = line.split("de tone de marfa")[0].split(" transporta")[1].trim();
                        cargolimString = cargolimString.replaceAll("[^\\d]", "");
                        int cargolim = Integer.parseInt(cargolimString);

                        int anFabricatie = Integer.parseInt(line.split("fabricat in anul:")[1].split(" cu scop")[0].trim());

                        boolean mil = line.contains("cu scop militar");
                        String culoare = line.split("cu culoare: ")[1].split(" cu raza:")[0].trim();

                        airplanes.add(new Avion(marca, model, id, anFabricatie, culoare, maxrange, pssnr, cargolim, tipMotor, mil));
                    }
                }

                // Sort the lists
                submarines.sort((s1, s2) -> Integer.compare(s1.getId(), s2.getId()));
                airplanes.sort((a1, a2) -> Integer.compare(a1.getId(), a2.getId()));

                // Update text area
                textArea.setText("");
                submarines.forEach(sub -> textArea.append(sub.toString() + "\n"));
                airplanes.forEach(av -> textArea.append(av.toString() + "\n"));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Write To File Button
        writeToFileButton.addActionListener(e -> {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("textout.txt")))) {
                bw.write(textArea.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Checkbox Filters
        ItemListener updateRightPanel = e -> {
            rightPanel.removeAll();
            if (showNuclearSubmarines.isSelected()) {
                submarines.stream()
                        .filter(Submarin::isNuclear)
                        .forEach(sub -> rightPanel.add(new JLabel(sub.toString())));
            }
            if (showConventionalSubmarines.isSelected()) {
                submarines.stream()
                        .filter(sub -> !sub.isNuclear())
                        .forEach(sub -> rightPanel.add(new JLabel(sub.toString())));
            }
            if (showMilitaryJets.isSelected()) {
                airplanes.stream()
                        .filter(Avion::isMil)
                        .filter(Avion::isJetType)
                        .forEach(av -> rightPanel.add(new JLabel(av.toString())));
            }
            if (showPropellerMilitaryPlanes.isSelected()) {
                airplanes.stream()
                        .filter(Avion::isMil)
                        .filter(av -> !av.isJetType())
                        .forEach(av -> rightPanel.add(new JLabel(av.toString())));
            }
            if (showDeepDivingSubmarines.isSelected()) {
                submarines.stream()
                        .filter(sub -> sub.getAdancimeMax() > 1500)
                        .forEach(sub -> rightPanel.add(new JLabel(sub.toString())));
            }
            if (showLongRangePlanes.isSelected()) {
                airplanes.stream()
                        .filter(av -> av.getMaxrange() > 10000)
                        .forEach(av -> rightPanel.add(new JLabel(av.toString())));
            }
            rightPanel.revalidate();
            rightPanel.repaint();
        };

        showNuclearSubmarines.addItemListener(updateRightPanel);
        showConventionalSubmarines.addItemListener(updateRightPanel);
        showMilitaryJets.addItemListener(updateRightPanel);
        showPropellerMilitaryPlanes.addItemListener(updateRightPanel);
        showDeepDivingSubmarines.addItemListener(updateRightPanel);
        showLongRangePlanes.addItemListener(updateRightPanel);

        frame.setVisible(true);
    }
}
