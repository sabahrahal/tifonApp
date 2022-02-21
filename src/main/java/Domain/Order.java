package Domain;


public class Order {
    private int id;
    private String client;
    private int quantity; 
    private double total; 
    private boolean pay;
    private static final double PRICE = 3.5;
    
    public Order(){
    }
    
    //for delete or search
    public Order(int id){
        this.id = id; 
    }
    
    //for add
    public Order(int quantity, double total, boolean pay, String client) {
        this.quantity = quantity;
        this.total = total;
        this.pay = pay;
        this.client = client; 
    }

    //for modify
    public Order(int id, int quantity, double total, boolean pay, String client) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.pay = pay;
        this.client = client; 
    }
    
    public double calculateTotal(int quantity){
    
        this.total = this.quantity * PRICE;
        return total ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
       
      
}
