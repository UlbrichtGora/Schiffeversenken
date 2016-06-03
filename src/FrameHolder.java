import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by mgora on 17.05.2016.
 */
public class FrameHolder {
    private final JFrame frame;

    public FrameHolder() {
        this.frame = new JFrame("Schiffe Versenken");
        this.frame.add(createContent());
        this.frame.pack();
        this.frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setResizable(false);
    }

    private JPanel createSpielfeld() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        panel.setPreferredSize(new Dimension(30, 30));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Rand 2 Pixel
        panel.setToolTipText(getClass().getName());
        return panel;
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


// Wir brauchen ein Panel Array um später auf Positionen zugreifen zu können!
        // so wie es aktuelle aufgebaut ist, kein Zugriff darauf möglich
        // TODO
        JPanel[] panels = new JPanel[10];
        for (int i = 0; i < panels.length; i++) {
            panels[i] = createSpielfeld();
        }


        for (int i = 0; i < 100; i++) {
            JPanel linkesFeld = createSpielfeld();
            linkesFeld.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    linkesFeld.setToolTipText("Schiff platziert");
                    linkesFeld.setBackground(Color.YELLOW);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    linkesFeld.setBackground(Color.gray);
                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            feldLinks.add(linkesFeld);

        }

        for (int i = 0; i < 100; i++) {
            JPanel rechtesFeld = createSpielfeld();

            rechtesFeld.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    rechtesFeld.setToolTipText("Schiff platziert");
                    rechtesFeld.setBackground(Color.YELLOW);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }
            });
            feldRechts.add(rechtesFeld);
        }

        JButton spielen = new JButton("Spielen");
        buttonPanel.add(spielen);
        spielen.setBackground(Color.lightGray);

        JButton spielSpeichern = new JButton("Speichern");
        buttonPanel.add(spielSpeichern);
        spielSpeichern.setBackground(Color.lightGray);

        JButton reset = new JButton("Reset");
        buttonPanel.add(reset);
        reset.setBackground(Color.lightGray);
        reset.addActionListener(new resetListener(name1, name2));

        return panel;
    }

    private JPanel createStringList() {
        JPanel panel = new JPanel();

        String[] flotte = {"U-Boot", "Fregatte", "Zerstörer", "Flugzeugträger",};

        JList liste = new JList<>(flotte);

        panel.add(new JScrollPane(liste, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        return panel;
    }
}
