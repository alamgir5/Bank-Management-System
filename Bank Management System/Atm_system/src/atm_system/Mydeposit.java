/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Mydeposit extends JFrame implements ActionListener {

    Container c;
    JLabel l1, l2, l3, image;
    JTextField t2;
    JButton deposit, back, exit;
    String pin;
    private ImageIcon icon;

    Mydeposit(String pin) {
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
        //creata a jalabel
        l2 = new JLabel("ENTER AMOUNT YOU WANT");
        l2.setBounds(180, 180, 700, 40);
        l2.setBackground(Color.ORANGE);
        l2.setFont(new Font("System", Font.BOLD, 38));
        c.add(l2);
//        //creata a jalabel
        l3 = new JLabel("TO DEPOSIT");
        l3.setBounds(310, 220, 700, 40);
        l3.setBackground(Color.ORANGE);
        l3.setFont(new Font("System", Font.BOLD, 38));
        c.add(l3);
        //creata a textfield
        t2 = new JTextField();
        t2.setBounds(230, 300, 450, 60);
        t2.setBackground(Color.ORANGE);
        t2.setFont(new Font("System", Font.BOLD, 38));
        c.add(t2);
        //create a button
        deposit = new JButton("Deposit");
        deposit.setBounds(230, 450, 200, 50);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("System", Font.BOLD, 30));
        c.add(deposit);
        //create a button
        back = new JButton("Back");
        back.setBounds(480, 450, 200, 50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("System", Font.BOLD, 30));
        c.add(back);
        //create a button
        exit = new JButton("Exit");
        exit.setBounds(350, 550, 200, 50);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("System", Font.BOLD, 30));
        c.add(exit);
        deposit.addActionListener(this);
        back.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {

            if (ae.getSource() == deposit) {
                String amount = t2.getText();
                Date date = new Date();
                if (amount.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Inter The Aomount You Want To Deposit","Rupali Bank",JOptionPane.WARNING_MESSAGE);
                } else {

                    Myconnection con = new Myconnection();
                    String Q1 = "INSERT INTO bank VALUES('" + pin + "','" + date + "','Deposit','" + amount + "')";
                    String Q2 = "SELECT * FROM account_detels WHERE pin='" + pin + "'";
                    con.s.executeUpdate(Q1);
                    int newval = 0;
                    ResultSet rs = con.s.executeQuery(Q2);
                    while (rs.next()) {
                        newval = Integer.parseInt(rs.getString("amount")) + Integer.parseInt(amount);
                    }

                    //data insert in account_detels table
                    String val = String.valueOf(newval);
                    String Q3 = "UPDATE account_detels SET amount='" + val + "' WHERE pin='" + pin + "'";
                    con.s.executeUpdate(Q3);
                    con.c.close();

                    JOptionPane.showMessageDialog(null, amount + "Taka deposit succfully","Rupali Bank",JOptionPane.PLAIN_MESSAGE);
                    this.setVisible(false);
                    new Mytransactions(pin).setVisible(true);
                }
            } else if (ae.getSource() == back) {
                this.setVisible(false);
                new Mytransactions(pin).setVisible(true);

            } else if (ae.getSource() == exit) {
                System.exit(0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String[] args) {
        new Mydeposit("").setVisible(true);
    }

}
