import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomersAndProducts {
    private JPanel CustomersAndProducts;
    private JButton btnAddCustomer;
    private JButton btnUpdateCustomer;
    private JButton deleteButton;
    private JFormattedTextField txtSearchById;
    private JButton btnSearchByCustomerName;
    private JTable table1;
    private JButton btnAddProduct;
    private JButton btnUpdateProduct;
    private JButton btnDeleteProduct;
    private JFormattedTextField searchByProductId;
    private JButton btnSearchByProductId;
    private JTable table2;


    public CustomersAndProducts() {

        ProductController product = new ProductController();
        product.showProductsList(table2);

        CustomerController customer = new CustomerController();
        customer.showCustomersList(table1);


        btnAddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddCustomer add = new AddCustomer();

                add.setVisible(true);

            }
        });
        btnUpdateCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateCustomer update = new UpdateCustomer();

                update.setVisible(true);


            }
        });
        btnAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddProduct add = new AddProduct();
                add.setVisible(true);
            }
        });
        btnUpdateProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateProduct update = new UpdateProduct();
                update.setVisible(true);

            }
        });
        btnSearchByCustomerName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtSearchById.getText();
                customer.searchCustomerById(id);

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtSearchById.getText();

                customer.deleteCustomerById(id);
            }
        });
        btnSearchByProductId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = searchByProductId.getText();

                product.searchProductById(id);
            }
        });
        btnDeleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = searchByProductId.getText();

                product.deleteProductById(id);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CustomersAndProducts");
        frame.setContentPane(new CustomersAndProducts().CustomersAndProducts);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
