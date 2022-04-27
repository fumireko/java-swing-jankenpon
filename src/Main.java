import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    static Language language = null;

    final GridLayout layout = new GridLayout(0, 1);

    static JButton play1v1 = null;
    static JButton playEasy = null;
    static JButton playHard = null;
    static JButton settings = null;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        UIManager.put("swing.boldMetal", Boolean.TRUE);
        javax.swing.SwingUtilities.invokeLater(Main::showMenu);
    }

    public Main(String name){
        super(name);
        setPreferredSize(Constants.userScreenSize);
        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public JButton getPlay1v1(){
        if(play1v1 == null){
            play1v1 = new JButton();
            play1v1.setText(language.play1v1);
            play1v1.addActionListener(e -> {
                        run(new Player(language.player + " 1"), new Player(language.player + " 2"));
                    }
            );
        }
        return play1v1;
    }

    public JButton getPlayEasy(){
        if(playEasy == null){
            playEasy = new JButton();
            playEasy.setText(language.playEasy);
            playEasy.addActionListener(e -> {
                        Player j = new Player(language.player + " 1");
                        run(j, new Computer(false, j));
                    }
            );
        }
        return playEasy;
    }

    public JButton getPlayHard(){
        if(playHard == null){
            playHard = new JButton();
            playHard.setText(language.playHard);
            playHard.addActionListener(e -> {
                        Player j = new Player(language.player + " 1");
                        run(j, new Computer(false, j));
                    }
            );
        }
        return playHard;
    }

    public JButton getSettings(){
        if(settings == null){
            settings = new JButton();
            settings.setText(language.settings);
            settings.addActionListener(e -> SwingUtilities.invokeLater(() -> {
                Settings settings1 = new Settings();
                settings1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                settings1.setVisible(true);
            }));
        }
        return settings;
    }

    public void addToPane(final Container c){
        final JPanel pane = new JPanel();

        pane.setLayout(layout);
        pane.add(getPlay1v1());
        pane.add(getPlayEasy());
        pane.add(getPlayHard());
        pane.add(getSettings());

        JPanel footer = new JPanel();
        footer.add(Constants.getLeaveButton(language.leaveButton));

        final JPanel label = new JPanel();
        JLabel x = new JLabel("Jankenpon", JLabel.CENTER);
        x.setFont(new Font("Serif", Font.PLAIN, 18));
        label.add(x);

        c.add(label, BorderLayout.PAGE_START);
        c.add(new JSeparator(), BorderLayout.LINE_START);
        c.add(pane, BorderLayout.CENTER);
        c.add(footer, BorderLayout.SOUTH);
    }

    public static void showMenu() {
        setLanguage(Constants.ENGLISH);
        Main main = new Main("Jankenpon");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.addToPane(main.getContentPane());
        main.pack();
        main.setVisible(true);
    }

    public static void run(Player a, Player b){
        a.setChoice(check(a));
        b.setChoice(check(b));
        compare(a, b);
    }

    public static void run(Player a, Computer b){
        a.setChoice(check(a));
        b.setChoice(check(b));
        compare(a, b);
    }

    public static String check(Player j){
        while(true) {
            String a = CustomPane.showPasswordPrompt(null, j.name + ", " + language.checkPrompt);
            System.out.println(a);
            if(a.equals(language.rock) || a.equals(language.paper) || a.equals(language.scissors)){
                j.setChoice(a);
                return a;
            }
            else JOptionPane.showMessageDialog(null, language.invalidChoice);
        }
    }

    public static String check(Computer c){
        while(true) {
            String a = c.choose();
            System.out.println(a);
            if(a.equals(language.rock) || a.equals(language.paper) || a.equals(language.scissors)){
                c.setChoice(a);
                return a;
            }
            else JOptionPane.showMessageDialog(null, language.invalidChoice);
        }
    }

    public static void compare(Player a, Player b){
        if(a.getChoice().equals(b.getChoice()))
            JOptionPane.showMessageDialog(null,language.draw + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.rock) && b.getChoice().equals(language.paper))
            JOptionPane.showMessageDialog(null,b.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.rock) && b.getChoice().equals(language.scissors))
            JOptionPane.showMessageDialog(null,a.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.paper) && b.getChoice().equals(language.scissors))
            JOptionPane.showMessageDialog(null,b.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.paper) && b.getChoice().equals(language.rock))
            JOptionPane.showMessageDialog(null,a.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.scissors) && b.getChoice().equals(language.rock))
            JOptionPane.showMessageDialog(null,b.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.scissors) && b.getChoice().equals(language.paper))
            JOptionPane.showMessageDialog(null,a.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());
    }

    public static void compare(Player a, Computer b){
        if(a.getChoice().equals(b.getChoice()))
            JOptionPane.showMessageDialog(null,language.draw + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.rock) && b.getChoice().equals(language.paper))
            JOptionPane.showMessageDialog(null,b.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.rock) && b.getChoice().equals(language.scissors))
            JOptionPane.showMessageDialog(null,a.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.paper) && b.getChoice().equals(language.scissors))
            JOptionPane.showMessageDialog(null,b.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.paper) && b.getChoice().equals(language.rock))
            JOptionPane.showMessageDialog(null,a.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.scissors) && b.getChoice().equals(language.rock))
            JOptionPane.showMessageDialog(null,b.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());

        if(a.getChoice().equals(language.scissors) && b.getChoice().equals(language.paper))
            JOptionPane.showMessageDialog(null,a.getName() + " " + language.win + ", " + a.getChoice() + " vs " + b.getChoice());
    }

    static void setLanguage(int value){
        try {
            language = new Language(value);

            play1v1.setText(language.play1v1);
            playEasy.setText(language.playEasy);
            playHard.setText(language.playHard);
            settings.setText(language.settings);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
