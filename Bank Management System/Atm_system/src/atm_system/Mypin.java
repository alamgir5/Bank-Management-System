package atm_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Mypin extends JFrame implements ActionListener {

    Container c;
    String pin;
    private ImageIcon icon;
    JLabel image, l1, l2, l3;
    JTextField f1, f2;
    private JButton change, back;

    Mypin(String pin) {
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

        l1 = new JLabel("Change Your Pin ");
        l1.setBounds(250, 180, 550, 50);
        l1.setFont(new Font("Arial", Font.BOLD, 35));
        c.add(l1);

        l2 = new JLabel("NEW PIN : ");
        l2.setBounds(50, 320, 250, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 24));
        c.add(l2);

        f1 = new JTextField();
        f1.setBounds(340, 320, 450, 50);
        f1.setFont(new Font("Arial", Font.BOLD, 24));
        c.add(f1);

        l3 = new JLabel("Re- Enter NEW PIN :");
        l3.setBounds(50, 420, 250, 50);
        l3.setFont(new Font("Arial", Font.BOLD, 24));
        c.add(l3);

        f2 = new JTextField();
        f2.setBounds(340, 420, 450, 50);
        f2.setFont(new Font("Arial", Font.BOLD, 24));
        c.add(f2);

        change = new JButton("CHANGE");
        change.setBounds(540, 550, 250, 50);
        change.setFont(new Font("Arial", Font.BOLD, 22));
        change.setForeground(Color.WHITE);
        change.setBackground(Color.BLACK);
        c.add(change);

        back = new JButton("BACK");
        back.setBounds(540, 640, 250, 50);
        back.setFont(new Font("Arial", Font.BOLD, 22));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        c.add(back);

        back.addActionListener(this);
        change.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = f1.getText();
            String rpin = f2.getText();

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Eenter Pin Doed Not Match","Rupali Bank",JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (ae.getSource() == change) {
                if (f1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New Pin","Rupali Bank",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                else  if (f2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New Pin","Rupali Bank",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Myconnection con = new Myconnection();

                String Q1 = "UPDATE bank SET pin='" + rpin + "' WHERE pin='" + pin + "'";
                String Q2 = "UPDATE login SET pin_number='" + rpin + "' WHERE pin_number='" + pin + "'";
                String Q3 = "UPDATE sign_up3 SET pin_number='" + rpin + "' WHERE pin_number='" + pin + "'";
                String Q4 = "UPDATE account_detels SET pin='" + rpin + "' WHERE pin='" + pin + "'";

                con.s.executeUpdate(Q1);
                con.s.executeUpdate(Q2);
                con.s.executeUpdate(Q3);
                con.s.executeUpdate(Q4);

                con.c.close();

                JOptionPane.showMessageDialog(null, "Pin Change Successfully ","Rupali Bank",JOptionPane.PLAIN_MESSAGE);
                this.setVisible(false);
                new Mylogin().setVisible(true);
            } else if (ae.getSource() == back) {
                this.setVisible(false);
                new Mytransactions(rpin).setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String[] args) {
        new Mypin("").setVisible(true);
    }

}
