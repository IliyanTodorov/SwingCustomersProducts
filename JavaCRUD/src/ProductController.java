import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductController {


    public void addProduct(String productname,double price, int quantity){

        String query = "INSERT INTO products (name,price,quantity ) VALUES (?,?,?)";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement prp = conn.prepareStatement(query)) {
            prp.setString(1, productname);
            prp.setDouble(2, price);
            prp.setInt(3, quantity);

            prp.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void showProductsList(JTable table){

        String query = "SELECT * FROM products";

        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query) ) {
            ResultSet rs = stmt.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }


    }

    public void updateProduct(String id, String name, String price, String quantity){

        String updatequery = "UPDATE products SET name=?, price=?, quantity=? WHERE Id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement prp = conn.prepareStatement(updatequery)){
            prp.setString(1,name);
            prp.setDouble(2,Double.parseDouble(price));
            prp.setInt(3,Integer.parseInt(quantity));
            prp.setString(4,id);

            prp.executeUpdate();


        }
        catch ( SQLException ex){
            ex.printStackTrace();
        }
    }


    public void searchProductById(String id) {

        UpdateProduct update = new UpdateProduct();

        String query = "SELECT name, price, quantity FROM products WHERE id=?";

        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement prp = conn.prepareStatement(query)) {
            prp.setString(1, id);

            ResultSet rs = prp.executeQuery();

            if (rs.next() == true) {

                String name = rs.getString(1);
                String price = Double.toString(rs.getDouble(2));
                String quantity = Integer.toString(rs.getInt(3));

                update.getIdProduct().setVisible(false);
                update.getIdProduct().setText(id);
                update.getNameTxt().setText(name);
                update.getPriceTxt().setText(price);
                update.getQuantityTxt().setText(quantity);


                update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                update.pack();

                update.setVisible(true);

                /*String fname = update.getFirstNameTxt().getText();
                String lname = update.getLastNameTxt().getText();
                String em = update.getEmailTxt().getText();
                String tel = update.getPhoneNumber().getText();


                updateCustomer(id,fname,lname,em,tel);*/
            } else {
                update.getNameTxt().setText("");
                update.getQuantityTxt().setText("");
                update.getPriceTxt().setText("");
                JOptionPane.showMessageDialog(null, "Invalid Employee No");

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteProductById(String id){

        String query = "DELETE FROM products WHERE id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, id);

            prp.executeUpdate();

        }
        catch ( SQLException ex){
            ex.printStackTrace();
        }

    }
}
