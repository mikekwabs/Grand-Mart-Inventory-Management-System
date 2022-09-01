package Models;

public class Category {
    private String categoryId;
    private String categoryName;

    public Category() {
    }

    public Category(String id, String name) {
        this.categoryId = new String(id);
        this.categoryName = new String(name);

    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryId(String id) {
        this.categoryId = id;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }

}
