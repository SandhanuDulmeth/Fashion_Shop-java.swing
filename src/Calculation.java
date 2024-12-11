public class Calculation {

    public static final double XS = 600;
    public static final double S = 800;
    public static final double M = 900;
    public static final double L = 1000;
    public static final double XL = 1100;
    public static final double XXL = 1200;


    // --------------- VALIDATE PHONE NUMBER ---------------
    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0') {
            return true;
        }
        return false;
    }


    // --------------- VALIDATE QTY ---------------
    public boolean validateQty(int qty) {
        if (qty > 0) {
            return true;
        }
        return false;
    }


    //---------------VALIDATE SIZE---------------
    public boolean validateSize(String size) {
        size = size.toUpperCase();
        if (size.equals("XS") || size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL") || size.equals("XXL")) {
            return true;
        }
        return false;

    }

    //--------------GET AMOUNT------------------
    public double getAmount(String size, int qty) {
        double amount = 0;
        switch (size.toUpperCase()) {
            case "XS":
                amount = XS * qty;
                break;
            case "S":
                amount = S * qty;
                break;
            case "M":
                amount = M * qty;
                break;
            case "L":
                amount = L * qty;
                break;
            case "XL":
                amount = XL * qty;
                break;
            case "XXL":
                amount = XXL * qty;
                break;

        }
        return amount;
    }


    ///////////////////////////////viewCustomer////////////////////////////////
    public String[][] viewCustomer() {

        String[][] ViewCustomersReportArrya = getCustomerReports2DArray();

        return ViewCustomersReportArrya;

    }



    //--------------REPORTS=>Customer Reports 2D array( BEST IN CUSTOMER,VIEW CUSTOMER,ALL CUSTOMER REPORT)----------------------
    public String[][] getCustomerReports2DArray() {
        List list=new List();
        int uniqueCount = 0;
        //Customer[] customerArray=list.toArray();
        Customer[] customerArray=list.loadFromFile();
        for (int i = 0; i < list.size(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (customerArray[i].getPhoneNumber().equals(customerArray[j].getPhoneNumber())) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueCount++;
            }
        }

        // temp=[{PhoneNumber},{XS},{S},{M},{L},{XL},{XXL},{Total}]
        String[][] temp = new String[uniqueCount][8];

        // input phoneNumbers & others "0"
        int index = 0;
        for (int i = 0; i < customerArray.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < index; j++) {
                if (temp[j][0].equals(customerArray[i].getPhoneNumber())) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[index][0] = customerArray[i].getPhoneNumber();
                for (int k = 1; k <= 7; k++) {
                    temp[index][k] = "0";
                }
                index++;
            }
        }

        for (int i = 0; i < customerArray.length; i++) {
            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j][0].equals(customerArray[i].getPhoneNumber())) {
                    // Update quantities
                    switch (customerArray[i].getSize()) {
                        case "XS":
                            temp[j][1] = String.valueOf(Integer.parseInt(temp[j][1]) + customerArray[i].getQty());
                            break;
                        case "S":
                            temp[j][2] = String.valueOf(Integer.parseInt(temp[j][2]) + customerArray[i].getQty());
                            break;
                        case "M":
                            temp[j][3] = String.valueOf(Integer.parseInt(temp[j][3]) + customerArray[i].getQty());
                            break;
                        case "L":
                            temp[j][4] = String.valueOf(Integer.parseInt(temp[j][4]) + customerArray[i].getQty());
                            break;
                        case "XL":
                            temp[j][5] = String.valueOf(Integer.parseInt(temp[j][5]) + customerArray[i].getQty());
                            break;
                        case "XXL":
                            temp[j][6] = String.valueOf(Integer.parseInt(temp[j][6]) + customerArray[i].getQty());
                            break;

                    }

                    // Add the total
                    temp[j][7] = String.valueOf(Double.parseDouble(temp[j][7]) + customerArray[i].getAmount());
                }
            }
        }

        return temp;
    }


    // ------------------- BEST IN CUSTOMER ------------------
    public String[][] bestInCustomer() {
        do {
            String[][] BestInCustomersReportArrya = selectionSortAscendingCustomerReport2D(getCustomerReports2DArray());
            // System.out.print("\n\n"+Arrays.deepToString(BestInCustomersReportArrya));

            return BestInCustomersReportArrya;


        } while (true);
    }

    //--------------REPORTS=>Customer Reports 2D array( BEST IN CUSTOMER,VIEW CUSTOMER,ALL CUSTOMER REPORT)----------------------
    public String[][] selectionSortAscendingCustomerReport2D(String[][] temp) {

        for (int i = 0; i < temp.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < temp.length; j++) {

                double currentTotal = Double.parseDouble(temp[j][7]);
                double minTotal = Double.parseDouble(temp[minIndex][7]);
                if (currentTotal > minTotal) {
                    minIndex = j;
                }
            }

            String[] tempRow = temp[i];
            temp[i] = temp[minIndex];
            temp[minIndex] = tempRow;
        }

        return temp;
    }

    //////////////////////////////viewAllCustomerReports////////////////////////////////
    public String[][] viewAllCustomerReports() {
        String[][] AllCustomerReportArrya = getCustomerReports2DArray();


        return AllCustomerReportArrya;
    }
    /////////////////////////////SORTED BY QTY//////////////////////////////////
    public String[][] sortedByQty() {
        String[][] SortedByQTY2DArray = selectionSortAsecendingItemReportQTY2D(getItemReports2DArray());

        return SortedByQTY2DArray;


    }
//----------------------ITEMREPORTS (BEST SELLING BY QTY AND AMOUNT)-------------------------------

    public String[][] getItemReports2DArray() {
        List list=new List();
        Customer[] customerArray=list.loadFromFile();
        // [{Size},{XS,S,M,L,XL,XXL-->QTY},{Amount}]
        String[][] ItemReportsDATA = new String[6][3];

        ItemReportsDATA[0][0] = "XS";
        ItemReportsDATA[1][0] = "S";
        ItemReportsDATA[2][0] = "M";
        ItemReportsDATA[3][0] = "L";
        ItemReportsDATA[4][0] = "XL";
        ItemReportsDATA[5][0] = "XXL";

        for (int i = 0; i < 6; i++) {
            ItemReportsDATA[i][1] = "0";
            ItemReportsDATA[i][2] = "0";
        }

        for (int i = 0; i < customerArray.length; i++) {

            switch (customerArray[i].getSize()) {
                case "XS":
                    ItemReportsDATA[0][1] = String.valueOf(Integer.parseInt(ItemReportsDATA[0][1]) + customerArray[i].getQty());
                    ItemReportsDATA[0][2] = String.valueOf(Double.parseDouble(ItemReportsDATA[0][2]) + customerArray[i].getAmount());
                    break;
                case "S":
                    ItemReportsDATA[1][1] = String.valueOf(Integer.parseInt(ItemReportsDATA[1][1]) + customerArray[i].getQty());
                    ItemReportsDATA[1][2] = String.valueOf(Double.parseDouble(ItemReportsDATA[1][2]) + customerArray[i].getAmount());
                    break;
                case "M":
                    ItemReportsDATA[2][1] = String.valueOf(Integer.parseInt(ItemReportsDATA[2][1]) + customerArray[i].getQty());
                    ItemReportsDATA[2][2] = String.valueOf(Double.parseDouble(ItemReportsDATA[2][2]) + customerArray[i].getAmount());
                    break;
                case "L":
                    ItemReportsDATA[3][1] = String.valueOf(Integer.parseInt(ItemReportsDATA[3][1]) + customerArray[i].getQty());
                    ItemReportsDATA[3][2] = String.valueOf(Double.parseDouble(ItemReportsDATA[3][2]) + customerArray[i].getAmount());
                    break;
                case "XL":
                    ItemReportsDATA[4][1] = String.valueOf(Integer.parseInt(ItemReportsDATA[4][1]) + customerArray[i].getQty());
                    ItemReportsDATA[4][2] = String.valueOf(Double.parseDouble(ItemReportsDATA[4][2]) + customerArray[i].getAmount());
                    break;
                case "XXL":
                    ItemReportsDATA[5][1] = String.valueOf(Integer.parseInt(ItemReportsDATA[5][1]) + customerArray[i].getQty());
                    ItemReportsDATA[5][2] = String.valueOf(Double.parseDouble(ItemReportsDATA[5][2]) + customerArray[i].getAmount());
                    break;
            }
        }

        return ItemReportsDATA;
    }

//----------------------ITEMREPORTS (BEST SELLING BY QTY AND AMOUNT)-------------------------------

    public String[][] selectionSortAsecendingItemReportQTY2D(String[][] temp) {

        for (int i = 0; i < temp.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < temp.length; j++) {

                double currentQTY = Integer.parseInt(temp[j][1]);
                double minQTY = Integer.parseInt(temp[minIndex][1]);
                if (currentQTY > minQTY) {
                    minIndex = j;
                }
            }

            String[] tempRow = temp[i];
            temp[i] = temp[minIndex];
            temp[minIndex] = tempRow;
        }

        return temp;

    }
    /////////////////////////////////////////SORTED BY AMOUNT  /////////////////////
    public String[][] sortedByAmount() {
        String[][] SortedByAmount2DArray = selectionSortAsecendingItemReportAmount2D(getItemReports2DArray());
        // System.out.print(Arrays.deepToString(SortedByAmount2DArray));
        return SortedByAmount2DArray;


    }

    ///////////////////////////////////////////selectionSortAsecendingItemReportAmount2D//////////////////////////////////////////////////
    public String[][] selectionSortAsecendingItemReportAmount2D(String[][] temp) {

        for (int i = 0; i < temp.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < temp.length; j++) {

                double currentAmount = Double.parseDouble(temp[j][2]);
                double minAmount = Double.parseDouble(temp[minIndex][2]);
                if (currentAmount > minAmount) {
                    minIndex = j;
                }
            }

            String[] tempRow = temp[i];
            temp[i] = temp[minIndex];
            temp[minIndex] = tempRow;
        }

        return temp;

    }
    ////////////////////////////////
    public String[][] selectionSortDescendingOrderReport2D(String[][] temp) {

        for (int i = 0; i < temp.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < temp.length; j++) {

                int currentID = Integer.parseInt(temp[j][0]);
                int minID = Integer.parseInt(temp[minIndex][0]);
                if (currentID > minID) {
                    minIndex = j;
                }
            }

            String[] tempRow = temp[i];
            temp[i] = temp[minIndex];
            temp[minIndex] = tempRow;
        }


        return temp;

    }

    /////////////////////////////////////////ORDERS SORT BY ORDER ID///////////////////////////////////////////////////////////////////
    public String[][] ordersSortByOrderId() {
        String[][] ALLOrderArray = selectionSortDescendingOrderReport2D(getOrdersReports2DArray());


        return ALLOrderArray;


    }

    ////////////////////////////GET ORDERS REPORTS////////////////////////////////////////////////
    public String[][] getOrdersReports2DArray() {
        List list=new List();
        Customer[] customerArray= list.loadFromFile();

        String[][] OrdersReports2DArray = new String[customerArray.length][6];

        for (int i = 0; i < customerArray.length; i++) {
            int b = Integer.parseInt(customerArray[i].getOrderId().split("[#]")[1]);
            OrdersReports2DArray[i][0] = String.valueOf(b);
            OrdersReports2DArray[i][1] = String.valueOf(customerArray[i].getPhoneNumber());
            OrdersReports2DArray[i][2] = String.valueOf(customerArray[i].getSize());
            OrdersReports2DArray[i][3] = String.valueOf(customerArray[i].getQty());
            OrdersReports2DArray[i][4] = String.valueOf(customerArray[i].getAmount());

            OrdersReports2DArray[i][5] = customerArray[i].getStatus() ;

        }

        return OrdersReports2DArray;

    }

    ///////////////////////////////SELECTION SORT DESCENDING ORDER REPORT AMOUNT///////////////////////////
    public String[][] selectionSortDescendingOrderReportAmount2D(String[][] temp) {

        for (int i = 0; i < temp.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < temp.length; j++) {

                double currentID = Double.parseDouble(temp[j][4]);
                double minID = Double.parseDouble(temp[minIndex][4]);
                if (currentID > minID) {
                    minIndex = j;
                }
            }

            String[] tempRow = temp[i];
            temp[i] = temp[minIndex];
            temp[minIndex] = tempRow;
        }

        return temp;

    }

    ///////////////////////////ORDER SORT BY AMOUNT///////////////////////////
    public String[][] ordersSortByAmount() {
        String[][] ALLOrderArrayAmount = selectionSortDescendingOrderReportAmount2D(getOrdersReports2DArray());

        return ALLOrderArrayAmount;


    }
}
