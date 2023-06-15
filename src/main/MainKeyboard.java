package main;

import java.io.File;
import java.util.Vector;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MainKeyboard extends Application {

    String audioFileSource = "lofi.mp3";
    File audioFile;
    Media audioMedia;
    MediaPlayer audioPlayer;

    private Vector<String> productName = new Vector<String>();
    private Vector<Integer> productPrice = new Vector<Integer>();
    private Vector<Integer> productStock = new Vector<Integer>();
    private Vector<String> productDesc = new Vector<String>();

    public static void main(String[] args) {
        launch(args);
    }

    void dragDropHandler(Label name, ImageView productsView, ScrollPane scrollRight, Stage primaryStage, int index) {
        name.setOnDragDetected(e -> {
            Dragboard db = name.startDragAndDrop(TransferMode.ANY);
            ClipboardContent board = new ClipboardContent();
            board.putString(name.getText());
            db.setContent(board);
            e.consume();
        });

        productsView.setOnDragDetected(e -> {
            Dragboard db = productsView.startDragAndDrop(TransferMode.ANY);
            ClipboardContent board = new ClipboardContent();
            board.putString(name.getText());
            db.setContent(board);
            e.consume();
        });

        scrollRight.setOnDragOver(e -> {
            if (e.getGestureSource() != scrollRight && e.getDragboard().hasString()) {
                e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            e.consume();
        });

        scrollRight.setOnDragDropped(e -> {
            Dragboard db = e.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                Label droppedName = new Label(db.getString());
                VBox rightBox = (VBox) scrollRight.getContent();
                rightBox.getChildren().add(rightBox.getChildren().size() - 1, droppedName); // Add item at second-to-last index
                success = true;
            }
            e.setDropCompleted(success);
            e.consume();
        });
    }

    
 

    void dragDropPage(Stage primaryStage) {
        BorderPane bp = new BorderPane();
        VBox leftBox = new VBox();
        VBox rightBox = new VBox();
        ScrollPane scrollLeft = new ScrollPane();
        ScrollPane scrollRight = new ScrollPane();

        Label leftTitle = new Label("Keyboard Catalogue");

        VBox rightPane = new VBox();

        scrollLeft.setContent(leftBox);
        scrollRight.setContent(rightPane);

        SplitPane sp = new SplitPane(scrollLeft, scrollRight);

        leftBox.getChildren().add(leftTitle);

        Button buy = new Button("Buy");
        Button clear = new Button("Clear Cart");

        // Keyboard 1
        productName.add("SteelLogi");
        productPrice.add(3000000);
        productStock.add(15);
        productDesc.add("Black and Yellow Keyboard");

        // Keyboard 2
        productName.add("DGA");
        productPrice.add(2000000);
        productStock.add(18);
        productDesc.add("Black with RGB LED Keyboard");

        // Keyboard 3
        productName.add("Fanxus");
        productPrice.add(450000);
        productStock.add(34);
        productDesc.add("Mint Bubblegum mechanical Keyboard");

        // Keyboard 4
        productName.add("Phantech");
        productPrice.add(525000);
        productStock.add(26);
        productDesc.add("Green typewriter styled Keyboard");

        for (int i = 0; i < 4; i++) {
            Image products = new Image("file:keyboard" + (i + 1) + ".png");
            ImageView productsView = new ImageView(products);

            Label name = new Label("Name: " + productName.get(i));
            Label price = new Label("Price: " + productPrice.get(i));
            Label stock = new Label("Stock: " + productStock.get(i));
            Label desc = new Label("Description: " + productDesc.get(i));
            
            
            // buat manggil window baru per keyboard 


                String productName = this.productName.get(i);

                productsView.setOnMouseClicked(e -> {
                    if (productName.equals("SteelLogi")) {
                        keyboard1();
                    } else if (productName.equals("DGA")) {
                        keyboard2();
                    } else if (productName.equals("Fanxus")) {
                        keyboard3();
                    }
                    else
                    {
                    	keyboard4();
                    }
                });

          
            
            productsView.setFitHeight(200);
            productsView.setPreserveRatio(true);

            dragDropHandler(name, productsView, scrollRight, primaryStage, i);

            leftBox.getChildren().addAll(productsView, name, price, stock, desc);
        }

        VBox buttonBox = new VBox();
        buttonBox.getChildren().addAll(buy, clear);
        buttonBox.setAlignment(Pos.BOTTOM_LEFT);

        rightBox.getChildren().addAll(buttonBox);
        rightPane.getChildren().addAll(rightBox);

        clear.setOnAction(e -> {
            rightPane.getChildren().clear();
            rightPane.getChildren().addAll(rightBox);
        });

        bp.setCenter(sp);

        Scene scene = new Scene(bp, 500, 500);
        primaryStage.setScene(scene);
    }
    
 
    void audio() 
    {
        audioFile = new File(audioFileSource);
        audioMedia = new Media(audioFile.toURI().toString());
        audioPlayer = new MediaPlayer(audioMedia);

        audioPlayer.setVolume(0.2);
        audioPlayer.play();
    }

    @Override
    public void start(Stage primaryStage) 
    {
        audio();
        dragDropPage(primaryStage);
        primaryStage.show();
        // System.out.println("Hello World");
    }
    
    void keyboard1()
    {
        keyboard1 app = new keyboard1();
        Stage newStage = new Stage();
        try 
        {
            app.start(newStage);
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    void keyboard2()
    {
        keyboard2 app = new keyboard2();
        Stage newStage = new Stage();
        try 
        {
            app.start(newStage);
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    
    void keyboard3()
    {
        keyboard3 app = new keyboard3();
        Stage newStage = new Stage();
        try 
        {
            app.start(newStage);
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    
    void keyboard4()
    {
        keyboard4 app = new keyboard4();
        Stage newStage = new Stage();
        try 
        {
            app.start(newStage);
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}

