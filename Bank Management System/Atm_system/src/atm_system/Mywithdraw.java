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
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Mywithdraw extends JFrame implements ActionListener {

    Container c;
    JLabel l1, l2, l3, image;
    JTextField t1, t2;
    JButton withdraw, back, exit;
    private ImageIcon icon;
    String pin;

    Mywithdraw(String pin) {
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
        l2.setBounds(210, 180, 700, 40);
        l2.setBackground(Color.ORANGE);
        l2.setFont(new Font("System", Font.BOLD, 38));
        c.add(l2);
        //creata a jalabel
        l3 = new JLabel("TO WITHDRAW");
        l3.setBounds(320, 220, 700, 40);
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
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(230, 450, 200, 50);
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("System", Font.BOLD, 30));
        c.add(withdraw);
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
        withdraw.addActionListener(this);
        back.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t2.getText();
            Date date = new Date();
            if (ae.getSource() == withdraw) {
                if (amount.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Withdrow");
                } else {
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
                    String Q2 = "INSERT INTO bank VALUES('" + pin + "','" + date + "','Withdraw','" + amount + "')";
                    con.s.executeUpdate(Q2);
                    con.c.close();
                    
                    JOptionPane.showMessageDialog(null, amount + " Taka withdraw succfully ","Rupali Bank",JOptionPane.PLAIN_MESSAGE);
                    
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
        new Mywithdraw("").setVisible(true);
    }

}
