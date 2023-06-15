package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private AnchorPane anchorPane;
    private BorderPane borderPane;
    private VBox vBox;
    private HBox topHBox;
    private Label titleLabel;
    private HBox emailHBox;
    private Label emailLabel;
    private TextField emailTextField;
    private HBox passwordHBox;
    private Label passwordLabel;
    private TextField passwordTextField;
    private GridPane gridPane;
    private ColumnConstraints column1;
    private ColumnConstraints column2;
    private RowConstraints row1;
    private RowConstraints row2;
    private RowConstraints row3;
    private GridPane innerGridPane;
    private ColumnConstraints innerColumn1;
    private ColumnConstraints innerColumn2;
    private RowConstraints innerRow1;
    private Button registerButton;
    private Button loginButton;
    
    private Register register;


    @Override
    public void start(Stage primaryStage) {
        init();
        setupLayout(primaryStage);
        setupScene(primaryStage);

        primaryStage.setTitle("Login Window");
        primaryStage.show();

        loginButton.setOnAction(e -> {
            // Validate and redirect based on credentials
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        
        if (email.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Email and password must be filled.");
            return;
            }
            
            register = new Register();

            // Map<String, String> registerMap = register.getNumRegisteredUsers();
            // Email validation
            String[] registeredEmail = register.getRegisteredEmails();
            String[] registeredPass = register.getRegisteredPasswords();
            int numRegistered = register.getNumRegisteredUsers();
            
            if (!email.contains("@") || !email.contains(".")) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Invalid email format.");
            return;
            }

            if (email.equals("admin@gmail.com") && password.equals("admin")) {
                // Redirect to Admin Window
                admin adminWindow = new admin();
                adminWindow.start(new Stage());
                primaryStage.close();
            } else {
                 for (int i = 0; i < numRegistered; i++) {
                if (email.equals(registeredEmail[i]) && password.equals(registeredPass[i])) {
                    user user= new user();
                    try {
                        user.start(new Stage());
                    } catch (Exception e1) {
                        //
                        e1.printStackTrace();
                    }
                    primaryStage.close();
                    return;
                }
                
            }

            showAlert(Alert.AlertType.ERROR, "Validation Error", "Invalid email or password.");
        }
        });

    }

    public void init() {
        anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(200);
        anchorPane.setPrefWidth(200);

        borderPane = new BorderPane();
        borderPane.setPrefHeight(465);
        borderPane.setPrefWidth(566);

        vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPrefHeight(483);
        vBox.setPrefWidth(610);
        BorderPane.setAlignment(vBox, Pos.CENTER);

        topHBox = new HBox();
        topHBox.setAlignment(Pos.CENTER);
        topHBox.setPrefHeight(172);
        topHBox.setPrefWidth(740);

        titleLabel = new Label("JEE KEYBOARD STORE");
        titleLabel.setAlignment(Pos.BASELINE_CENTER);
        titleLabel.setFont(new Font("System Bold", 36));

        emailHBox = new HBox();
        emailHBox.setAlignment(Pos.CENTER);

        emailLabel = new Label("Email");
        emailLabel.setPrefHeight(27);
        emailLabel.setPrefWidth(65);

        emailTextField = new TextField();
        emailTextField.setPrefHeight(25);
        emailTextField.setPrefWidth(160);

        passwordHBox = new HBox();
        passwordHBox.setAlignment(Pos.CENTER);

        passwordLabel = new Label("Password");
        passwordLabel.setPrefHeight(27);
        passwordLabel.setPrefWidth(65);

        passwordTextField = new TextField();
        passwordTextField.setPrefHeight(25);
        passwordTextField.setPrefWidth(160);

        gridPane = new GridPane();

        column1 = new ColumnConstraints();
        column1.setHgrow(Priority.SOMETIMES);
        column1.setMaxWidth(278);
        column1.setMinWidth(10);
        column1.setPrefWidth(238);

        column2 = new ColumnConstraints();
        column2.setHgrow(Priority.SOMETIMES);
        column2.setMaxWidth(350);
        column2.setMinWidth(10);
        column2.setPrefWidth(328);

        row1 = new RowConstraints();
        row1.setMinHeight(10);
        row1.setPrefHeight(30);
        row1.setVgrow(Priority.SOMETIMES);

        row2 = new RowConstraints();
        row2.setMinHeight(10);
        row2.setPrefHeight(30);
        row2.setVgrow(Priority.SOMETIMES);

        row3 = new RowConstraints();
        row3.setMinHeight(10);
        row3.setPrefHeight(30);
        row3.setVgrow(Priority.SOMETIMES);

        innerGridPane = new GridPane();

        innerColumn1 = new ColumnConstraints();
        innerColumn1.setHgrow(Priority.SOMETIMES);
        innerColumn1.setMaxWidth(170);
        innerColumn1.setMinWidth(10);
        innerColumn1.setPrefWidth(102);

        innerColumn2 = new ColumnConstraints();
        innerColumn2.setHgrow(Priority.SOMETIMES);
        innerColumn2.setMaxWidth(248);
        innerColumn2.setMinWidth(10);
        innerColumn2.setPrefWidth(248);

        innerRow1 = new RowConstraints();
        innerRow1.setMinHeight(10);
        innerRow1.setPrefHeight(30);
        innerRow1.setVgrow(Priority.SOMETIMES);

        registerButton = new Button("Register");
        registerButton.setPrefHeight(25);
        registerButton.setPrefWidth(82);

        loginButton = new Button("Login");
        loginButton.setPrefHeight(25);
        loginButton.setPrefWidth(80);
        GridPane.setColumnIndex(loginButton, 1);
    }

    private void setupLayout(Stage primaryStage) {
        innerGridPane.getColumnConstraints().addAll(innerColumn1, innerColumn2);
        innerGridPane.getRowConstraints().addAll(innerRow1);
        innerGridPane.getChildren().addAll(registerButton, loginButton);

        gridPane.getColumnConstraints().addAll(column1, column2);
        gridPane.getRowConstraints().addAll(row1, row2, row3);
        gridPane.add(innerGridPane, 1, 0);

        emailHBox.getChildren().addAll(emailLabel, emailTextField);
        emailHBox.setPadding(new Insets(15, 0, 0, 0));

        passwordHBox.getChildren().addAll(passwordLabel, passwordTextField);
        passwordHBox.setPadding(new Insets(15, 0, 0, 0));

        topHBox.getChildren().add(new Label());
        vBox.getChildren().addAll(topHBox, titleLabel, emailHBox, passwordHBox, gridPane);
        borderPane.setCenter(vBox);
        anchorPane.getChildren().add(borderPane);

        registerButton.setOnAction(e -> {
            // Open Register Window
            Register registerApp = new Register();
            registerApp.start(new Stage());
            primaryStage.close();
        });
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void setupScene(Stage primaryStage) {
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}