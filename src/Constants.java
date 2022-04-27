import javax.swing.*;
import java.awt.*;

public class Constants {
    public static final int PORTUGUESE = 0;
    public static final int SPANISH = 1;
    public static final int RUSSIAN = 2;
    public static final int JAPANESE = 3;
    public static final int ENGLISH = 4;
    public static JButton leaveButton = null;
    public static double ScreenWidthDivisor = 3;
    public static double ScreenHeightDivisor = 2;
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static Dimension userScreenSize = new Dimension(
            (int) (screenSize.getWidth() / ScreenWidthDivisor), (int) (screenSize.getHeight() / ScreenHeightDivisor)
    );

    public static JButton getLeaveButton(String text){
        if(leaveButton == null){
            leaveButton = new JButton();
            leaveButton.setText(text);
            leaveButton.addActionListener(e -> {
                JFrame topFrame = (JFrame) SwingUtilities.getRoot(leaveButton);
                topFrame.dispose();
            });
        }
        return leaveButton;
    }
}
