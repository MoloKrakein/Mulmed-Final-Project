package main;

public class KeyboardArray {
    private KeyboardData[] keyboards;

    public KeyboardArray() {
        keyboards = new KeyboardData[4];
    }
    
    public void addKeyboard(KeyboardData keyboard, int index) {
        keyboards[index] = keyboard;
    }
    
    public KeyboardData[] getKeyboards() {
        return keyboards;
    }
    
    // Getter methods for properties of KeyboardData
    
    public int getId(int index) {
        if (keyboards[index] != null) {
            return keyboards[index].getId();
        } else {
            return -1; // Return a default value or throw an exception to handle null case
        }
    }
    
    public String getName(int index) {
        if (keyboards[index] != null) {
            return keyboards[index].getName();
        } else {
            return null; // Return a default value or throw an exception to handle null case
        }
    }
    
    public int getPrice(int index) {
        if (keyboards[index] != null) {
            return keyboards[index].getPrice();
        } else {
            return -1; // Return a default value or throw an exception to handle null case
        }
    }
    
    public int getStock(int index) {
        if (keyboards[index] != null) {
            return keyboards[index].getStock();
        } else {
            return -1; // Return a default value or throw an exception to handle null case
        }
    }
    
    public String getDescription(int index) {
        if (keyboards[index] != null) {
            return keyboards[index].getDescription();
        } else {
            return null; // Return a default value or throw an exception to handle null case
        }
    }
    
    public String getImage(int index) {
        if (keyboards[index] != null) {
            return keyboards[index].getImage();
        } else {
            return null; // Return a default value or throw an exception to handle null case
        }
    }

    // Setter methods for properties of KeyboardData

    public void setId(int index, int id) {
        if (keyboards[index] != null) {
            keyboards[index].setId(id);
        }
    }

    public void setName(int index, String name) {
        if (keyboards[index] != null) {
            keyboards[index].setName(name);
        }
    }

    public void setPrice(int index, int price) {
        if (keyboards[index] != null) {
            keyboards[index].setPrice(price);
        }
    }

    public void setStock(int index, int stock) {
        if (keyboards[index] != null) {
            keyboards[index].setStock(stock);
        }
    }

    public void setDescription(int index, String description) {
        if (keyboards[index] != null) {
            keyboards[index].setDescription(description);
        }
    }

    // public void setImage(int index, String image) {
    //     if (keyboards[index] != null) {
    //         keyboards[index].setImage(image);
    //     }
    // }

    public void init() {
        KeyboardData keyboard1 = new KeyboardData(0, "Igoltech Keebs XO200", 800000, 56, "Classic black and yellow combination with modern architecture.", "keyboard1.png");
        KeyboardData keyboard2 = new KeyboardData(1,"Dark Black RGB", 1500000, 116, "RGB LED has come to this futuristic keyboard with elegant style.", "keyboard2.png");
        KeyboardData keyboard3 = new KeyboardData(2,"Watermelon Keebs Z200", 750000, 9, "Did you ever seen watermelon in keyboard? Now you see!", "keyboard3.png");
        KeyboardData keyboard4 = new KeyboardData(3,"Igoltech Classic Keebs", 1250000, 56, "Business keyboard with modern design make your style cool.", "keyboard4.png");

        addKeyboard(keyboard1, 0);
        addKeyboard(keyboard2, 1);
        addKeyboard(keyboard3, 2);
        addKeyboard(keyboard4, 3);
    }
}
