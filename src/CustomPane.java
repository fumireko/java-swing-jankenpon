import java.awt.Component;

import javax.swing.*;

public class CustomPane
{
    public static String showPasswordPrompt(Component parent, String title)
    {
        JPanel panel = new JPanel();
        final JPasswordField passwordField = new JPasswordField(40);
        passwordField.setEchoChar(' ');
        panel.add(passwordField);
        JOptionPane pane = new JOptionPane(panel, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION) {
            @Override
            public void selectInitialValue() {
                passwordField.requestFocusInWindow();
            }
        };
        pane.createDialog(parent, title).setVisible(true);
        return new String(passwordField.getPassword());
    }
}