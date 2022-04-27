import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class CustomPane
{
    public static String showPasswordPrompt(Component parent, String title)
    {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setEchoChar(' ');
        passwordField.setColumns(5);

        int returnVal = JOptionPane.showConfirmDialog( parent, passwordField, title, JOptionPane.OK_CANCEL_OPTION );
        if (returnVal == JOptionPane.OK_OPTION) return new String(passwordField.getPassword());
        else return null;
    }
}