import javax.swing.*;
import java.awt.*;

public class LearnAboutEncryption extends JFrame {
    LearnAboutEncryption(){
        setSize(600,350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        ImageIcon icon = new ImageIcon(getClass().getResource("/NoteX.png"));
        setIconImage(icon.getImage());
        setTitle("Learn about NoteX Encryption");
        setLayout(null);

        JLabel title = new JLabel("Encryption and Decryption in NoteX");
        title.setFont(new Font("Arial",Font.BOLD,22));
        title.setBounds(100,40,400,24);
        add(title);

        JTextArea area = new JTextArea("NoteX provides it's users a feature for basic level of text encryption. Just open your text or write a new text in NoteX, and click the 'Encrypt' to encrypt your text. Remember each time you click 'Encrypt', your text goes through 5 rounds of encryption and each time you click 'Decrypt', the text is decrypted 5 times.");
        area.setEditable(false);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setFocusable(false);
        area.setFont(new Font("Arial",Font.PLAIN,17));
        area.setBounds(65,100,500,120);
        add(area);

        JTextArea area1 = new JTextArea("Eg: If you click 'Encrypt' button 3 times, then you must click 'Decrypt' button 3 times also to get your original text.");
        area1.setEditable(false);
        area1.setWrapStyleWord(true);
        area1.setLineWrap(true);
        area1.setFocusable(false);
        area1.setFont(new Font("Arial",Font.PLAIN,17));
        area1.setBounds(65,220,500,50);
        add(area1);

        setVisible(true);
    }
}