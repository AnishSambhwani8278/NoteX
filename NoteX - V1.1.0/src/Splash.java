import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        setSize(250,250);
        setUndecorated(true);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/NoteX.png"));
        setIconImage(icon.getImage());

        ImageIcon display = new ImageIcon(icon.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
        JLabel image = new JLabel(display);
        image.setBounds(140,10,200,200);
        add(image);

        setVisible(true);

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        dispose();
        new NoteX();
    }
}