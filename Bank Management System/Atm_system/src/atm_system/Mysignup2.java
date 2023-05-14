package atm_system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Mysignup2 extends JFrame implements ActionListener {

    Container c;
    JLabel pagelabel, religionlabel, catagorylabel, incomelabel, educationlabel,
            occupationlabel, nationalidcardlabel, homeholdinglabel, seniorlabel, fromelabel, existinlabel, image;
    JComboBox religioncombo, catagorycombo, incomecombo, educationcombo, occupationcombo;
    JTextField nationalidfield, homeholdingfield, fromefield;
    JRadioButton r1, r2, r3, r4;
    JButton next;
    String formnb;
    private ButtonGroup grp1, grp2;
    private ImageIcon icon;

    Mysignup2(String formnb) {

        this.formnb = formnb;
        this.setBounds(500, 50, 900, 900);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);

        grp1 = new ButtonGroup();
        grp2 = new ButtonGroup();

        icon = new ImageIcon("src/icon/bank.png");
        image = new JLabel(icon);
        image.setBounds(80, 30, icon.getIconWidth(), icon.getIconHeight());
        c.add(image);

        //creat a label 
        fromelabel = new JLabel("Form No:" + formnb);
        fromelabel.setBounds(700, 20, 150, 30);
        fromelabel.setFont(new Font("Time the new roman", Font.PLAIN, 18));
        fromelabel.setForeground(Color.BLACK);
        fromelabel.setFont(new Font("Time the new roman", Font.BOLD, 16));
        c.add(fromelabel);
        //creat a label 
        pagelabel = new JLabel("Page 2: Additional Details");
        pagelabel.setBounds(350, 70, 350, 40);
        pagelabel.setFont(new Font("Time the new roman", Font.BOLD, 28));
        pagelabel.setForeground(Color.BLACK);
        c.add(pagelabel);
        //creat a label 
        religionlabel = new JLabel("Religion:");
        religionlabel.setBounds(100, 160, 150, 40);
        religionlabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        religionlabel.setForeground(Color.BLACK);
        c.add(religionlabel);
        //creat a combobox 
        String reg[] = {"Muslim", "Hindu", "Christianity", "Buddhism", "Other"};
        religioncombo = new JComboBox(reg);
        religioncombo.setBounds(400, 160, 400, 40);
        religioncombo.setFont(new Font("Time the new roman", Font.BOLD, 18));
        religioncombo.setForeground(Color.BLACK);
        c.add(religioncombo);
        //creat a label 
        catagorylabel = new JLabel("Catagory:");
        catagorylabel.setBounds(100, 220, 150, 40);
        catagorylabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        catagorylabel.setForeground(Color.BLACK);
        c.add(catagorylabel);
        //creat a combobox 
        String catagory[] = {"General", "OBC", "SC", "ST", "Other"};
        catagorycombo = new JComboBox(catagory);
        catagorycombo.setBounds(400, 220, 400, 40);
        catagorycombo.setFont(new Font("Time the new roman", Font.BOLD, 18));
        catagorycombo.setForeground(Color.BLACK);
        c.add(catagorycombo);
        //creat a label 
        incomelabel = new JLabel("Income:");
        incomelabel.setBounds(100, 290, 150, 40);
        incomelabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        incomelabel.setForeground(Color.BLACK);
        c.add(incomelabel);
        //creat a combobox 
        String income[] = {"Null","<30,000","< 50,000","<1,00,000" ,"<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        incomecombo = new JComboBox(income);
        incomecombo.setBounds(400, 290, 400, 40);
        incomecombo.setFont(new Font("Time the new roman", Font.BOLD, 18));
        incomecombo.setForeground(Color.BLACK);
        c.add(incomecombo);
        //creat a label 
        educationlabel = new JLabel("Eucational:");
        educationlabel.setBounds(100, 360, 150, 40);
        educationlabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        educationlabel.setForeground(Color.BLACK);
        c.add(educationlabel);
        //creat a combobox 
        String education[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        educationcombo = new JComboBox(education);
        educationcombo.setBounds(400, 360, 400, 40);
        educationcombo.setFont(new Font("Time the new roman", Font.BOLD, 18));
        educationcombo.setForeground(Color.BLACK);
        c.add(educationcombo);
        //creat a label 
        occupationlabel = new JLabel("Occupation:");
        occupationlabel.setBounds(100, 430, 150, 40);
        occupationlabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        occupationlabel.setForeground(Color.BLACK);
        c.add(occupationlabel);
        //creat a combobox 
        String occupation[] = {"Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others"};
        occupationcombo = new JComboBox(occupation);
        occupationcombo.setBounds(400, 430, 400, 40);
        occupationcombo.setFont(new Font("Time the new roman", Font.BOLD, 18));
        occupationcombo.setForeground(Color.BLACK);
        c.add(occupationcombo);
        //creat a label 
        nationalidcardlabel = new JLabel("NID No:");
        nationalidcardlabel.setBounds(100, 500, 150, 40);
        nationalidcardlabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        nationalidcardlabel.setForeground(Color.BLACK);
        c.add(nationalidcardlabel);
        //creat a combobox 
        nationalidfield = new JTextField();
        nationalidfield.setBounds(400, 500, 400, 40);
        nationalidfield.setFont(new Font("Time the new roman", Font.BOLD, 18));
        nationalidfield.setForeground(Color.BLACK);
        c.add(nationalidfield);
        //creat a label 
        homeholdinglabel = new JLabel("HouseHolging No:");
        homeholdinglabel.setBounds(100, 570, 200, 40);
        homeholdinglabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        homeholdinglabel.setForeground(Color.BLACK);
        c.add(homeholdinglabel);

        //creat a combobox 
        homeholdingfield = new JTextField();
        homeholdingfield.setBounds(400, 570, 400, 40);
        homeholdingfield.setFont(new Font("Time the new roman", Font.BOLD, 18));
        homeholdingfield.setForeground(Color.BLACK);
        c.add(homeholdingfield);
        //creat a label 
        seniorlabel = new JLabel("Senior Citizen:");
        seniorlabel.setBounds(100, 630, 200, 40);
        seniorlabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        seniorlabel.setForeground(Color.BLACK);
        c.add(seniorlabel);
        //crea a radio butotn

        r1 = new JRadioButton("Yes");
        r1.setBounds(400, 630, 80, 40);
        r1.setFont(new Font("Time the new roman", Font.BOLD, 18));
        r1.setBackground(Color.ORANGE);
        r1.setForeground(Color.BLACK);
        c.add(r1);
        r2 = new JRadioButton("No");
        r2.setBounds(600, 630, 80, 40);
        r2.setFont(new Font("Time the new roman", Font.BOLD, 18));
        r2.setBackground(Color.ORANGE);
        r2.setForeground(Color.BLACK);
        c.add(r2);
        grp1.add(r1);
        grp1.add(r2);
        //create a button
        next = new JButton("Next");
        next.setBounds(700, 750, 100, 40);
        next.setFont(new Font("Time the new roman", Font.BOLD, 18));
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        c.add(next);
        //create existinlabel
        existinlabel = new JLabel("Existing Account");
        existinlabel.setBounds(100, 680, 200, 40);
        existinlabel.setFont(new Font("Time the new roman", Font.BOLD, 18));
        existinlabel.setForeground(Color.BLACK);
        c.add(existinlabel);

        //create radio button;
        r3 = new JRadioButton("Yes");
        r3.setBounds(400, 680, 80, 40);
        r3.setFont(new Font("Time the new roman", Font.BOLD, 18));
        r3.setBackground(Color.ORANGE);
        r3.setForeground(Color.BLACK);
        c.add(r3);
        r4 = new JRadioButton("No");
        r4.setBounds(600, 680, 80, 40);
        r4.setFont(new Font("Time the new roman", Font.BOLD, 18));
        r4.setBackground(Color.ORANGE);
        r4.setForeground(Color.BLACK);
        c.add(r4);
        grp2.add(r3);
        grp2.add(r4);
        next.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String religion = (String) religioncombo.getSelectedItem();
        String catagory = (String) catagorycombo.getSelectedItem();
        String income = (String) incomecombo.getSelectedItem();
        String education = (String) educationcombo.getSelectedItem();
        String occupation = (String) occupationcombo.getSelectedItem();
        String nidno = nationalidfield.getText();
        String householding = homeholdingfield.getText();

        String scitizen = null;
        if (r1.isSelected()) {
            scitizen = "Yes";
        } else {
            scitizen = "No";
        }
        
        String eaccount = null;
        if (r1.isSelected()) {
            eaccount = "Yes";
        } else {
            eaccount = "No";
        }
        try {
            if (nidno.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please give your NID number");
            } else {

                Myconnection con = new Myconnection();
                String Q = "INSERT INTO sign_up2 VALUES ('" + formnb + "','" + religion + "','" + catagory + "','" + income + "','" + education + "','" + occupation + "','" + nidno + "','" + householding + "','" + scitizen + "','" + eaccount + "') ";
                con.s.executeUpdate(Q);
                con.c.close();

                JOptionPane.showMessageDialog(null, "Data insert succfully");

                this.setVisible(false);
                new Mysignup3(formnb).setVisible(true);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String[] args) {

        Mysignup2 frame = new Mysignup2("");
        frame.setVisible(true);
    }

}
