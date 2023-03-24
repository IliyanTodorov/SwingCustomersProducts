import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;


public class CustomerController {

    public void addCustomer(String firstName, String lastName, String email, String phone){

        String query = "INSERT INTO customers (firstname,lastname,email,phone) VALUES (?,?,?,?)";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1,firstName);
            prp.setString(2,lastName);
            prp.setString(3,email);
            prp.setString(4,phone);

            prp.executeUpdate();

        }
        catch ( SQLException ex){
            ex.printStackTrace();
        }



    }

    public void showCustomersList(JTable table){


        String query = "SELECT * FROM customers";


        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch ( SQLException ex){
            ex.printStackTrace();
        }

    }

    public void updateCustomer(String id, String firstName, String lastName, String email, String phone){

        String updatequery = "UPDATE customers SET firstname=?, lastname=?, email=?, phone=? WHERE id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement prp = conn.prepareStatement(updatequery)){
            prp.setString(1,firstName);
            prp.setString(2,lastName);
            prp.setString(3,email);
            prp.setString(4,phone);
            prp.setString(5,id);

            prp.executeUpdate();


        }
        catch ( SQLException ex){
            ex.printStackTrace();
        }
    }
    public void searchCustomerById(String id){
        UpdateCustomer update = new UpdateCustomer();


        String query = "SELECT firstname, lastname, email, phone FROM customers WHERE id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1,id);

            ResultSet rs = prp.executeQuery();

            if (rs.next()==true){

                String firstname = rs.getString(1);
                String lastName = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);

                update.getId().setVisible(false);
                update.getId().setText(id);
                update.getFirstNameTxt().setText(firstname);
                update.getLastNameTxt().setText(lastName);
                update.getEmailTxt().setText(email);
                update.getPhoneNumber().setText(phone);



                update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                update.pack();

                update.setVisible(true);

                /*String fname = update.getFirstNameTxt().getText();
                String lname = update.getLastNameTxt().getText();
                String em = update.getEmailTxt().getText();
                String tel = update.getPhoneNumber().getText();


                updateCustomer(id,fname,lname,em,tel);*/
            }
            else
            {
                update.getFirstNameTxt().setText("");
                update.getLastNameTxt().setText("");
                update.getEmailTxt().setText("");
                update.getPhoneNumber().setText("");
                JOptionPane.showMessageDialog(null,"Invalid Employee No");

            }


        }
        catch ( SQLException ex){
            ex.printStackTrace();
        }



    }

    public void deleteCustomerById(String id){

        String query = "DELETE FROM customers WHERE id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, id);

            prp.executeUpdate();

        }
        catch ( SQLException ex){
            ex.printStackTrace();
        }

    }

}

