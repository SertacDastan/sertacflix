import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogInGUI extends JFrame {
    private JButton LogIn;
    private JPanel midPanel, errPanel;
    private JTextField id;
    private JPasswordField pass;
    private JLabel signText, flixText, registerText, idLabel, passLabel, errLabel;
    private BufferedReader fileread;
    private String fileMail, filePass, filePackage;
    private char filereadc;
    private String[] words;
    private boolean exist = false;
    public LogInGUI(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        LogIn = new JButton("LogIn");
        midPanel = new JPanel();
        id = new JTextField();
        pass = new JPasswordField();
        signText = new JLabel("Sign In");
        flixText = new JLabel("SERTACFLIX");
        registerText = new JLabel("New to SertacFlix? Sign up now.");
        idLabel = new JLabel("E-mail");
        passLabel = new JLabel("Password");
        errLabel = new JLabel();
        errPanel = new JPanel();
        Container c = getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcV = new GridBagConstraints();

        c.setBackground(new Color(19, 19, 19, 255));
        midPanel.setBackground(new Color(109, 109, 117, 11));
        signText.setForeground(new Color(180, 9, 9, 245));
        errPanel.setBackground(new Color(255,0,0));
        registerText.setForeground(Color.white);
        flixText.setForeground(new Color(180, 9, 9, 245));
        idLabel.setForeground(Color.white);
        passLabel.setForeground(Color.white);

        c.setLayout(new GridBagLayout());
        midPanel.setLayout(new GridBagLayout());

        midPanel.setPreferredSize(new Dimension((screenSize.width)/4, (screenSize.height)/2));
        errPanel.setPreferredSize(new Dimension((screenSize.width)/4, (screenSize.height)/30));
        id.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/16));
        pass.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/16));
        LogIn.setPreferredSize(new Dimension((screenSize.width/10), (screenSize.height/20)));
        signText.setFont(new Font("Serif", Font.BOLD, 40));
        flixText.setFont(new Font("Serif", Font.BOLD, 55));
        registerText.setFont(new Font("Serif", Font.ITALIC, 20));

        errPanel.setVisible(false);
        errLabel.setVisible(false);

        gbc.ipady = screenSize.height/50;
        gbcV.ipadx = screenSize.width/20;
        gbcV.gridx = 0;
        gbcV.gridy=1;
        c.add(flixText, gbcV);
        gbcV.gridy=0;
        gbcV.gridx = 1;
        gbcV.ipadx = 0;
        gbcV.ipady = screenSize.height/50;
        c.add(errPanel, gbcV);
        errPanel.add(errLabel);
        gbcV.gridy=1;
        gbcV.ipadx = screenSize.width/20;
        gbcV.ipady = 0;
        c.add(midPanel,gbcV);
        midPanel.add(signText, gbc);
        gbc.gridy = 1;
        gbc.ipady = screenSize.height/60;
        gbc.anchor = GridBagConstraints.WEST;
        midPanel.add(idLabel, gbc);
        gbc.gridy = 2;
        midPanel.add(id, gbc);
        gbc.gridy = 3;
        midPanel.add(passLabel, gbc);
        gbc.gridy = 4;
        midPanel.add(pass,gbc);
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        midPanel.add(LogIn, gbc);
        LogIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    fileread = new BufferedReader(new FileReader("registery.txt"));
                    fileMail = new String();
                    try{
                        String line = fileread.readLine();
                        while (line != null) {
                            words = line.split(" ");
                            line = fileread.readLine();
                            if(words[0].equals(id.getText())){
                                exist = true;
                                break;
                            }
                        }
                        if(exist == false){
                            errLabel.setText("Email Does Not Exist");
                            errPanel.setVisible(true);
                            errLabel.setVisible(true);
                            repaint();
                        }else{
                            if(!words[1].equals(pass.getText())){
                                errLabel.setText("Password Not True");
                                errPanel.setVisible(true);
                                errLabel.setVisible(true);
                                repaint();
                            }else{
                                VideoAppGUI vag = new VideoAppGUI(words[2], words[3], words[4]);
                                setVisible(false);
                            }
                        }

                    }catch (IOException io){
                        io.printStackTrace();
                    }


                }
                catch (FileNotFoundException fnfe){
                    fnfe.getStackTrace();
                }
            }
        });
        gbc.gridy = 6;
        midPanel.add(registerText, gbc);
        registerText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SignUpGUI vap = new SignUpGUI();
                setVisible(false);
            }
        });
        registerText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        LogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setTitle("SertacFlix");
        setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
