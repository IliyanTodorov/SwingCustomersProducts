import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends JFrame {
    private JPanel AddCustomer;
    private JFormattedTextField txtCustomerFirstName;
    private JFormattedTextField txtCustomerLastName;
    private JFormattedTextField txtCustomerEmail;
    private JFormattedTextField txtCustomerPhoneNumber;
    private JButton btnCustomerAdd;
    private JButton btnClose;


    public AddCustomer(){
        setContentPane(AddCustomer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        setVisible(true);

        btnCustomerAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String firstname = AddCustomer.this.txtCustomerFirstName.getText();
                String lastname = AddCustomer.this.txtCustomerLastName.getText();
                String email = AddCustomer.this.txtCustomerEmail.getText();
                String phone = AddCustomer.this.txtCustomerPhoneNumber.getText();

                if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || phone.isEmpty()){
                    JOptionPane.showMessageDialog(AddCustomer, "The fields are not full!");
                }
                else {

                    CustomerController customer = new CustomerController();

                    customer.addCustomer(firstname,lastname,email,phone);


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
