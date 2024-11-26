import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


class placeOrderForm {
    //////////////////////AWT WINDOW//////////////////////
    JFrame placeOrderFrame;
    //////////////////////AWT COMPONENT//////////////////////
    JLabel OrderIdLabel, OrderIdLabelValue, CustomerIdLabel, SizeLabel, QTYLabel, AmountLabel, AmountValueLabel, SizeListLabel;
    JPanel BackButtonpanel, IdPanelWest, CenterTextPanel, EastPanel, placeOrderButtonPanel;
    JButton backButton, placeButton, checkAmountButton;
    JTextField CustomerIdTextField, SizeTextField, QTYTextField;

    //////////////////////VARIABLES////////////////////////////
    Customer customer;
    Calculation calculation = new Calculation();
    double amount;
    //String tempOrderID = calculation.generateId();
    int tempOrderID;

    public placeOrderForm() {
        //////////////////PLACE ORDER FRAME/////////////////////////////////////////
        placeOrderFrame = new JFrame();
        placeOrderFrame.setTitle("Place Order");
        placeOrderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        placeOrderFrame.setSize(500, 400);
        placeOrderFrame.setLocationRelativeTo(null);
        placeOrderFrame.setResizable(false);

        try {
            tempOrderID=CustomerController.generateCustomerId();

        } catch (IOException ex) {

        }

        //////////////////BACK BUTTON///////////////////////////////////
        BackButtonpanel = new JPanel();
        BackButtonpanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(80, 30));
        backButton.setBackground(new Color(255, 102, 102));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeOrderFrame.dispose();
                new FashionShopMainForm();

            }
        });
        BackButtonpanel.add(backButton);
        placeOrderFrame.add(BackButtonpanel, BorderLayout.NORTH);

        /////////////////LEBEL-WEST (ORDER,CUSTOMER,SIZE,QTY,AMOUNT)////////////////////////
        IdPanelWest = new JPanel();
        IdPanelWest.setLayout(new GridLayout(5, 1, 0, 40));
        IdPanelWest.setBorder(new EmptyBorder(5, 30, 5, 20));

        OrderIdLabel = new JLabel("Order ID :");
        OrderIdLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        CustomerIdLabel = new JLabel("Customer ID : ");
        CustomerIdLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        SizeLabel = new JLabel("Size : ");
        SizeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        QTYLabel = new JLabel("Qty : ");
        QTYLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        AmountLabel = new JLabel("Amount : ");
        AmountLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

        IdPanelWest.add(OrderIdLabel);
        IdPanelWest.add(CustomerIdLabel);
        IdPanelWest.add(SizeLabel);
        IdPanelWest.add(QTYLabel);
        IdPanelWest.add(AmountLabel);

        placeOrderFrame.add(IdPanelWest, BorderLayout.WEST);
        //////////////////TEXT FIELDS-CENTER/////////////////////////
        CenterTextPanel = new JPanel();
        CenterTextPanel.setLayout(new GridLayout(5, 1, 0, 25));
        CenterTextPanel.setBorder(new EmptyBorder(0, 5, 0, 5));

        OrderIdLabelValue = new JLabel(String.format("ODR#%05d", tempOrderID==0? ++tempOrderID:tempOrderID));
        OrderIdLabelValue.setFont(new Font("Tahoma", Font.BOLD, 16));

        CustomerIdTextField = new JTextField(5);
        SizeTextField = new JTextField(5);
        AmountValueLabel = new JLabel(String.valueOf(amount));
        QTYTextField = new JTextField(5);

        CenterTextPanel.add(OrderIdLabelValue);
        CenterTextPanel.add(CustomerIdTextField);
        CenterTextPanel.add(SizeTextField);
        CenterTextPanel.add(QTYTextField);

        placeOrderFrame.add(CenterTextPanel, BorderLayout.CENTER);
        ///////////////////////////EAST PANEL//////////////////////////////////
        EastPanel = new JPanel();
        EastPanel.setLayout(new GridLayout(1, 1));
        EastPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        SizeListLabel = new JLabel("(XS/S/M/L/XL/XXL)");
        EastPanel.add(SizeListLabel);

        placeOrderFrame.add(EastPanel, BorderLayout.EAST);

        placeOrderButtonPanel = new JPanel();
        placeOrderButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        /////////////////////////////GET AMOUNT BUTTON//////////////////////
        checkAmountButton = new JButton("Get Amount");
        checkAmountButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        checkAmountButton.setForeground(Color.WHITE);
        checkAmountButton.setPreferredSize(new Dimension(160, 30));
        checkAmountButton.setBackground(new Color(255, 102, 102));
        checkAmountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeOrderValidation();
            }
        });
        //////////////////////GET PLACE BUTTON///////////////////////
        placeButton = new JButton();
        placeButton.setText("Place");
        placeButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        placeButton.setForeground(Color.WHITE);
        placeButton.setPreferredSize(new Dimension(80, 30));
        placeButton.setBackground(new Color(0, 152, 152));
        placeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boolean istrue = placeOrderValidation();
                if (!istrue) {
                    return;
                }

                String id = String.format("ODR#%05d", tempOrderID);
                String phoneNumber = CustomerIdTextField.getText();
                String size = SizeTextField.getText();
                int qty = Integer.parseInt(QTYTextField.getText());
                double amount = calculation.getAmount(size, qty);
                int status = (0);

                Customer c1 = new Customer(id, phoneNumber, size, qty, amount, status);
                try {
                    boolean isAdded = CustomerController.addCustomer(c1);
                    if (isAdded) {

                        JOptionPane.showMessageDialog(placeOrderFrame, "Order Placed");
                    }

                } catch (IOException ex) {

                }

                placeOrderFrame.dispose();
                new placeOrderForm();
            }
        });
        placeOrderButtonPanel.add(checkAmountButton);
        placeOrderButtonPanel.add(placeButton);
        placeOrderFrame.add(placeOrderButtonPanel, BorderLayout.SOUTH);
        placeOrderFrame.setVisible(true);

    }


    ///////////////////////////PLACE ORDER VALIDATION//////////////////////////////
    public boolean placeOrderValidation() {
        ///////////////////SET PHONE NUMBER , SIZE AND QTY/////////////////////////////
        String PhoneNumber = CustomerIdTextField.getText();
        String Size = SizeTextField.getText();
        int Qty = Integer.parseInt(QTYTextField.getText());
        /////////////////CHECK IS CORRECT VALUES////////////////////////////////////
        boolean isTruePhoneNumber = calculation.validatePhoneNumber(PhoneNumber);
        boolean isTrueSize = calculation.validateSize(Size);
        boolean isTureQTY = calculation.validateQty(Qty);

        if (!(isTruePhoneNumber && isTrueSize && isTureQTY)) {
            String tempmsg = "";
            if (isTruePhoneNumber == false) {
                tempmsg = "Phone Number";
            }
            if (isTrueSize == false) {
                tempmsg = "Size";
            }
            if (isTureQTY == false) {
                tempmsg = "Quantity";
            }

            JOptionPane.showMessageDialog(placeOrderFrame, "Invalid " + tempmsg);
            placeOrderFrame.dispose();

            new placeOrderForm();
            return false;
        }
        //////////////////////////GET AMOUNT//////////////////////////////////////////////////
        amount = calculation.getAmount(Size, Qty);
        AmountValueLabel.setText(String.valueOf(amount));
        CenterTextPanel.add(AmountValueLabel);
        placeOrderFrame.add(CenterTextPanel, BorderLayout.CENTER);
        placeOrderFrame.setVisible(true);
        return true;

    }


}


