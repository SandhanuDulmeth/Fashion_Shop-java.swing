import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FashionShopMainForm {
    //////////////////////AWT WINDOW//////////////////////
    private JFrame MainPageFrame;

    //////////////////////FORMS///////////////////////////
    private placeOrderForm placeOrderForm;

    //////////////////////AWT COMPONENT//////////////////////

    private JPanel panelMainImage, panelButtons;
    private JButton search, status, reports, delete, placeOrder;
    private JLabel fashionShopLabelTop, fashionShopLabelBottom;

    public FashionShopMainForm() {
        /////////////////////MAIN PAGE FRAME SET//////////////////////

        MainPageFrame = new JFrame();
        MainPageFrame.setTitle("Fashion Shop");
        MainPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPageFrame.setSize(500, 550);
        MainPageFrame.setLocationRelativeTo(null);
        MainPageFrame.setResizable(false);

        /////////////////MAIN PAGE LABEL TOP///////////////////////////

        fashionShopLabelTop = new JLabel("Fashion Shop", JLabel.CENTER);
        fashionShopLabelTop.setFont(new Font("Serif", Font.BOLD, 35));
        fashionShopLabelTop.setForeground(Color.WHITE);
        fashionShopLabelTop.setBackground(new Color(51, 102, 255));
        fashionShopLabelTop.setOpaque(true);
        fashionShopLabelTop.setBorder(new EmptyBorder(8, 5, 8, 5));

        MainPageFrame.add(fashionShopLabelTop, BorderLayout.NORTH);

        /////////////////////MAIN PAGE LABEL BOTTOM////////////////////////////

        fashionShopLabelBottom = new JLabel();
        fashionShopLabelBottom.setBackground(new Color(36, 54, 66));
        fashionShopLabelBottom.setOpaque(true);
        fashionShopLabelBottom.setBorder(new EmptyBorder(8, 5, 8, 5));

        MainPageFrame.add(fashionShopLabelBottom, BorderLayout.SOUTH);

        ////////////////////MAIN PAGE BUTTONS//////////////////////////////

        panelButtons = new JPanel();
        panelButtons.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 20));

        ////////////////////SEARCH BUTTON//////////////////////////

        search = new JButton("Search");
        search.setFont(new Font("Tahoma", Font.BOLD, 16));
        search.setPreferredSize(new Dimension(150, 40));
        search.setBackground(Color.CYAN);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Search Customer", "Search Order", "Cancel"};
                int n = JOptionPane.showOptionDialog(null,
                        "Please select the option",
                        "Search Option",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.DEFAULT_OPTION,
                        null,
                        options,
                        options[1]);

                System.out.println(n);


                JFrame imperial = new JFrame("Imperial");
                imperial.setBounds(0, 0, 320, 240);

                if (n == 0) {
                    MainPageFrame.dispose();

                    new searchCustomerForm();
                } else if (n == 1) {
                    MainPageFrame.dispose();

                    new searchOrderForm();
                } else {
                    System.out.println("no option choosen");
                }
            }
        });

        ///////////////////STATUS BUTTON/////////////////////
        status = new JButton("Status");
        status.setFont(new Font("Tahoma", Font.BOLD, 16));
        status.setPreferredSize(new Dimension(150, 40));
        status.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainPageFrame.dispose();
                //new ChangeOrderstatusClass();
                new changeOrderstatusForm();
            }
        });
        status.setBackground(Color.CYAN);

        //////////////////REPORTS BUTTON////////////////////////////
        reports = new JButton("Reports");
        reports.setFont(new Font("Tahoma", Font.BOLD, 16));
        reports.setPreferredSize(new Dimension(150, 40));
        reports.setBackground(Color.CYAN);
        reports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainPageFrame.dispose();
                //new viewReportsClass();
                new ReportForm();

            }
        });

        //////////////////DELETE BUTTON////////////////////////////
        delete = new JButton("Delete");
        delete.setFont(new Font("Tahoma", Font.BOLD, 16));
        delete.setPreferredSize(new Dimension(150, 40));
        delete.setBackground(Color.CYAN);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainPageFrame.dispose();
                //new DeleteClass();
                new DeleteForm();


            }
        });

        //////////////////PLACE ORDER BUTTON///////////////////////////
        placeOrder = new JButton("Place Order");
        placeOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
        placeOrder.setPreferredSize(new Dimension(150, 40));
        placeOrder.setBackground(Color.CYAN);
        placeOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainPageFrame.dispose();
                new placeOrderForm();

            }
        });

        //////////////////ADDING BUTTONS TO BUTTON PANEL//////////////////////
        panelButtons.add(search);
        panelButtons.add(status);
        panelButtons.add(reports);
        panelButtons.add(delete);
        panelButtons.add(placeOrder);
        panelButtons.setBackground(Color.WHITE);
        panelButtons.setLayout(new GridLayout(6, 1, 30, 30));

        MainPageFrame.add(panelButtons, BorderLayout.WEST);

        ///////////////////IMPORT A IMAGE(FASHION SHOP)/////////////////////
        ImageIcon imageIcon = new ImageIcon("D:/sandhanu/ICET/OOP/Assignment/CW2/fashion.jpg");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));

        ///////////////////ADDING THE IMAGE///////////////////////////////
        panelMainImage = new JPanel();
        panelMainImage.setBackground(Color.white);
        panelMainImage.setBorder(BorderFactory.createEmptyBorder(60, 5, 5, 5));
        panelMainImage.add(imageLabel, BorderLayout.EAST);

        MainPageFrame.add(panelMainImage, BorderLayout.CENTER);

        //////////////////FRAME VISIBLE//////////////////////////////
        MainPageFrame.setVisible(true);
    }

}





