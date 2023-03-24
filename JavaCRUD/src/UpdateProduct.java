import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProduct extends JFrame {
    private JFormattedTextField txtUpdatePrice;
    private JFormattedTextField txtUpdateName;
    private JFormattedTextField txtUpdateQuantiy;
    private JButton updateProductButton;
    private JButton closeButton;
    private JPanel UpdateProduct;
    private JFormattedTextField txtProductId;

    public JFormattedTextField getIdProduct(){
        return txtProductId;
    }

    public JFormattedTextField getNameTxt(){
        return txtUpdateName;
    }


    public JFormattedTextField getPriceTxt(){
        return txtUpdatePrice;
    }

    public JFormattedTextField getQuantityTxt(){
        return txtUpdateQuantiy;
    }


    public UpdateProduct()
    {
        setContentPane(UpdateProduct);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();

        setVisible(true);


        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = UpdateProduct.this.txtProductId.getText();
                String updateName = UpdateProduct.this.txtUpdateName.getText();
                String updatePrice = UpdateProduct.this.txtUpdatePrice.getText();
                String updateQuantity = UpdateProduct.this.txtUpdateQuantiy.getText();

                if(updateName.isEmpty() || updatePrice.isEmpty() || updateQuantity.isEmpty()) {

                    JOptionPane.showMessageDialog(UpdateProduct, "The fields are not full!");

                }
                else{
                    ProductController product = new ProductController();

                    product.updateProduct(id, updateName, updatePrice, updateQuantity);

                    dispose();
                }

            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
