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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Mytransactions extends JFrame implements ActionListener {

    Container c;
    JLabel label1, image;
    JButton deposit, cashwithdrow, fashcash, ministatement, pinchange, blanceenquery, exit, back;
    String pin;
    private ImageIcon icon;

    Mytransactions(String pin) {
        this.pin = pin;
        this.setBounds(500, 50, 900, 900);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setUndecorated(true);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(java.awt.Color.ORANGE);

        //creat a image
        icon = new ImageIcon("src/icon/bank.png");
        image = new JLabel(icon);
         image.setBounds(80, 30, icon.getIconWidth(), icon.getIconHeight());
        c.add(image);

        //crea a first label
        label1 = new JLabel("Please Select Your Transaction");
        label1.setBounds(250, 100, 550, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 35));
        c.add(label1);
        //creat button
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(120, 300, 250, 50);
        deposit.setForeground(Color.WHITE);
        deposit.setBackground(Color.BLACK);
        deposit.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(deposit);
        //creat button
        cashwithdrow = new JButton("CASH WITHDRAWL");
        cashwithdrow.setBounds(520, 300, 250, 50);
        cashwithdrow.setForeground(Color.WHITE);
        cashwithdrow.setBackground(Color.BLACK);
        cashwithdrow.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(cashwithdrow);
        //creat button
        fashcash = new JButton("FAST CASH");
        fashcash.setBounds(120, 400, 250, 50);
        fashcash.setForeground(Color.WHITE);
        fashcash.setBackground(Color.BLACK);
        fashcash.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(fashcash);
        //creat button
        ministatement = new JButton("Ministatement");
        ministatement.setBounds(520, 400, 250, 50);
        ministatement.setForeground(Color.WHITE);
        ministatement.setBackground(Color.BLACK);
        ministatement.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(ministatement);
        //creat button
        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(120, 500, 250, 50);
        pinchange.setForeground(Color.WHITE);
        pinchange.setBackground(Color.BLACK);
        pinchange.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(pinchange);
        //creat button
        blanceenquery = new JButton("BLANCE ENQUIRY");
        blanceenquery.setBounds(520, 500, 250, 50);
        blanceenquery.setForeground(Color.WHITE);
        blanceenquery.setBackground(Color.BLACK);
        blanceenquery.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(blanceenquery);
        exit = new JButton("EXIT");
        exit.setBounds(520, 650, 250, 50);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLACK);
        exit.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(exit);
        //creat a back button
        back = new JButton("BACK");
        back.setBounds(120, 650, 250, 50);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(back);

        deposit.addActionListener(this);
        cashwithdrow.addActionListener(this);
        fashcash.addActionListener(this);
        ministatement.addActionListener(this);
        pinchange.addActionListener(this);
        blanceenquery.addActionListener(this);
        exit.addActionListener(this);
        back.addActionListener(this);

    }

    Mytransactions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            this.setVisible(false);
            new Mylogin().setVisible(true);
        } else if (ae.getSource() == deposit) {
            this.setVisible(false);
            new Mydeposit(pin).setVisible(true);
        } else if (ae.getSource() == blanceenquery) {
            this.setVisible(false);
            new Myblance(pin).setVisible(true);
        } else if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == cashwithdrow) {
            this.setVisible(false);
            new Mywithdraw(pin).setVisible(true);

        } else if (ae.getSource() == fashcash) {
            this.setVisible(false);
            new Myfastcash(pin).setVisible(true);

        } else if (ae.getSource() == pinchange) {
            this.setVisible(false);
            new Mypin(pin).setVisible(true);

        } else if (ae.getSource() == ministatement) {
            this.setVisible(false);
            new Myministatement(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        Mytransactions transactionsframe = new Mytransactions("");
        transactionsframe.setVisible(true);
    }

}
