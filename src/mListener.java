import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by mgora on 08.06.2016.
 */
public class mListener extends MouseAdapter {
    private final JPanel[][] linksPanel;
    private final int[] Schiff = new int[4];

    @Override
    public void mouseClicked(MouseEvent e) {

        for (int i = 0; i < linksPanel.length; i++) {
            for (int j = 0; j < linksPanel.length; j++) {
                linksPanel[i][j].setBackground(Color.BLUE);
                linksPanel[i][j].setToolTipText("Platziert");
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX() / 30;
        System.out.println("Gibt mir x: " + x);

        int y = e.getY() / 30;
        System.out.println("Gibt mir y: " + y);

        for (int i = 0; i < linksPanel.length; i++) {
            for (int j = 0; j < linksPanel[i].length; j++) {
                linksPanel[i][j].setBackground(Color.BLUE);


            }
        }

        for (int i = 0; i < Schiff.length && y + Schiff.length <= 10; i++) {
            try {
                linksPanel[y][x + i].setBackground(Color.YELLOW);
            } catch (ArrayIndexOutOfBoundsException e1) {

            }
            linksPanel[y + i][x].setBackground(Color.BLUE);


        }

    }

    public mListener(JPanel[][] linksPanel) {
        this.linksPanel = linksPanel;
    }

}
