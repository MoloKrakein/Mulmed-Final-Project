package main;

public class KeyboardIOTest {
    private static KeyboardArray keyboardArray = new KeyboardArray();
    
    //main
    public static void main(String[] args) {
        keyboardDefaultValue();
        System.out.println("KeyboardIO Test");
        System.out.println(keyboardArray.getName(0));
    }
    public static void keyboardDefaultValue(){
        //  public KeyboardData(int id, String name, int price, int stock, String description, String image)
       KeyboardData keyboard1 = new KeyboardData(0, "Igoltech Keebs XO200", 800000, 56, "Classic black and yellow combination with modern architecture.", "keyboard1.png");
       KeyboardData keyboard2 = new KeyboardData(1,"Dark Black RGB", 1500000, 116, "RGB LED has come to this futuristic keyboard with elegant style.", "keyboard2.png");
       KeyboardData keyboard3 = new KeyboardData(2,"Watermelon Keebs Z200", 750000, 9, "Did you ever seen watermelon in keyboard? Now you see!", "keyboard3.png");
        KeyboardData keyboard4 = new KeyboardData(3,"Igoltech Classic Keebs", 1250000, 56, "Business keyboard with modern design make your style cool.", "keyboard4.png");
    
        keyboardArray.addKeyboard(keyboard1, 0);
        keyboardArray.addKeyboard(keyboard2, 1);
        keyboardArray.addKeyboard(keyboard3, 2);
        keyboardArray.addKeyboard(keyboard4, 3);
    }
}

