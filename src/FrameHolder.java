import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.blue);
        panel.setPreferredSize(new Dimension(30, 30));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Rand 1 Pixel
        panel.setToolTipText(getClass().getName());
        return panel;
    }

    private JPanel createContent() {
        JPanel panel = new JPanel(new BorderLayout(100, 100));
        JPanel feldLinks = new JPanel(new GridLayout(10, 10));
        JPanel feldRechts = new JPanel(new GridLayout(10, 10));
        JLabel label = new JLabel("Wählen Sie Ihre Flotte");
        JPanel buttonPanel = new JPanel();

        panel.add(feldLinks, BorderLayout.WEST);
        panel.add(feldRechts, BorderLayout.EAST);
        panel.add(label, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(this.createStringList(), BorderLayout.CENTER);
        System.out.println(panel.getPreferredSize());


        for (int i = 0; i < 100; i++) {
            JPanel bli = createPanel();
            bli.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    bli.setToolTipText("JPanel 1 Mouse CLICKED");
                    bli.setBackground(Color.YELLOW);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    bli.setToolTipText("JPanel 1 Mouse Pressed");
                    bli.setBackground(Color.gray);
                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    bli.setToolTipText("JPanel 1 Mouse Entered");

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            feldLinks.add(bli);

        }

        for (int i = 0; i < 100; i++) {
            JPanel bla = createPanel();
            feldRechts.add(bla);
        }

        JButton button1 = new JButton("Spielen");
        buttonPanel.add(button1);
        button1.setBackground(Color.lightGray);

        JButton button2 = new JButton("Reset");
        buttonPanel.add(button2);
        button2.setBackground(Color.lightGray);


        return panel;
    }
    private JPanel createStringList() {
        JPanel panel = new JPanel();

        String[] flotte = {"Schnellboot", "Fregatte", "Flugzeugträger",};

        JList liste = new JList<>(flotte);

        panel.add( new JScrollPane(liste, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        return panel;
    }
}
