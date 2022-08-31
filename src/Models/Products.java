package Models;

public class Products {
    private String productId;
    private String productName;
    private String price;
    private String category;
    private String stockq;
    private String quantity;

    // constructor

    public Products() {

    }

    // constructor overloading for products
    // get products including Id

    public Products(String productId, String productName, String price, String quantity, String category) {

        try {

            // create an object
            this.productId = new String(productId);
            this.productName = new String(productName);
            this.price = new String(price);
            this.category = new String(category);
            // this.stockq = new SimpleIntegerProperty(stockq);
            this.quantity = new String(quantity);

        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getStocks() {
        return stockq;
    }

    public String getCategory() {
        return category;
    }

    // setters
    public void setPrductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
