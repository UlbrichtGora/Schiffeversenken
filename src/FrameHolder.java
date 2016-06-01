import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private JPanel createContent() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel feldLinks = new JPanel(new GridLayout(10, 10));
        JPanel feldRechts = new JPanel(new GridLayout(10, 10));
        JLabel label = new JLabel("Wählen Sie Ihre Flotte");
        JPanel buttonPanel = new JPanel();

        panel.add(feldLinks, BorderLayout.WEST);
        panel.add(feldRechts, BorderLayout.EAST);
        panel.add(label, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        for (int i = 0; i < 100; i++) {
            JPanel bli = new JPanel();
            bli.setBackground(Color.cyan);
            feldLinks.add(bli);
            bli.setSize(10, 10);


        }

        for (int i = 0; i < 100; i++) {
            JPanel bla = new JPanel();
            bla.setBackground(Color.blue);
            feldRechts.add(bla);
            bla.setSize(10,10);
        }

        JButton button1 = new JButton("Spielen");
        buttonPanel.add(button1);
        button1.setBackground(Color.lightGray);

        JButton button2 = new JButton("Reset");
        buttonPanel.add(button2);
        button2.setBackground(Color.lightGray);

        return panel;
    }
}
