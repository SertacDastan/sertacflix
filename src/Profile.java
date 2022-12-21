import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


    public class Profile extends JFrame {
        private JButton Home, Movies, TVShows;
        private JPanel bar, moviesPnl;
        private JLabel profileTxt, flixTxt, pckTxt;
        public Profile(String name, String lName, String pck){
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            String[] generes = { "My Profile", "Options", "LogOut" };
            flixTxt = new JLabel("SERTACFLIX");
            Home = new JButton("Home");
            Movies = new JButton("Movies");
            TVShows = new JButton("TvShows");
            moviesPnl = new JPanel();
            bar = new JPanel();
            profileTxt = new JLabel("Main Screen");
            pckTxt = new JLabel();
            GridBagConstraints gbc = new GridBagConstraints();
            final JComboBox comboBox = new JComboBox(generes);
            Container c = getContentPane();

            c.setLayout(new GridBagLayout());
            bar.setLayout(new GridBagLayout());

            c.setBackground(new Color(19, 19, 19, 255));
            moviesPnl.setBackground(new Color(19, 19, 19, 255));
            bar.setBackground(new Color(180, 9, 9, 245));
            flixTxt.setForeground(Color.white);
            profileTxt.setForeground(Color.white);
            pckTxt.setForeground(Color.white);

            bar.setPreferredSize(new Dimension((screenSize.width), (screenSize.height)/18));
            profileTxt.setFont(new Font("Serif", Font.BOLD, 25));
            flixTxt.setFont(new Font("Serif", Font.BOLD, 25));
            pckTxt.setFont(new Font("Serif", Font.BOLD, 25));

            if(!pck.equals("trial"))
                profileTxt.setText("<html>" + "Name: " + name + "<br/>" + "Surname: " + lName + "<br/>"+ "SertacFlix Subscription: " + pck + "<br/>"+ "Payment Complete" + "</html>");
            else
                profileTxt.setText("<html>" + "Name: " + name + "<br/>" + "Surname: " + lName + "<br/>"+ "SertacFlix Subscription: " + pck + "<br/>"+ "Payment Not Complete" + "</html>");


            comboBox.setRenderer(new MyComboBoxRenderer(name + " " + lName));
            comboBox.setSelectedIndex(-1);

            gbc.fill = GridBagConstraints.HORIZONTAL;

            c.add(bar);
            bar.add(flixTxt,gbc);
            gbc.weightx = 0.5;
            gbc.gridx = 1;
            bar.add(Home,gbc);
            Home.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    VideoAppGUI mov = new VideoAppGUI(name, lName, pck);
                    setVisible(false);
                }
            });
            gbc.gridx = 2;
            bar.add(Movies,gbc);
            Movies.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    moviesGUI mov = new moviesGUI(name, lName, pck);
                    setVisible(false);
                }
            });
            gbc.gridx = 3;
            bar.add(TVShows,gbc);
            if(!pck.equals("trial"))
                TVShows.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tvShowGUI mov = new tvShowGUI(name, lName, pck);
                        setVisible(false);
                    }
                });
            gbc.gridx = 4;
            bar.add(comboBox,gbc);
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selection = comboBox.getSelectedIndex();
                    if(selection == 2){
                        LogInGUI log = new LogInGUI();
                        setVisible(false);
                    }
                }
            });
            gbc.gridx=0;
            gbc.gridy=1;
            gbc.weighty = 1;
            c.add(moviesPnl, gbc);
            gbc.weighty = 0;
            moviesPnl.add(profileTxt, gbc);
            gbc.gridy = 2;
            c.add(pckTxt, gbc);


            setTitle("SertacFlix");
            setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            if(pck.equals("trial")) {
                TVShows.setEnabled(false);
            }
        }

        class MyComboBoxRenderer extends JLabel implements ListCellRenderer
        {
            private String _title;

            public MyComboBoxRenderer(String title)
            {
                _title = title;
            }

            @Override
            public Component getListCellRendererComponent(JList list, Object value,
                                                          int index, boolean isSelected, boolean hasFocus)
            {
                if (index == -1 && value == null) setText(_title);
                else setText(value.toString());
                return this;
            }
        }
    }
