package atm_system;

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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Mysignup3 extends JFrame implements ActionListener {

    Container c;
    JLabel formlabel, accoutlabel, pagelabel, cardlabel, cardlabel2, cardlabel3, cardlabel4,
            pinlabel, pinlavel2, pinlabel3, pinlabel4, serviceslabel, image;
    JCheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    JRadioButton r1, r2, r3, r4;
    JButton submit, cancel;
    private ImageIcon icon;
    private ButtonGroup grp1;
    String formnb;

    Mysignup3(String formnb) {
        this.formnb = formnb;
        this.setBounds(500, 50, 900, 900);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(java.awt.Color.ORANGE);

        icon = new ImageIcon("src/icon/bank.png");
        image = new JLabel(icon);
        image.setBounds(80, 30, icon.getIconWidth(), icon.getIconHeight());
        c.add(image);

        grp1 = new ButtonGroup();

        //creat  a label
        pagelabel = new JLabel("Page 3: Account Details");
        pagelabel.setBounds(250, 100, 600, 50);
        pagelabel.setFont(new Font("System", Font.BOLD, 36));
        c.add(pagelabel);
        //creat  a label
        formlabel = new JLabel("Form No:" + formnb);
        formlabel.setBounds(700, 30, 150, 40);
        formlabel.setFont(new Font("System", Font.BOLD, 16));
        c.add(formlabel);

        //creat  a label
        accoutlabel = new JLabel("Account Type:");
        accoutlabel.setBounds(80, 180, 200, 40);
        accoutlabel.setFont(new Font("System", Font.BOLD, 20));
        c.add(accoutlabel);
        //creat a radio button
        r1 = new JRadioButton("Savings Account");
        r1.setBounds(80, 220, 200, 40);
        r1.setFont(new Font("System", Font.BOLD, 16));
        r1.setBackground(Color.ORANGE);
        c.add(r1);
        //creat a radio button
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(400, 220, 200, 40);
        r2.setFont(new Font("System", Font.BOLD, 16));
        r2.setBackground(Color.ORANGE);
        c.add(r2);
        //creat a radio button
        r3 = new JRadioButton("Current Account");
        r3.setBounds(80, 270, 200, 40);
        r3.setFont(new Font("System", Font.BOLD, 16));
        r3.setBackground(Color.ORANGE);
        c.add(r3);
        //creat a radio button
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(400, 270, 250, 40);
        r4.setFont(new Font("System", Font.BOLD, 16));
        r4.setBackground(Color.ORANGE);
        c.add(r4);
        grp1.add(r1);
        grp1.add(r2);
        grp1.add(r3);
        grp1.add(r4);
        //creat  a label
        cardlabel = new JLabel("Card Number:");
        cardlabel.setBounds(80, 320, 200, 40);
        cardlabel.setFont(new Font("System", Font.BOLD, 20));
        c.add(cardlabel);
        //creat  a label
        cardlabel2 = new JLabel("xxxx-xxxx-xxxx-xxxx");
        cardlabel2.setBounds(400, 320, 200, 40);
        cardlabel2.setFont(new Font("System", Font.BOLD, 20));
        c.add(cardlabel2);
        //creat  a label
        cardlabel3 = new JLabel("Your-16-digite-Card number");
        cardlabel3.setBounds(80, 350, 200, 40);
        cardlabel3.setFont(new Font("System", Font.BOLD, 14));
        c.add(cardlabel3);
        //creat  a label
        cardlabel4 = new JLabel("It would appear on Atm Card/Cheque Book and Statements ");
        cardlabel4.setBounds(400, 350, 450, 40);
        cardlabel4.setFont(new Font("System", Font.BOLD, 14));
        c.add(cardlabel4);
        //creat  a label
        pinlabel = new JLabel("Pin:");
        pinlabel.setBounds(80, 400, 200, 40);
        pinlabel.setFont(new Font("System", Font.BOLD, 20));
        c.add(pinlabel);
        //creat  a label
        pinlavel2 = new JLabel("xxxx");
        pinlavel2.setBounds(400, 400, 450, 40);
        pinlavel2.setFont(new Font("System", Font.BOLD, 20));
        c.add(pinlavel2);
        //creat  a label
        pinlabel3 = new JLabel("4-digit Card number");
        pinlabel3.setBounds(80, 430, 200, 40);
        pinlabel3.setFont(new Font("System", Font.BOLD, 14));
        c.add(pinlabel3);
        //creat  a label
        pinlabel4 = new JLabel("It will be auto crate/please remember pin number ");
        pinlabel4.setBounds(400, 430, 450, 40);
        pinlabel4.setFont(new Font("System", Font.BOLD, 14));
        c.add(pinlabel4);
        //creat  a label
        serviceslabel = new JLabel("Services Required: ");
        serviceslabel.setBounds(80, 480, 200, 40);
        serviceslabel.setFont(new Font("System", Font.BOLD, 20));
        c.add(serviceslabel);
        //creat a check box
        c1 = new JCheckBox("Atm Card");
        c1.setBounds(80, 520, 200, 40);
        c1.setFont(new Font("System", Font.BOLD, 18));
        c1.setBackground(Color.ORANGE);
        c.add(c1);
        //creat a check box
        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(400, 520, 200, 40);
        c2.setFont(new Font("System", Font.BOLD, 18));
        c2.setBackground(Color.ORANGE);
        c.add(c2);
        //creat a check box
        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(80, 580, 200, 40);
        c3.setFont(new Font("System", Font.BOLD, 18));
        c3.setBackground(Color.ORANGE);
        c.add(c3);
        //creat a check box
        c4 = new JCheckBox("Email Alerts");
        c4.setBounds(400, 580, 200, 40);
        c4.setFont(new Font("System", Font.BOLD, 18));
        c4.setBackground(Color.ORANGE);
        c.add(c4);
        //creat a check box
        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(80, 640, 200, 40);
        c5.setFont(new Font("System", Font.BOLD, 18));
        c5.setBackground(Color.ORANGE);
        c.add(c5);
        //creat a check box
        c6 = new JCheckBox("E-Statement");
        c6.setBounds(400, 640, 200, 40);
        c6.setFont(new Font("System", Font.BOLD, 18));
        c6.setBackground(Color.ORANGE);
        c.add(c6);
        //creat a check box
        c6 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge", true);
        c6.setBounds(80, 700, 700, 40);
        c6.setFont(new Font("System", Font.BOLD, 14));
        c6.setBackground(Color.ORANGE);
        c.add(c6);
        //create a button
        submit = new JButton("Submi");
        submit.setBounds(300, 760, 100, 40);
        submit.setFont(new Font("System", Font.BOLD, 18));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        c.add(submit);
        //create a button
        cancel = new JButton("Cancel");
        cancel.setBounds(480, 760, 100, 40);
        cancel.setFont(new Font("System", Font.BOLD, 18));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        c.add(cancel);
        submit.addActionListener(this);
        cancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("alpha");

        String acco_type = null;
        if (r1.isSelected()) {
            acco_type = "Savings account";
        } else if (r2.isSelected()) {
            acco_type = "Fixed deposit accoutn";
        } else if (r3.isSelected()) {
            acco_type = "Current accout";
        } else if (r4.isSelected()) {
            acco_type = "Recurring Deposit Account";
        }
        //crea a 16digit random number
        Random ran = new Random();
        long cardno = Math.abs(ran.nextLong() % 9000 + 18020290000000000L);
        //crea a 4 digid pin number
        long val = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(val);

        String service_required = "";
        if (c1.isSelected()) {
            service_required = service_required + " ATM Card";
        }
        if (c2.isSelected()) {
            service_required = service_required + " Internet Banking";
        }
        if (c3.isSelected()) {
            service_required = service_required + " Mobile Banking";
        }
        if (c4.isSelected()) {
            service_required = service_required + " EMAIL Alerts";
        }
        if (c5.isSelected()) {
            service_required = service_required + " Cheque Book";
        }
        if (c6.isSelected()) {
            service_required = service_required + " E-Statement";
        }
        try {
            if (ae.getSource() == submit) {
                if (acco_type.equals("")) {
                    JOptionPane.showMessageDialog(null, "Plese fill the Account type: ");
                } else {
                    Myconnection con = new Myconnection();
                    String Q1 = "INSERT INTO sign_up3 VALUES('" + formnb + "','" + acco_type + "','" + cardno + "','" + pin + "','" + service_required + "')";
                    String Q2 = "INSERT INTO login VALUES('" + formnb + "','" + cardno + "','" + pin + "')";
                    String Q3 = "INSERT INTO account_detels VALUES('" + pin + "','" + "0" + "')";

                    con.s.executeUpdate(Q1);
                    con.s.executeUpdate(Q2);
                    con.s.executeUpdate(Q3);

                    con.c.close();

                    //show user to card no and pin number;
                    JOptionPane.showMessageDialog(null, "Your card No : " + cardno + " and pin: " + pin,"Rupali Bank",JOptionPane.PLAIN_MESSAGE);

                    this.setVisible(false);
                    new Mylogin().setVisible(true);
                }
            } else if (ae.getSource() == cancel) {
                System.exit(0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String[] args) {

        new Mysignup3("").setVisible(true);
    }

}
