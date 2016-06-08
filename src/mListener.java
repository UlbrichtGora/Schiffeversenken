import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by mgora on 08.06.2016.
 */
public class mListener extends MouseAdapter {
    public static final char sperrzone = 's';
    public static final char wasser = 'w';
    public static final char schiff = 's';
    private final JPanel[][] linksPanel;
    private final int[] aktuellesSchiff = new int[4];

    @Override
    public void mouseClicked(MouseEvent e) {

        for (int i = 0; i < linksPanel.length; i++) {
            for (int j = 0; j < linksPanel.length; j++) {
                linksPanel[i][j].setBackground(Color.CYAN);
                linksPanel[i][j].setToolTipText("Platziert");
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX() / 30;
        System.out.println("Koordinate X: " + x);

        int y = e.getY() / 30;
        System.out.println("Koordinate Y: " + y);

        for (int i = 0; i < linksPanel.length; i++) {
            for (int j = 0; j < linksPanel[i].length; j++) {
                linksPanel[i][j].setBackground(Color.CYAN);


            }
        }

        for (int i = 0; i < aktuellesSchiff.length && y + aktuellesSchiff.length <= 10; i++) {
            try {
                linksPanel[y][x + i].setBackground(Color.YELLOW);
            } catch (ArrayIndexOutOfBoundsException e1) {

            }
            linksPanel[y + i][x].setBackground(Color.CYAN);


        }

//        int laenge = 0;
//
//        for (int zeile = y - 1; zeile <= y + 1; y++) {
//            for (int spalte = x - 1; spalte <= x + laenge + 1; x++) {
//
//                try {
//                    if (spielFeldBrett[zeile][spalte] != schiff) {
//                        spielFeldBrett[zeile][spalte] = sperrzone;
//
//                    }
//                } catch (ArrayIndexOutOfBoundsException e1) {
//                    e1.printStackTrace();
//                }
//
//            }
//
//        }
    }

    public mListener(JPanel[][] linksPanel) {
        this.linksPanel = linksPanel;
    }

}
