import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCustomer extends JFrame {
    private JPanel UpdateCustomer;
    private JFormattedTextField txtFirstNameUpdate;
    private JFormattedTextField txtLastNameUpdate;
    private JFormattedTextField txtEmailUpdate;
    private JFormattedTextField txtPhoneNumberUpdate;
    private JButton btnUpdate;
    private JButton btnClose;
    private JFormattedTextField txtId;

    public JFormattedTextField getId(){
        return txtId;
    }

    public JFormattedTextField getFirstNameTxt(){
        return txtFirstNameUpdate;
    }

    public void setFirstName(JFormattedTextField txtFirstName){
        txtFirstName = txtFirstNameUpdate;
    }

    public JFormattedTextField getLastNameTxt(){
        return txtLastNameUpdate;
    }

    public void setLastName(JFormattedTextField txtLastName){
       txtLastName = txtLastNameUpdate;
    }

    public JFormattedTextField getEmailTxt(){
        return txtEmailUpdate;
    }

    public void setEmail(JFormattedTextField txtEmail){
        txtEmail = txtEmailUpdate;
    }

    public JFormattedTextField getPhoneNumber(){
        return txtPhoneNumberUpdate;
    }

    public void setPhoneNumber(JFormattedTextField txtPhone){
        txtPhone = txtPhoneNumberUpdate;
    }

    public UpdateCustomer(){

        setContentPane(UpdateCustomer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();

        setVisible(true);


        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = UpdateCustomer.this.txtId.getText();
                String firstname = UpdateCustomer.this.txtFirstNameUpdate.getText();
                String lastname = UpdateCustomer.this.txtLastNameUpdate.getText();
                String email = UpdateCustomer.this.txtEmailUpdate.getText();
                String phone = UpdateCustomer.this.txtPhoneNumberUpdate.getText();

                if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(UpdateCustomer, "The fields are not full!");
                }
                else {
                    CustomerController customer = new CustomerController();


                    customer.updateCustomer(id, firstname,lastname,email,phone);

                    dispose();
                }
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
