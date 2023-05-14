package atm_system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Myministatement extends JFrame implements ActionListener {

    Container c;
    String pin;
    private ImageIcon icon;
    JLabel image, l1, l2, l3, l4;
    private JButton back, exit;
    private JTextArea a;
    private JScrollPane s;

    public Myministatement(String pin) {
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

        l1 = new JLabel("RUPALI BANK");
        l1.setBounds(340, 80, 300, 50);
        l1.setFont(new Font("Time the new roman", Font.BOLD, 40));
        c.add(l1);

        l2 = new JLabel();
        l2.setBounds(280, 140, 600, 50);
        l2.setFont(new Font("Time the new roman", Font.BOLD, 20));
        c.add(l2);

        l3 = new JLabel();
        l3.setBounds(50, 250, 600, 50);
        l3.setFont(new Font("Time the new roman", Font.BOLD, 20));
        c.add(l3);

        l4 = new JLabel();
        l4.setBounds(50, 650, 600, 50);
        l4.setFont(new Font("Time the new roman", Font.BOLD, 20));
        c.add(l4);

        back = new JButton("BACK");
        back.setBounds(100, 810, 150, 50);
        back.setFont(new Font("Time the new roman", Font.BOLD, 20));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        c.add(back);

        exit = new JButton("EXIT");
        exit.setBounds(650, 810, 150, 50);
        exit.setFont(new Font("Time the new roman", Font.BOLD, 20));
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLACK);
        c.add(exit);

        a = new JTextArea();
        //a.setBounds(100, 200,700,600);
        a.setFont(new Font("Time the new roman", Font.BOLD, 20));
        a.setLineWrap(true);
        a.setWrapStyleWord(true);
        a.setBackground(Color.BLACK);
        a.setForeground(Color.white);

        s = new JScrollPane(a, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        s.setBounds(100, 200, 700, 600);
        c.add(s);

        back.addActionListener(this);
        exit.addActionListener(this);

        Myconnection con = new Myconnection();
        ///try catch - 1 find card number from longin table
        try {

            String Q = "SELECT *FROM login WHERE pin_number='" + pin + "'";
            ResultSet rs = con.s.executeQuery(Q);
            while (rs.next()) {
                l2.setText("Card numbre :      " + rs.getString("card_number").substring(0, 4) + "XXXXXXX" + rs.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        ///try catch 2  find from_number from sign_up3 table
        String fromnumber = null;
        try {
            String Q = "SELECT *FROM sign_up3 WHERE pin_number='" + pin + "'";
            ResultSet rs = con.s.executeQuery(Q);
            while (rs.next()) {
                fromnumber = rs.getString("formnumber");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        ///try catch - 3 find name from sign_up table
        try {
            String Q = "SELECT *FROM sign_up WHERE formnumber='" + fromnumber + "'";
            ResultSet rs = con.s.executeQuery(Q);
            while (rs.next()) {
                a.setText("Your Name :"+rs.getString("name") + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //try catch - 4 
        try {
            String Q = "SELECT *FROM bank WHERE pin='" + pin + "'";
            ResultSet rs = con.s.executeQuery(Q);
            while (rs.next()) {
                a.append(rs.getString("date") + "         " + rs.getString("mode") + "        " + rs.getString("amount") + "\n");
            }
            con.c.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            this.setVisible(false);
            new Mytransactions(pin).setVisible(true);
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Myministatement("").setVisible(true);
    }

}
