package main;

public class KeyboardData {
    private int id;
    private String name;
    private int price;
    private int stock;
    private String description;
    private String image;
    
    public KeyboardData(int id, String name, int price, int stock, String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.image = image;
    }
    
    // Getter methods
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getStock() {
        return stock;
    }
    
    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
    
    // Setter methods
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}