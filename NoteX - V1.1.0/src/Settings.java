import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

public class Settings extends JFrame {
    NoteX temp;
    Settings(NoteX temp){
        this.temp = temp;
        setSize(500,320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        ImageIcon icon = new ImageIcon(getClass().getResource("/NoteX.png"));
        setIconImage(icon.getImage());
        setTitle("Settings");
        setLayout(null);

        JLabel title = new JLabel("Settings");
        title.setFont(new Font("Arial",Font.BOLD,22));
        title.setBounds(190,40,200,24);
        add(title);

        JLabel theme = new JLabel("Theme:");
        theme.setFont(new Font("Arial",Font.PLAIN,15));
        theme.setBounds(100,100,80,17);
        add(theme);

        JRadioButton light = new JRadioButton("Light");
        light.setBounds(190,100,80,17);
        light.setBackground(Color.white);
        light.setFocusable(false);
        light.setOpaque(false);
        add(light);

        JRadioButton dark = new JRadioButton("Dark");
        dark.setBounds(260,100,80,17);
        dark.setBackground(Color.white);
        dark.setFocusable(false);
        dark.setOpaque(false);
        add(dark);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(light);
        buttonGroup.add(dark);

        JLabel fontSize = new JLabel("Font Size:");
        fontSize.setFont(new Font("Arial",Font.PLAIN,15));
        fontSize.setBounds(100,140,80,17);
        add(fontSize);

        JRadioButton small = new JRadioButton("Small");
        small.setBounds(190,140,80,17);
        small.setBackground(Color.white);
        small.setFocusable(false);
        small.setOpaque(false);
        add(small);

        JRadioButton medium = new JRadioButton("Medium");
        medium.setBounds(260,140,80,17);
        medium.setBackground(Color.white);
        medium.setFocusable(false);
        medium.setOpaque(false);
        add(medium);

        JRadioButton large = new JRadioButton("Large");
        large.setBounds(345,140,80,17);
        large.setBackground(Color.white);
        large.setFocusable(false);
        large.setOpaque(false);
        add(large);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(small);
        buttonGroup1.add(medium);
        buttonGroup1.add(large);

        JButton save = new JButton("Save");
        save.setBorderPainted(false);
        save.setFocusable(false);
        save.setBackground(Color.darkGray);
        save.setForeground(Color.white);
        save.setBounds(190,200,90,25);
        save.setFont(new Font("Arial",Font.BOLD,15));

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences prefs = Preferences.userNodeForPackage(NoteX.class);

                if (light.isSelected()) {
                    temp.textArea.setBackground(Color.decode("#ecedec"));
                    temp.textArea.setForeground(Color.black);
                    temp.textArea.setCaretColor(Color.black);
                    prefs.put("theme", "light");
                } else if (dark.isSelected()) {
                    temp.textArea.setBackground(Color.decode("#252623"));
                    temp.textArea.setForeground(Color.decode("#f6f6f6"));
                    temp.textArea.setCaretColor(Color.decode("#f6f6f6"));
                    prefs.put("theme", "dark");
                }

                if (small.isSelected()) {
                    temp.textArea.setFont(new Font("Arial", Font.PLAIN, 10));
                    prefs.putInt("fontSize", 10);
                } else if (medium.isSelected()) {
                    temp.textArea.setFont(new Font("Arial", Font.PLAIN, 18));
                    prefs.putInt("fontSize", 18);
                } else if (large.isSelected()) {
                    temp.textArea.setFont(new Font("Arial", Font.PLAIN, 25));
                    prefs.putInt("fontSize", 25);
                }
                dispose();
            }
        });

        add(save);
        setVisible(true);
    }
}