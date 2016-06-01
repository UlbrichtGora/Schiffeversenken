import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        System.out.println(panel.getPreferredSize());


        for (int i = 0; i < 100; i++) {
            JPanel bli = createPanel();
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
}
