public class Customer {

    private String orderId;
    private String phoneNumber;
    private String size;
    private int qty;
    private double amount;
    private int status;

    public Customer(String orderId, String phoneNumber, String size, int qty, double amount, int status) {
        this.orderId = orderId;
        this.phoneNumber = phoneNumber;
        this.size = size;
        this.qty = qty;
        this.amount = amount;
        this.status = status;

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
       String tempStatus = status==0? "PROPROCESSING":status==1? "DELIVERING":"DELIVERED"  ;
        return tempStatus;

    }

    public void setStatus(int status) {
        this.status = status;
    }


    public boolean equals(Customer customer){
        return this.orderId.equalsIgnoreCase(customer.orderId);
    }
    public String toString(){
        String tempStatus = status==0? "PROPROCESSING":status==1? "DELIVERING":"DELIVERED"  ;
        return orderId+","+phoneNumber+","+size+","+qty+","+amount+","+tempStatus;
    }

}

