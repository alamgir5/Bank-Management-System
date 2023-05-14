package atm_system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import jdk.nashorn.internal.scripts.JO;

public class Myblance extends JFrame implements ActionListener {

    Container c;
    String pin;
    private ImageIcon icon;
    JLabel image, l2;
    JTextField f1;
    private JButton back,exit;

    public Myblance(String pin) {
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

        l2 = new JLabel("Your Current Blacne is : ");
        l2.setBounds(150, 200, 700, 50);
        l2.setBackground(Color.ORANGE);
        l2.setFont(new Font("System", Font.BOLD, 38));
        c.add(l2);

        //create a button
        back = new JButton("BACK");
        back.setBounds(600, 750, 200, 50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("System", Font.BOLD, 30));
        c.add(back);
        
        //create a button
        exit = new JButton("EXIT");
        exit.setBounds(100, 750, 200, 50);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("System", Font.BOLD, 30));
        c.add(exit);
        
        String balance = "0";
        try {
            Myconnection con = new Myconnection();
            String Q = "SELECT *FROM account_detels WHERE pin='" + pin + "'";
            ResultSet rs = con.s.executeQuery(Q);

            while (rs.next()) {
                balance = rs.getString("amount");
            }
            con.c.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        l2.setText("Your Current Blacne is : "+balance);
        back.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
        this.setVisible(false);
        new Mytransactions(pin).setVisible(true);
        }
        else{
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Myblance("").setVisible(true);
    }

}
