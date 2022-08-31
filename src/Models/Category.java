package Models;

import com.mysql.cj.conf.IntegerProperty;
import com.mysql.cj.conf.StringProperty;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Category {
    private SimpleIntegerProperty categoryId;
    private SimpleStringProperty categoryName;

    public Category() {
    }

    public Category(int id, String name) {
        this.categoryId = new SimpleIntegerProperty(id);
        this.categoryName = new SimpleStringProperty(name);

    }

    public int getCategoryId() {
        return categoryId.get();
    }

    public String getCategoryName() {
        return categoryName.get();
    }

    public void setCategoryId(int id) {
        this.categoryId.set(id);
    }

    public void setCategoryName(String name) {
        this.categoryName.set(name);
    }

}
