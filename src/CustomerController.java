import java.io.*;
import java.util.*;


public class CustomerController {
    public static boolean addCustomer(Customer customer)throws IOException{
        FileWriter fw=new FileWriter("Customer.txt",true);
        fw.write(customer.getOrderId()+","+customer.getPhoneNumber()+","+customer.getSize()+","+customer.getQty()+","+customer.getAmount()+","+customer.getStatus()+"\n");
        fw.close();
        return true;
    }


public static Customer searchCustomer(String id)throws IOException{

    BufferedReader br=new BufferedReader(new FileReader("Customer.txt"));
    String line=br.readLine();
    boolean isExist=false;
    while(line!=null){
        String rowId=line.substring(0,9);
        if(rowId.equalsIgnoreCase(id)){
            isExist=true;
            break;
        }
        line=br.readLine();
    }
    br.close();
    if(isExist){

        String[] rowData=line.split(",");
        Customer customer=new Customer(rowData[0],rowData[1],rowData[2],Integer.parseInt(rowData[3]),Double.parseDouble(rowData[4]), (rowData[5].equals("PROPROCESSING")? 0:rowData[5].equals("DELIVERING")? 1:2));
        return customer;
    }else{
        return null;
    }
}

    public static Customer[] searchCustomer2(String PhoneNumber) throws IOException {
        Customer[] customersArray = new Customer[100];
        int i = 0;
        BufferedReader br = new BufferedReader(new FileReader("Customer.txt"));
        String line = br.readLine();

        while (line != null) {
            String rowId = line.substring(10,20);
            if (rowId.equalsIgnoreCase(PhoneNumber)) {
                String[] rowData = line.split(",");
                Customer customer = new Customer(
                        rowData[0],
                        rowData[1],
                        rowData[2],
                        Integer.parseInt(rowData[3]),
                        Double.parseDouble(rowData[4]),
                        rowData[5].equals("PROPROCESSING") ? 0 : rowData[5].equals("DELIVERING") ? 1 : 2
                );
                customersArray[i++] = customer;
            }
            line = br.readLine();
        }
        br.close();

        // Resize array to match the number of found customers
        return Arrays.copyOf(customersArray, i);
    }
    public static int generateCustomerId()throws IOException{
        String lastLine=null;
        BufferedReader br=new BufferedReader(new FileReader("Customer.txt"));
        String line=br.readLine();
        while(line!=null){
            lastLine=line;
            line=br.readLine();
        }
        br.close();
        if(lastLine==null){
            return 1;
        }else{
            int lastIdNumber=Integer.parseInt(lastLine.substring(4,9));
            return lastIdNumber+1;
        }
    }

    public static boolean deleteCustomer(String id)throws IOException{
        BufferedReader br=new BufferedReader(new FileReader("Customer.txt"));
        List customerList=new List();
        String line=br.readLine();
        while(line!=null){
            String[] rowData=line.split(",");
            //Customer customer=new Customer(rowData[0],rowData[1],rowData[2],Double.parseDouble(rowData[3]));
            Customer customer=new Customer(rowData[0],rowData[1],rowData[2],Integer.parseInt(rowData[3]),Double.parseDouble(rowData[4]), (rowData[5].equals("PROPROCESSING")? 0:rowData[5].equals("DELIVERING")? 1:2));

            customerList.add(customer);
            line=br.readLine();
        }
        boolean isDeleted=customerList.remove(new Customer(id,null,null,0,0,0));

        FileWriter fw=new FileWriter("Customer.txt");
        System.out.println("kk");
        for (int i = 0; i < customerList.size(); i++){
            Customer customer=customerList.get(i);
            fw.write(customer.toString()+"\n");
        }
        fw.close();
        return isDeleted;
    }

    public static boolean changeStatus(String id,int status)throws IOException{
        BufferedReader br=new BufferedReader(new FileReader("Customer.txt"));
        List customerList=new List();
        String line=br.readLine();
        while(line!=null){
            String[] rowData=line.split(",");
            //Customer customer=new Customer(rowData[0],rowData[1],rowData[2],Double.parseDouble(rowData[3]));
            Customer customer=new Customer(rowData[0],rowData[1],rowData[2],Integer.parseInt(rowData[3]),Double.parseDouble(rowData[4]), (rowData[5].equals("PROPROCESSING")? 0:rowData[5].equals("DELIVERING")? 1:2));

            customerList.add(customer);
            line=br.readLine();
        }
       // boolean isDeleted=customerList.remove(new Customer(id,null,null,0,0,0));
      int index=customerList.search(new Customer(id,null,null,0,0,0));

        FileWriter fw=new FileWriter("Customer.txt");
        System.out.println("kk");
        for (int i = 0; i < customerList.size(); i++){
            Customer customer=customerList.get(i);
            if (index==i){
                customer.setStatus(status);
            }
                fw.write(customer.toString()+"\n");



        }
        fw.close();
        return true;
    }
    public static Customer[] getAllCustomersFromFile() throws IOException {
        ArrayList<Object> customers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("Customer.txt"));
        String line = br.readLine();

        while (line != null) {
            String[] rowData = line.split(",");
            Customer customer = new Customer(
                    rowData[0],
                    rowData[1],
                    rowData[2],
                    Integer.parseInt(rowData[3]),
                    Double.parseDouble(rowData[4]),
                    rowData[5].equals("PROPROCESSING") ? 0 : rowData[5].equals("DELIVERING") ? 1 : 2
            );
            customers.add(customer);
            line = br.readLine();
        }
        br.close();

        // Convert the list to an array and return
        return customers.toArray(new Customer[0]);
    }



}