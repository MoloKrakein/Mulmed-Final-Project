package main;

import java.io.File;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class user extends Application 
{

	Scene scene;
	BorderPane bp;
	MenuBar menubar = new MenuBar();
	MenuItem logout = new MenuItem("Logout");
	MenuItem viewKeyboard = new MenuItem("View Keyboard");
	
	File file;
	Media videoMedia;
	MediaPlayer videoPlayer;
	MediaView videoView;
	Text text;
	

	
	public void menuSettings()
	{
        Menu fileMenu = new Menu("Menu");
        fileMenu.getItems().addAll(logout, viewKeyboard);

        // Create menu bar
        menubar.getMenus().add(fileMenu);
        bp.setTop(menubar);
        
        logout.setOnAction(e->{
        	Stage stage = (Stage) bp.getScene().getWindow();
        	stage.close();
        	
        	videoPlayer.stop();
        	
        	
        	Main secondScript = new Main();
        	try 
        	{
        		secondScript.start(new Stage());
        	}
        	catch ( Exception ex)
        	{
        		ex.printStackTrace();
        	}
        });

		viewKeyboard.setOnAction(e->{
			// keyboardDefaultValue();
			Stage stage = (Stage) bp.getScene().getWindow();
			stage.close();
			
			videoPlayer.stop();
			
			MainKeyboard secondScript = new MainKeyboard();
			try 
			{
				secondScript.start(new Stage());
			}
			catch ( Exception ex)
			{
				ex.printStackTrace();
			}
		});
	}
	
	// public void keyboardDefaultValue(){
	// 	KeyboardArray keyboardArray = new KeyboardArray();
    //     //  public KeyboardData(int id, String name, int price, int stock, String description, String image)
    //    KeyboardData keyboard1 = new KeyboardData(0, "Igoltech Keebs XO200", 800000, 56, "Classic black and yellow combination with modern architecture.", "keyboard1.png");
    //    KeyboardData keyboard2 = new KeyboardData(1,"Dark Black RGB", 1500000, 116, "RGB LED has come to this futuristic keyboard with elegant style.", "keyboard2.png");
    //    KeyboardData keyboard3 = new KeyboardData(2,"Watermelon Keebs Z200", 750000, 9, "Did you ever seen watermelon in keyboard? Now you see!", "keyboard3.png");
    //     KeyboardData keyboard4 = new KeyboardData(3,"Igoltech Classic Keebs", 1250000, 56, "Business keyboard with modern design make your style cool.", "keyboard4.png");

    //     keyboardArray.addKeyboard(keyboard1, 0);
    //     keyboardArray.addKeyboard(keyboard2, 1);
    //     keyboardArray.addKeyboard(keyboard3, 2);
    //     keyboardArray.addKeyboard(keyboard4, 3);
    // }
	
	public void videoFunction()
	{

		//read path file buat video 
		file = new File("keyboard.mp4");
		videoMedia = new Media(file.toURI(). toString());
		videoPlayer = new MediaPlayer(videoMedia);
		
		videoView = new MediaView(videoPlayer);

		videoView.setFitWidth(700);
		videoView.setFitHeight(600);
	
		bp.setCenter(videoView);
		
		videoPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		videoPlayer.setAutoPlay(true);
		

		lanjut = new Button("CONTINUE >>	");
		
        lanjut.setFont(Font.font(18));
		lanjut.setStyle("-fx-background-color :#363636; -fx-text-fill : white ");

		lanjut.setTranslateX(-300);
	}
	
	VBox vb, vb2 = new VBox();
	VBox vbUp = new VBox();
	GridPane gp, gp2 = new GridPane();
	Button lanjut = new Button();
	Text title = new Text();

	public void titleFunction()
	{
		vb2 = new VBox();
		title = new Text("NEW KEYBOARD HAS ARRIVED!");
		title.setFont(Font.font(56));
		
		
		VBox vbUp = new VBox(title, videoView, lanjut);

		vbUp.setAlignment(Pos.CENTER);
		vbUp.setSpacing(10);
		
		bp.setCenter(vbUp);
	}
	
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primary_Stage) throws Exception {
		// TODO Auto-generated method stub
		bp = new BorderPane();
		scene = new Scene(bp, 1200, 700);
		videoFunction();
		titleFunction();
		menuSettings();
		

		
		primary_Stage.show();
		primary_Stage.setTitle("USER");
		primary_Stage.setScene(scene);
		
	}

}
