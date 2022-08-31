package Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Vendors {

    private SimpleIntegerProperty vendorId;
    private SimpleStringProperty vendorName;

    public Vendors() {
    }

    public Vendors(int id, String name) {
        this.vendorId = new SimpleIntegerProperty(id);
        this.vendorName = new SimpleStringProperty(name);
    }

    // getters and setters

    public int getVendorId() {
        return vendorId.get();
    }

    public String getVendorName() {
        return vendorName.get();
    }

    public void setVendorId(int id) {
        this.vendorId.set(id);
    }

    public void setVendorName(String name) {
        this.vendorName.set(name);
    }
}