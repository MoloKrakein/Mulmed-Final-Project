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
        return keyboards[index].getId();
    }
    
    public String getName(int index) {
        return keyboards[index].getName();
    }
    
    public int getPrice(int index) {
        return keyboards[index].getPrice();
    }
    
    public int getStock(int index) {
        return keyboards[index].getStock();
    }
    
    public String getDescription(int index) {
        return keyboards[index].getDescription();
    }
    
    public String getImage(int index) {
        return keyboards[index].getImage();
    }
}
