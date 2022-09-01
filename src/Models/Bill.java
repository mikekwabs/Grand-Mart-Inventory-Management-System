package Models;

public class Bill {
    private String invoiceNumber;
    private String prodName;
    private String quantity;
    private String invoiceDate;
    private String dueDate;
    private String billAmount;
    private String balance;

    public Bill() {

    }

    public Bill(String invoiceNumber, String prodName, String quantity, String invoiceDate, String dueDate,
            String billAmount, String balance) {
        this.invoiceNumber = new String(invoiceNumber);
        this.prodName = new String(prodName);
        this.quantity = new String(quantity);
        this.invoiceDate = new String(invoiceDate);
        this.dueDate = new String(dueDate);
        this.billAmount = new String(billAmount);
        this.balance = new String(balance);

    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
