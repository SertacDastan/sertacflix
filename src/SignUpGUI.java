import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpGUI extends JFrame {
    private JButton ContinueButton;
    private JPanel midPanel, errPanel;
    private JTextField fName, lName, eMail;
    private JPasswordField pass, rePass;
    private JLabel signText, flixText, fNameLabel, lNameLabel, eMailLabel, passLabel, rePassLabel, errorLabel;
    private FileWriter registery;
    public SignUpGUI(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ContinueButton = new JButton("Continue");
        midPanel = new JPanel();
        fName= new JTextField();
        lName = new JTextField();
        eMail = new JTextField();
        pass = new JPasswordField();
        rePass = new JPasswordField();
        signText = new JLabel("Sign Up");
        flixText = new JLabel("SERTACFLIX");
        fNameLabel = new JLabel("First Name");
        lNameLabel = new JLabel("Last Name");
        eMailLabel= new JLabel("E-Mail");
        passLabel = new JLabel("Password");
        rePassLabel = new JLabel("Re-enter Password");
        errorLabel = new JLabel();
        errPanel = new JPanel();
        Container c = getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcV = new GridBagConstraints();

        c.setBackground(new Color(19, 19, 19, 255));
        midPanel.setBackground(new Color(109, 109, 117, 11));
        errPanel.setBackground(new Color(255,0,0));
        signText.setForeground(new Color(180, 9, 9, 245));
        flixText.setForeground(new Color(180, 9, 9, 245));
        fNameLabel.setForeground(Color.white);
        lNameLabel.setForeground(Color.white);
        eMailLabel.setForeground(Color.white);
        passLabel.setForeground(Color.white);
        rePassLabel.setForeground(Color.white);

        c.setLayout(new GridBagLayout());
        midPanel.setLayout(new GridBagLayout());
        errPanel.setLayout(new GridBagLayout());

        midPanel.setPreferredSize(new Dimension((screenSize.width)/4, (screenSize.height)/2));
        errPanel.setPreferredSize(new Dimension((screenSize.width)/5, (screenSize.height)/30));
        fName.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/40));
        lName.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/40));
        eMail.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/40));
        pass.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/40));
        rePass.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/40));
        ContinueButton.setPreferredSize(new Dimension((screenSize.width/10), (screenSize.height/20)));
        signText.setFont(new Font("Serif", Font.BOLD, 40));
        flixText.setFont(new Font("Serif", Font.BOLD, 55));

        gbc.ipady = screenSize.height/50;
        gbcV.ipadx = screenSize.width/20;
        gbcV.gridx = 0;
        gbcV.gridy=1;
        c.add(flixText, gbcV);
        gbcV.gridy=0;
        gbcV.gridx = 1;
        gbcV.ipadx = 0;
        gbcV.ipady = screenSize.height/50;
        c.add(signText, gbcV);
        gbcV.gridy=1;
        gbcV.ipadx = screenSize.width/20;
        gbcV.ipady = 0;
        c.add(midPanel,gbcV);
        gbcV.gridy = 2;
        c.add(errPanel, gbcV);
        errPanel.add(errorLabel);
        gbc.gridy = 1;
        gbc.ipady = screenSize.height/60;
        gbc.anchor = GridBagConstraints.WEST;
        midPanel.add(fNameLabel, gbc);
        gbc.gridy = 2;
        midPanel.add(fName, gbc);
        gbc.gridy = 3;
        midPanel.add(lNameLabel, gbc);
        gbc.gridy = 4;
        midPanel.add(lName,gbc);
        gbc.gridy = 5;
        midPanel.add(eMailLabel, gbc);
        gbc.gridy = 6;
        midPanel.add(eMail, gbc);
        gbc.gridy = 7;
        midPanel.add(passLabel, gbc);
        gbc.gridy = 8;
        midPanel.add(pass, gbc);
        gbc.gridy = 9;
        midPanel.add(rePassLabel, gbc);
        gbc.gridy = 10;
        midPanel.add(rePass, gbc);
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.CENTER;
        midPanel.add(ContinueButton, gbc);

        errPanel.setVisible(false);
        errorLabel.setVisible(false);

        flixText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LogInGUI log = new LogInGUI();
                setVisible(false);
            }
        });

        ContinueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String regex = "^(.+)@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(eMail.getText());
                if(fName.getText().equals("")){
                    errorLabel.setText("Enter First Name");
                    errPanel.setVisible(true);
                    errorLabel.setVisible(true);
                    repaint();
                }else {
                    if(lName.getText().equals("")){
                        errorLabel.setText("Enter Last Name");
                        errPanel.setVisible(true);
                        errorLabel.setVisible(true);
                        repaint();
                    }else {
                        if(matcher.matches() != true){
                            errorLabel.setText("E-Mail Not Valid");
                            errPanel.setVisible(true);
                            errorLabel.setVisible(true);
                            repaint();

                        }else{
                            if(pass.getText().equals("") || rePass.getText().equals("")){
                                errorLabel.setText("Enter Password");
                                errPanel.setVisible(true);
                                errorLabel.setVisible(true);
                                repaint();
                            }else{
                                if(!pass.getText().equals(rePass.getText())){
                                    errorLabel.setText("Passwords don't match.");
                                    errPanel.setVisible(true);
                                    errorLabel.setVisible(true);
                                    repaint();
                                }else{
                                    errPanel.setVisible(false);
                                    errorLabel.setVisible(false);
                                    repaint();
                                    try{
                                        registery = new FileWriter("registery.txt", true);
                                        registery.write(eMail.getText() + " ");
                                        registery.write(pass.getText() + " ");
                                        registery.write(fName.getText() + " ");
                                        registery.write(lName.getText() + " ");
                                        registery.close();
                                        PackagesGUI pckg = new PackagesGUI();
                                        setVisible(false);
                                    }
                                    catch (IOException ioe){
                                        ioe.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }

            }
        });

        flixText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ContinueButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setTitle("SertacFlix");
        setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

