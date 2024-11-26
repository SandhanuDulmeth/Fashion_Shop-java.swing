import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.table.*;


class searchCustomerForm {
    private JTable tblCustomer;
    JFrame searchCustomerClassFrame;
    JPanel BackButtonpanel, centerPanel, southPanel;
    JButton backButton, searchButton;
    JTextField CustomerIdTextField;
    JLabel CustomerIdLabel, TotalLabel, TotalAmountLabel;
    Customer customer;
    DefaultTableModel dtm;
    Calculation calculation = new Calculation();
    double totalAmount;

    public searchCustomerForm() {
        /////////////////SEARCH CUSTOMER FRAME////////////////////////
        searchCustomerClassFrame = new JFrame();
        // searchCustomerClassFrame.setLayout(new BorderLayout());
        searchCustomerClassFrame.setSize(600, 400);
        searchCustomerClassFrame.setLocationRelativeTo(null);
        searchCustomerClassFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchCustomerClassFrame.setTitle("Search Customer");
        searchCustomerClassFrame.setVisible(true);

        searchCustomerClassFrame.setLayout(null);
        searchCustomerClassFrame.setResizable(false);

        // BackButtonpanel = new JPanel();
//BackButtonpanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        // backButton.setPreferredSize(new Dimension(8, 3));
        backButton.setBackground(new Color(255, 102, 102));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchCustomerClassFrame.dispose();
                new FashionShopMainForm();

            }
        });
        backButton.setBounds(5, 5, 100, 40);
        searchCustomerClassFrame.add(backButton);
        // BackButtonpanel.add(backButton);
        // searchCustomerClassFrame.add(BackButtonpanel,BorderLayout.NORTH);


        // centerPanel = new JPanel();
        CustomerIdLabel = new JLabel("Enter Customer ID :    ");
        CustomerIdLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        CustomerIdLabel.setBounds(30, 70, 500, 20);
        searchCustomerClassFrame.add(CustomerIdLabel);

        // centerPanel.add(CustomerIdLabel);


        CustomerIdTextField = new JTextField(10);
        CustomerIdTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
        CustomerIdTextField.setBounds(200, 70, 200, 30);
        searchCustomerClassFrame.add(CustomerIdTextField);

        //centerPanel.add(CustomerIdTextField);


        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setLayout(new FlowLayout(FlowLayout.LEFT));
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        searchButton.setForeground(Color.WHITE);
        //searchButton.setPreferredSize(new Dimension(120, 30));
        searchButton.setBackground(new Color(0, 152, 152));
        searchButton.setBounds(430, 60, 100, 35);
        searchCustomerClassFrame.add(searchButton);

        JLabel lblTitle = new JLabel("View Customer Form");
        lblTitle.setFont(new Font("", 1, 30));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);


        searchButton.addActionListener(new ActionListener() {
            boolean isTurn = false;

            public void actionPerformed(ActionEvent e) {
                isTurn = calculation.validatePhoneNumber(CustomerIdTextField.getText());
                if (!isTurn) {
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number");
                    CustomerIdTextField.setText("");

                }
                try {

                    Customer[] customerArr = CustomerController.searchCustomer2(CustomerIdTextField.getText());
                    if (customerArr.length != 0) {
                        String[] tempSizeArray = new String[6];
                        int[] tempQtyArray = new int[6];
                        double[] tempAmountArray = new double[6];

                        tempSizeArray[0] = "XS";
                        tempSizeArray[1] = "S";
                        tempSizeArray[2] = "M";
                        tempSizeArray[3] = "L";
                        tempSizeArray[4] = "XL";
                        tempSizeArray[5] = "XXL";

                        for (int i = 0; i < customerArr.length; i++) {

                            if (customerArr[i].getSize().equals("XS")) {
                                tempQtyArray[0] += customerArr[i].getQty();
                                tempAmountArray[0] += customerArr[i].getAmount();
                            } else if (customerArr[i].getSize().equals("S")) {
                                tempQtyArray[1] += customerArr[i].getQty();
                                tempAmountArray[1] += customerArr[i].getAmount();
                            } else if (customerArr[i].getSize().equals("M")) {
                                tempQtyArray[2] += customerArr[i].getQty();
                                tempAmountArray[2] += customerArr[i].getAmount();
                            } else if (customerArr[i].getSize().equals("L")) {
                                tempQtyArray[3] += customerArr[i].getQty();
                                tempAmountArray[3] += customerArr[i].getAmount();
                            } else if (customerArr[i].getSize().equals("XL")) {
                                tempQtyArray[4] += customerArr[i].getQty();
                                tempAmountArray[4] += customerArr[i].getAmount();
                            } else if (customerArr[i].getSize().equals("XXL")) {
                                tempQtyArray[5] += customerArr[i].getQty();
                                tempAmountArray[5] += customerArr[i].getAmount();
                            }
                        }


                        totalAmount = 0;
                        for (int i = 0; i < 6; i++) {
                            totalAmount += tempAmountArray[i];
                        }
                        System.out.println(totalAmount);
                        String[] tempSizeSortingArray = new String[6];
                        int[] tempQtySortingArray = new int[6];
                        double[] tempAmountSortingArray = new double[6];

                        for (int i = 0; i < 6; i++) {
                            tempSizeSortingArray[i] = tempSizeArray[i];
                            tempQtySortingArray[i] = tempQtyArray[i];
                            tempAmountSortingArray[i] = tempAmountArray[i];
                        }

                        for (int j = 1; j < tempAmountArray.length; j++) {
                            for (int i = 0; i < tempAmountArray.length - j; i++) {
                                if (tempAmountSortingArray[i] < tempAmountSortingArray[i + 1]) {

                                    double tempAmount = tempAmountSortingArray[i];
                                    tempAmountSortingArray[i] = tempAmountSortingArray[i + 1];
                                    tempAmountSortingArray[i + 1] = tempAmount;

                                    String tempSize = tempSizeSortingArray[i];
                                    tempSizeSortingArray[i] = tempSizeSortingArray[i + 1];
                                    tempSizeSortingArray[i + 1] = tempSize;

                                    int tempQty = tempQtySortingArray[i];
                                    tempQtySortingArray[i] = tempQtySortingArray[i + 1];
                                    tempQtySortingArray[i + 1] = tempQty;
                                }
                            }
                        }


                        dtm.setRowCount(0);
                        for (int i = 0; i < 6; i++) {
                            Object[] rowData = {tempSizeSortingArray[i], tempQtySortingArray[i], tempAmountSortingArray[i]};
                            dtm.addRow(rowData);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found...");
                    }
                } catch (IOException ex) {
                    //
                }
            }
        });

        // centerPanel.add(searchButton);

        String[] columnNames = {"Size", "QTY", "Amount"};
        dtm = new DefaultTableModel(columnNames, 0);
        tblCustomer = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(tblCustomer);
        tablePane.setBounds(80, 110, 400, 120);
        searchCustomerClassFrame.add(tablePane);
        //searchCustomerClassFrame.add( tablePane,BorderLayout.EAST);

        TotalAmountLabel = new JLabel("Total : ");
        TotalAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        TotalAmountLabel.setBounds(40, 280, 100, 30);
        searchCustomerClassFrame.add(TotalAmountLabel);

        TotalLabel = new JLabel(String.valueOf(totalAmount));
        TotalLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        TotalLabel.setBounds(500, 280, 100, 30);
        searchCustomerClassFrame.add(TotalLabel);

        //searchCustomerClassFrame.add(centerPanel,FlowLayout.CENTER);

        searchCustomerClassFrame.setVisible(true);


    }

}

