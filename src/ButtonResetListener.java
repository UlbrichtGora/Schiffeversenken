import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mgora on 03.06.2016.
 */
public class ButtonResetListener implements ActionListener {


    private JTextField name1;
    private JTextField name2;

    public ButtonResetListener(JTextField name1, JTextField name2) {
        this.name1 = name1;
        this.name2 = name2;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.name1.setText(null);
        this.name2.setText(null);

    }
}
