import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.prefs.Preferences;

public class NoteX extends JFrame {

    JMenuBar menuBar;

    JMenu file;
    JMenuItem newdoc;
    JMenuItem open;
    JMenuItem save;
    JMenuItem print;
    JMenuItem exit;

    JMenu edit;
    JMenuItem copy;
    JMenuItem paste;
    JMenuItem cut;
    JMenuItem selectAll;

    JMenu about;
    JMenuItem aboutItem;

    JMenu security;
    JMenuItem encryption;
    JMenuItem decryption;
    JMenuItem learnMore;

    JMenu settings;
    JMenuItem settingsItem;

    JTextArea textArea;
    JScrollPane scrollPane;
    JFileChooser fileChooser;
    String text;
    int i;

    NoteX(){
        setSize(900,600);
        setTitle("NoteX - Light Weight Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon(getClass().getResource("/NoteX.png")).getImage());

        menuBar = new JMenuBar();
        menuBar.setBackground(Color.decode("#f6f6f6"));

        file = new JMenu("File");
        file.setFont(new Font("Arial",Font.BOLD,15));

        newdoc = new JMenuItem("New");
        newdoc.setFont(new Font("Arial",Font.BOLD,15));
        newdoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        open = new JMenuItem("Open");
        open.setFont(new Font("Arial",Font.BOLD,15));
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Choose .txt file", "txt"));
                int choose = fileChooser.showOpenDialog(null);

                if(choose != JFileChooser.APPROVE_OPTION){
                    return;
                }

                File file = fileChooser.getSelectedFile();
                try{
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    textArea.read(br,null);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        save = new JMenuItem("Save");
        save.setFont(new Font("Arial",Font.BOLD,15));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser saveFile = new JFileChooser();
                saveFile.setAcceptAllFileFilterUsed(false);
                saveFile.setApproveButtonText("Save");
                saveFile.addChoosableFileFilter(new FileNameExtensionFilter("Type your file name", "txt"));
                int save = saveFile.showOpenDialog(null);

                if(save != JFileChooser.APPROVE_OPTION){
                    return;
                }

                File file = new File(saveFile.getSelectedFile() + ".txt");
                try{
                    BufferedWriter wr = new BufferedWriter(new FileWriter(file));
                    textArea.write(wr);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        print = new JMenuItem("Print");
        print.setFont(new Font("Arial",Font.BOLD,15));
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    textArea.print();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        exit = new JMenuItem("Exit");
        exit.setFont(new Font("Arial",Font.BOLD,15));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);

        edit = new JMenu("Edit");
        edit.setFont(new Font("Arial",Font.BOLD,15));

        copy = new JMenuItem("Copy");
        copy.setFont(new Font("Arial",Font.BOLD,15));
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textArea.getSelectedText();
            }
        });

        paste = new JMenuItem("Paste");
        paste.setFont(new Font("Arial",Font.BOLD,15));
        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.insert(text,textArea.getCaretPosition());
            }
        });

        cut = new JMenuItem("Cut");
        cut.setFont(new Font("Arial",Font.BOLD,15));
        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textArea.getSelectedText();
                textArea.replaceRange("",textArea.getSelectionStart(),textArea.getSelectionEnd());
            }
        });

        selectAll = new JMenuItem("Select All");
        selectAll.setFont(new Font("Arial",Font.BOLD,15));
        selectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.selectAll();
            }
        });

        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectAll);

        about = new JMenu("About");
        about.setFont(new Font("Arial",Font.BOLD,15));

        aboutItem = new JMenuItem("About");
        aboutItem.setFont(new Font("Arial",Font.BOLD,15));
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
            }
        });

        about.add(aboutItem);

        security = new JMenu("Security");
        security.setFont(new Font("Arial",Font.BOLD,15));

        encryption = new JMenuItem("Encrypt");
        encryption.setFont(new Font("Arial",Font.BOLD,15));
        encryption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = textArea.getText();
                String encryptedText = "";
                for(i = 0; i < 5; i++){
                    encryptedText = Encryption.encrypt(temp);
                    temp = encryptedText;
                }
                textArea.setText(encryptedText);
            }
        });

        decryption = new JMenuItem("Decrypt");
        decryption.setFont(new Font("Arial",Font.BOLD,15));
        decryption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = textArea.getText();
                String decryptedText = "";
                for(i = 0; i < 5; i++){
                    decryptedText = Encryption.decrypt(temp);
                    temp = decryptedText;
                }
                textArea.setText(decryptedText);
            }
        });

        learnMore = new JMenuItem("Learn More");
        learnMore.setFont(new Font("Arial",Font.BOLD,15));
        learnMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LearnAboutEncryption();
            }
        });

        security.add(encryption);
        security.add(decryption);
        security.add(learnMore);

        settings = new JMenu("Settings");
        settings.setFont(new Font("Arial",Font.BOLD,15));

        settingsItem = new JMenuItem("Customise");
        settingsItem.setFont(new Font("Arial",Font.BOLD,15));
        settingsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Settings(NoteX.this);
            }
        });

        settings.add(settingsItem);

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial",Font.PLAIN,18));
        textArea.setBackground(Color.decode("#f6f6f6"));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(new EmptyBorder(10, 10, 10, 10));

        Preferences prefs = Preferences.userNodeForPackage(NoteX.class);
        String theme = prefs.get("theme", "light");
        int fontSize = prefs.getInt("fontSize", 18);

        if(theme.equals("light")) {
            textArea.setBackground(Color.decode("#ecedec"));
            textArea.setForeground(Color.black);
            textArea.setCaretColor(Color.black);
        }
        else if(theme.equals("dark")) {
            textArea.setBackground(Color.decode("#252623"));
            textArea.setForeground(Color.decode("#f6f6f6"));
            textArea.setCaretColor(Color.decode("#f6f6f6"));
        }

        if(fontSize == 18){
            textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        }
        else if (fontSize == 10) {
            textArea.setFont(new Font("Arial", Font.PLAIN, 10));
        }
        else if (fontSize == 25) {
            textArea.setFont(new Font("Arial", Font.PLAIN, 25));
        }

        scrollPane = new JScrollPane(textArea);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(security);
        menuBar.add(settings);
        menuBar.add(about);
        setJMenuBar(menuBar);
        add(scrollPane);

        setVisible(true);
    }
}