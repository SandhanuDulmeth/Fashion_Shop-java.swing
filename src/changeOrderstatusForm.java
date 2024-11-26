import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class changeOrderstatusForm{
    JFrame ChangeOrderstatusClassFrame;
    JButton backButton, searchButton, changeStatusButton;
    JTextField OrderIDTextField;
    JLabel OrderIDLabel, CutomerIDValue, SizeValue, QTYValue, AmountValue, StatusValue;
    Calculation calculation = new Calculation();
    JLabel SizeLabel, QtyLabel, AmountLabel, StatusLabel, CutomerIDLabel2;

    changeOrderstatusForm() {

        ChangeOrderstatusClassFrame = new JFrame(" Status Form ");
        // searchCustomerClassFrame.setLayout(new BorderLayout());
        ChangeOrderstatusClassFrame.setSize(590, 470);
        ChangeOrderstatusClassFrame.setLocationRelativeTo(null);
        ChangeOrderstatusClassFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ChangeOrderstatusClassFrame.setVisible(true);
        ChangeOrderstatusClassFrame.setLayout(null);
        ChangeOrderstatusClassFrame.setResizable(false);

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        // backButton.setPreferredSize(new Dimension(8, 3));
        backButton.setBackground(new Color(255, 102, 102));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangeOrderstatusClassFrame.dispose();
                new FashionShopMainForm();

            }
        });
        backButton.setBounds(5, 5, 100, 40);
        ChangeOrderstatusClassFrame.add(backButton);
        // BackButtonpanel.add(backButton);
        // searchCustomerClassFrame.add(BackButtonpanel,BorderLayout.NORTH);


        // centerPanel = new JPanel();
        OrderIDLabel = new JLabel("Enter Order ID :    ");
        OrderIDLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        OrderIDLabel.setBounds(30, 70, 500, 20);
        ChangeOrderstatusClassFrame.add(OrderIDLabel);

        // centerPanel.add(CustomerIdLabel);


        OrderIDTextField = new JTextField(10);
        OrderIDTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
        OrderIDTextField.setBounds(200, 70, 200, 30);
        ChangeOrderstatusClassFrame.add(OrderIDTextField);

        //centerPanel.add(CustomerIdTextField);


        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setLayout(new FlowLayout(FlowLayout.LEFT));
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        searchButton.setForeground(Color.WHITE);
        //searchButton.setPreferredSize(new Dimension(120, 30));
        searchButton.setBackground(new Color(0, 152, 152));
        searchButton.setBounds(430, 60, 100, 35);
        ChangeOrderstatusClassFrame.add(searchButton);

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
                        ChangeOrderstatusClassFrame.add(CutomerIDValue);

                        SizeValue = new JLabel(String.valueOf(customer.getSize()));
                        SizeValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        SizeValue.setBounds(200, 170, 500, 20);
                        ChangeOrderstatusClassFrame.add(SizeValue);

                        QTYValue = new JLabel(String.valueOf(customer.getQty()));
                        QTYValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        QTYValue.setBounds(200, 220, 500, 20);
                        ChangeOrderstatusClassFrame.add(QTYValue);

                        AmountValue = new JLabel(String.valueOf(customer.getAmount()));
                        AmountValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        AmountValue.setBounds(200, 270, 500, 20);
                        ChangeOrderstatusClassFrame.add(AmountValue);

                        StatusValue = new JLabel(customer.getStatus());
                        StatusValue.setFont(new Font("Tahoma", Font.BOLD, 16));
                        StatusValue.setBounds(200, 320, 500, 20);
                        ChangeOrderstatusClassFrame.add(StatusValue);

                        ChangeOrderstatusClassFrame.revalidate();
                        ChangeOrderstatusClassFrame.repaint();
                        ChangeOrderstatusClassFrame.setVisible(true);


                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found...");
                        OrderIDTextField.setText("");
                    }
                } catch (IOException ex) {
                    //
                }
            }
        });


        ChangeOrderstatusClassFrame.add(searchButton);


        CutomerIDLabel2 = new JLabel("    Customer ID :    ");
        CutomerIDLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
        CutomerIDLabel2.setBounds(30, 130, 500, 20);
        ChangeOrderstatusClassFrame.add(CutomerIDLabel2);

        SizeLabel = new JLabel("    Size :    ");
        SizeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        SizeLabel.setBounds(30, 170, 500, 20);
        ChangeOrderstatusClassFrame.add(SizeLabel);

        QtyLabel = new JLabel("    Qty    :    ");
        QtyLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        QtyLabel.setBounds(30, 220, 500, 20);
        ChangeOrderstatusClassFrame.add(QtyLabel);

        AmountLabel = new JLabel("    Amount :    ");
        AmountLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        AmountLabel.setBounds(30, 270, 500, 20);
        ChangeOrderstatusClassFrame.add(AmountLabel);

        StatusLabel = new JLabel("    Status :    ");
        StatusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        StatusLabel.setBounds(30, 320, 500, 20);
        ChangeOrderstatusClassFrame.add(StatusLabel);

        //DeleteClassFrame.setVisible(true);

        changeStatusButton = new JButton(" Change Status ");

        changeStatusButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        changeStatusButton.setForeground(Color.WHITE);
        // backButton.setPreferredSize(new Dimension(8, 3));
        changeStatusButton.setBackground(new Color(101, 152, 253));
        changeStatusButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Customer customer=null;
                try {
                customer = CustomerController.searchCustomer(OrderIDTextField.getText());
                } catch (IOException ex) {
                    //
                }

                int statusNumber =customer.getStatus().equals("PROPROCESSING") ? 0 : customer.getStatus().equals("DELIVERING") ? 1 : 2;

                if (statusNumber == 0) {
                    Object[] options = {"Delivering", "Delivered",};
                    int n = JOptionPane.showOptionDialog(null,
                            "Please select the status ",
                            "Status",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.DEFAULT_OPTION,
                            null,
                            options,
                            options[1]);

                    System.out.println(n);


                    JFrame imperial = new JFrame("Imperial");
                    imperial.setBounds(0, 0, 320, 240);

                    if (n == 0) {
                        try {
                            CustomerController.changeStatus(OrderIDTextField.getText(),1);
                        } catch (IOException ex) {
                            //
                        }
                        JOptionPane.showMessageDialog(ChangeOrderstatusClassFrame, "Order Status changed");


                    } else if (n == 1) {
                        try {
                            CustomerController.changeStatus(OrderIDTextField.getText(),2);
                        } catch (IOException ex) {
                            //
                        }
                        JOptionPane.showMessageDialog(ChangeOrderstatusClassFrame, "Order Status changed");


                    }

                } else if (statusNumber == 1) {
                    Object[] options = {"Delivered", "Cancel"};
                    int n = JOptionPane.showOptionDialog(null,
                            "Please select the status ",
                            "Status",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.DEFAULT_OPTION,
                            null,
                            options,
                            options[1]);

                    System.out.println(n);


                    JFrame imperial = new JFrame("Imperial");
                    imperial.setBounds(0, 0, 320, 240);

                    if (n == 0) {
                        try {
                            CustomerController.changeStatus(OrderIDTextField.getText(),2);
                        } catch (IOException ex) {
                            //
                        }
                        JOptionPane.showMessageDialog(ChangeOrderstatusClassFrame, "Order Status changed");



                        //JOptionPane.showMessageDialog(DeleteClassFrame, "Order Deleted");

                    } else {
                        ChangeOrderstatusClassFrame.dispose();
                        new changeOrderstatusForm();
                    }
                } else {
                    JOptionPane.showMessageDialog(ChangeOrderstatusClassFrame, "Order Status Delivered");
                    ChangeOrderstatusClassFrame.dispose();
                    new changeOrderstatusForm();
                }


            }

        });

        changeStatusButton.setBounds(320, 360, 200, 40);
        ChangeOrderstatusClassFrame.add(changeStatusButton);


        ChangeOrderstatusClassFrame.setVisible(true);


    }

}
