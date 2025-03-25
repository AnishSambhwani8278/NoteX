import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class About extends JFrame {
    About(){
        setSize(500,450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        ImageIcon icon = new ImageIcon(getClass().getResource("/NoteX.png"));
        setIconImage(icon.getImage());
        setTitle("About");
        setLayout(null);

        ImageIcon displayIcon = new ImageIcon(icon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
        JLabel iconPanel = new JLabel(displayIcon);
        iconPanel.setBounds(140,10,200,200);
        add(iconPanel);

        JLabel name = new JLabel("NoteX - Light Weight Text Editor");
        name.setBounds(140,210,200,15);
        name.setFont(new Font("Arial",Font.BOLD,13));
        add(name);

        JLabel description = new JLabel("NoteX is an open-source light weight text editor made in pure Java.");
        description.setBounds(65,250,350,14);
        description.setFont(new Font("Arial",Font.PLAIN,12));
        add(description);

        JLabel version = new JLabel("Version: 1.0.0");
        version.setBounds(150,290,200,15);
        version.setFont(new Font("Arial",Font.PLAIN,12));
        add(version);

        JLabel author = new JLabel("Made By: Anish Sambhwani");
        author.setBounds(150,310,200,15);
        author.setFont(new Font("Arial",Font.PLAIN,12));
        add(author);

        JLabel code = new JLabel("Get Code:");
        code.setBounds(150,330,80,15);
        code.setFont(new Font("Arial",Font.PLAIN,12));
        add(code);

        JButton codeButton = new JButton("Click Here");
        codeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.github.com"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        codeButton.setBounds(182,330,100,15);
        codeButton.setFocusable(false);
        codeButton.setBackground(Color.white);
        codeButton.setForeground(Color.blue);
        codeButton.setBorderPainted(false);
        codeButton.setOpaque(false);
        codeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        codeButton.setFont(new Font("Arial",Font.PLAIN,12));
        add(codeButton);

        JLabel connect = new JLabel("Connect On Linkedin: ");
        connect.setBounds(150,350,130,15);
        connect.setFont(new Font("Arial",Font.PLAIN,12));
        add(connect);

        JButton connectButton = new JButton("Click Here");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/anish-sambhwani/"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        connectButton.setBounds(240,350,100,15);
        connectButton.setBackground(Color.white);
        connectButton.setForeground(Color.blue);
        connectButton.setFocusable(false);
        connectButton.setBorderPainted(false);
        connectButton.setOpaque(false);
        connectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        connectButton.setFont(new Font("Arial",Font.PLAIN,12));
        add(connectButton);

        setVisible(true);
    }
}