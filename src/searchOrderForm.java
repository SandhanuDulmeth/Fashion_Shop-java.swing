import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class searchOrderForm {

    private Customer customer;

    JFrame searchOrderclassFrame;
    //JFrame searchCustomerClassFrame;
    JPanel BackButtonpanel, centerPanel, SouthPanel;
    JButton backButton, searchButton;
    JTextField CustomerIdTextField;
    JLabel CustomerIdLabel1, CutomerIDLabel2, SizeLabel, QtyLabel, AmountLabel, StatusLabel, CutomerIDValue, SizeValue, QTYValue, AmountValue, StatusValue;
    Calculation calculation;

    public searchOrderForm() {
        /////////////////SEARCH ORDER FRAME/////////////////////////////////
        searchOrderclassFrame = new JFrame();
        searchOrderclassFrame.setLayout(new BorderLayout(5, 5));
        searchOrderclassFrame.setSize(600, 420);
        searchOrderclassFrame.setLocationRelativeTo(null);
        searchOrderclassFrame.setVisible(true);
        searchOrderclassFrame.setLayout(null);
        searchOrderclassFrame.setTitle("Search Order ");
        searchOrderclassFrame.setResizable(false);


        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(80, 30));
        backButton.setBackground(new Color(255, 102, 102));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchOrderclassFrame.dispose();
                new FashionShopMainForm();

            }
        });
        backButton.setBounds(5, 5, 100, 40);
        searchOrderclassFrame.add(backButton);

        CustomerIdLabel1 = new JLabel("Enter Order ID :    ");
        CustomerIdLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
        CustomerIdLabel1.setBounds(30, 70, 500, 20);
        searchOrderclassFrame.add(CustomerIdLabel1);

        CustomerIdTextField = new JTextField(10);
        CustomerIdTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
        CustomerIdTextField.setBounds(200, 70, 200, 30);
        searchOrderclassFrame.add(CustomerIdTextField);

        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setLayout(new FlowLayout(FlowLayout.LEFT));
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        searchButton.setForeground(Color.WHITE);
        //searchButton.setPreferredSize(new Dimension(120, 30));
        searchButton.setBackground(new Color(0, 152, 152));
        searchButton.setBounds(410, 60, 100, 40);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                try {
                    Customer customer = CustomerController.searchCustomer(CustomerIdTextField.getText());
                    if (customer != null) {
                        //txtName.setText(customer.getName());
                        //txtAddress.setText(customer.getAddress());
                        //txtSalary.setText(""+customer.getSalary());

                        CutomerIDValue = new JLabel(String.valueOf(customer.getPhoneNumber()));
                        CutomerIDValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        CutomerIDValue.setBounds(200, 130, 500, 20);
                        searchOrderclassFrame.add(CutomerIDValue);

                        SizeValue = new JLabel(String.valueOf(customer.getSize()));
                        SizeValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        SizeValue.setBounds(200, 170, 500, 20);
                        searchOrderclassFrame.add(SizeValue);

                        QTYValue = new JLabel(String.valueOf(customer.getQty()));
                        QTYValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        QTYValue.setBounds(200, 220, 500, 20);
                        searchOrderclassFrame.add(QTYValue);

                        AmountValue = new JLabel(String.valueOf(customer.getAmount()));
                        AmountValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        AmountValue.setBounds(200, 270, 500, 20);
                        searchOrderclassFrame.add(AmountValue);

                        StatusValue = new JLabel(customer.getStatus());
                        StatusValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        StatusValue.setBounds(200, 320, 500, 20);
                        searchOrderclassFrame.add(StatusValue);

                        searchOrderclassFrame.revalidate();
                        searchOrderclassFrame.repaint();
                        searchOrderclassFrame.setVisible(true);


                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found...");
                    }
                } catch (IOException ex) {
                    //
                }
            }

        });


        searchOrderclassFrame.add(searchButton);


        CutomerIDLabel2 = new JLabel("    Customer ID :    ");
        CutomerIDLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
        CutomerIDLabel2.setBounds(30, 130, 500, 20);
        searchOrderclassFrame.add(CutomerIDLabel2);

        SizeLabel = new JLabel("    Size :    ");
        SizeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        SizeLabel.setBounds(30, 170, 500, 20);
        searchOrderclassFrame.add(SizeLabel);

        QtyLabel = new JLabel("    Qty    :    ");
        QtyLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        QtyLabel.setBounds(30, 220, 500, 20);
        searchOrderclassFrame.add(QtyLabel);

        AmountLabel = new JLabel("    Amount :    ");
        AmountLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        AmountLabel.setBounds(30, 270, 500, 20);
        searchOrderclassFrame.add(AmountLabel);

        StatusLabel = new JLabel("    Status :    ");
        StatusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        StatusLabel.setBounds(30, 320, 500, 20);
        searchOrderclassFrame.add(StatusLabel);

        searchOrderclassFrame.setVisible(true);

    }
}

