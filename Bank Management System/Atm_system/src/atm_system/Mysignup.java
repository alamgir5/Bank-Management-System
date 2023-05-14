package atm_system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Mysignup extends JFrame implements ActionListener {

    Container c;
    JLabel label1, label2, namelabel, fathernamelabel, datelabel, date,
            month, year, gender, email, married, address, city, pin, state, image;
    JTextField namefield, fathernamefield, emailfield, addressfield, cityfied, pinfield, statefield;
    JComboBox datecombo, monthcombo, yearcombo;
    JRadioButton maleradio, femaleradio, semale, marriedradio, ummarried;
    JButton next, back;
    private ImageIcon icon;
    private ButtonGroup grp1, grp2;
    private JDateChooser datechooser;

    Random ran = new Random();
    int number = ran.nextInt(1000) + 1000;
    String value = "" + Math.abs(number);

    Mysignup() {

        this.setBounds(500, 50, 900, 900);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RUPALI BANK");
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(java.awt.Color.ORANGE);

        grp1 = new ButtonGroup();
        grp2 = new ButtonGroup();

        icon = new ImageIcon("src/icon/bank.png");
        image = new JLabel(icon);
        image.setBounds(50, 10, icon.getIconWidth(), icon.getIconHeight());
        c.add(image);

        //creat a lebel1
        label1 = new JLabel("APPLICATION FORM NO." + value);
        label1.setBounds(260, 20, 580, 38);
        label1.setFont(new Font("Time the new roman", Font.BOLD, 40));
        c.add(label1);

        //creat a label2 
        label2 = new JLabel("Page 1 : Personal Details ");
        label2.setBounds(430, 60, 400, 40);
        label2.setFont(new Font("Time the new roman", Font.BOLD, 20));
        c.add(label2);

        //crate a name labe
        namelabel = new JLabel("Name:");
        namelabel.setBounds(50, 150, 100, 40);
        namelabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(namelabel);
        //creat a namefield

        namefield = new JTextField();
        namefield.setBounds(300, 150, 500, 40);
        namefield.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(namefield);
        //crate a fathername labe

        fathernamelabel = new JLabel("Father's Name:");
        fathernamelabel.setBounds(50, 200, 200, 40);
        fathernamelabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(fathernamelabel);
        //creat a father nametextfield
        fathernamefield = new JTextField();
        fathernamefield.setBounds(300, 200, 500, 40);
        fathernamefield.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(fathernamefield);
        //creat a date label
        datelabel = new JLabel("Date of Brith :");
        datelabel.setBounds(50, 260, 200, 40);
        datelabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(datelabel);

        //create a Jdatechooser
        datechooser = new JDateChooser();
        datechooser.setForeground(Color.GRAY);
        datechooser.setFont(new Font("Time the new roman",Font.BOLD,16));
        datechooser.setBounds(300, 260, 500, 40);
        c.add(datechooser);

        //creat a Gender label
        gender = new JLabel("Gender");
        gender.setBounds(50, 320, 100, 40);
        gender.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(gender);
        //creat a radio button
        maleradio = new JRadioButton("Male");
        maleradio.setBackground(Color.ORANGE);
        maleradio.setBounds(300, 320, 100, 40);
        maleradio.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(maleradio);

        //creat a  female radio button
        femaleradio = new JRadioButton("Female");
        femaleradio.setBounds(500, 320, 100, 40);
        femaleradio.setBackground(Color.ORANGE);
        femaleradio.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(femaleradio);
        //create semale radio button
        semale = new JRadioButton("Other");
        semale.setBounds(720, 320, 100, 40);
        semale.setFont(new Font("Time the new roman", Font.BOLD, 18));
        semale.setBackground(Color.ORANGE);
        c.add(semale);
        //create button group
        grp1.add(maleradio);
        grp1.add(femaleradio);
        grp1.add(semale);
        //creat a emanil label
        email = new JLabel("Email Address:");
        email.setBounds(50, 380, 150, 40);
        email.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(email);
        //creat a email textfield
        emailfield = new JTextField();
        emailfield.setBounds(300, 380, 500, 40);
        emailfield.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(emailfield);
        //maried sttus
        married = new JLabel("Married Status:");
        married.setBounds(50, 440, 150, 40);
        married.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(married);
        //crea a marriedraio button
        marriedradio = new JRadioButton("Married");
        marriedradio.setBounds(300, 440, 100, 40);
        marriedradio.setBackground(Color.ORANGE);
        marriedradio.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(marriedradio);
        //creat a unmarried radio button
        ummarried = new JRadioButton("Ummarried");
        ummarried.setBounds(520, 440, 150, 40);
        ummarried.setBackground(Color.ORANGE);
        ummarried.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(ummarried);
        //create button group
        grp2.add(marriedradio);
        grp2.add(ummarried);
        //creat a address label
        address = new JLabel("Present Address:");
        address.setBounds(50, 500, 180, 40);
        address.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(address);
        //adderss field
        addressfield = new JTextField();
        addressfield.setBounds(300, 500, 500, 40);
        addressfield.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(addressfield);
        //creat a city label
        city = new JLabel("Permanent Address:");
        city.setBounds(50, 560, 200, 40);
        city.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(city);
        //city  field
        cityfied = new JTextField();
        cityfied.setBounds(300, 560, 500, 40);
        cityfied.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(cityfied);
        //creat a pin  label
        pin = new JLabel("Zip Code:");
        pin.setBounds(50, 620, 150, 40);
        pin.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(pin);
        //pin   field
        pinfield = new JTextField();
        pinfield.setBounds(300, 620, 500, 40);
        pinfield.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(pinfield);
        //creat a state  label
        state = new JLabel("Division:");
        state.setBounds(50, 680, 150, 40);
        state.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(state);
        //state  field
        statefield = new JTextField();
        statefield.setBounds(300, 680, 500, 40);
        statefield.setFont(new Font("Time the new roman", Font.BOLD, 18));
        c.add(statefield);
        //creat a next button
        next = new JButton("Next");
        next.setBounds(700, 750, 100, 40);
        next.setFont(new Font("Time the new roman", Font.BOLD, 18));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        c.add(next);

        //creat a back  button
        back = new JButton("Back");
        back.setBounds(550, 750, 100, 40);
        back.setFont(new Font("Time the new roman", Font.BOLD, 18));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        c.add(back);
        next.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            this.setVisible(false);
            new Mylogin().setVisible(true);
        } else {
            String formnumber = value;
            String name = namefield.getText();
            String fname = fathernamefield.getText();
            //get full date and month and year
            String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();

            String gender = null;
            if (maleradio.isSelected()) {
                gender = "Male";

            } else if (femaleradio.isSelected()) {
                gender = "Female";
            } else {
                gender = "Other";
            }
            String emailname = emailfield.getText();
            String married = null;
            if (marriedradio.isSelected()) {
                married = "Married";
            } else {
                married = "Unmarried";
            }
            String address = addressfield.getText();
            String city = cityfied.getText();
            String pincode = pinfield.getText();
            String state = statefield.getText();

            try {
                if (namefield.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up  your name", "RUPALI BANK", JOptionPane.WARNING_MESSAGE);
                } else if (fathernamefield.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up  your fathername", "RUPALI BANK", JOptionPane.WARNING_MESSAGE);
                } else if (emailfield.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up  email", "RUPALI BANK", JOptionPane.WARNING_MESSAGE);
                } else if (addressfield.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up address", "RUPALI BANK", JOptionPane.WARNING_MESSAGE);
                } else if (cityfied.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up city", "RUPALI BANK", JOptionPane.WARNING_MESSAGE);
                } else if (pinfield.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up pin", "RUPALI BANK", JOptionPane.WARNING_MESSAGE);
                } else if (statefield.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up state", "RUPALI BANK", JOptionPane.WARNING_MESSAGE);
                } else {
                    Myconnection con = new Myconnection();
                    String Q = "INSERT INTO sign_up VALUES('" + formnumber + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + emailname + "','" + married + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                    con.s.executeUpdate(Q);
                    con.c.close();
                    
                    JOptionPane.showMessageDialog(null, "Data insert succfully");
                    
                    this.setVisible(false);
                    new Mysignup2(formnumber).setVisible(true);;
                    
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void main(String[] args) {
        Mysignup frame = new Mysignup();
        frame.setVisible(true);
    }

}
