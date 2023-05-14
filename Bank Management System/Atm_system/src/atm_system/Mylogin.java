package atm_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Mylogin extends JFrame implements ActionListener {

    private Container c;
    private JLabel l1, l2, l3, biglabel, image;
    private JTextField f1, f2, f3;
    private JButton b1, b2, b3,b4;
    private Font font, font2;
    private ImageIcon icon;

    Mylogin() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(500, 50, 900, 900);
        this.setTitle("RUPALI BANK");
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);

        icon = new ImageIcon("src/icon/bank.png");

        image = new JLabel(icon);
        image.setBounds(80, 30, icon.getIconWidth(), icon.getIconHeight());
        c.add(image);

        font = new Font("Time the new roman", Font.BOLD, 24);
        font2 = new Font("Time the new roman", Font.BOLD, 40);

        biglabel = new JLabel("WELLCOME TO MY BANK");
        biglabel.setFont(font2);
        biglabel.setBounds(300, 110, 500, 50);
        c.add(biglabel);

        l1 = new JLabel("Card No :");
        l1.setBounds(150, 250, 150, 40);
        l1.setFont(font);
        c.add(l1);

        f1 = new JTextField();
        f1.setBounds(350, 250, 350, 40);
        f1.setFont(font);
        c.add(f1);

        l2 = new JLabel("PIN :");
        l2.setBounds(150, 350, 150, 40);
        l2.setFont(font);
        c.add(l2);

        f2 = new JTextField();
        f2.setBounds(350, 350, 350, 40);
        f2.setFont(font);
        c.add(f2);

        b1 = new JButton("SIGN IN");
        b1.setBounds(350, 440, 150, 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(font);
        c.add(b1);

        b2 = new JButton("CLEAR");
        b2.setBounds(550, 440, 150, 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(font);
        c.add(b2);

        b3 = new JButton("SIGN UP");
        b3.setBounds(350, 540, 350, 40);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(font);
        c.add(b3);
        
        b4 = new JButton("EXIT");
        b4.setBounds(350, 600, 350, 40);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(font);
        c.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            f1.setText("");
            f2.setText("");
        } else if (e.getSource() == b3) {
            this.setVisible(false);
            new Mysignup().setVisible(true);
        } else if (e.getSource() == b1) {
            String cardnb = f1.getText();
            String pin = f2.getText();
            if(cardnb.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Inter Your Card Number","Rupali Bank",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(pin.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Inter Your Pin Number","Rupali Bank",JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                Myconnection con = new Myconnection();
                String Q = "SELECT *FROM login WHERE card_number='" + cardnb + "' AND pin_number='" + pin + "'";
                ResultSet rs = con.s.executeQuery(Q);
                if (rs.next()) {
                    this.setVisible(false);
                    new Mytransactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Your Card Number And Pin Invalide","Rupali Bank",JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
        else{
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Mylogin frame = new Mylogin();
        frame.setVisible(true);
    }

}
