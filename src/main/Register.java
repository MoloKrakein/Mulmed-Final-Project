package main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Register extends Application {

    private AnchorPane anchorPane;
    private BorderPane borderPane;
    private VBox vBox;
    private Label titleLabel;
    private GridPane gridPane;
    private Label emailLabel;
    private Label passwordLabel;
    private Label confirmPasswordLabel;
    private TextField emailTextField;
    private PasswordField passwordField;
    private PasswordField confirmPasswordField;
    private Button registerButton;
    private Button loginButton;
    private static String[] registerEmail = new String[100];
    private static String[] registerPassword = new String[100];
    private static int registerCount = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        init();

        anchorPane.getChildren().addAll(borderPane);
        Scene scene = new Scene(anchorPane, 566, 465);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Back to login Logic
        loginButton.setOnAction(e->{
        Main main = new Main();
        main.start(new Stage());
        primaryStage.close();
    });
                // Button Logic Reg
        registerButton.setOnAction(e-> {
        String email = emailTextField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields must be filled.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Password and Confirm Password do not match.");
            return;
        }

        // Store the registration information
        registerEmail[registerCount] = email;
        registerPassword[registerCount] = password;
        registerCount++;

        // Clear the registration fields
        emailTextField.clear();
        passwordField.clear();
        confirmPasswordField.clear();

        // Show a success message
        showAlert(Alert.AlertType.INFORMATION, "Success", "Registration successful!");
    });
    }
        public static String[] getRegisteredEmails() {
        return registerEmail;
    }

    public static String[] getRegisteredPasswords() {
        return registerPassword;
    }

    public static int getNumRegisteredUsers() {
        return registerCount;
    }
    public void init() {
        anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(200);
        anchorPane.setPrefWidth(200);

        borderPane = new BorderPane();
        borderPane.setPrefHeight(465);
        borderPane.setPrefWidth(566);

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(vBox, Pos.CENTER);

        titleLabel = new Label("REGISTER");
        titleLabel.setFont(new Font("System Bold", 24));

        gridPane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column1.setMinWidth(10);
        column1.setPrefWidth(100);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column2.setMinWidth(10);
        column2.setPrefWidth(100);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column3.setMaxWidth(211);
        column3.setMinWidth(10);
        column3.setPrefWidth(188);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column4.setMaxWidth(147);
        column4.setMinWidth(10);
        column4.setPrefWidth(94);
        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(10);
        row1.setPrefHeight(30);
        row1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        RowConstraints row2 = new RowConstraints();
        row2.setMinHeight(10);
        row2.setPrefHeight(30);
        row2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        RowConstraints row3 = new RowConstraints();
        row3.setMinHeight(10);
        row3.setPrefHeight(30);
        row3.setVgrow(javafx.scene.layout.Priority.NEVER);
        RowConstraints row4 = new RowConstraints();
        row4.setMinHeight(10);
        row4.setPrefHeight(30);
        row4.setVgrow(javafx.scene.layout.Priority.NEVER);

        emailLabel = new Label("Email");
        passwordLabel = new Label("Password");
        confirmPasswordLabel = new Label("Confirm Password");

        emailTextField = new TextField();
        passwordField = new PasswordField();
        confirmPasswordField = new PasswordField();

        registerButton = new Button("Register");
        loginButton = new Button("Login");

        GridPane buttonGridPane = new GridPane();
        ColumnConstraints buttonColumn1 = new ColumnConstraints();
        buttonColumn1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        buttonColumn1.setMinWidth(10);
        buttonColumn1.setPrefWidth(100);
        ColumnConstraints buttonColumn2 = new ColumnConstraints();
        buttonColumn2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        buttonColumn2.setMinWidth(10);
        buttonColumn2.setPrefWidth(100);
        RowConstraints buttonRow1 = new RowConstraints();
        buttonRow1.setMinHeight(10);
        buttonRow1.setPrefHeight(30);
        buttonRow1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        buttonGridPane.getColumnConstraints().addAll(buttonColumn1, buttonColumn2);
        buttonGridPane.getRowConstraints().addAll(buttonRow1);
        buttonGridPane.add(registerButton, 1, 0);
        buttonGridPane.add(loginButton, 0, 0);

        gridPane.getColumnConstraints().addAll(column1, column2, column3, column4);
        gridPane.getRowConstraints().addAll(row1, row2, row3, row4);
        gridPane.add(emailLabel, 1, 0);
        gridPane.add(passwordLabel, 1, 1);
        gridPane.add(confirmPasswordLabel, 1, 2);
        gridPane.add(emailTextField, 2, 0);
        gridPane.add(passwordField, 2, 1);
        gridPane.add(confirmPasswordField, 2, 2);
        gridPane.add(buttonGridPane, 2, 3);

        vBox.getChildren().addAll(titleLabel, gridPane);
        borderPane.setCenter(vBox);
        


    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
