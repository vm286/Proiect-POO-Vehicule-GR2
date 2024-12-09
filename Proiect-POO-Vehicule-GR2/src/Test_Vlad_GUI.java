import javax.swing.*;
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
        JButton readFromFileButton = new JButton("Read From File");
        JButton writeToFileButton = new JButton("Write To File");
        bottomPanel.add(readFromFileButton);
        bottomPanel.add(writeToFileButton);

        // Load data from file
        ArrayList<Submarin> submarines = Submarin.getListaSubmarine();
        ArrayList<Avion> airplanes = Avion.getListaAvioane();

        // Initial content in text area
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(new File("text.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            textArea.setText(fileContent.toString());
        } catch (IOException e) {
            textArea.setText("Error reading the file: " + e.getMessage());
        }

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
