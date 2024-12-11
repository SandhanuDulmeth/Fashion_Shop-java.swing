import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ReportForm {
    JFrame ViewReportsFrame;
    JButton backButton;
    JButton ViewCustomers, BestInCustomers, AllCustomers, CategorizedByQTY, CategorizedByAmount, OrdersByAmount, AllOrders;

    Calculation calculation = new Calculation();

    public ReportForm() {
        ViewReportsFrame = new JFrame();
        ViewReportsFrame.setTitle("View Reports");
        ViewReportsFrame.setSize(620, 420);
        ViewReportsFrame.setLocationRelativeTo(null);
        ViewReportsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ViewReportsFrame.setLayout(null);
        ViewReportsFrame.setResizable(false);

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(80, 30));
        backButton.setBackground(new Color(255, 102, 102));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewReportsFrame.dispose();
              //  new MainPageclass();
                new FashionShopMainForm();

            }
        });
        backButton.setBounds(5, 5, 100, 40);
        ViewReportsFrame.add(backButton);

        ViewCustomers = new JButton("View Customers");
        ViewCustomers.setFont(new Font("Tahoma", Font.BOLD, 14));
        ViewCustomers.setBounds(20, 90, 170, 30);
        ViewCustomers.setBackground(new Color(0, 202, 51));
        ViewCustomers.setForeground(Color.WHITE);
        ViewCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewReportsFrame.dispose();
              //  new ViewCustomerclass(); kkkkkkkkkkkkkkkkkkkk
                new ViewCustomerclass();
            }
        });

        ViewReportsFrame.add(ViewCustomers);

        BestInCustomers = new JButton("Best In Customers");
        BestInCustomers.setFont(new Font("Tahoma", Font.BOLD, 14));
        BestInCustomers.setBackground(new Color(0, 202, 51));
        BestInCustomers.setForeground(Color.WHITE);
        BestInCustomers.setBounds(20, 140, 170, 30);
        BestInCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewReportsFrame.dispose();
              //  new BestInCustomersClass();kkkkkkkkkkkkkkkkkkkkkkk
                new BestInCustomersClass();


            }
        });

        
        ViewReportsFrame.add(BestInCustomers);


        AllCustomers = new JButton("All Customers");
        AllCustomers.setFont(new Font("Tahoma", Font.BOLD, 14));
        AllCustomers.setBackground(new Color(0, 202, 51));
        AllCustomers.setForeground(Color.WHITE);
        AllCustomers.setBounds(20, 190, 170, 30);
        AllCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewReportsFrame.dispose();
              //  new AllCustomerReportsclass();kkkkkkkkkkkkkkkkkkkkkk
                new AllCustomerReportsclass();
            }
        });
        ViewReportsFrame.add(AllCustomers);

        CategorizedByQTY = new JButton("Categorized By Qty");
        CategorizedByQTY.setFont(new Font("Tahoma", Font.BOLD, 14));
        CategorizedByQTY.setBackground(new Color(0, 51, 152));
        CategorizedByQTY.setForeground(Color.WHITE);
        CategorizedByQTY.setBounds(215, 120, 170, 30);
        CategorizedByQTY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewReportsFrame.dispose();
                new CategorizedBYQTYClass();
            }
        });
        ViewReportsFrame.add(CategorizedByQTY);

        CategorizedByAmount = new JButton("Categorized By Amount");
        CategorizedByAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
        CategorizedByAmount.setBackground(new Color(0, 51, 152));
        CategorizedByAmount.setForeground(Color.WHITE);
        CategorizedByAmount.setBounds(200, 170, 200, 30);
        CategorizedByAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewReportsFrame.dispose();
                  new CategorizedByAmountClass();          }
        });
        ViewReportsFrame.add(CategorizedByAmount);

        OrdersByAmount = new JButton("Orders By Amount");
        OrdersByAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
        OrdersByAmount.setBackground(new Color(101, 101, 101));
        OrdersByAmount.setForeground(Color.WHITE);
        OrdersByAmount.setBounds(410, 120, 170, 30);
        OrdersByAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewReportsFrame.dispose();
                new viewReportOrderByAmountClass();
            }
        });
        ViewReportsFrame.add(OrdersByAmount);

        AllOrders = new JButton("All Orders");
        AllOrders.setFont(new Font("Tahoma", Font.BOLD, 14));
        AllOrders.setBackground(new Color(101, 101, 101));
        AllOrders.setForeground(Color.WHITE);
        AllOrders.setBounds(410, 170, 170, 30);
        AllOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewReportsFrame.dispose();
                new AllOrdersClass();
            }
        });
        ViewReportsFrame.add(AllOrders);


        ViewReportsFrame.setVisible(true);

    }


///////////////////////////VIEW CUSTOMERS//////////////////////////////////

    class ViewCustomerclass {
        JFrame ViewCustomerclassFrame;
        JButton backButton;
        private JTable tblCustomer;
        DefaultTableModel dtm;
        Calculation calculation = new Calculation();

        ViewCustomerclass() {
            ViewCustomerclassFrame = new JFrame();
            ViewCustomerclassFrame.setTitle("View Customer");
            ViewCustomerclassFrame.setSize(620, 420);
            ViewCustomerclassFrame.setLocationRelativeTo(null);
            ViewCustomerclassFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ViewCustomerclassFrame.setLayout(null);
            ViewCustomerclassFrame.setResizable(false);


            backButton = new JButton();
            backButton.setText("Back");
            backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
            backButton.setForeground(Color.WHITE);
            backButton.setPreferredSize(new Dimension(80, 30));
            backButton.setBackground(new Color(255, 102, 102));
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ViewCustomerclassFrame.dispose();
                    new ReportForm();

                }
            });
            backButton.setBounds(5, 5, 100, 40);
            ViewCustomerclassFrame.add(backButton);


            String[][] BestInCustomersReportArrya = calculation.viewCustomer();
            String[] columnNames = {"Customer ID", " QTY ", " Amount "};
            dtm = new DefaultTableModel(columnNames, 0);
            tblCustomer = new JTable(dtm);
            JScrollPane tablePane = new JScrollPane(tblCustomer);
            tablePane.setBounds(80, 110, 400, 120);
            ViewCustomerclassFrame.add(tablePane);
            dtm.setRowCount(0);

            for (int i = 0; i < BestInCustomersReportArrya.length; i++) {
                int ALLQTY = 0;
                for (int j = 1; j < BestInCustomersReportArrya[i].length - 1; j++) {
                    ALLQTY += Integer.parseInt(BestInCustomersReportArrya[i][j]);
                }
                Object[] rowData = {BestInCustomersReportArrya[i][0], ALLQTY, BestInCustomersReportArrya[i][7]};

                dtm.addRow(rowData);


            }

            ViewCustomerclassFrame.setVisible(true);

        }

    }

    ////////////////////////BEST IN CUSTOMER CLASS////////////////////////////

    class BestInCustomersClass {
        JFrame BestInCustomersframe;
        private JTable tblCustomer;
        DefaultTableModel dtm;
        Calculation calculation = new Calculation();
        JButton backButton;

        BestInCustomersClass() {


            BestInCustomersframe = new JFrame();
            BestInCustomersframe.setTitle("Best in Customers");
            BestInCustomersframe.setSize(620, 420);
            BestInCustomersframe.setLocationRelativeTo(null);
            BestInCustomersframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            BestInCustomersframe.setLayout(null);
            BestInCustomersframe.setResizable(false);


            backButton = new JButton();
            backButton.setText("Back");
            backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
            backButton.setForeground(Color.WHITE);
            backButton.setPreferredSize(new Dimension(80, 30));
            backButton.setBackground(new Color(255, 102, 102));
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    BestInCustomersframe.dispose();
                    new ReportForm();

                }
            });
            backButton.setBounds(5, 5, 100, 40);
            BestInCustomersframe.add(backButton);


            String[][] BestInCustomersReportArrya = calculation.bestInCustomer();
            String[] columnNames = {"Customer ID", " QTY ", " Amount "};
            dtm = new DefaultTableModel(columnNames, 0);
            tblCustomer = new JTable(dtm);
            JScrollPane tablePane = new JScrollPane(tblCustomer);
            tablePane.setBounds(80, 110, 400, 120);
            BestInCustomersframe.add(tablePane);
            dtm.setRowCount(0);

            for (int i = 0; i < BestInCustomersReportArrya.length; i++) {
                int ALLQTY = 0;
                for (int j = 1; j < BestInCustomersReportArrya[i].length - 1; j++) {
                    ALLQTY += Integer.parseInt(BestInCustomersReportArrya[i][j]);
                }
                Object[] rowData = {BestInCustomersReportArrya[i][0], ALLQTY, BestInCustomersReportArrya[i][7]};

                //System.out.printf("\t| %-13s | %-8d | %-15s |\n", BestInCustomersReportArrya[i][0], ALLQTY, BestInCustomersReportArrya[i][7]);
                dtm.addRow(rowData);


            }


            BestInCustomersframe.setVisible(true);


        }


    }

////////////////////////VIEW REPORTS ALL CUSTOMERS////////////////////////

    class AllCustomerReportsclass {
        JFrame ViewALLCustomerclassFrame;
        JButton backButton;
        private JTable tblCustomer;
        DefaultTableModel dtm;
        Calculation calculation = new Calculation();

        AllCustomerReportsclass() {
            ViewALLCustomerclassFrame = new JFrame();
            ViewALLCustomerclassFrame.setTitle("All Customer Reports");
            ViewALLCustomerclassFrame.setSize(650, 420);
            ViewALLCustomerclassFrame.setLocationRelativeTo(null);
            ViewALLCustomerclassFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ViewALLCustomerclassFrame.setLayout(null);

            backButton = new JButton();
            backButton.setText("Back");
            backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
            backButton.setForeground(Color.WHITE);
            backButton.setPreferredSize(new Dimension(80, 30));
            backButton.setBackground(new Color(255, 102, 102));
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ViewALLCustomerclassFrame.dispose();
                    new ReportForm();
                }
            });
            backButton.setBounds(5, 5, 100, 40);
            ViewALLCustomerclassFrame.add(backButton);
            /////////////////////////////////////
            String[][] ALLInCustomersReportArrya = calculation.viewAllCustomerReports();
            String[] columnNames = {"Customer ID", " XS ", " S ", " M ", " L ", " XL ", " XXL ", " Amount "};
            dtm = new DefaultTableModel(columnNames, 0);
            tblCustomer = new JTable(dtm);
            JScrollPane tablePane = new JScrollPane(tblCustomer);
            tablePane.setBounds(20, 110, 610, 120);
            ViewALLCustomerclassFrame.add(tablePane);
            dtm.setRowCount(0);
/////////////////////////////
            for (int i = 0; i < ALLInCustomersReportArrya.length; i++) {
                //Object[] rowData = {ALLInCustomersReportArrya[i][0], ALLQTY, ALLInCustomersReportArrya[i][7]};
                Object[] rowData = {ALLInCustomersReportArrya[i][0], ALLInCustomersReportArrya[i][1], ALLInCustomersReportArrya[i][2], ALLInCustomersReportArrya[i][3], ALLInCustomersReportArrya[i][4], ALLInCustomersReportArrya[i][5], ALLInCustomersReportArrya[i][6], ALLInCustomersReportArrya[i][7]};
                // System.out.printf("\t| %-12s ", ALLInCustomersReportArrya[i][0]);

                dtm.addRow(rowData);
            }




            ViewALLCustomerclassFrame.setVisible(true);
        }
    }

/////////////////////////DELETE CLASS////////////////////////////////////

    class CategorizedBYQTYClass {
        JFrame CategorizedBYQTYClassFrame;
        JButton backButton;
        private JTable tblCustomer;
        DefaultTableModel dtm;
        Calculation calculation = new Calculation();

        CategorizedBYQTYClass() {
            CategorizedBYQTYClassFrame = new JFrame();
            CategorizedBYQTYClassFrame.setTitle("Categoried by QTY");
            CategorizedBYQTYClassFrame.setSize(620, 420);
            CategorizedBYQTYClassFrame.setLocationRelativeTo(null);
            CategorizedBYQTYClassFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CategorizedBYQTYClassFrame.setLayout(null);
            CategorizedBYQTYClassFrame.setResizable(false);


            backButton = new JButton();
            backButton.setText("Back");
            backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
            backButton.setForeground(Color.WHITE);
            backButton.setPreferredSize(new Dimension(80, 30));
            backButton.setBackground(new Color(255, 102, 102));
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CategorizedBYQTYClassFrame.dispose();
                    new ReportForm();

                }
            });
            backButton.setBounds(5, 5, 100, 40);
            CategorizedBYQTYClassFrame.add(backButton);


            String[][] SortedByQTY2DArray = calculation.sortedByQty();
            String[] columnNames = {"Size", " QTY ", " Amount "};
            dtm = new DefaultTableModel(columnNames, 0);
            tblCustomer = new JTable(dtm);
            JScrollPane tablePane = new JScrollPane(tblCustomer);
            tablePane.setBounds(80, 110, 400, 120);
            CategorizedBYQTYClassFrame.add(tablePane);
            dtm.setRowCount(0);

            for (int i = 0; i < 6; i++) {
                Object[] rowData = {SortedByQTY2DArray[i][0], SortedByQTY2DArray[i][1], SortedByQTY2DArray[i][2]};
                dtm.addRow(rowData);
            }

            CategorizedBYQTYClassFrame.setVisible(true);

        }
    }

//////////////////////CATEGORIZED BY AMOUNT CLASS////////////////////////

    class CategorizedByAmountClass {
        JFrame CategorizedByAmountClassFrame;
        JButton backButton;
        private JTable tblCustomer;
        DefaultTableModel dtm;
        Calculation calculation = new Calculation();

        CategorizedByAmountClass() {
            CategorizedByAmountClassFrame = new JFrame();
            CategorizedByAmountClassFrame.setTitle("Categorized By AmountClass");
            CategorizedByAmountClassFrame.setSize(620, 420);
            CategorizedByAmountClassFrame.setLocationRelativeTo(null);
            CategorizedByAmountClassFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CategorizedByAmountClassFrame.setLayout(null);
            CategorizedByAmountClassFrame.setResizable(false);


            backButton = new JButton();
            backButton.setText("Back");
            backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
            backButton.setForeground(Color.WHITE);
            backButton.setPreferredSize(new Dimension(80, 30));
            backButton.setBackground(new Color(255, 102, 102));
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CategorizedByAmountClassFrame.dispose();
                    new ReportForm();

                }
            });
            backButton.setBounds(5, 5, 100, 40);
            CategorizedByAmountClassFrame.add(backButton);


            String[][] CategorizedByAmountSortedByQTY2DArray = calculation.sortedByAmount();
            String[] columnNames = {"Size", " QTY ", " Amount "};
            dtm = new DefaultTableModel(columnNames, 0);
            tblCustomer = new JTable(dtm);
            JScrollPane tablePane = new JScrollPane(tblCustomer);
            tablePane.setBounds(80, 110, 400, 120);
            CategorizedByAmountClassFrame.add(tablePane);
            dtm.setRowCount(0);

            for (int i = 0; i < 6; i++) {
                Object[] rowData = {CategorizedByAmountSortedByQTY2DArray[i][0], CategorizedByAmountSortedByQTY2DArray[i][1], CategorizedByAmountSortedByQTY2DArray[i][2]};
                dtm.addRow(rowData);
            }

            CategorizedByAmountClassFrame.setVisible(true);

        }
    }

/////////////////// ALL ORDERS CLASS/////////////////////////////////////

    class AllOrdersClass {
        JFrame AllOrdersClassFrame;
        JButton backButton;
        private JTable tblCustomer;
        DefaultTableModel dtm;
        Calculation calculation = new Calculation();

        AllOrdersClass() {
            AllOrdersClassFrame = new JFrame();
            AllOrdersClassFrame.setTitle("ALL Orders");
            AllOrdersClassFrame.setSize(620, 420);
            AllOrdersClassFrame.setLocationRelativeTo(null);
            AllOrdersClassFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            AllOrdersClassFrame.setLayout(null);
            AllOrdersClassFrame.setResizable(false);


            backButton = new JButton();
            backButton.setText("Back");
            backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
            backButton.setForeground(Color.WHITE);
            backButton.setPreferredSize(new Dimension(80, 30));
            backButton.setBackground(new Color(255, 102, 102));
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    AllOrdersClassFrame.dispose();
                    new ReportForm();

                }
            });
            backButton.setBounds(5, 5, 100, 40);
            AllOrdersClassFrame.add(backButton);


            String[][] ALLOrderArray = calculation.ordersSortByOrderId();
            String[] columnNames = {"Order ID", " Customer ID ", " Size ", " QTY ", " Amount ", " Status "};
            dtm = new DefaultTableModel(columnNames, 0);
            tblCustomer = new JTable(dtm);
            JScrollPane tablePane = new JScrollPane(tblCustomer);
            tablePane.setBounds(10, 110, 590, 120);
            AllOrdersClassFrame.add(tablePane);
            dtm.setRowCount(0);
            List list=new List();
            Customer[] customerArray=list.loadFromFile();

            for (int i = 0; i <customerArray.length; i++) {

                int k = Integer.parseInt(ALLOrderArray[i][0]);
                String OrderID = "";
                if (k < 10) {
                    OrderID = "ODR#0000" + k;

                } else if (k >= 10 && k < 100) {
                    OrderID = "ODR#000" + k;
                    ;
                } else if (k >= 100 && k < 1000) {
                    OrderID = "ODR#00" + k;

                } else if (k >= 1000 && k < 10000) {
                    OrderID = "ODR#0" + k;

                } else if (k >= 10000) {
                    OrderID = "ODR#" + k;

                }

                //System.out.printf("\t| %-10s | %-12s | %-5s | %-3s | %-8s | %-11s |\n", OrderID, ALLOrderArray[i][1], ALLOrderArray[i][2], ALLOrderArray[i][3], ALLOrderArray[i][4], ALLOrderArray[i][5]);
                Object[] rowData = {OrderID, ALLOrderArray[i][1], ALLOrderArray[i][2], ALLOrderArray[i][3], ALLOrderArray[i][4], ALLOrderArray[i][5]};
               // rowData = {ALLOrderArray[i][0], ALLOrderArray[i][1], ALLOrderArray[i][2], ALLOrderArray[i][3], ALLOrderArray[i][4], ALLOrderArray[i][5]};
                dtm.addRow(rowData);
            }


            AllOrdersClassFrame.setVisible(true);

        }

    }

    class viewReportOrderByAmountClass {
        JFrame viewReportOrderByAmountClassFrame;
        JButton backButton;
        private JTable tblCustomer;
        DefaultTableModel dtm;
        Calculation calculation = new Calculation();

        viewReportOrderByAmountClass() {
            viewReportOrderByAmountClassFrame = new JFrame();
            viewReportOrderByAmountClassFrame.setTitle("Order By Amount");
            viewReportOrderByAmountClassFrame.setSize(620, 420);
            viewReportOrderByAmountClassFrame.setLocationRelativeTo(null);
            viewReportOrderByAmountClassFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            viewReportOrderByAmountClassFrame.setLayout(null);
            viewReportOrderByAmountClassFrame.setResizable(false);


            backButton = new JButton();
            backButton.setText("Back");
            backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
            backButton.setForeground(Color.WHITE);
            backButton.setPreferredSize(new Dimension(80, 30));
            backButton.setBackground(new Color(255, 102, 102));
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    viewReportOrderByAmountClassFrame.dispose();
                    new ReportForm();
                }
            });
            backButton.setBounds(5, 5, 100, 40);
            viewReportOrderByAmountClassFrame.add(backButton);


            String[][] ALLOrderArrayByAmount = calculation.ordersSortByAmount();
            String[] columnNames = {"Order ID", " Customer ID ", " Size ", " QTY ", " Amount ", " Status "};
            dtm = new DefaultTableModel(columnNames, 0);
            tblCustomer = new JTable(dtm);
            JScrollPane tablePane = new JScrollPane(tblCustomer);
            tablePane.setBounds(10, 110, 590, 120);
            viewReportOrderByAmountClassFrame.add(tablePane);
            dtm.setRowCount(0);
            List list=new List();
            Customer[] customerArray=list.toArray();
            for (int i = 0; i < customerArray.length; i++) {

                int k = Integer.parseInt(ALLOrderArrayByAmount[i][0]);
                String OrderID = "";
                if (k < 10) {
                    OrderID = "ODR#0000" + k;

                } else if (k >= 10 && k < 100) {
                    OrderID = "ODR#000" + k;
                    ;
                } else if (k >= 100 && k < 1000) {
                    OrderID = "ODR#00" + k;

                } else if (k >= 1000 && k < 10000) {
                    OrderID = "ODR#0" + k;

                } else if (k >= 10000) {
                    OrderID = "ODR#" + k;

                }

                //System.out.printf("\t| %-10s | %-12s | %-5s | %-3s | %-8s | %-11s |\n", OrderID, ALLOrderArray[i][1], ALLOrderArray[i][2], ALLOrderArray[i][3], ALLOrderArray[i][4], ALLOrderArray[i][5]);
                Object[] rowData = {OrderID, ALLOrderArrayByAmount[i][1], ALLOrderArrayByAmount[i][2], ALLOrderArrayByAmount[i][3], ALLOrderArrayByAmount[i][4], ALLOrderArrayByAmount[i][5]};
                dtm.addRow(rowData);
            }


            viewReportOrderByAmountClassFrame.setVisible(true);

        }

    }



}

