package Models;

public class Category {
    private String categoryName;

    public Category() {
    }

    public Category(String name) {
          this.categoryName = new String(name);

    }


    public String getCategoryName() {
        return categoryName;
    }


    public void setCategoryName(String name) {
        this.categoryName = name;
    }

}
