package main;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class admin extends Application {

    private TitledPane titledPane;
    private ScrollPane scrollPane;
    private VBox vBox;

    public void init() {
        titledPane = new TitledPane();
        titledPane.setAnimated(false);
        titledPane.setMaxHeight(Double.NEGATIVE_INFINITY);
        titledPane.setMaxWidth(Double.NEGATIVE_INFINITY);
        titledPane.setMinHeight(Double.NEGATIVE_INFINITY);
        titledPane.setMinWidth(Double.NEGATIVE_INFINITY);
        titledPane.setPrefHeight(439.0);
        titledPane.setPrefWidth(752.0);
        titledPane.setText("Menu");

        scrollPane = new ScrollPane();
        scrollPane.setPrefHeight(200.0);
        scrollPane.setPrefWidth(200.0);

        vBox = new VBox();
        vBox.setPrefHeight(702.0);
        vBox.setPrefWidth(728.0);
    }

    @Override
    public void start(Stage primaryStage) {
        init();

        HBox hbox1 = createHBox();
        HBox hbox2 = createHBox();
        HBox hbox3 = createHBox();

        vBox.getChildren().addAll(hbox1, hbox2, hbox3);
        scrollPane.setContent(vBox);
        titledPane.setContent(scrollPane);

        Scene scene = new Scene(titledPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createHBox() {
        HBox hbox = new HBox();
        File file = new File("keyboard1.png");
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPrefHeight(161.0);
        hbox.setPrefWidth(649.0);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image("file:" + file.getAbsolutePath() + "");
        imageView.setImage(image);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        gridPane.getColumnConstraints().add(columnConstraints);

        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(10.0);
        row1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        RowConstraints row2 = new RowConstraints();
        row2.setMinHeight(10.0);
        row2.setPrefHeight(30.0);
        row2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane.getRowConstraints().addAll(row1, row2);

        HBox hboxContent1 = createHBoxContent();
        VBox vboxContent2 = createVBoxContent();

        gridPane.add(hboxContent1, 0, 0);
        gridPane.add(vboxContent2, 0, 1);

        hbox.getChildren().addAll(imageView, gridPane);
        return hbox;
    }

    private HBox createHBoxContent() {
        HBox hboxContent = new HBox();
        hboxContent.setAlignment(Pos.CENTER);

        Label nameLabel = new Label("Name");
        TextField nameTextField = new TextField();

        Label priceLabel = new Label("Price");
        TextField priceTextField = new TextField();

        Label stockLabel = new Label("Stock");
        TextField stockTextField = new TextField();

        hboxContent.getChildren().addAll(nameLabel, nameTextField, priceLabel, priceTextField, stockLabel, stockTextField);
        return hboxContent;
    }

    private VBox createVBoxContent() {
        VBox vboxContent = new VBox();
        vboxContent.setAlignment(Pos.CENTER_LEFT);
        vboxContent.setPrefHeight(83.0);
        vboxContent.setPrefWidth(555.0);

        HBox hboxContent1 = new HBox();
        Label descriptionLabel = new Label("Description");
        TextField descriptionTextField = new TextField();
        hboxContent1.getChildren().addAll(descriptionLabel, descriptionTextField);

        Button updateButton = new Button("Update");

        vboxContent.getChildren().addAll(hboxContent1, updateButton);
        return vboxContent;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
