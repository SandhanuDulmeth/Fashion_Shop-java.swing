import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class DeleteForm {
    JFrame DeleteClassFrame;
    JButton backButton, searchButton, deleteButton;
    JTextField OrderIDTextField;
    JLabel OrderIDLabel, CutomerIDValue, SizeValue, QTYValue, AmountValue, StatusValue;
    Calculation calculation = new Calculation();
    JLabel SizeLabel, QtyLabel, AmountLabel, StatusLabel, CutomerIDLabel2;

    DeleteForm() {

        DeleteClassFrame = new JFrame("Delete Order");
        // searchCustomerClassFrame.setLayout(new BorderLayout());
        DeleteClassFrame.setSize(590, 470);
        DeleteClassFrame.setLocationRelativeTo(null);
        DeleteClassFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DeleteClassFrame.setVisible(true);
        DeleteClassFrame.setLayout(null);
        DeleteClassFrame.setResizable(false);

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        // backButton.setPreferredSize(new Dimension(8, 3));
        backButton.setBackground(new Color(255, 102, 102));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteClassFrame.dispose();
                new FashionShopMainForm();

            }
        });
        backButton.setBounds(5, 5, 100, 40);
        DeleteClassFrame.add(backButton);
        // BackButtonpanel.add(backButton);
        // searchCustomerClassFrame.add(BackButtonpanel,BorderLayout.NORTH);


        // centerPanel = new JPanel();
        OrderIDLabel = new JLabel("Enter Order ID :    ");
        OrderIDLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        OrderIDLabel.setBounds(30, 70, 500, 20);
        DeleteClassFrame.add(OrderIDLabel);

        // centerPanel.add(CustomerIdLabel);


        OrderIDTextField = new JTextField(10);
        OrderIDTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
        OrderIDTextField.setBounds(200, 70, 200, 30);
        DeleteClassFrame.add(OrderIDTextField);

        //centerPanel.add(CustomerIdTextField);


        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setLayout(new FlowLayout(FlowLayout.LEFT));
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        searchButton.setForeground(Color.WHITE);
        //searchButton.setPreferredSize(new Dimension(120, 30));
        searchButton.setBackground(new Color(0, 152, 152));
        searchButton.setBounds(430, 60, 100, 35);
        DeleteClassFrame.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                try {
                    Customer customer = CustomerController.searchCustomer(OrderIDTextField.getText());
                    if (customer != null) {
                        //txtName.setText(customer.getName());
                        //txtAddress.setText(customer.getAddress());
                        //txtSalary.setText(""+customer.getSalary());

                        CutomerIDValue = new JLabel(String.valueOf(customer.getPhoneNumber()));
                        CutomerIDValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        CutomerIDValue.setBounds(200, 130, 500, 20);
                        DeleteClassFrame.add(CutomerIDValue);

                        SizeValue = new JLabel(String.valueOf(customer.getSize()));
                        SizeValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        SizeValue.setBounds(200, 170, 500, 20);
                        DeleteClassFrame.add(SizeValue);

                        QTYValue = new JLabel(String.valueOf(customer.getQty()));
                        QTYValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        QTYValue.setBounds(200, 220, 500, 20);
                        DeleteClassFrame.add(QTYValue);

                        AmountValue = new JLabel(String.valueOf(customer.getAmount()));
                        AmountValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        AmountValue.setBounds(200, 270, 500, 20);
                        DeleteClassFrame.add(AmountValue);

                        StatusValue = new JLabel(customer.getStatus());
                        StatusValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        StatusValue.setBounds(200, 320, 500, 20);
                        DeleteClassFrame.add(StatusValue);

                        DeleteClassFrame.revalidate();
                        DeleteClassFrame.repaint();
                        DeleteClassFrame.setVisible(true);


                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found...");
                    }
                } catch (IOException ex) {
                    //
                }
            }
        });


        DeleteClassFrame.add(searchButton);


        CutomerIDLabel2 = new JLabel("    Customer ID :    ");
        CutomerIDLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
        CutomerIDLabel2.setBounds(30, 130, 500, 20);
        DeleteClassFrame.add(CutomerIDLabel2);

        SizeLabel = new JLabel("    Size :    ");
        SizeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        SizeLabel.setBounds(30, 170, 500, 20);
        DeleteClassFrame.add(SizeLabel);

        QtyLabel = new JLabel("    Qty    :    ");
        QtyLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        QtyLabel.setBounds(30, 220, 500, 20);
        DeleteClassFrame.add(QtyLabel);

        AmountLabel = new JLabel("    Amount :    ");
        AmountLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        AmountLabel.setBounds(30, 270, 500, 20);
        DeleteClassFrame.add(AmountLabel);

        StatusLabel = new JLabel("    Status :    ");
        StatusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        StatusLabel.setBounds(30, 320, 500, 20);
        DeleteClassFrame.add(StatusLabel);

        //DeleteClassFrame.setVisible(true);

        deleteButton = new JButton(" Delete ");

        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        deleteButton.setForeground(Color.WHITE);
        // backButton.setPreferredSize(new Dimension(8, 3));
        deleteButton.setBackground(new Color(152, 51, 0));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Yes", "No",};
                int n = JOptionPane.showOptionDialog(null,
                        "Do you want to delete this order? ",
                        "Delete Confrimation",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.DEFAULT_OPTION,
                        null,
                        options,
                        options[1]);

                System.out.println(n);


                JFrame imperial = new JFrame("Imperial");
                imperial.setBounds(0, 0, 320, 240);

                if (n == 0) {


                            String id=OrderIDTextField.getText();
                            try{
                                boolean isDeleted=CustomerController.deleteCustomer(id);
                                if(isDeleted){
                                    JOptionPane.showMessageDialog(null,"Deleted..");
                                }else{

                                }
                            }catch(IOException ex){

                            }






                    //JOptionPane.showMessageDialog(DeleteClassFrame, "Order Deleted");

                } else if (n == 1) {
                    JOptionPane.showMessageDialog(null,"Delete fail..");
                    DeleteClassFrame.dispose();
                    new DeleteForm();
                    return;
                } else {
                    System.out.println("no option choosen");
                }

            }
        });
        deleteButton.setBounds(420, 360, 100, 40);
        DeleteClassFrame.add(deleteButton);


        DeleteClassFrame.setVisible(true);
    }

}
