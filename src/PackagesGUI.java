import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;

public class PackagesGUI extends JFrame{
    private JPanel freeTrial, HD,FHD, UHD;
    private JLabel freeLabel, hdLabel, fhdLabel, uhdLabel, commitmentLabel, commitmentLabel1, commitmentLabel2;
    private JLabel qualityHD, qualityFHD, qualityUHD, resolutionHD, resolutionFHD, resolutionUHD;
    private JLabel freeDay, freeTime, freeWatch;
    private JButton StartMember, StartMember1, StartMember2, StartMember3;
    private String choosenpack;
    private FileWriter registery;
    public PackagesGUI(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        freeTrial = new JPanel();
        HD = new JPanel();
        FHD = new JPanel();
        UHD = new JPanel();
        freeLabel = new JLabel("Free Trial");
        hdLabel = new JLabel("HD Package");
        fhdLabel = new JLabel("FHD Package");
        uhdLabel = new JLabel("UHD Package");
        commitmentLabel = new JLabel("✓ No commitments, cancel anytime.");
        commitmentLabel1 = new JLabel("✓ No commitments, cancel anytime.");
        commitmentLabel2 = new JLabel("✓ No commitments, cancel anytime.");
        qualityHD = new JLabel("✓ Video quality: Good");
        qualityFHD = new JLabel("✓ Video quality: Better");
        qualityUHD = new JLabel("✓ Video quality: Best");
        resolutionHD = new JLabel("✓ Resolution: 720p");
        resolutionFHD = new JLabel("✓ Resolution: 1080p");
        resolutionUHD = new JLabel("✓ Resolution: 4K+HDR");
        freeDay = new JLabel("✓ 30 days Free trial");
        freeTime = new JLabel("✓ Watch the half of the movie");
        freeWatch = new JLabel("✓ Limited access to movies");
        StartMember = new JButton("Free");
        StartMember1 = new JButton("$5");
        StartMember2 = new JButton("$10");
        StartMember3 = new JButton("$20");

        Container c = getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcV = new GridBagConstraints();

        c.setBackground(new Color(19, 19, 19, 255));
        freeTrial.setBackground(new Color(109, 109, 117, 11));
        HD.setBackground(new Color(109, 109, 117, 11));
        FHD.setBackground(new Color(109, 109, 117, 11));
        UHD.setBackground(new Color(109, 109, 117, 11));
        freeLabel.setForeground(Color.white);
        hdLabel.setForeground(Color.white);
        fhdLabel.setForeground(Color.white);
        uhdLabel.setForeground(Color.white);
        commitmentLabel.setForeground(Color.white);
        commitmentLabel1.setForeground(Color.white);
        commitmentLabel2.setForeground(Color.white);
        qualityHD.setForeground(Color.white);
        qualityFHD.setForeground(Color.white);
        qualityUHD.setForeground(Color.white);
        resolutionHD.setForeground(Color.white);
        resolutionFHD.setForeground(Color.white);
        resolutionUHD.setForeground(Color.white);
        freeTime.setForeground(Color.white);
        freeDay.setForeground(Color.white);
        freeWatch.setForeground(Color.white);

        c.setLayout(new GridBagLayout());
        freeTrial.setLayout(new GridBagLayout());
        HD.setLayout(new GridBagLayout());
        FHD.setLayout(new GridBagLayout());
        UHD.setLayout(new GridBagLayout());

        freeTrial.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/2));
        HD.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/2));
        FHD.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/2));
        UHD.setPreferredSize(new Dimension((screenSize.width)/6, (screenSize.height)/2));
        freeLabel.setFont(new Font("Serif", Font.BOLD, 45));
        hdLabel.setFont(new Font("Serif", Font.BOLD, 45));
        uhdLabel.setFont(new Font("Serif", Font.BOLD, 45));
        fhdLabel.setFont(new Font("Serif", Font.BOLD, 45));
        commitmentLabel.setFont(new Font("Serif", Font.BOLD, 20));
        commitmentLabel1.setFont(new Font("Serif", Font.BOLD, 20));
        commitmentLabel2.setFont(new Font("Serif", Font.BOLD, 20));
        qualityHD.setFont(new Font("Serif", Font.BOLD, 20));
        qualityFHD.setFont(new Font("Serif", Font.BOLD, 20));
        qualityUHD.setFont(new Font("Serif", Font.BOLD, 20));
        resolutionHD.setFont(new Font("Serif", Font.BOLD, 20));
        resolutionFHD.setFont(new Font("Serif", Font.BOLD, 20));
        resolutionUHD.setFont(new Font("Serif", Font.BOLD, 20));
        freeWatch.setFont(new Font("Serif", Font.BOLD, 20));
        freeTime.setFont(new Font("Serif", Font.BOLD, 20));
        freeDay.setFont(new Font("Serif", Font.BOLD, 20));
        StartMember.setFont(new Font("Serif", Font.BOLD, 20));
        StartMember1.setFont(new Font("Serif", Font.BOLD, 20));
        StartMember2.setFont(new Font("Serif", Font.BOLD, 20));
        StartMember3.setFont(new Font("Serif", Font.BOLD, 20));
        StartMember.setPreferredSize(new Dimension((screenSize.width/8), (screenSize.height/40)));
        StartMember1.setPreferredSize(new Dimension((screenSize.width/8), (screenSize.height/40)));
        StartMember2.setPreferredSize(new Dimension((screenSize.width/8), (screenSize.height/40)));
        StartMember3.setPreferredSize(new Dimension((screenSize.width/8), (screenSize.height/40)));

        gbc.ipadx = (screenSize.width/15);
        c.add(freeTrial,gbc);
        c.add(HD,gbc);
        c.add(FHD,gbc);
        c.add(UHD,gbc);
        gbcV.ipady=(screenSize.height/15);
        freeTrial.add(freeLabel,gbcV);
        HD.add(hdLabel,gbcV);
        FHD.add(fhdLabel,gbcV);
        UHD.add(uhdLabel,gbcV);
        gbcV.ipady=(screenSize.height/25);
        gbcV.gridy=1;
        freeTrial.add(freeDay, gbcV);
        HD.add(commitmentLabel,gbcV);
        FHD.add(commitmentLabel1,gbcV);
        UHD.add(commitmentLabel2,gbcV);
        gbcV.gridy=2;
        freeTrial.add(freeWatch, gbcV);
        HD.add(qualityHD,gbcV);
        FHD.add(qualityFHD,gbcV);
        UHD.add(qualityUHD,gbcV);
        gbcV.gridy=3;
        freeTrial.add(freeTime, gbcV);
        HD.add(resolutionHD,gbcV);
        FHD.add(resolutionFHD,gbcV);
        UHD.add(resolutionUHD,gbcV);
        gbcV.gridy=4;
        freeTrial.add(StartMember,gbcV);
        HD.add(StartMember1,gbcV);
        FHD.add(StartMember2,gbcV);
        UHD.add(StartMember3,gbcV);

        StartMember.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                choosenpack = "trial";
                try{
                    registery = new FileWriter("registery.txt", true);
                    registery.write(choosenpack + "\n");
                    registery.close();
                    LogInGUI log = new LogInGUI();
                    setVisible(false);
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        });
        StartMember1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                choosenpack = "HD";
                try{
                    registery = new FileWriter("registery.txt", true);
                    registery.write(choosenpack + "\n");
                    registery.close();
                    LogInGUI log = new LogInGUI();
                    setVisible(false);
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        });
        StartMember2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                choosenpack = "FHD";
                try{
                    registery = new FileWriter("registery.txt", true);
                    registery.write(choosenpack + "\n");
                    registery.close();
                    LogInGUI log = new LogInGUI();
                    setVisible(false);
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        });
        StartMember3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                choosenpack = "UHD";
                try{
                    registery = new FileWriter("registery.txt", true);
                    registery.write(choosenpack + "\n");
                    registery.close();
                    LogInGUI log = new LogInGUI();
                    setVisible(false);
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        });
        setTitle("SertacFlix");
        setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
