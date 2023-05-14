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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Myfastcash extends JFrame implements ActionListener {

    Container c;
    JLabel label1, image;
    JButton R_100, R_500, R_1000, R_2000, R_5000, R_10000, back, exit;
    private ImageIcon icon;
    String pin;

    Myfastcash(String pin) {
        this.pin = pin;
        this.setBounds(500, 50, 900, 900);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(java.awt.Color.ORANGE);
        //create a image
        icon = new ImageIcon("src/icon/bank.png");
        image = new JLabel(icon);
        image.setBounds(80, 30, icon.getIconWidth(), icon.getIconHeight());
        c.add(image);
        //crea a first label
        label1 = new JLabel("Please Select Withdraw amount");
        label1.setBounds(220, 120, 550, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 35));
        c.add(label1);
        //creat button
        R_100 = new JButton("Tk 100");
        R_100.setBounds(160, 250, 250, 50);
        R_100.setForeground(Color.WHITE);
        R_100.setBackground(Color.BLACK);
        R_100.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(R_100);
        //creat button
        R_500 = new JButton("Tk 500");
        R_500.setBounds(520, 250, 250, 50);
        R_500.setForeground(Color.WHITE);
        R_500.setBackground(Color.BLACK);
        R_500.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(R_500);
        //creat button
        R_1000 = new JButton("Tk 1000");
        R_1000.setBounds(160, 350, 250, 50);
        R_1000.setForeground(Color.WHITE);
        R_1000.setBackground(Color.BLACK);
        R_1000.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(R_1000);
        //creat button
        R_2000 = new JButton("Tk 2000");
        R_2000.setBounds(520, 350, 250, 50);
        R_2000.setForeground(Color.WHITE);
        R_2000.setBackground(Color.BLACK);
        R_2000.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(R_2000);
        //creat button
        R_5000 = new JButton("Tk 5000");
        R_5000.setBounds(160, 450, 250, 50);
        R_5000.setForeground(Color.WHITE);
        R_5000.setBackground(Color.BLACK);
        R_5000.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(R_5000);
        //creat button
        R_10000 = new JButton("Tk 10000");
        R_10000.setBounds(520, 450, 250, 50);
        R_10000.setForeground(Color.WHITE);
        R_10000.setBackground(Color.BLACK);
        R_10000.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(R_10000);
        back = new JButton("Back");
        back.setBounds(160, 550, 250, 50);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(back);
        exit = new JButton("EXIT");
        exit.setBounds(520, 550, 250, 50);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLACK);
        exit.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(exit);
        R_100.addActionListener(this);
        R_500.addActionListener(this);
        R_1000.addActionListener(this);
        R_2000.addActionListener(this);
        R_5000.addActionListener(this);
        R_10000.addActionListener(this);
        back.addActionListener(this);
        exit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            Date date = new Date();
            if (ae.getSource() == back) {
                this.setVisible(false);
                new Mytransactions(pin).setVisible(true);
            } else if (ae.getSource() == exit) {
                System.exit(0);
            } else {
                String amount = ((JButton) ae.getSource()).getText().substring(3);
                Myconnection con = new Myconnection();
                
                String Q1 = "SELECT * FROM account_detels WHERE pin='" + pin + "'";
                ResultSet rs = con.s.executeQuery(Q1);
                int tota_valu = 0;
                while (rs.next()) {
                    tota_valu = Integer.parseInt(rs.getString("amount")) - Integer.parseInt(amount);
                }
                if (tota_valu <= 0) {
                    JOptionPane.showMessageDialog(null, "Insuffient Blance","Rupali Bank",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                //inset in acount detls 
                String val = String.valueOf(tota_valu);
                String Q3 = "UPDATE account_detels SET amount='" + val + "' WHERE pin='" + pin + "'";
                con.s.executeUpdate(Q3);

                //inset in bank table
                String Q2 = "INSERT INTO bank VALUES('" + pin + "','" + date + "','Withdrawl','" + amount + "')";
                con.s.executeUpdate(Q2);
                con.c.close();

                JOptionPane.showMessageDialog(null, amount + " Taka withdraw succfully ","Rupali Bank",JOptionPane.PLAIN_MESSAGE);

                this.setVisible(false);
                new Mytransactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String[] args) {
        new Myfastcash("").setVisible(true);
    }

}
