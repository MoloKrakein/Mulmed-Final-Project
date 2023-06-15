package main;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class admin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Pane contentPane = new Pane();
        ScrollPane scrollPane = new ScrollPane(contentPane);
        VBox vbox = new VBox();
        vbox.setPrefWidth(763.0);
        vbox.setPrefHeight(702.0);

        for (int i = 0; i < 6; i++) {
            HBox hbox = createHBox();
            vbox.getChildren().add(hbox);
        }

        vbox.setLayoutX(0.0);
        vbox.setLayoutY(0.0);

        contentPane.getChildren().add(vbox);

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem closeItem = new MenuItem("Close");
        closeItem.setOnAction(e -> primaryStage.close());
        fileMenu.getItems().add(closeItem);
        menuBar.getMenus().add(fileMenu);

        root.setTop(menuBar);
        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");
        primaryStage.show();
    }

    private HBox createHBox() {
        File file = new File("keyboard1.png");
        HBox hbox = new HBox();
        hbox.setPrefWidth(649.0);
        hbox.setPrefHeight(161.0);

        ImageView imageView = new ImageView();
        imageView.setImage(new Image(file.toURI().toString()));
        imageView.setFitWidth(200.0);
        imageView.setFitHeight(150.0);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);

        GridPane gridPane = new GridPane();
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        gridPane.getColumnConstraints().add(columnConstraints);

        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setVgrow(Priority.SOMETIMES);

        RowConstraints rowConstraints2 = new RowConstraints();
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(Priority.SOMETIMES);

        gridPane.getRowConstraints().addAll(rowConstraints1, rowConstraints2);

        HBox hboxInner = new HBox();
        Label nameLabel = new Label("Name");
        TextField nameTextField = new TextField();
        Label priceLabel = new Label("Price");
        TextField priceTextField = new TextField();
        Label stockLabel = new Label("Stock");
        TextField stockTextField = new TextField();

        hboxInner.getChildren().addAll(nameLabel, nameTextField, priceLabel, priceTextField, stockLabel, stockTextField);

        VBox vboxInner = new VBox();
        Label descriptionLabel = new Label("Description");
        TextField descriptionTextField = new TextField();
        Button updateButton = new Button("Update");

        vboxInner.getChildren().addAll(descriptionLabel, descriptionTextField, updateButton);

        gridPane.add(hboxInner, 0, 0);
        gridPane.add(vboxInner, 0, 1);

        hbox.getChildren().addAll(imageView, gridPane);

        return hbox;
    }
}