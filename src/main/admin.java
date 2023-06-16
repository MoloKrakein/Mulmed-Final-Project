package main;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class admin extends Application {

    private KeyboardArray keyboardArray;

    @Override
    public void start(Stage primaryStage) {
        keyboardArray = new KeyboardArray();
        keyboardArray.init();

        Pane root = new Pane();
        Scene scene = new Scene(root, 842, 647);

        BorderPane borderPane = new BorderPane();
        ScrollPane scrollPane = new ScrollPane();
        VBox vBox = new VBox();
        vBox.setSpacing(25);

        HBox hBox1 = new HBox();
        File file1 = new File(keyboardArray.getImage(0));
        ImageView imageView1 = new ImageView();
        Image image1 = new Image(file1.toURI().toString());
        imageView1.setImage(image1);
        imageView1.setFitWidth(200);
        imageView1.setFitHeight(150);

        GridPane gridPane1 = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane1.getColumnConstraints().add(column1);

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        row2.setMinHeight(30);
        row2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane1.getRowConstraints().addAll(row1, row2);

        HBox hBox1Inner = new HBox();
        Label nameLabel1 = new Label("Name");
        TextField nameTextField1 = new TextField(keyboardArray.getName(0));
        Label priceLabel1 = new Label("Price");
        TextField priceTextField1 = new TextField(String.valueOf(keyboardArray.getPrice(0)));
        Label stockLabel1 = new Label("Stock");
        TextField stockTextField1 = new TextField(String.valueOf(keyboardArray.getStock(0)));
        hBox1Inner.getChildren().addAll(nameLabel1, nameTextField1, priceLabel1, priceTextField1, stockLabel1,
                stockTextField1);

        VBox vBox1Inner = new VBox();
        Label descriptionLabel1 = new Label("Description");
        TextField descriptionTextField1 = new TextField();
        descriptionTextField1.setText(keyboardArray.getDescription(0));
        Button updateButton1 = new Button("Update");
        vBox1Inner.getChildren().addAll(descriptionLabel1, descriptionTextField1, updateButton1);

        gridPane1.add(hBox1Inner, 0, 0);
        gridPane1.add(vBox1Inner, 0, 1);

        updateButton1.setOnAction(e -> {
            // check if the fields is integer or not
            try {
                Integer.parseInt(priceTextField1.getText());
                Integer.parseInt(stockTextField1.getText());
            } catch (NumberFormatException ex) {
                // System.out.println("Price and Stock must be integer");
                // show alert
                showAlert(AlertType.ERROR, "Form Error!", "Price and Stock must be integer");


                return;
            }
            
            keyboardArray.setName(0, nameTextField1.getText());
            keyboardArray.setPrice(0, Integer.parseInt(priceTextField1.getText()));
            keyboardArray.setStock(0, Integer.parseInt(stockTextField1.getText()));
            keyboardArray.setDescription(0, descriptionTextField1.getText());

            // update the fields
            nameTextField1.setText(keyboardArray.getName(0));
            priceTextField1.setText(String.valueOf(keyboardArray.getPrice(0)));
            stockTextField1.setText(String.valueOf(keyboardArray.getStock(0)));
            descriptionTextField1.setText(keyboardArray.getDescription(0));

        });

        hBox1.getChildren().addAll(imageView1, gridPane1);
        vBox.getChildren().add(hBox1);
        HBox hBox2 = new HBox();
        File file2 = new File(keyboardArray.getImage(1));
        ImageView imageView2 = new ImageView();
        Image image2 = new Image(file2.toURI().toString());
        imageView2.setImage(image2);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(150);

        GridPane gridPane2 = new GridPane();
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane2.getColumnConstraints().add(column2);

        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        row4.setMinHeight(30);
        row4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane2.getRowConstraints().addAll(row3, row4);

        HBox hBox2Inner = new HBox();
        Label nameLabel2 = new Label("Name");
        TextField nameTextField2 = new TextField(keyboardArray.getName(1));
        Label priceLabel2 = new Label("Price");
        TextField priceTextField2 = new TextField(String.valueOf(keyboardArray.getPrice(1)));
        Label stockLabel2 = new Label("Stock");
        TextField stockTextField2 = new TextField(String.valueOf(keyboardArray.getStock(1)));
        hBox2Inner.getChildren().addAll(nameLabel2, nameTextField2, priceLabel2, priceTextField2, stockLabel2,
                stockTextField2);

        VBox vBox2Inner = new VBox();
        Label descriptionLabel2 = new Label("Description");
        TextField descriptionTextField2 = new TextField();
        descriptionTextField2.setText(keyboardArray.getDescription(1));
        Button updateButton2 = new Button("Update");
        vBox2Inner.getChildren().addAll(descriptionLabel2, descriptionTextField2, updateButton2);

        gridPane2.add(hBox2Inner, 0, 0);
        gridPane2.add(vBox2Inner, 0, 1);

        updateButton2.setOnAction(e -> {
            keyboardArray.setName(1, nameTextField2.getText());
            keyboardArray.setPrice(1, Integer.parseInt(priceTextField2.getText()));
            keyboardArray.setStock(1, Integer.parseInt(stockTextField2.getText()));
            keyboardArray.setDescription(1, descriptionTextField2.getText());

            // Update the fields
            nameTextField2.setText(keyboardArray.getName(1));
            priceTextField2.setText(String.valueOf(keyboardArray.getPrice(1)));
            stockTextField2.setText(String.valueOf(keyboardArray.getStock(1)));
            descriptionTextField2.setText(keyboardArray.getDescription(1));
        });

        hBox2.getChildren().addAll(imageView2, gridPane2);
        vBox.getChildren().add(hBox2);

        HBox hBox3 = new HBox();
        File file3 = new File(keyboardArray.getImage(2));
        ImageView imageView3 = new ImageView();
        Image image3 = new Image(file3.toURI().toString());
        imageView3.setImage(image3);
        imageView3.setFitWidth(200);
        imageView3.setFitHeight(150);

        GridPane gridPane3 = new GridPane();
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane3.getColumnConstraints().add(column3);

        RowConstraints row5 = new RowConstraints();
        RowConstraints row6 = new RowConstraints();
        row6.setMinHeight(30);
        row6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane3.getRowConstraints().addAll(row5, row6);

        HBox hBox3Inner = new HBox();
        Label nameLabel3 = new Label("Name");
        TextField nameTextField3 = new TextField(keyboardArray.getName(2));
        Label priceLabel3 = new Label("Price");
        TextField priceTextField3 = new TextField(String.valueOf(keyboardArray.getPrice(2)));
        Label stockLabel3 = new Label("Stock");
        TextField stockTextField3 = new TextField(String.valueOf(keyboardArray.getStock(2)));
        hBox3Inner.getChildren().addAll(nameLabel3, nameTextField3, priceLabel3, priceTextField3, stockLabel3,
                stockTextField3);

        VBox vBox3Inner = new VBox();
        Label descriptionLabel3 = new Label("Description");
        TextField descriptionTextField3 = new TextField();
        descriptionTextField3.setText(keyboardArray.getDescription(2));
        Button updateButton3 = new Button("Update");
        vBox3Inner.getChildren().addAll(descriptionLabel3, descriptionTextField3, updateButton3);

        gridPane3.add(hBox3Inner, 0, 0);
        gridPane3.add(vBox3Inner, 0, 1);

        updateButton3.setOnAction(e -> {
            keyboardArray.setName(2, nameTextField3.getText());
            keyboardArray.setPrice(2, Integer.parseInt(priceTextField3.getText()));
            keyboardArray.setStock(2, Integer.parseInt(stockTextField3.getText()));
            keyboardArray.setDescription(2, descriptionTextField3.getText());

            // Update the fields
            nameTextField3.setText(keyboardArray.getName(2));
            priceTextField3.setText(String.valueOf(keyboardArray.getPrice(2)));
            stockTextField3.setText(String.valueOf(keyboardArray.getStock(2)));
            descriptionTextField3.setText(keyboardArray.getDescription(2));
        });

        hBox3.getChildren().addAll(imageView3, gridPane3);
        vBox.getChildren().add(hBox3);

        HBox hBox4 = new HBox();
        File file4 = new File(keyboardArray.getImage(3));
        ImageView imageView4 = new ImageView();
        Image image4 = new Image(file4.toURI().toString());
        imageView4.setImage(image4);
        imageView4.setFitWidth(200);
        imageView4.setFitHeight(150);

        GridPane gridPane4 = new GridPane();
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane4.getColumnConstraints().add(column4);

        RowConstraints row7 = new RowConstraints();
        RowConstraints row8 = new RowConstraints();
        row8.setMinHeight(30);
        row8.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane4.getRowConstraints().addAll(row7, row8);

        HBox hBox4Inner = new HBox();
        Label nameLabel4 = new Label("Name");
        TextField nameTextField4 = new TextField(keyboardArray.getName(3));
        Label priceLabel4 = new Label("Price");
        TextField priceTextField4 = new TextField(String.valueOf(keyboardArray.getPrice(3)));
        Label stockLabel4 = new Label("Stock");
        TextField stockTextField4 = new TextField(String.valueOf(keyboardArray.getStock(3)));
        hBox4Inner.getChildren().addAll(nameLabel4, nameTextField4, priceLabel4, priceTextField4, stockLabel4,
                stockTextField4);

        VBox vBox4Inner = new VBox();
        Label descriptionLabel4 = new Label("Description");
        TextField descriptionTextField4 = new TextField();
        descriptionTextField4.setText(keyboardArray.getDescription(3));
        Button updateButton4 = new Button("Update");
        vBox4Inner.getChildren().addAll(descriptionLabel4, descriptionTextField4, updateButton4);

        gridPane4.add(hBox4Inner, 0, 0);
        gridPane4.add(vBox4Inner, 0, 1);

        updateButton4.setOnAction(e -> {
            keyboardArray.setName(3, nameTextField4.getText());
            keyboardArray.setPrice(3, Integer.parseInt(priceTextField4.getText()));
            keyboardArray.setStock(3, Integer.parseInt(stockTextField4.getText()));
            keyboardArray.setDescription(3, descriptionTextField4.getText());

            // Update the fields
            nameTextField4.setText(keyboardArray.getName(3));
            priceTextField4.setText(String.valueOf(keyboardArray.getPrice(3)));
            stockTextField4.setText(String.valueOf(keyboardArray.getStock(3)));
            descriptionTextField4.setText(keyboardArray.getDescription(3));
        });

        hBox4.getChildren().addAll(imageView4, gridPane4);
        vBox.getChildren().add(hBox4);


        scrollPane.setContent(vBox);
        borderPane.setCenter(scrollPane);

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exitMenuItem = new MenuItem("Exit");
        fileMenu.getItems().add(exitMenuItem);
        menuBar.getMenus().add(fileMenu);

        exitMenuItem.setOnAction(event -> {
        Main main = new Main();
        main.start(new Stage());
        primaryStage.close();

        });

        borderPane.setTop(menuBar);

        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        // image 1 on click
        imageView1.setOnMouseClicked(e -> {
            keyboard1();
        });

        // image 2 on click
        imageView2.setOnMouseClicked(e -> {
            keyboard2();
        });

        // image 3 on click
        imageView3.setOnMouseClicked(e -> {
            keyboard3();
        });

        // image 4 on click
        imageView4.setOnMouseClicked(e -> {
            keyboard4();
        });
        
    }

    public static void main(String[] args) {
        launch(args);
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

        private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
