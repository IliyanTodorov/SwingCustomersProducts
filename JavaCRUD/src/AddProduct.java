import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddProduct extends JFrame{
    private JFormattedTextField txtNameProduct;
    private JFormattedTextField txtPriceProduct;
    private JFormattedTextField txtQuantityProduct;
    private JButton btnAddProduct;
    private JButton btnClose;
    private JPanel AddProduct;

    public AddProduct()
    {
        setContentPane(AddProduct);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        btnAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameproduct = AddProduct.this.txtNameProduct.getText();
                double price =  Double.parseDouble(AddProduct.this.txtPriceProduct.getText());
                int quantity = Integer.parseInt(AddProduct.this.txtQuantityProduct.getText());

                if(nameproduct.isEmpty() ) {
                    JOptionPane.showMessageDialog(AddProduct, "The fields are not full!");
                }
                else{
                    ProductController product = new ProductController();
                    product.addProduct(nameproduct,price,quantity);
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
