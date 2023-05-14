package atm_system;

import java.sql.*;
import javax.swing.JOptionPane;

public class Myconnection {

    Connection c;
    Statement s;

    public Myconnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/bank_management_system", "root", "");
            s = c.createStatement();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
