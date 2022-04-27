import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame{

    public Settings(){
        super();
        initialize();
    }

    private JPanel getJContentPane(){
        if(jContentPane == null){
            jContentPane = new JPanel();
            jContentPane.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            jContentPane.add(getLanguageLabel(), gbc);
            jContentPane.add(getLanguages(), gbc);
            gbc.insets = new Insets(10, 0, 0, 0);
            jContentPane.add(new JSeparator());
            jContentPane.add(getApplyButton(), gbc);
            jContentPane.add(getLeaveButton(), gbc);
        }
        return jContentPane;
    }

    private JLabel getLanguageLabel() {
        if (labelLanguage == null) {
            labelLanguage = new JLabel();
            labelLanguage.setText("*");
        }
        return labelLanguage;
    }

    private JButton getApplyButton(){
        if (applyButton == null){
            applyButton = new JButton();
            applyButton.setText("OK");

            applyButton.addActionListener(e1 -> {
                Main.setLanguage(getLanguages().getSelectedIndex());
                this.dispose();
            });
        }
        return applyButton;
    }

    public JButton getLeaveButton(){
        if(leaveButton == null){
            leaveButton = new JButton("X");
            leaveButton.addActionListener(e -> {
                JFrame topFrame = (JFrame) SwingUtilities.getRoot(getJContentPane().getRootPane());
                SwingUtilities.updateComponentTreeUI(topFrame);
                topFrame.dispose();
            });
        }
        return leaveButton;
    }

    public static JComboBox<String> getLanguages(){
        if (cbLanguages == null){
            String[] languages = {"PORTUGUESE", "SPANISH", "RUSSIAN", "JAPANESE", "ENGLISH"};
            cbLanguages = new JComboBox<>(languages);
        }
        return cbLanguages;
    }

    private void initialize(){
        this.setSize(Constants.userScreenSize);
        this.setContentPane(getJContentPane());
        this.setTitle("Settings");
        this.setLocationRelativeTo(null);
    }

    JPanel jContentPane = null;

    static JComboBox<String> cbLanguages = null;

    JButton applyButton = null;
    JButton leaveButton = null;

    JLabel labelLanguage = null;
}
