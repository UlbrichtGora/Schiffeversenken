import javax.swing.*;
import java.awt.*;

/**
 * Created by mgora on 17.05.2016.
 */
public class FrameHolder {
    private final JFrame frame;
    private String[] flotte = {"Flugzeugträger", "Zerstörer", "Fregatte", "U-Boot", "Schnellboot"};

    private final JPanel[][] linksPanel = new JPanel[10][10];
    private final JPanel[][] rechtsPanel = new JPanel[10][10];

    public FrameHolder() {
        this.frame = new JFrame("Schiffe Versenken");
        this.frame.add(createContent());
        this.frame.pack();
        this.frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setResizable(false);
    }


    private JPanel createContent() {
        JPanel panel = new JPanel(new BorderLayout(80, 80));
        JPanel eingabeBereich = new JPanel(new GridLayout(2, 2));
        JPanel feldLinks = new JPanel(new GridLayout(10, 10));

        JPanel feldRechts = new JPanel(new GridLayout(10, 10));

        JLabel labelName1 = new JLabel("Spieler 1: ");
        JLabel labelName2 = new JLabel("Spieler 2: ");

        JTextField name1 = new JTextField("...");
        JTextField name2 = new JTextField("...");
        JPanel buttonPanel = new JPanel();

        panel.add(eingabeBereich, BorderLayout.NORTH);
        eingabeBereich.add(labelName1);
        eingabeBereich.add(labelName2);
        eingabeBereich.add(name1);
        eingabeBereich.add(name2);
        panel.add(feldLinks, BorderLayout.WEST);
        panel.add(feldRechts, BorderLayout.EAST);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(this.createStringList(), BorderLayout.CENTER);

        System.out.println(panel.getPreferredSize());

        for (int i = 0; i < linksPanel.length; i++) {
            for (int j = 0; j < linksPanel.length; j++) {

                linksPanel[i][j] = this.createSpielfeld(i, j);
                rechtsPanel[i][j] = this.createSpielfeld(i, j);
                feldLinks.add(linksPanel[i][j]);
                feldRechts.add(rechtsPanel[i][j]);
            }
        }
        mListener mouseL = new mListener(this.linksPanel);
        feldLinks.addMouseListener(mouseL);
        feldLinks.addMouseMotionListener(mouseL);

        JButton spielen = new JButton("Spielen");
        buttonPanel.add(spielen);
        spielen.setBackground(Color.lightGray);

        JButton spielSpeichern = new JButton("Speichern");
        buttonPanel.add(spielSpeichern);
        spielSpeichern.setBackground(Color.lightGray);

        JButton reset = new JButton("Reset");
        buttonPanel.add(reset);
        reset.setBackground(Color.lightGray);
        reset.addActionListener(new ButtonResetListener(name1, name2));
        return panel;
    }

    private JPanel createSpielfeld(int x, int y) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        panel.setPreferredSize(new Dimension(30, 30));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Rand 2 Pixel
        return panel;
    }

    private JPanel createStringList() {
        JPanel panel = new JPanel();
        JList fleetList = new JList<>(flotte);
        panel.add(new JScrollPane(fleetList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        fleetList.setSelectedIndex(0);
        fleetList.ensureIndexIsVisible(1);
        return panel;
    }
}
